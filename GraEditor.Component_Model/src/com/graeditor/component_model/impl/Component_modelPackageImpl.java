/**
 */
package com.graeditor.component_model.impl;

import com.graeditor.component_model.ComponentModule;
import com.graeditor.component_model.Component_modelFactory;
import com.graeditor.component_model.Component_modelPackage;
import com.graeditor.component_model.DatabaseModule;
import com.graeditor.component_model.LittleComponentModule;
import com.graeditor.component_model.LittleFramworkModule;
import com.graeditor.component_model.LittleInterfaceModule;

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
public class Component_modelPackageImpl extends EPackageImpl implements Component_modelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass databaseModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass littleComponentModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass littleFramworkModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass littleInterfaceModuleEClass = null;

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
	 * @see com.graeditor.component_model.Component_modelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Component_modelPackageImpl() {
		super(eNS_URI, Component_modelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Component_modelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Component_modelPackage init() {
		if (isInited) return (Component_modelPackage)EPackage.Registry.INSTANCE.getEPackage(Component_modelPackage.eNS_URI);

		// Obtain or create and register package
		Component_modelPackageImpl theComponent_modelPackage = (Component_modelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Component_modelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Component_modelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theComponent_modelPackage.createPackageContents();

		// Initialize created meta-data
		theComponent_modelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theComponent_modelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Component_modelPackage.eNS_URI, theComponent_modelPackage);
		return theComponent_modelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentModule() {
		return componentModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentModule_PictogramElement() {
		return (EReference)componentModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentModule_PreviousModules() {
		return (EReference)componentModuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentModule_Next() {
		return (EReference)componentModuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentModule_Name() {
		return (EAttribute)componentModuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentModule_TextContent() {
		return (EAttribute)componentModuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDatabaseModule() {
		return databaseModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLittleComponentModule() {
		return littleComponentModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLittleFramworkModule() {
		return littleFramworkModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLittleInterfaceModule() {
		return littleInterfaceModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component_modelFactory getComponent_modelFactory() {
		return (Component_modelFactory)getEFactoryInstance();
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
		componentModuleEClass = createEClass(COMPONENT_MODULE);
		createEReference(componentModuleEClass, COMPONENT_MODULE__PICTOGRAM_ELEMENT);
		createEReference(componentModuleEClass, COMPONENT_MODULE__PREVIOUS_MODULES);
		createEReference(componentModuleEClass, COMPONENT_MODULE__NEXT);
		createEAttribute(componentModuleEClass, COMPONENT_MODULE__NAME);
		createEAttribute(componentModuleEClass, COMPONENT_MODULE__TEXT_CONTENT);

		databaseModuleEClass = createEClass(DATABASE_MODULE);

		littleComponentModuleEClass = createEClass(LITTLE_COMPONENT_MODULE);

		littleFramworkModuleEClass = createEClass(LITTLE_FRAMWORK_MODULE);

		littleInterfaceModuleEClass = createEClass(LITTLE_INTERFACE_MODULE);
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
		databaseModuleEClass.getESuperTypes().add(this.getComponentModule());
		littleComponentModuleEClass.getESuperTypes().add(this.getComponentModule());
		littleFramworkModuleEClass.getESuperTypes().add(this.getComponentModule());
		littleInterfaceModuleEClass.getESuperTypes().add(this.getComponentModule());

		// Initialize classes, features, and operations; add parameters
		initEClass(componentModuleEClass, ComponentModule.class, "ComponentModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentModule_PictogramElement(), ecorePackage.getEObject(), null, "pictogramElement", null, 0, 1, ComponentModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentModule_PreviousModules(), this.getComponentModule(), this.getComponentModule_Next(), "previousModules", null, 0, 1, ComponentModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentModule_Next(), this.getComponentModule(), this.getComponentModule_PreviousModules(), "next", null, 0, -1, ComponentModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentModule_Name(), ecorePackage.getEString(), "name", null, 0, 1, ComponentModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentModule_TextContent(), ecorePackage.getEString(), "textContent", null, 0, 1, ComponentModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(databaseModuleEClass, DatabaseModule.class, "DatabaseModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(littleComponentModuleEClass, LittleComponentModule.class, "LittleComponentModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(littleFramworkModuleEClass, LittleFramworkModule.class, "LittleFramworkModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(littleInterfaceModuleEClass, LittleInterfaceModule.class, "LittleInterfaceModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}
	
	@Override
	protected Resource createResource(String uri){
		return super.createResource("E:/Git/buptsse2015/buptsse2015/GraEditor.Component_Model/model/component_model.ecore");
	}

} //Component_modelPackageImpl
