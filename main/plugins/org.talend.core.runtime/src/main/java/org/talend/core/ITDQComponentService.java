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
package org.talend.core;

import org.talend.core.model.process.AbstractExternalNode;
import org.talend.core.model.process.INode;

public interface ITDQComponentService extends IService {

    public boolean isTDQExternalComponent(String componentName);

    public AbstractExternalNode createExternalComponent(INode node);
}
