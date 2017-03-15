/**
 */
package com.graeditor.relation_model.impl;

import com.graeditor.relation_model.ContentModule;
import com.graeditor.relation_model.HorizontalLineModule;
import com.graeditor.relation_model.Relation;
import com.graeditor.relation_model.RelationModule;
import com.graeditor.relation_model.Relation_modelFactory;
import com.graeditor.relation_model.Relation_modelPackage;
import com.graeditor.relation_model.TitleModule;

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
public class Relation_modelPackageImpl extends EPackageImpl implements Relation_modelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass horizontalLineModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass titleModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contentModuleEClass = null;

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
	 * @see com.graeditor.relation_model.Relation_modelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Relation_modelPackageImpl() {
		super(eNS_URI, Relation_modelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Relation_modelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Relation_modelPackage init() {
		if (isInited) return (Relation_modelPackage)EPackage.Registry.INSTANCE.getEPackage(Relation_modelPackage.eNS_URI);

		// Obtain or create and register package
		Relation_modelPackageImpl theRelation_modelPackage = (Relation_modelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Relation_modelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Relation_modelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theRelation_modelPackage.createPackageContents();

		// Initialize created meta-data
		theRelation_modelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRelation_modelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Relation_modelPackage.eNS_URI, theRelation_modelPackage);
		return theRelation_modelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHorizontalLineModule() {
		return horizontalLineModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelation() {
		return relationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelation_Modules() {
		return (EReference)relationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationModule() {
		return relationModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationModule_PictogramElement() {
		return (EReference)relationModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationModule_Name() {
		return (EAttribute)relationModuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationModule_TextContent() {
		return (EAttribute)relationModuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTitleModule() {
		return titleModuleEClass;
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
	public Relation_modelFactory getRelation_modelFactory() {
		return (Relation_modelFactory)getEFactoryInstance();
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
		horizontalLineModuleEClass = createEClass(HORIZONTAL_LINE_MODULE);

		relationEClass = createEClass(RELATION);
		createEReference(relationEClass, RELATION__MODULES);

		relationModuleEClass = createEClass(RELATION_MODULE);
		createEReference(relationModuleEClass, RELATION_MODULE__PICTOGRAM_ELEMENT);
		createEAttribute(relationModuleEClass, RELATION_MODULE__NAME);
		createEAttribute(relationModuleEClass, RELATION_MODULE__TEXT_CONTENT);

		titleModuleEClass = createEClass(TITLE_MODULE);

		contentModuleEClass = createEClass(CONTENT_MODULE);
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
		horizontalLineModuleEClass.getESuperTypes().add(this.getRelationModule());
		titleModuleEClass.getESuperTypes().add(this.getRelationModule());
		contentModuleEClass.getESuperTypes().add(this.getRelationModule());

		// Initialize classes, features, and operations; add parameters
		initEClass(horizontalLineModuleEClass, HorizontalLineModule.class, "HorizontalLineModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(relationEClass, Relation.class, "Relation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelation_Modules(), this.getRelationModule(), null, "modules", null, 0, -1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationModuleEClass, RelationModule.class, "RelationModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationModule_PictogramElement(), ecorePackage.getEObject(), null, "pictogramElement", null, 0, 1, RelationModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationModule_Name(), ecorePackage.getEString(), "name", null, 0, 1, RelationModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationModule_TextContent(), ecorePackage.getEString(), "textContent", null, 0, 1, RelationModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(titleModuleEClass, TitleModule.class, "TitleModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(contentModuleEClass, ContentModule.class, "ContentModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}
	
	protected Resource creatResource(String uri){
		return super.createResource("file:///E:/Git/buptsse2015/buptsse2015/GraEditor.Relation_Model/model/relation_model.ecore");
	}

} //Relation_modelPackageImpl
