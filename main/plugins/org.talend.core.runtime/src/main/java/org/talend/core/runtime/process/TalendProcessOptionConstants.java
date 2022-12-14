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
package org.talend.core.runtime.process;

/**
 * DOC ggu class global comment. Detailled comment
 */
public interface TalendProcessOptionConstants {

    /**
     * generate options
     */
    public static final int GENERATE_MAIN_ONLY = 1 << 1;

    public static final int GENERATE_WITH_FIRST_CHILD = 1 << 2;

    public static final int GENERATE_ALL_CHILDS = 1 << 3;

    public static final int GENERATE_TESTS = 1 << 4;

    public static final int GENERATE_WITHOUT_COMPILING = 1 << 5;

    public static final int GENERATE_WITHOUT_FORMAT = 1 << 6;

    public static final int GENERATE_POM_ONLY = 1 << 7;

    /**
     * for recursive job.
     */
    public static final int GENERATE_IS_MAINJOB = 1 << 8;

    /**
     * for ESB bundle.
     */
    public static final int GENERATE_NO_CODEGEN = 1 << 9;

    public static final int GENERATE_POM_NO_FILTER = 1 << 10;
    
    public static final int GENERATE_POM_NOT_CLEAR_CACHE = 1 << 11;

    /**
     * for DQ clean item
     */
    public static final int GENERATE_NO_RESET_DQ = 1 << 12;
    /**
     * clean options
     */
    public static final int CLEAN_JAVA_CODES = 1;

    public static final int CLEAN_CONTEXTS = 1 << 1;

    public static final int CLEAN_DATA_SETS = 1 << 2;

    /**
     * generate modules options
     */
    public static final int MODULES_DEFAULT = 1;

    public static final int MODULES_WITH_CHILDREN = 1 << 1;

    public static final int MODULES_WITH_INDEPENDENT = 1 << 2;

    /**
     * @Deprecated will get all modules of node inside joblet recursively, use {@link #MODULES_DEFAULT} instead.
     */
    @Deprecated
    public static final int MODULES_WITH_JOBLET = 1 << 3;

    public static final int MODULES_FOR_MR = 1 << 4;

    public static final int MODULES_EXCLUDE_SHADED = 1 << 5;

    /**
     * NOTE with this option, still won't get codesjar modules of related joblet TODO check all callers to find a way to
     * include those
     */
    public static final int MODULES_WITH_CODESJAR = 1 << 6;

    /**
     * flag for check if is ESB job
     */
    public static final int ISESB_CHECKED = 1;

    public static final int ISESB_CHILDREN_INCLUDE = 1 << 1;

    public static final int ISESB_CURRENT_INCLUDE = 1 << 2;

}
