/**
 */
package com.graeditor.component_model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.graeditor.component_model.Component_modelPackage
 * @generated
 */
public interface Component_modelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Component_modelFactory eINSTANCE = com.graeditor.component_model.impl.Component_modelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Component Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Module</em>'.
	 * @generated
	 */
	ComponentModule createComponentModule();

	/**
	 * Returns a new object of class '<em>Database Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Database Module</em>'.
	 * @generated
	 */
	DatabaseModule createDatabaseModule();

	/**
	 * Returns a new object of class '<em>Little Component Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Little Component Module</em>'.
	 * @generated
	 */
	LittleComponentModule createLittleComponentModule();

	/**
	 * Returns a new object of class '<em>Little Framwork Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Little Framwork Module</em>'.
	 * @generated
	 */
	LittleFramworkModule createLittleFramworkModule();

	/**
	 * Returns a new object of class '<em>Little Interface Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Little Interface Module</em>'.
	 * @generated
	 */
	LittleInterfaceModule createLittleInterfaceModule();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Component_modelPackage getComponent_modelPackage();

} //Component_modelFactory
