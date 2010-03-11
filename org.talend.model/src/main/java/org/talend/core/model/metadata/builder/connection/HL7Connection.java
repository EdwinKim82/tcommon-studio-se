/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.core.model.metadata.builder.connection;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HL7 Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.core.model.metadata.builder.connection.HL7Connection#getStartChar <em>Start Char</em>}</li>
 *   <li>{@link org.talend.core.model.metadata.builder.connection.HL7Connection#getEndChar <em>End Char</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.core.model.metadata.builder.connection.ConnectionPackage#getHL7Connection()
 * @model
 * @generated
 */
public interface HL7Connection extends FileConnection {
    /**
     * Returns the value of the '<em><b>Start Char</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Start Char</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Start Char</em>' attribute.
     * @see #setStartChar(String)
     * @see org.talend.core.model.metadata.builder.connection.ConnectionPackage#getHL7Connection_StartChar()
     * @model
     * @generated
     */
    String getStartChar();

    /**
     * Sets the value of the '{@link org.talend.core.model.metadata.builder.connection.HL7Connection#getStartChar <em>Start Char</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Start Char</em>' attribute.
     * @see #getStartChar()
     * @generated
     */
    void setStartChar(String value);

    /**
     * Returns the value of the '<em><b>End Char</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>End Char</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>End Char</em>' attribute.
     * @see #setEndChar(String)
     * @see org.talend.core.model.metadata.builder.connection.ConnectionPackage#getHL7Connection_EndChar()
     * @model
     * @generated
     */
    String getEndChar();

    /**
     * Sets the value of the '{@link org.talend.core.model.metadata.builder.connection.HL7Connection#getEndChar <em>End Char</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>End Char</em>' attribute.
     * @see #getEndChar()
     * @generated
     */
    void setEndChar(String value);

} // HL7Connection
