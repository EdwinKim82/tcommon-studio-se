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
package org.talend.core.service;

import org.eclipse.core.runtime.IProgressMonitor;
import org.talend.core.IService;

public interface IUpdateService extends IService {

    boolean checkComponentNexusUpdate();
    
    public boolean syncSharedStudioLibraryInPatch(IProgressMonitor monitor) throws Exception;

    public boolean updateArtifactsFileSha256Hex(IProgressMonitor monitor, String studioArtifactsFileShaCodeHex);

    public void checkThirdPartyLibraries();
}
