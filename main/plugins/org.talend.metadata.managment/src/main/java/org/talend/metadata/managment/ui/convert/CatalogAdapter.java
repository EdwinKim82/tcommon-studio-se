// ============================================================================
//
// Copyright (C) 2006-2022 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.metadata.managment.ui.convert;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.util.EList;
import org.talend.core.model.metadata.builder.connection.DatabaseConnection;
import org.talend.cwm.helper.CatalogHelper;
import org.talend.cwm.helper.TaggedValueHelper;

import orgomg.cwm.foundation.softwaredeployment.DataManager;
import orgomg.cwm.resource.relational.Catalog;

public class CatalogAdapter {

    Catalog originalCat;

    public CatalogAdapter(Catalog cat) {
        originalCat = cat;
    }

    public String getName() {
        if (originalCat == null) {
            return null;
        }
        String catalogName = originalCat.getName();
        EList<DataManager> dataManagerList = originalCat.getDataManager();
        if (StringUtils.isEmpty(catalogName) || dataManagerList == null || dataManagerList.isEmpty()) {
            return catalogName;
        }
        DataManager dataManager = dataManagerList.get(0);
        if (dataManager instanceof DatabaseConnection) {
            DatabaseConnection parentConnection = (DatabaseConnection) dataManager;
            DbConnectionAdapter dbConnectionAdapter =
                    new DbConnectionAdapter(parentConnection);
            if (dbConnectionAdapter.isSwitchWithTaggedValueMode()) {
                String originalSID = TaggedValueHelper.getValueString(TaggedValueHelper.ORIGINAL_SID, parentConnection);
                String targetSID = TaggedValueHelper.getValueString(TaggedValueHelper.TARGET_SID, parentConnection);
                if (catalogName.equals(originalSID)) {
                    return targetSID;
                }
            }
        }
        return catalogName;
    }

    public Catalog getCatalog() {
        if (originalCat == null) {
            return null;
        }
        String catalogName = originalCat.getName();
        if (StringUtils.isEmpty(catalogName)) {
            return originalCat;
        }
        DataManager dataManager = originalCat.getDataManager().get(0);
        if (dataManager instanceof DatabaseConnection) {
            DatabaseConnection parentConnection = (DatabaseConnection) dataManager;
            DbConnectionAdapter dbConnectionAdapter =
                    new DbConnectionAdapter(parentConnection);
            if (dbConnectionAdapter.isSwitchWithTaggedValueMode()) {
                String originalSID = TaggedValueHelper.getValueString(TaggedValueHelper.ORIGINAL_SID, parentConnection);
                String targetSID = TaggedValueHelper.getValueString(TaggedValueHelper.TARGET_SID, parentConnection);
                if (catalogName.equals(originalSID)) {
                    return CatalogHelper.getCatalog(parentConnection, targetSID);
                }
            }
        }
        return originalCat;
    }
}
