// ============================================================================
//
// Copyright (C) 2006-2019 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.core.model.components.filters;

import org.talend.core.model.components.ComponentUtilities;
import org.talend.designer.core.model.utils.emf.talendfile.NodeType;

/**
 * Filter components by name, property and value.<br>
 * $Id: talend.epf 1 2006-09-29 17:06:40 +0000 (ven., 29 sept. 2006) nrousseau $
 */
public class PropertyComponentFilter extends NameComponentFilter implements IComponentFilter {

    private interface AcceptOperator {

        public boolean evaluate(String param1, String param2);
    }

    private static class EqualityOperator implements AcceptOperator {

        @Override
        public boolean evaluate(String param1, String param2) {
            if (param1 != null) {
                return param1.equals(param2);
            } else {
                return false;
            }
        }
    }

    private static class ContainsOperator implements AcceptOperator {

        @Override
        public boolean evaluate(String param1, String param2) {
            if (param1 != null) {
                return param1.contains(param2);
            } else {
                return false;
            }
        }
    }

    public static AcceptOperator equalsOperator = new EqualityOperator();
    public static AcceptOperator containsOperator = new ContainsOperator();

    private String property;

    private String value;

    private AcceptOperator operator = new EqualityOperator();

    public PropertyComponentFilter(String name, String property, String value) {
        super(name);
        this.property = property;
        this.value = value;
    }

    public PropertyComponentFilter(String name, String property, String value, AcceptOperator operator) {
        super(name);
        this.property = property;
        this.value = value;
        this.operator = operator;
    }

    @Override
    public boolean accept(NodeType node) {
        boolean toReturn = (name == null ? true : super.accept(node));
        if (toReturn) {
            String pValue = ComponentUtilities.getNodePropertyValue(node, property);
            toReturn = operator.evaluate(pValue, value);
        }
        return toReturn;
    }
}
