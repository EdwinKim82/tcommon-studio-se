// ============================================================================
//
// Copyright (C) 2006-2021 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.librariesmanager.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.talend.core.model.general.ModuleNeeded;
import org.talend.core.model.general.ModuleNeeded.ELibraryInstallStatus;
import org.talend.core.model.general.ModuleStatusProvider;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.properties.RoutineItem;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.designer.core.model.utils.emf.component.ComponentFactory;
import org.talend.designer.core.model.utils.emf.component.IMPORTType;

/**
 * created by wchen on Sep 1, 2017 Detailled comment
 *
 */
public class ModulesNeededProviderTest {

    @Test
    public void testUpdateModulesNeededForRoutine() throws Exception {
        String jarName1 = "testUpdateModulesNeededForRoutine1.jar";
        String jarName2 = "testUpdateModulesNeededForRoutine2.jar";
        String jarName3 = "testUpdateModulesNeededForRoutine3.jar";

        String message = ModuleNeeded.UNKNOWN;

        RoutineItem routineItem = PropertiesFactory.eINSTANCE.createRoutineItem();
        routineItem.setProperty(PropertiesFactory.eINSTANCE.createProperty());
        routineItem.getProperty().setLabel("routineTest");
        IMPORTType importJar1 = ComponentFactory.eINSTANCE.createIMPORTType();
        importJar1.setMODULE(jarName1);
        importJar1.setREQUIRED(true);
        importJar1.setNAME(routineItem.getProperty().getLabel());
        routineItem.getImports().add(importJar1);
        IMPORTType importJar2 = ComponentFactory.eINSTANCE.createIMPORTType();
        importJar2.setMODULE(jarName2);
        importJar2.setREQUIRED(true);
        importJar2.setNAME(routineItem.getProperty().getLabel());
        routineItem.getImports().add(importJar2);
        IMPORTType importJar3 = ComponentFactory.eINSTANCE.createIMPORTType();
        importJar3.setMODULE(jarName3);
        importJar3.setREQUIRED(false);
        importJar3.setNAME(routineItem.getProperty().getLabel());
        routineItem.getImports().add(importJar3);
        // remove old modules from the two lists before test
        String label = ERepositoryObjectType.getItemType(routineItem).getLabel();
        String currentContext = label + " " + routineItem.getProperty().getLabel();
        Set<ModuleNeeded> oldModules = new HashSet<ModuleNeeded>();
        for (ModuleNeeded existingModule : ModulesNeededProvider.getModulesNeeded()) {
            if (currentContext.equals(existingModule.getContext()) || jarName1.equals(existingModule.getModuleName())
                    || jarName2.equals(existingModule.getModuleName()) || jarName3.equals(existingModule.getModuleName())) {
                oldModules.add(existingModule);
            }
        }
        ModulesNeededProvider.getModulesNeeded().removeAll(oldModules);
        oldModules = new HashSet<ModuleNeeded>();
        for (ModuleNeeded existingModule : ModulesNeededProvider.getAllManagedModules()) {
            if (currentContext.equals(existingModule.getContext()) || jarName1.equals(existingModule.getModuleName())
                    || jarName2.equals(existingModule.getModuleName()) || jarName3.equals(existingModule.getModuleName())) {
                oldModules.add(existingModule);
            }
        }
        ModulesNeededProvider.getAllManagedModules().removeAll(oldModules);

        ModulesNeededProvider.addUnknownModules(jarName1, null, false);
        int originalNeededSize = ModulesNeededProvider.getModulesNeeded().size();
        int originalAllSize = ModulesNeededProvider.getAllManagedModules().size();

        ModulesNeededProvider.updateModulesNeededForRoutine(routineItem);
        // add 3 modules to needed list, even one of them is require false but still need to +3
        // change logic because of https://jira.talendforge.org/browse/TUP-29826
        Assert.assertEquals(ModulesNeededProvider.getModulesNeeded().size(), originalNeededSize + 3);
        // add one + change one in the all list
        Assert.assertEquals(ModulesNeededProvider.getAllManagedModules().size(), originalAllSize + 2);

        List<ModuleNeeded> module1 = ModulesNeededProvider.getModulesNeededForName(jarName1);
        List<ModuleNeeded> module2 = ModulesNeededProvider.getModulesNeededForName(jarName2);
        Assert.assertEquals(module1.get(0).getContext(), "Global Routines " + routineItem.getProperty().getLabel());
        Assert.assertEquals(module2.get(0).getContext(), "Global Routines " + routineItem.getProperty().getLabel());
    }

    @Test
    public void testInstallModuleForRoutineOrBeans() throws Exception {
        ModuleNeeded module1 = new ModuleNeeded("", "ModulesNeededProviderTest", "description", false, null, null,
                "mvn:org.talend.librariesmanager.model/ModulesNeededProviderTest/8.0.1");
        try {
            ModuleStatusProvider.putStatus(module1.getMavenUri(), ELibraryInstallStatus.NOT_INSTALLED);
            ModulesNeededProvider.getModulesNeeded().add(module1);
            ModulesNeededProvider.checkInstallStatus(Arrays.asList(module1));
            Assert.assertTrue("Don't need to rebuild the codes project here",
                    ModulesNeededProvider.installModuleForRoutineOrBeans() == false);
            ModuleStatusProvider.putStatus(module1.getMavenUri(), ELibraryInstallStatus.INSTALLED);
            Assert.assertTrue("Need to rebuild the codes project here",
                    ModulesNeededProvider.installModuleForRoutineOrBeans() == true);
            ModulesNeededProvider.setInstallModuleForRoutineOrBeans();
            Assert.assertTrue("Don't need to rebuild the codes project here",
                    ModulesNeededProvider.installModuleForRoutineOrBeans() == false);
        } finally {
            ModulesNeededProvider.getModulesNeeded().remove(module1);
        }
    }

}
