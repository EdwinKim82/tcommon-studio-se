// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.core.model.repository;

import org.eclipse.emf.ecore.EObject;
import org.talend.core.PluginChecker;
import org.talend.core.i18n.Messages;
import org.talend.core.model.properties.BusinessProcessItem;
import org.talend.core.model.properties.CSVFileConnectionItem;
import org.talend.core.model.properties.ContextItem;
import org.talend.core.model.properties.DatabaseConnectionItem;
import org.talend.core.model.properties.DelimitedFileConnectionItem;
import org.talend.core.model.properties.DocumentationItem;
import org.talend.core.model.properties.EbcdicConnectionItem;
import org.talend.core.model.properties.ExcelFileConnectionItem;
import org.talend.core.model.properties.FolderItem;
import org.talend.core.model.properties.GenericSchemaConnectionItem;
import org.talend.core.model.properties.HL7ConnectionItem;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.JobDocumentationItem;
import org.talend.core.model.properties.JobletDocumentationItem;
import org.talend.core.model.properties.JobletProcessItem;
import org.talend.core.model.properties.LDAPSchemaConnectionItem;
import org.talend.core.model.properties.LdifFileConnectionItem;
import org.talend.core.model.properties.LinkDocumentationItem;
import org.talend.core.model.properties.LinkRulesItem;
import org.talend.core.model.properties.MDMConnectionItem;
import org.talend.core.model.properties.PositionalFileConnectionItem;
import org.talend.core.model.properties.ProcessItem;
import org.talend.core.model.properties.RegExFileConnectionItem;
import org.talend.core.model.properties.RoutineItem;
import org.talend.core.model.properties.RulesItem;
import org.talend.core.model.properties.SAPConnectionItem;
import org.talend.core.model.properties.SQLPatternItem;
import org.talend.core.model.properties.SVGBusinessProcessItem;
import org.talend.core.model.properties.SalesforceSchemaConnectionItem;
import org.talend.core.model.properties.SnippetItem;
import org.talend.core.model.properties.SnippetVariable;
import org.talend.core.model.properties.TDQItem;
import org.talend.core.model.properties.WSDLSchemaConnectionItem;
import org.talend.core.model.properties.XmlFileConnectionItem;
import org.talend.core.model.properties.util.PropertiesSwitch;

/**
 * This enum represents all objects types that can be store in the repository.<br/>
 * Exception is the recycle bin that isn't really an object type (could think of moving it).
 * 
 * $Id$
 * 
 */
public enum ERepositoryObjectType {
    SVN_ROOT("repository.svnroot"), //$NON-NLS-1$
    BUSINESS_PROCESS("repository.businessProcess"), //$NON-NLS-1$
    SVG_BUSINESS_PROCESS("repository.svgBusinessProcess"), //$NON-NLS-1$
    PROCESS("repository.process"), //$NON-NLS-1$
    CONTEXT("repository.context"), //$NON-NLS-1$
    ROUTINES("repository.routines"), //$NON-NLS-1$
    SNIPPETS("repository.snippets"), //$NON-NLS-1$
    DOCUMENTATION("repository.documentation"), //$NON-NLS-1$
    METADATA("repository.metadata"), //$NON-NLS-1$
    METADATA_CON_TABLE("repository.metadataTable", true), //$NON-NLS-1$
    METADATA_CON_VIEW("repository.metadataView", true), //$NON-NLS-1$
    METADATA_CON_SYNONYM("repository.synonym", true), //$NON-NLS-1$
    METADATA_CON_QUERY("repository.query", true), //$NON-NLS-1$
    METADATA_CON_CDC("repository.CDC", true), //$NON-NLS-1$
    METADATA_SAP_FUNCTION("repository.SAPFunction", true), //$NON-NLS-1$
    MDM_CONCEPT("repository.concept", true), //$NON-NLS-1$

    // feature 0006484 add
    METADATA_FILE_RULES("repository.metadataFileRules", "repository.metadataFileRules.alias"), //$NON-NLS-1$ //$NON-NLS-2$
    METADATA_FILE_LINKRULES("repository.metadataLinkFileRules", "repository.metadataLinkFileRules.alias"), //$NON-NLS-1$ //$NON-NLS-2$

    METADATA_CONNECTIONS("repository.metadataConnections", "repository.metadataConnections.alias"), //$NON-NLS-1$ //$NON-NLS-2$
    METADATA_SAPCONNECTIONS("repository.metadataSAPConnections", "repository.metadataSAPConnections.alias"), //$NON-NLS-1$ //$NON-NLS-2$
    SQLPATTERNS("repository.metadataSQLPatterns", "repository.metadataSQLPatterns.alias"), //$NON-NLS-1$ //$NON-NLS-2$
    METADATA_FILE_EBCDIC("repository.metadataFileEDCDIC", "repository.metadataFileEDCDIC.alias"), //$NON-NLS-1$ //$NON-NLS-2$
    METADATA_FILE_HL7("repository.metadataFileHL7", "repository.metadataFileHL7.alias"), //$NON-NLS-1$ //$NON-NLS-2$
    METADATA_MDMCONNECTION("repository.metadataMDMConnections", "repository.metadataMDMConnections.alias"), //$NON-NLS-1$ //$NON-NLS-2$
    METADATA_FILE_DELIMITED("repository.metadataFileDelimited", "repository.metadataFileDelimited.alias"), //$NON-NLS-1$ //$NON-NLS-2$
    METADATA_FILE_POSITIONAL("repository.metadataFilePositional", "repository.metadataFilePositional.alias"), //$NON-NLS-1$ //$NON-NLS-2$
    METADATA_FILE_REGEXP("repository.metadataFileRegexp", "repository.metadataFileRegexp.alias"), //$NON-NLS-1$ //$NON-NLS-2$
    METADATA_FILE_XML("repository.metadataFileXml", "repository.metadataFileXml.alias"), //$NON-NLS-1$ //$NON-NLS-2$
    METADATA_FILE_LDIF("repository.metadataFileLdif", "repository.metadataFileLdif.alias"), //$NON-NLS-1$ //$NON-NLS-2$
    METADATA_FILE_EXCEL("repository.metadataFileExcel", "repository.metadataFileExcel.alias"), //$NON-NLS-1$ //$NON-NLS-2$
    METADATA_SALESFORCE_SCHEMA("repository.metadataSalesforceSchema", "repository.metadataSalesforceSchema.alias"), //$NON-NLS-1$ //$NON-NLS-2$
    METADATA_GENERIC_SCHEMA("repository.metadataGenericSchema", "repository.metadataGenericSchema.alias"), //$NON-NLS-1$ //$NON-NLS-2$
    METADATA_LDAP_SCHEMA("repository.metadataLDAPSchema", "repository.metadataLDAPSchema.alias"), //$NON-NLS-1$ //$NON-NLS-2$
    FOLDER("repository.folder"), //$NON-NLS-1$
    REFERENCED_PROJECTS("repository.referencedProjects", "repository.referencedProjects.alias"), //$NON-NLS-1$ //$NON-NLS-2$
    GENERATED("repository.generated"), //$NON-NLS-1$
    JOBS("repository.jobs"), //$NON-NLS-1$
    JOB_DOC("repository.jobdoc"), //$NON-NLS-1$
    JOBLET("repository.joblet"), //$NON-NLS-1$
    METADATA_WSDL_SCHEMA("repository.metadataWSDLSchema", "repository.metadataWSDLSchema.alias"), //$NON-NLS-1$ //$NON-NLS-2$
    JOBLETS("repository.joblets"), //$NON-NLS-1$
    JOBLET_DOC("repository.jobletdoc"), //$NON-NLS-1$
    // MOD mzhao feature 9207
    TDQ_ELEMENT("repository.tdqelement"); //$NON-NLS-1$

    private String key;

    private String alias;

    private boolean subItem;

    /**
     * Constructor with the i18n key used to display the folder wich contains this object type.
     * 
     * @param key
     */
    ERepositoryObjectType(String key) {
        this(key, false);
    }

    ERepositoryObjectType(String key, boolean subItem) {
        this.key = key;
        this.subItem = subItem;
    }

    ERepositoryObjectType(String key, String alias) {
        this(key);
        this.alias = alias;
    }

    public String toString() {
        return Messages.getString(getKey());
    }

    public String getAlias() {
        if (alias == null) {
            return null;
        }
        return Messages.getString(alias);
    }

    public static ERepositoryObjectType getTypeFromKey(String key) {
        for (ERepositoryObjectType type : ERepositoryObjectType.values()) {
            if (type.getKey().equals(key)) {
                return type;
            }
        }
        return null;
    }

    /**
     * Getter for key.
     * 
     * @return the key
     */
    public String getKey() {
        return this.key;
    }

    /**
     * 
     * ggu Comment method "hasFolder". bug 9789
     */
    public boolean hasFolder() {
        try {
            String folderName = getFolderName(this);
            if (folderName != null && !"".equals(folderName)) { //$NON-NLS-1$
                return true;
            }
        } catch (IllegalArgumentException e) { // not found
            // nothing to do
        }
        return false;
    }

    public static String getFolderName(ERepositoryObjectType type) {
        switch (type) {
        case BUSINESS_PROCESS:
            return "businessProcess"; //$NON-NLS-1$
        case SVG_BUSINESS_PROCESS:
            return "businessProcessSVG"; //$NON-NLS-1$
        case PROCESS:
            return "process"; //$NON-NLS-1$
        case JOBLET:
            return "joblets"; //$NON-NLS-1$
        case CONTEXT:
            return "context"; //$NON-NLS-1$
        case ROUTINES:
            return "code/routines"; //$NON-NLS-1$
        case SNIPPETS:
            return "code/snippets"; //$NON-NLS-1$
        case DOCUMENTATION:
            return "documentations"; //$NON-NLS-1$
        case SQLPATTERNS:
            return "sqlPatterns"; //$NON-NLS-1$
        case METADATA:
            return "metadata"; //$NON-NLS-1$
        case METADATA_CONNECTIONS:
            return "metadata/connections"; //$NON-NLS-1$
        case METADATA_SAPCONNECTIONS:
            return "metadata/sapconnections"; //$NON-NLS-1$
        case METADATA_FILE_EBCDIC:
            return "metadata/fileEBCDIC"; //$NON-NLS-1$
        case METADATA_FILE_HL7:
            return "metadata/fileHL7"; //$NON-NLS-1$
        case METADATA_MDMCONNECTION:
            return "metadata/MDMconnections"; //$NON-NLS-1$
        case METADATA_FILE_DELIMITED:
            return "metadata/fileDelimited"; //$NON-NLS-1$
        case METADATA_FILE_POSITIONAL:
            return "metadata/filePositional"; //$NON-NLS-1$
        case METADATA_FILE_REGEXP:
            return "metadata/fileRegex"; //$NON-NLS-1$
        case METADATA_FILE_XML:
            return "metadata/fileXml"; //$NON-NLS-1$
        case METADATA_FILE_EXCEL:
            return "metadata/fileExcel"; //$NON-NLS-1$
        case METADATA_FILE_LDIF:
            return "metadata/fileLdif"; //$NON-NLS-1$
        case METADATA_LDAP_SCHEMA:
            return "metadata/LDAPSchema"; //$NON-NLS-1$
        case METADATA_GENERIC_SCHEMA:
            return "metadata/genericSchema"; //$NON-NLS-1$
        case METADATA_WSDL_SCHEMA:
            return "metadata/WSDLSchema"; //$NON-NLS-1$
        case METADATA_SALESFORCE_SCHEMA:
            return "metadata/SalesforceSchema"; //$NON-NLS-1$
        case METADATA_FILE_RULES:
            return "metadata/rules"; //$NON-NLS-1$
        case METADATA_FILE_LINKRULES:
            return "metadata/rules"; //$NON-NLS-1$
            // MOD mzhao feature 9207
        case TDQ_ELEMENT:
            return "";//$NON-NLS-1$
        default:
            if (PluginChecker.isDocumentationPluginLoaded()) {
                if (type == GENERATED) {
                    return "documentations/generated"; //$NON-NLS-1$
                }
                if (type == JOBS) {
                    return "documentations/generated/jobs"; //$NON-NLS-1$
                }
                if (type == JOB_DOC) {
                    return "documentations/generated/jobs"; //$NON-NLS-1$
                }
                if (PluginChecker.isJobLetPluginLoaded() && type == JOBLETS) {
                    return "documentations/generated/joblets"; //$NON-NLS-1$
                }
                if (PluginChecker.isJobLetPluginLoaded() && type == JOBLET_DOC) {
                    return "documentations/generated/joblets"; //$NON-NLS-1$
                }
            }

            throw new IllegalArgumentException(Messages.getString("ERepositoryObjectType.FolderNotFound", type)); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    public static ERepositoryObjectType getItemType(Item item) {
        return (ERepositoryObjectType) new PropertiesSwitch() {

            @Override
            public Object caseFolderItem(FolderItem object) {

                return FOLDER;
            }

            public Object caseDocumentationItem(DocumentationItem object) {
                return DOCUMENTATION;
            }

            @Override
            public Object caseLinkDocumentationItem(LinkDocumentationItem object) {

                return DOCUMENTATION;
            }

            @Override
            public Object caseRulesItem(RulesItem object) {
                return METADATA_FILE_RULES;
            }

            @Override
            public Object caseLinkRulesItem(LinkRulesItem object) {
                return METADATA_FILE_LINKRULES;
            }

            /*
             * (non-Javadoc)
             * 
             * @seeorg.talend.core.model.properties.util.PropertiesSwitch# caseJobDocumentationItem
             * (org.talend.core.model.properties.JobDocumentationItem)
             */
            public Object caseJobDocumentationItem(JobDocumentationItem object) {
                return JOB_DOC;
            }

            /*
             * (non-Javadoc)
             * 
             * @seeorg.talend.core.model.properties.util.PropertiesSwitch# caseJobletDocumentationItem
             * (org.talend.core.model.properties.JobletDocumentationItem)
             */
            public Object caseJobletDocumentationItem(JobletDocumentationItem object) {
                return JOBLET_DOC;
            }

            public Object caseRoutineItem(RoutineItem object) {
                return ROUTINES;
            }

            /*
             * (non-Javadoc)
             * 
             * @seeorg.talend.core.model.properties.util.PropertiesSwitch# caseSQLPatternItem
             * (org.talend.core.model.properties.SQLPatternItem)
             */
            @Override
            public Object caseSQLPatternItem(SQLPatternItem object) {
                return SQLPATTERNS;
            }

            public Object caseProcessItem(ProcessItem object) {
                return PROCESS;
            }

            /*
             * (non-Javadoc)
             * 
             * @seeorg.talend.core.model.properties.util.PropertiesSwitch# caseJobletProcessItem
             * (org.talend.core.model.properties.JobletProcessItem)
             */
            @Override
            public Object caseJobletProcessItem(JobletProcessItem object) {
                return JOBLET;
            }

            public Object caseContextItem(ContextItem object) {
                return CONTEXT;
            }

            public Object caseSnippetItem(SnippetItem object) {
                return SNIPPETS;
            }

            public Object caseSnippetVariable(SnippetVariable object) {
                return SNIPPETS;
            }

            public Object caseBusinessProcessItem(BusinessProcessItem object) {
                return BUSINESS_PROCESS;
            }

            public Object caseCSVFileConnectionItem(CSVFileConnectionItem object) {
                throw new IllegalStateException(Messages.getString("ERepositoryObjectType.NotImplemented")); //$NON-NLS-1$
            }

            public Object caseDatabaseConnectionItem(DatabaseConnectionItem object) {
                return METADATA_CONNECTIONS;
            }

            @Override
            public Object caseSAPConnectionItem(SAPConnectionItem object) {
                return METADATA_SAPCONNECTIONS;
            }

            public Object caseDelimitedFileConnectionItem(DelimitedFileConnectionItem object) {
                return METADATA_FILE_DELIMITED;
            }

            public Object casePositionalFileConnectionItem(PositionalFileConnectionItem object) {
                return METADATA_FILE_POSITIONAL;
            }

            public Object caseRegExFileConnectionItem(RegExFileConnectionItem object) {
                return METADATA_FILE_REGEXP;
            }

            public Object caseXmlFileConnectionItem(XmlFileConnectionItem object) {
                return METADATA_FILE_XML;
            }

            public Object caseExcelFileConnectionItem(ExcelFileConnectionItem object) {
                return METADATA_FILE_EXCEL;
            }

            public Object caseLdifFileConnectionItem(LdifFileConnectionItem object) {
                return METADATA_FILE_LDIF;
            }

            public Object caseLDAPSchemaConnectionItem(LDAPSchemaConnectionItem object) {
                return METADATA_LDAP_SCHEMA;
            }

            public Object caseGenericSchemaConnectionItem(GenericSchemaConnectionItem object) {
                return METADATA_GENERIC_SCHEMA;
            }

            public Object caseSalesforceSchemaConnectionItem(SalesforceSchemaConnectionItem object) {
                return METADATA_SALESFORCE_SCHEMA;
            }

            public Object caseWSDLSchemaConnectionItem(WSDLSchemaConnectionItem object) {
                return METADATA_WSDL_SCHEMA;
            }

            @Override
            public Object caseEbcdicConnectionItem(EbcdicConnectionItem object) {
                return METADATA_FILE_EBCDIC;
            }

            public Object caseHL7ConnectionItem(HL7ConnectionItem object) {
                return METADATA_FILE_HL7;
            }

            public Object caseMDMConnectionItem(MDMConnectionItem object) {
                return METADATA_MDMCONNECTION;
            }

            @Override
            public Object caseSVGBusinessProcessItem(SVGBusinessProcessItem object) {
                // TODO Auto-generated method stub
                return SVG_BUSINESS_PROCESS;
            }

            // MOD mzhao feature 9207
            @Override
            public Object caseTDQItem(TDQItem object) {
                return TDQ_ELEMENT;
            }

            public Object defaultCase(EObject object) {
                throw new IllegalStateException();
            }
        }.doSwitch(item);
    }

    public boolean isSubItem() {
        return subItem;
    }

    public boolean isResourceItem() {
        return !subItem && !this.equals(ERepositoryObjectType.FOLDER) && !this.equals(ERepositoryObjectType.REFERENCED_PROJECTS)
                && !this.equals(ERepositoryObjectType.SNIPPETS) && !this.equals(ERepositoryObjectType.GENERATED)
                && !this.equals(ERepositoryObjectType.JOBS) && !this.equals(ERepositoryObjectType.JOB_DOC)
                && !this.equals(ERepositoryObjectType.JOBLETS) && !this.equals(ERepositoryObjectType.JOBLET_DOC)
                && !this.equals(ERepositoryObjectType.METADATA);
    }
}
