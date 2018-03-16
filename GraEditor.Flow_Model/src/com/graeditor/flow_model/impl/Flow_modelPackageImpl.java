/**
 */
package com.graeditor.flow_model.impl;

import com.graeditor.flow_model.ContentModule;
import com.graeditor.flow_model.ControlTagModule;
import com.graeditor.flow_model.EndTagModule;
import com.graeditor.flow_model.FenChaModule;
import com.graeditor.flow_model.Flow;
import com.graeditor.flow_model.FlowModule;
import com.graeditor.flow_model.Flow_modelFactory;
import com.graeditor.flow_model.Flow_modelPackage;
import com.graeditor.flow_model.HeBingModule;
import com.graeditor.flow_model.HorizontalLineMoudle;
import com.graeditor.flow_model.HuiHeModule;
import com.graeditor.flow_model.PreLogInTagModule;
import com.graeditor.flow_model.StartTagModule;

import com.graeditor.flow_model.TitleMoudle;
import com.graeditor.flow_model.VerticalLineModule;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Flow_modelPackageImpl extends EPackageImpl implements Flow_modelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contentModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endTagModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startTagModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass verticalLineModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass horizontalLineMoudleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass titleMoudleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass preLogInTagModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass controlTagModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fenChaModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass heBingModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass huiHeModuleEClass = null;

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
	 * @see com.graeditor.flow_model.Flow_modelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Flow_modelPackageImpl() {
		super(eNS_URI, Flow_modelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Flow_modelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Flow_modelPackage init() {
		if (isInited) return (Flow_modelPackage)EPackage.Registry.INSTANCE.getEPackage(Flow_modelPackage.eNS_URI);

		// Obtain or create and register package
		Flow_modelPackageImpl theFlow_modelPackage = (Flow_modelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Flow_modelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Flow_modelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theFlow_modelPackage.createPackageContents();

		// Initialize created meta-data
		theFlow_modelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFlow_modelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Flow_modelPackage.eNS_URI, theFlow_modelPackage);
		return theFlow_modelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContentModule() {
		return contentModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndTagModule() {
		return endTagModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlow() {
		return flowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlow_Modules() {
		return (EReference)flowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlow_EndTag() {
		return (EReference)flowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowModule() {
		return flowModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowModule_PictogramElement() {
		return (EReference)flowModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowModule_PreviousModules() {
		return (EReference)flowModuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowModule_Next() {
		return (EReference)flowModuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlowModule_Name() {
		return (EAttribute)flowModuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlowModule_TextContent() {
		return (EAttribute)flowModuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartTagModule() {
		return startTagModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVerticalLineModule() {
		return verticalLineModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHorizontalLineMoudle() {
		return horizontalLineMoudleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTitleMoudle() {
		return titleMoudleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPreLogInTagModule() {
		return preLogInTagModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getControlTagModule() {
		return controlTagModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFenChaModule() {
		return fenChaModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHeBingModule() {
		return heBingModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHuiHeModule() {
		return huiHeModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Flow_modelFactory getFlow_modelFactory() {
		return (Flow_modelFactory)getEFactoryInstance();
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
		contentModuleEClass = createEClass(CONTENT_MODULE);

		endTagModuleEClass = createEClass(END_TAG_MODULE);

		flowEClass = createEClass(FLOW);
		createEReference(flowEClass, FLOW__MODULES);
		createEReference(flowEClass, FLOW__END_TAG);

		flowModuleEClass = createEClass(FLOW_MODULE);
		createEReference(flowModuleEClass, FLOW_MODULE__PICTOGRAM_ELEMENT);
		createEReference(flowModuleEClass, FLOW_MODULE__PREVIOUS_MODULES);
		createEReference(flowModuleEClass, FLOW_MODULE__NEXT);
		createEAttribute(flowModuleEClass, FLOW_MODULE__NAME);
		createEAttribute(flowModuleEClass, FLOW_MODULE__TEXT_CONTENT);

		startTagModuleEClass = createEClass(START_TAG_MODULE);

		verticalLineModuleEClass = createEClass(VERTICAL_LINE_MODULE);

		horizontalLineMoudleEClass = createEClass(HORIZONTAL_LINE_MOUDLE);

		titleMoudleEClass = createEClass(TITLE_MOUDLE);

		preLogInTagModuleEClass = createEClass(PRE_LOG_IN_TAG_MODULE);

		controlTagModuleEClass = createEClass(CONTROL_TAG_MODULE);

		fenChaModuleEClass = createEClass(FEN_CHA_MODULE);

		heBingModuleEClass = createEClass(HE_BING_MODULE);

		huiHeModuleEClass = createEClass(HUI_HE_MODULE);
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
		contentModuleEClass.getESuperTypes().add(this.getFlowModule());
		endTagModuleEClass.getESuperTypes().add(this.getFlowModule());
		startTagModuleEClass.getESuperTypes().add(this.getFlowModule());
		verticalLineModuleEClass.getESuperTypes().add(this.getFlowModule());
		horizontalLineMoudleEClass.getESuperTypes().add(this.getFlowModule());
		titleMoudleEClass.getESuperTypes().add(this.getFlowModule());
		preLogInTagModuleEClass.getESuperTypes().add(this.getFlowModule());
		controlTagModuleEClass.getESuperTypes().add(this.getFlowModule());
		fenChaModuleEClass.getESuperTypes().add(this.getFlowModule());
		heBingModuleEClass.getESuperTypes().add(this.getFlowModule());
		huiHeModuleEClass.getESuperTypes().add(this.getFlowModule());

		// Initialize classes, features, and operations; add parameters
		initEClass(contentModuleEClass, ContentModule.class, "ContentModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(endTagModuleEClass, EndTagModule.class, "EndTagModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(flowEClass, Flow.class, "Flow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFlow_Modules(), this.getFlowModule(), null, "modules", null, 0, -1, Flow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlow_EndTag(), this.getEndTagModule(), null, "endTag", null, 0, 1, Flow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flowModuleEClass, FlowModule.class, "FlowModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFlowModule_PictogramElement(), ecorePackage.getEObject(), null, "pictogramElement", null, 0, 1, FlowModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlowModule_PreviousModules(), this.getFlowModule(), this.getFlowModule_Next(), "previousModules", null, 0, -1, FlowModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlowModule_Next(), this.getFlowModule(), this.getFlowModule_PreviousModules(), "next", null, 0, 1, FlowModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFlowModule_Name(), ecorePackage.getEString(), "name", null, 0, 1, FlowModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFlowModule_TextContent(), ecorePackage.getEString(), "textContent", null, 0, 1, FlowModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(startTagModuleEClass, StartTagModule.class, "StartTagModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(verticalLineModuleEClass, VerticalLineModule.class, "VerticalLineModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(horizontalLineMoudleEClass, HorizontalLineMoudle.class, "HorizontalLineMoudle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(titleMoudleEClass, TitleMoudle.class, "TitleMoudle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(preLogInTagModuleEClass, PreLogInTagModule.class, "PreLogInTagModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(controlTagModuleEClass, ControlTagModule.class, "ControlTagModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fenChaModuleEClass, FenChaModule.class, "FenChaModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(heBingModuleEClass, HeBingModule.class, "HeBingModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(huiHeModuleEClass, HuiHeModule.class, "HuiHeModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}
	
//	protected Resource creatResource(String uri){
//		return super.createResource("file:///E:/Client/GraEditor.Flow_Model/model/flow_model.ecore");
//	}

} //Flow_modelPackageImpl
