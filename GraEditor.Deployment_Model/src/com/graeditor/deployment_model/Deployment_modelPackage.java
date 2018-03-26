/**
 */
package com.graeditor.deployment_model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.graeditor.deployment_model.Deployment_modelFactory
 * @model kind="package"
 * @generated
 */
public interface Deployment_modelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "deployment_model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///com/graeditor/deployment_model.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.graeditor.deployment_model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Deployment_modelPackage eINSTANCE = com.graeditor.deployment_model.impl.Deployment_modelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.graeditor.deployment_model.impl.DeploymentModuleImpl <em>Deployment Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.deployment_model.impl.DeploymentModuleImpl
	 * @see com.graeditor.deployment_model.impl.Deployment_modelPackageImpl#getDeploymentModule()
	 * @generated
	 */
	int DEPLOYMENT_MODULE = 0;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_MODULE__PICTOGRAM_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_MODULE__PREVIOUS_MODULES = 1;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_MODULE__NEXT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_MODULE__NAME = 3;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_MODULE__TEXT_CONTENT = 4;

	/**
	 * The number of structural features of the '<em>Deployment Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_MODULE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Deployment Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_MODULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.graeditor.deployment_model.impl.DeviceNodeModuleImpl <em>Device Node Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.deployment_model.impl.DeviceNodeModuleImpl
	 * @see com.graeditor.deployment_model.impl.Deployment_modelPackageImpl#getDeviceNodeModule()
	 * @generated
	 */
	int DEVICE_NODE_MODULE = 1;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_NODE_MODULE__PICTOGRAM_ELEMENT = DEPLOYMENT_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_NODE_MODULE__PREVIOUS_MODULES = DEPLOYMENT_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_NODE_MODULE__NEXT = DEPLOYMENT_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_NODE_MODULE__NAME = DEPLOYMENT_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_NODE_MODULE__TEXT_CONTENT = DEPLOYMENT_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Device Node Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_NODE_MODULE_FEATURE_COUNT = DEPLOYMENT_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Device Node Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_NODE_MODULE_OPERATION_COUNT = DEPLOYMENT_MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.graeditor.deployment_model.impl.ProcessorNodeModuleImpl <em>Processor Node Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.deployment_model.impl.ProcessorNodeModuleImpl
	 * @see com.graeditor.deployment_model.impl.Deployment_modelPackageImpl#getProcessorNodeModule()
	 * @generated
	 */
	int PROCESSOR_NODE_MODULE = 2;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_NODE_MODULE__PICTOGRAM_ELEMENT = DEPLOYMENT_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_NODE_MODULE__PREVIOUS_MODULES = DEPLOYMENT_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_NODE_MODULE__NEXT = DEPLOYMENT_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_NODE_MODULE__NAME = DEPLOYMENT_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_NODE_MODULE__TEXT_CONTENT = DEPLOYMENT_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Processor Node Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_NODE_MODULE_FEATURE_COUNT = DEPLOYMENT_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Processor Node Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_NODE_MODULE_OPERATION_COUNT = DEPLOYMENT_MODULE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link com.graeditor.deployment_model.DeploymentModule <em>Deployment Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment Module</em>'.
	 * @see com.graeditor.deployment_model.DeploymentModule
	 * @generated
	 */
	EClass getDeploymentModule();

	/**
	 * Returns the meta object for the reference '{@link com.graeditor.deployment_model.DeploymentModule#getPictogramElement <em>Pictogram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pictogram Element</em>'.
	 * @see com.graeditor.deployment_model.DeploymentModule#getPictogramElement()
	 * @see #getDeploymentModule()
	 * @generated
	 */
	EReference getDeploymentModule_PictogramElement();

	/**
	 * Returns the meta object for the reference '{@link com.graeditor.deployment_model.DeploymentModule#getPreviousModules <em>Previous Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Previous Modules</em>'.
	 * @see com.graeditor.deployment_model.DeploymentModule#getPreviousModules()
	 * @see #getDeploymentModule()
	 * @generated
	 */
	EReference getDeploymentModule_PreviousModules();

	/**
	 * Returns the meta object for the reference list '{@link com.graeditor.deployment_model.DeploymentModule#getNext <em>Next</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Next</em>'.
	 * @see com.graeditor.deployment_model.DeploymentModule#getNext()
	 * @see #getDeploymentModule()
	 * @generated
	 */
	EReference getDeploymentModule_Next();

	/**
	 * Returns the meta object for the attribute '{@link com.graeditor.deployment_model.DeploymentModule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.graeditor.deployment_model.DeploymentModule#getName()
	 * @see #getDeploymentModule()
	 * @generated
	 */
	EAttribute getDeploymentModule_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.graeditor.deployment_model.DeploymentModule#getTextContent <em>Text Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Content</em>'.
	 * @see com.graeditor.deployment_model.DeploymentModule#getTextContent()
	 * @see #getDeploymentModule()
	 * @generated
	 */
	EAttribute getDeploymentModule_TextContent();

	/**
	 * Returns the meta object for class '{@link com.graeditor.deployment_model.DeviceNodeModule <em>Device Node Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Device Node Module</em>'.
	 * @see com.graeditor.deployment_model.DeviceNodeModule
	 * @generated
	 */
	EClass getDeviceNodeModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.deployment_model.ProcessorNodeModule <em>Processor Node Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processor Node Module</em>'.
	 * @see com.graeditor.deployment_model.ProcessorNodeModule
	 * @generated
	 */
	EClass getProcessorNodeModule();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Deployment_modelFactory getDeployment_modelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.graeditor.deployment_model.impl.DeploymentModuleImpl <em>Deployment Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.deployment_model.impl.DeploymentModuleImpl
		 * @see com.graeditor.deployment_model.impl.Deployment_modelPackageImpl#getDeploymentModule()
		 * @generated
		 */
		EClass DEPLOYMENT_MODULE = eINSTANCE.getDeploymentModule();

		/**
		 * The meta object literal for the '<em><b>Pictogram Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_MODULE__PICTOGRAM_ELEMENT = eINSTANCE.getDeploymentModule_PictogramElement();

		/**
		 * The meta object literal for the '<em><b>Previous Modules</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_MODULE__PREVIOUS_MODULES = eINSTANCE.getDeploymentModule_PreviousModules();

		/**
		 * The meta object literal for the '<em><b>Next</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_MODULE__NEXT = eINSTANCE.getDeploymentModule_Next();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYMENT_MODULE__NAME = eINSTANCE.getDeploymentModule_Name();

		/**
		 * The meta object literal for the '<em><b>Text Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYMENT_MODULE__TEXT_CONTENT = eINSTANCE.getDeploymentModule_TextContent();

		/**
		 * The meta object literal for the '{@link com.graeditor.deployment_model.impl.DeviceNodeModuleImpl <em>Device Node Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.deployment_model.impl.DeviceNodeModuleImpl
		 * @see com.graeditor.deployment_model.impl.Deployment_modelPackageImpl#getDeviceNodeModule()
		 * @generated
		 */
		EClass DEVICE_NODE_MODULE = eINSTANCE.getDeviceNodeModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.deployment_model.impl.ProcessorNodeModuleImpl <em>Processor Node Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.deployment_model.impl.ProcessorNodeModuleImpl
		 * @see com.graeditor.deployment_model.impl.Deployment_modelPackageImpl#getProcessorNodeModule()
		 * @generated
		 */
		EClass PROCESSOR_NODE_MODULE = eINSTANCE.getProcessorNodeModule();

	}

} //Deployment_modelPackage
