/**
 */
package com.graeditor.vocabulary_model.impl;

import com.graeditor.vocabulary_model.AreaModule;
import com.graeditor.vocabulary_model.FileModule;
import com.graeditor.vocabulary_model.FileStackModule;
import com.graeditor.vocabulary_model.PageModule;
import com.graeditor.vocabulary_model.PageStackModule;
import com.graeditor.vocabulary_model.VocabularyModule;
import com.graeditor.vocabulary_model.Vocabulary_modelFactory;
import com.graeditor.vocabulary_model.Vocabulary_modelPackage;

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
public class Vocabulary_modelPackageImpl extends EPackageImpl implements Vocabulary_modelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass areaModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vocabularyModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileStackModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pageModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pageStackModuleEClass = null;

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
	 * @see com.graeditor.vocabulary_model.Vocabulary_modelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Vocabulary_modelPackageImpl() {
		super(eNS_URI, Vocabulary_modelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Vocabulary_modelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Vocabulary_modelPackage init() {
		if (isInited) return (Vocabulary_modelPackage)EPackage.Registry.INSTANCE.getEPackage(Vocabulary_modelPackage.eNS_URI);

		// Obtain or create and register package
		Vocabulary_modelPackageImpl theVocabulary_modelPackage = (Vocabulary_modelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Vocabulary_modelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Vocabulary_modelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theVocabulary_modelPackage.createPackageContents();

		// Initialize created meta-data
		theVocabulary_modelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theVocabulary_modelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Vocabulary_modelPackage.eNS_URI, theVocabulary_modelPackage);
		return theVocabulary_modelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAreaModule() {
		return areaModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVocabularyModule() {
		return vocabularyModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVocabularyModule_PictogramElement() {
		return (EReference)vocabularyModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVocabularyModule_PreviousModules() {
		return (EReference)vocabularyModuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVocabularyModule_Next() {
		return (EReference)vocabularyModuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVocabularyModule_Name() {
		return (EAttribute)vocabularyModuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVocabularyModule_TextContent() {
		return (EAttribute)vocabularyModuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileModule() {
		return fileModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileStackModule() {
		return fileStackModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPageModule() {
		return pageModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPageStackModule() {
		return pageStackModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vocabulary_modelFactory getVocabulary_modelFactory() {
		return (Vocabulary_modelFactory)getEFactoryInstance();
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
		areaModuleEClass = createEClass(AREA_MODULE);

		vocabularyModuleEClass = createEClass(VOCABULARY_MODULE);
		createEReference(vocabularyModuleEClass, VOCABULARY_MODULE__PICTOGRAM_ELEMENT);
		createEReference(vocabularyModuleEClass, VOCABULARY_MODULE__PREVIOUS_MODULES);
		createEReference(vocabularyModuleEClass, VOCABULARY_MODULE__NEXT);
		createEAttribute(vocabularyModuleEClass, VOCABULARY_MODULE__NAME);
		createEAttribute(vocabularyModuleEClass, VOCABULARY_MODULE__TEXT_CONTENT);

		fileModuleEClass = createEClass(FILE_MODULE);

		fileStackModuleEClass = createEClass(FILE_STACK_MODULE);

		pageModuleEClass = createEClass(PAGE_MODULE);

		pageStackModuleEClass = createEClass(PAGE_STACK_MODULE);
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
		areaModuleEClass.getESuperTypes().add(this.getVocabularyModule());
		fileModuleEClass.getESuperTypes().add(this.getVocabularyModule());
		fileStackModuleEClass.getESuperTypes().add(this.getVocabularyModule());
		pageModuleEClass.getESuperTypes().add(this.getVocabularyModule());
		pageStackModuleEClass.getESuperTypes().add(this.getVocabularyModule());

		// Initialize classes, features, and operations; add parameters
		initEClass(areaModuleEClass, AreaModule.class, "AreaModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(vocabularyModuleEClass, VocabularyModule.class, "VocabularyModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVocabularyModule_PictogramElement(), ecorePackage.getEObject(), null, "pictogramElement", null, 0, 1, VocabularyModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVocabularyModule_PreviousModules(), this.getVocabularyModule(), this.getVocabularyModule_Next(), "previousModules", null, 0, -1, VocabularyModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVocabularyModule_Next(), this.getVocabularyModule(), this.getVocabularyModule_PreviousModules(), "next", null, 0, 1, VocabularyModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVocabularyModule_Name(), ecorePackage.getEString(), "name", null, 0, 1, VocabularyModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVocabularyModule_TextContent(), ecorePackage.getEString(), "textContent", null, 0, 1, VocabularyModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fileModuleEClass, FileModule.class, "FileModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fileStackModuleEClass, FileStackModule.class, "FileStackModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pageModuleEClass, PageModule.class, "PageModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pageStackModuleEClass, PageStackModule.class, "PageStackModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}
	
	@Override
	protected Resource createResource(String uri){
		return super.createResource("E:/Git/buptsse2015/buptsse2015/GraEditor.Vocabulary_model/model/vocabulary_model.ecore");
	}

} //Vocabulary_modelPackageImpl
