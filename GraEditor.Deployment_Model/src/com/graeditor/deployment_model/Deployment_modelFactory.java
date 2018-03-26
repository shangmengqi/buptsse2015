/**
 */
package com.graeditor.deployment_model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.graeditor.deployment_model.Deployment_modelPackage
 * @generated
 */
public interface Deployment_modelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Deployment_modelFactory eINSTANCE = com.graeditor.deployment_model.impl.Deployment_modelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Deployment Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deployment Module</em>'.
	 * @generated
	 */
	DeploymentModule createDeploymentModule();

	/**
	 * Returns a new object of class '<em>Device Node Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Device Node Module</em>'.
	 * @generated
	 */
	DeviceNodeModule createDeviceNodeModule();

	/**
	 * Returns a new object of class '<em>Processor Node Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Processor Node Module</em>'.
	 * @generated
	 */
	ProcessorNodeModule createProcessorNodeModule();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Deployment_modelPackage getDeployment_modelPackage();

} //Deployment_modelFactory
