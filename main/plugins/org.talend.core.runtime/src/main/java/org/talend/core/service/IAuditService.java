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

import java.util.Map;

import org.talend.core.IService;
import org.talend.utils.sugars.TypedReturnCode;

public interface IAuditService extends IService {

    public void populateAudit(String url, String driver, String user, String password);

    public Map<String, String> generateAuditReport(String path);

    public TypedReturnCode<java.sql.Connection> checkConnection(String version, String url, String driver, String user,
            String password);

    public Map<Integer, String> listAllHistoryAudits(String url, String driver, String user, String password);

    public void populateHistoryAudit(Integer auditId, String url, String driver, String user, String password);
}
