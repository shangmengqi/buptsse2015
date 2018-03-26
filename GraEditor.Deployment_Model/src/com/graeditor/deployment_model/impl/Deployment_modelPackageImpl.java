/**
 */
package com.graeditor.deployment_model.impl;

import com.graeditor.deployment_model.DeploymentModule;
import com.graeditor.deployment_model.Deployment_modelFactory;
import com.graeditor.deployment_model.Deployment_modelPackage;
import com.graeditor.deployment_model.DeviceNodeModule;
import com.graeditor.deployment_model.ProcessorNodeModule;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Deployment_modelPackageImpl extends EPackageImpl implements Deployment_modelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deploymentModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deviceNodeModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processorNodeModuleEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.graeditor.deployment_model.Deployment_modelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Deployment_modelPackageImpl() {
		super(eNS_URI, Deployment_modelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link Deployment_modelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Deployment_modelPackage init() {
		if (isInited) return (Deployment_modelPackage)EPackage.Registry.INSTANCE.getEPackage(Deployment_modelPackage.eNS_URI);

		// Obtain or create and register package
		Deployment_modelPackageImpl theDeployment_modelPackage = (Deployment_modelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Deployment_modelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Deployment_modelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theDeployment_modelPackage.createPackageContents();

		// Initialize created meta-data
		theDeployment_modelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDeployment_modelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Deployment_modelPackage.eNS_URI, theDeployment_modelPackage);
		return theDeployment_modelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeploymentModule() {
		return deploymentModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeploymentModule_PictogramElement() {
		return (EReference)deploymentModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeploymentModule_PreviousModules() {
		return (EReference)deploymentModuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeploymentModule_Next() {
		return (EReference)deploymentModuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeploymentModule_Name() {
		return (EAttribute)deploymentModuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeploymentModule_TextContent() {
		return (EAttribute)deploymentModuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeviceNodeModule() {
		return deviceNodeModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessorNodeModule() {
		return processorNodeModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deployment_modelFactory getDeployment_modelFactory() {
		return (Deployment_modelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		deploymentModuleEClass = createEClass(DEPLOYMENT_MODULE);
		createEReference(deploymentModuleEClass, DEPLOYMENT_MODULE__PICTOGRAM_ELEMENT);
		createEReference(deploymentModuleEClass, DEPLOYMENT_MODULE__PREVIOUS_MODULES);
		createEReference(deploymentModuleEClass, DEPLOYMENT_MODULE__NEXT);
		createEAttribute(deploymentModuleEClass, DEPLOYMENT_MODULE__NAME);
		createEAttribute(deploymentModuleEClass, DEPLOYMENT_MODULE__TEXT_CONTENT);

		deviceNodeModuleEClass = createEClass(DEVICE_NODE_MODULE);

		processorNodeModuleEClass = createEClass(PROCESSOR_NODE_MODULE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		deviceNodeModuleEClass.getESuperTypes().add(this.getDeploymentModule());
		processorNodeModuleEClass.getESuperTypes().add(this.getDeploymentModule());

		// Initialize classes, features, and operations; add parameters
		initEClass(deploymentModuleEClass, DeploymentModule.class, "DeploymentModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeploymentModule_PictogramElement(), ecorePackage.getEObject(), null, "pictogramElement", null, 0, 1, DeploymentModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeploymentModule_PreviousModules(), this.getDeploymentModule(), this.getDeploymentModule_Next(), "previousModules", null, 0, 1, DeploymentModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeploymentModule_Next(), this.getDeploymentModule(), this.getDeploymentModule_PreviousModules(), "next", null, 0, -1, DeploymentModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeploymentModule_Name(), ecorePackage.getEString(), "name", null, 0, 1, DeploymentModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeploymentModule_TextContent(), ecorePackage.getEString(), "textContent", null, 0, 1, DeploymentModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deviceNodeModuleEClass, DeviceNodeModule.class, "DeviceNodeModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(processorNodeModuleEClass, ProcessorNodeModule.class, "ProcessorNodeModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}
	
	@Override
	protected Resource createResource(String uri){
		return super.createResource("E:/Git/buptsse2015/buptsse2015/GraEditor.Deployment_Model/model/deployment_model.ecore");
	}

} //Deployment_modelPackageImpl
