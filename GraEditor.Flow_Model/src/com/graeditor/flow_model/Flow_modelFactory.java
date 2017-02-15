/**
 */
package com.graeditor.flow_model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.graeditor.flow_model.Flow_modelPackage
 * @generated
 */
public interface Flow_modelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Flow_modelFactory eINSTANCE = com.graeditor.flow_model.impl.Flow_modelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Content Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Content Module</em>'.
	 * @generated
	 */
	ContentModule createContentModule();

	/**
	 * Returns a new object of class '<em>End Tag Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>End Tag Module</em>'.
	 * @generated
	 */
	EndTagModule createEndTagModule();

	/**
	 * Returns a new object of class '<em>Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flow</em>'.
	 * @generated
	 */
	Flow createFlow();

	/**
	 * Returns a new object of class '<em>Flow Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flow Module</em>'.
	 * @generated
	 */
	FlowModule createFlowModule();

	/**
	 * Returns a new object of class '<em>Start Tag Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Start Tag Module</em>'.
	 * @generated
	 */
	StartTagModule createStartTagModule();

	/**
	 * Returns a new object of class '<em>Vertical Line Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vertical Line Module</em>'.
	 * @generated
	 */
	VerticalLineModule createVerticalLineModule();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Flow_modelPackage getFlow_modelPackage();

} //Flow_modelFactory
