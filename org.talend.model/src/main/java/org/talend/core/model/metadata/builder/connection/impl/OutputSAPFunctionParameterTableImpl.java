/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.core.model.metadata.builder.connection.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.talend.core.model.metadata.builder.connection.Connection;
import org.talend.core.model.metadata.builder.connection.ConnectionPackage;
import org.talend.core.model.metadata.builder.connection.OutputSAPFunctionParameterTable;
import org.talend.core.model.metadata.builder.connection.SAPFunctionUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Output SAP Function Parameter Table</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.talend.core.model.metadata.builder.connection.impl.OutputSAPFunctionParameterTableImpl#getFunctionUnit <em>Function Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutputSAPFunctionParameterTableImpl extends
		SAPFunctionParameterTableImpl implements
		OutputSAPFunctionParameterTable {
	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	protected OutputSAPFunctionParameterTableImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass() {
        return ConnectionPackage.Literals.OUTPUT_SAP_FUNCTION_PARAMETER_TABLE;
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public SAPFunctionUnit getFunctionUnit() {
        if (eContainerFeatureID() != ConnectionPackage.OUTPUT_SAP_FUNCTION_PARAMETER_TABLE__FUNCTION_UNIT) return null;
        return (SAPFunctionUnit)eContainer();
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetFunctionUnit(
			SAPFunctionUnit newFunctionUnit, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newFunctionUnit, ConnectionPackage.OUTPUT_SAP_FUNCTION_PARAMETER_TABLE__FUNCTION_UNIT, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public void setFunctionUnit(SAPFunctionUnit newFunctionUnit) {
        if (newFunctionUnit != eInternalContainer() || (eContainerFeatureID() != ConnectionPackage.OUTPUT_SAP_FUNCTION_PARAMETER_TABLE__FUNCTION_UNIT && newFunctionUnit != null)) {
            if (EcoreUtil.isAncestor(this, newFunctionUnit))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newFunctionUnit != null)
                msgs = ((InternalEObject)newFunctionUnit).eInverseAdd(this, ConnectionPackage.SAP_FUNCTION_UNIT__OUTPUT_PARAMETER_TABLE, SAPFunctionUnit.class, msgs);
            msgs = basicSetFunctionUnit(newFunctionUnit, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConnectionPackage.OUTPUT_SAP_FUNCTION_PARAMETER_TABLE__FUNCTION_UNIT, newFunctionUnit, newFunctionUnit));
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ConnectionPackage.OUTPUT_SAP_FUNCTION_PARAMETER_TABLE__FUNCTION_UNIT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetFunctionUnit((SAPFunctionUnit)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ConnectionPackage.OUTPUT_SAP_FUNCTION_PARAMETER_TABLE__FUNCTION_UNIT:
                return basicSetFunctionUnit(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case ConnectionPackage.OUTPUT_SAP_FUNCTION_PARAMETER_TABLE__FUNCTION_UNIT:
                return eInternalContainer().eInverseRemove(this, ConnectionPackage.SAP_FUNCTION_UNIT__OUTPUT_PARAMETER_TABLE, SAPFunctionUnit.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ConnectionPackage.OUTPUT_SAP_FUNCTION_PARAMETER_TABLE__FUNCTION_UNIT:
                return getFunctionUnit();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ConnectionPackage.OUTPUT_SAP_FUNCTION_PARAMETER_TABLE__FUNCTION_UNIT:
                setFunctionUnit((SAPFunctionUnit)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public void eUnset(int featureID) {
        switch (featureID) {
            case ConnectionPackage.OUTPUT_SAP_FUNCTION_PARAMETER_TABLE__FUNCTION_UNIT:
                setFunctionUnit((SAPFunctionUnit)null);
                return;
        }
        super.eUnset(featureID);
    }

	/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ConnectionPackage.OUTPUT_SAP_FUNCTION_PARAMETER_TABLE__FUNCTION_UNIT:
                return getFunctionUnit() != null;
        }
        return super.eIsSet(featureID);
    }

	public boolean isReadOnly() {
		Connection connection = getFunctionUnit().getConnection();
		return connection == null ? false : connection.isReadOnly();
	}

} // OutputSAPFunctionParameterTableImpl
