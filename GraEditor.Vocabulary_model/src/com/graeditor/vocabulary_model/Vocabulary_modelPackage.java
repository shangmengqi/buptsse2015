/**
 */
package com.graeditor.vocabulary_model;

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
 * @see com.graeditor.vocabulary_model.Vocabulary_modelFactory
 * @model kind="package"
 * @generated
 */
public interface Vocabulary_modelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "vocabulary_model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///com/graeditor/vocabulary_model.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.graeditor.vocabulary_model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Vocabulary_modelPackage eINSTANCE = com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.graeditor.vocabulary_model.impl.VocabularyModuleImpl <em>Vocabulary Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.vocabulary_model.impl.VocabularyModuleImpl
	 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getVocabularyModule()
	 * @generated
	 */
	int VOCABULARY_MODULE = 1;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_MODULE__PICTOGRAM_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_MODULE__PREVIOUS_MODULES = 1;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_MODULE__NEXT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_MODULE__NAME = 3;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_MODULE__TEXT_CONTENT = 4;

	/**
	 * The number of structural features of the '<em>Vocabulary Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_MODULE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Vocabulary Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOCABULARY_MODULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.graeditor.vocabulary_model.impl.AreaModuleImpl <em>Area Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.vocabulary_model.impl.AreaModuleImpl
	 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getAreaModule()
	 * @generated
	 */
	int AREA_MODULE = 0;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_MODULE__PICTOGRAM_ELEMENT = VOCABULARY_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_MODULE__PREVIOUS_MODULES = VOCABULARY_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_MODULE__NEXT = VOCABULARY_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_MODULE__NAME = VOCABULARY_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_MODULE__TEXT_CONTENT = VOCABULARY_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Area Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_MODULE_FEATURE_COUNT = VOCABULARY_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Area Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_MODULE_OPERATION_COUNT = VOCABULARY_MODULE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link com.graeditor.vocabulary_model.impl.FileModuleImpl <em>File Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.vocabulary_model.impl.FileModuleImpl
	 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getFileModule()
	 * @generated
	 */
	int FILE_MODULE = 2;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODULE__PICTOGRAM_ELEMENT = VOCABULARY_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODULE__PREVIOUS_MODULES = VOCABULARY_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODULE__NEXT = VOCABULARY_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODULE__NAME = VOCABULARY_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODULE__TEXT_CONTENT = VOCABULARY_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>File Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODULE_FEATURE_COUNT = VOCABULARY_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>File Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_MODULE_OPERATION_COUNT = VOCABULARY_MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.graeditor.vocabulary_model.impl.FileStackModuleImpl <em>File Stack Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.vocabulary_model.impl.FileStackModuleImpl
	 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getFileStackModule()
	 * @generated
	 */
	int FILE_STACK_MODULE = 3;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_STACK_MODULE__PICTOGRAM_ELEMENT = VOCABULARY_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_STACK_MODULE__PREVIOUS_MODULES = VOCABULARY_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_STACK_MODULE__NEXT = VOCABULARY_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_STACK_MODULE__NAME = VOCABULARY_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_STACK_MODULE__TEXT_CONTENT = VOCABULARY_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>File Stack Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_STACK_MODULE_FEATURE_COUNT = VOCABULARY_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>File Stack Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_STACK_MODULE_OPERATION_COUNT = VOCABULARY_MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.graeditor.vocabulary_model.impl.PageModuleImpl <em>Page Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.vocabulary_model.impl.PageModuleImpl
	 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getPageModule()
	 * @generated
	 */
	int PAGE_MODULE = 4;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_MODULE__PICTOGRAM_ELEMENT = VOCABULARY_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_MODULE__PREVIOUS_MODULES = VOCABULARY_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_MODULE__NEXT = VOCABULARY_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_MODULE__NAME = VOCABULARY_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_MODULE__TEXT_CONTENT = VOCABULARY_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Page Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_MODULE_FEATURE_COUNT = VOCABULARY_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Page Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_MODULE_OPERATION_COUNT = VOCABULARY_MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.graeditor.vocabulary_model.impl.PageStackModuleImpl <em>Page Stack Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.vocabulary_model.impl.PageStackModuleImpl
	 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getPageStackModule()
	 * @generated
	 */
	int PAGE_STACK_MODULE = 5;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_STACK_MODULE__PICTOGRAM_ELEMENT = VOCABULARY_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_STACK_MODULE__PREVIOUS_MODULES = VOCABULARY_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_STACK_MODULE__NEXT = VOCABULARY_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_STACK_MODULE__NAME = VOCABULARY_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_STACK_MODULE__TEXT_CONTENT = VOCABULARY_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Page Stack Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_STACK_MODULE_FEATURE_COUNT = VOCABULARY_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Page Stack Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_STACK_MODULE_OPERATION_COUNT = VOCABULARY_MODULE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link com.graeditor.vocabulary_model.impl.ClusterModuleImpl <em>Cluster Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.vocabulary_model.impl.ClusterModuleImpl
	 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getClusterModule()
	 * @generated
	 */
	int CLUSTER_MODULE = 6;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_MODULE__PICTOGRAM_ELEMENT = VOCABULARY_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_MODULE__PREVIOUS_MODULES = VOCABULARY_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_MODULE__NEXT = VOCABULARY_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_MODULE__NAME = VOCABULARY_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_MODULE__TEXT_CONTENT = VOCABULARY_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Cluster Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_MODULE_FEATURE_COUNT = VOCABULARY_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Cluster Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_MODULE_OPERATION_COUNT = VOCABULARY_MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.graeditor.vocabulary_model.impl.ConcurrentSetModuleImpl <em>Concurrent Set Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.vocabulary_model.impl.ConcurrentSetModuleImpl
	 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getConcurrentSetModule()
	 * @generated
	 */
	int CONCURRENT_SET_MODULE = 7;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCURRENT_SET_MODULE__PICTOGRAM_ELEMENT = VOCABULARY_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCURRENT_SET_MODULE__PREVIOUS_MODULES = VOCABULARY_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCURRENT_SET_MODULE__NEXT = VOCABULARY_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCURRENT_SET_MODULE__NAME = VOCABULARY_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCURRENT_SET_MODULE__TEXT_CONTENT = VOCABULARY_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Concurrent Set Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCURRENT_SET_MODULE_FEATURE_COUNT = VOCABULARY_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Concurrent Set Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCURRENT_SET_MODULE_OPERATION_COUNT = VOCABULARY_MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.graeditor.vocabulary_model.impl.CondBranchModuleImpl <em>Cond Branch Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.vocabulary_model.impl.CondBranchModuleImpl
	 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getCondBranchModule()
	 * @generated
	 */
	int COND_BRANCH_MODULE = 8;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COND_BRANCH_MODULE__PICTOGRAM_ELEMENT = VOCABULARY_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COND_BRANCH_MODULE__PREVIOUS_MODULES = VOCABULARY_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COND_BRANCH_MODULE__NEXT = VOCABULARY_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COND_BRANCH_MODULE__NAME = VOCABULARY_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COND_BRANCH_MODULE__TEXT_CONTENT = VOCABULARY_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Cond Branch Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COND_BRANCH_MODULE_FEATURE_COUNT = VOCABULARY_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Cond Branch Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COND_BRANCH_MODULE_OPERATION_COUNT = VOCABULARY_MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.graeditor.vocabulary_model.impl.ContHorzModuleImpl <em>Cont Horz Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.vocabulary_model.impl.ContHorzModuleImpl
	 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getContHorzModule()
	 * @generated
	 */
	int CONT_HORZ_MODULE = 9;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONT_HORZ_MODULE__PICTOGRAM_ELEMENT = VOCABULARY_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONT_HORZ_MODULE__PREVIOUS_MODULES = VOCABULARY_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONT_HORZ_MODULE__NEXT = VOCABULARY_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONT_HORZ_MODULE__NAME = VOCABULARY_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONT_HORZ_MODULE__TEXT_CONTENT = VOCABULARY_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Cont Horz Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONT_HORZ_MODULE_FEATURE_COUNT = VOCABULARY_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Cont Horz Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONT_HORZ_MODULE_OPERATION_COUNT = VOCABULARY_MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.graeditor.vocabulary_model.impl.ContVertModuleImpl <em>Cont Vert Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.vocabulary_model.impl.ContVertModuleImpl
	 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getContVertModule()
	 * @generated
	 */
	int CONT_VERT_MODULE = 10;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONT_VERT_MODULE__PICTOGRAM_ELEMENT = VOCABULARY_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONT_VERT_MODULE__PREVIOUS_MODULES = VOCABULARY_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONT_VERT_MODULE__NEXT = VOCABULARY_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONT_VERT_MODULE__NAME = VOCABULARY_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONT_VERT_MODULE__TEXT_CONTENT = VOCABULARY_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Cont Vert Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONT_VERT_MODULE_FEATURE_COUNT = VOCABULARY_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Cont Vert Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONT_VERT_MODULE_OPERATION_COUNT = VOCABULARY_MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.graeditor.vocabulary_model.impl.DecPointModuleImpl <em>Dec Point Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.vocabulary_model.impl.DecPointModuleImpl
	 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getDecPointModule()
	 * @generated
	 */
	int DEC_POINT_MODULE = 11;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEC_POINT_MODULE__PICTOGRAM_ELEMENT = VOCABULARY_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEC_POINT_MODULE__PREVIOUS_MODULES = VOCABULARY_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEC_POINT_MODULE__NEXT = VOCABULARY_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEC_POINT_MODULE__NAME = VOCABULARY_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEC_POINT_MODULE__TEXT_CONTENT = VOCABULARY_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Dec Point Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEC_POINT_MODULE_FEATURE_COUNT = VOCABULARY_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Dec Point Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEC_POINT_MODULE_OPERATION_COUNT = VOCABULARY_MODULE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link com.graeditor.vocabulary_model.AreaModule <em>Area Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Area Module</em>'.
	 * @see com.graeditor.vocabulary_model.AreaModule
	 * @generated
	 */
	EClass getAreaModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.vocabulary_model.VocabularyModule <em>Vocabulary Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vocabulary Module</em>'.
	 * @see com.graeditor.vocabulary_model.VocabularyModule
	 * @generated
	 */
	EClass getVocabularyModule();

	/**
	 * Returns the meta object for the reference '{@link com.graeditor.vocabulary_model.VocabularyModule#getPictogramElement <em>Pictogram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pictogram Element</em>'.
	 * @see com.graeditor.vocabulary_model.VocabularyModule#getPictogramElement()
	 * @see #getVocabularyModule()
	 * @generated
	 */
	EReference getVocabularyModule_PictogramElement();

	/**
	 * Returns the meta object for the reference list '{@link com.graeditor.vocabulary_model.VocabularyModule#getPreviousModules <em>Previous Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Previous Modules</em>'.
	 * @see com.graeditor.vocabulary_model.VocabularyModule#getPreviousModules()
	 * @see #getVocabularyModule()
	 * @generated
	 */
	EReference getVocabularyModule_PreviousModules();

	/**
	 * Returns the meta object for the reference '{@link com.graeditor.vocabulary_model.VocabularyModule#getNext <em>Next</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next</em>'.
	 * @see com.graeditor.vocabulary_model.VocabularyModule#getNext()
	 * @see #getVocabularyModule()
	 * @generated
	 */
	EReference getVocabularyModule_Next();

	/**
	 * Returns the meta object for the attribute '{@link com.graeditor.vocabulary_model.VocabularyModule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.graeditor.vocabulary_model.VocabularyModule#getName()
	 * @see #getVocabularyModule()
	 * @generated
	 */
	EAttribute getVocabularyModule_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.graeditor.vocabulary_model.VocabularyModule#getTextContent <em>Text Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Content</em>'.
	 * @see com.graeditor.vocabulary_model.VocabularyModule#getTextContent()
	 * @see #getVocabularyModule()
	 * @generated
	 */
	EAttribute getVocabularyModule_TextContent();

	/**
	 * Returns the meta object for class '{@link com.graeditor.vocabulary_model.FileModule <em>File Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Module</em>'.
	 * @see com.graeditor.vocabulary_model.FileModule
	 * @generated
	 */
	EClass getFileModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.vocabulary_model.FileStackModule <em>File Stack Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Stack Module</em>'.
	 * @see com.graeditor.vocabulary_model.FileStackModule
	 * @generated
	 */
	EClass getFileStackModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.vocabulary_model.PageModule <em>Page Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Module</em>'.
	 * @see com.graeditor.vocabulary_model.PageModule
	 * @generated
	 */
	EClass getPageModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.vocabulary_model.PageStackModule <em>Page Stack Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Stack Module</em>'.
	 * @see com.graeditor.vocabulary_model.PageStackModule
	 * @generated
	 */
	EClass getPageStackModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.vocabulary_model.ClusterModule <em>Cluster Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cluster Module</em>'.
	 * @see com.graeditor.vocabulary_model.ClusterModule
	 * @generated
	 */
	EClass getClusterModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.vocabulary_model.ConcurrentSetModule <em>Concurrent Set Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concurrent Set Module</em>'.
	 * @see com.graeditor.vocabulary_model.ConcurrentSetModule
	 * @generated
	 */
	EClass getConcurrentSetModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.vocabulary_model.CondBranchModule <em>Cond Branch Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cond Branch Module</em>'.
	 * @see com.graeditor.vocabulary_model.CondBranchModule
	 * @generated
	 */
	EClass getCondBranchModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.vocabulary_model.ContHorzModule <em>Cont Horz Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cont Horz Module</em>'.
	 * @see com.graeditor.vocabulary_model.ContHorzModule
	 * @generated
	 */
	EClass getContHorzModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.vocabulary_model.ContVertModule <em>Cont Vert Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cont Vert Module</em>'.
	 * @see com.graeditor.vocabulary_model.ContVertModule
	 * @generated
	 */
	EClass getContVertModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.vocabulary_model.DecPointModule <em>Dec Point Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dec Point Module</em>'.
	 * @see com.graeditor.vocabulary_model.DecPointModule
	 * @generated
	 */
	EClass getDecPointModule();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Vocabulary_modelFactory getVocabulary_modelFactory();

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
		 * The meta object literal for the '{@link com.graeditor.vocabulary_model.impl.AreaModuleImpl <em>Area Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.vocabulary_model.impl.AreaModuleImpl
		 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getAreaModule()
		 * @generated
		 */
		EClass AREA_MODULE = eINSTANCE.getAreaModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.vocabulary_model.impl.VocabularyModuleImpl <em>Vocabulary Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.vocabulary_model.impl.VocabularyModuleImpl
		 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getVocabularyModule()
		 * @generated
		 */
		EClass VOCABULARY_MODULE = eINSTANCE.getVocabularyModule();

		/**
		 * The meta object literal for the '<em><b>Pictogram Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOCABULARY_MODULE__PICTOGRAM_ELEMENT = eINSTANCE.getVocabularyModule_PictogramElement();

		/**
		 * The meta object literal for the '<em><b>Previous Modules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOCABULARY_MODULE__PREVIOUS_MODULES = eINSTANCE.getVocabularyModule_PreviousModules();

		/**
		 * The meta object literal for the '<em><b>Next</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VOCABULARY_MODULE__NEXT = eINSTANCE.getVocabularyModule_Next();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VOCABULARY_MODULE__NAME = eINSTANCE.getVocabularyModule_Name();

		/**
		 * The meta object literal for the '<em><b>Text Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VOCABULARY_MODULE__TEXT_CONTENT = eINSTANCE.getVocabularyModule_TextContent();

		/**
		 * The meta object literal for the '{@link com.graeditor.vocabulary_model.impl.FileModuleImpl <em>File Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.vocabulary_model.impl.FileModuleImpl
		 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getFileModule()
		 * @generated
		 */
		EClass FILE_MODULE = eINSTANCE.getFileModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.vocabulary_model.impl.FileStackModuleImpl <em>File Stack Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.vocabulary_model.impl.FileStackModuleImpl
		 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getFileStackModule()
		 * @generated
		 */
		EClass FILE_STACK_MODULE = eINSTANCE.getFileStackModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.vocabulary_model.impl.PageModuleImpl <em>Page Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.vocabulary_model.impl.PageModuleImpl
		 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getPageModule()
		 * @generated
		 */
		EClass PAGE_MODULE = eINSTANCE.getPageModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.vocabulary_model.impl.PageStackModuleImpl <em>Page Stack Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.vocabulary_model.impl.PageStackModuleImpl
		 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getPageStackModule()
		 * @generated
		 */
		EClass PAGE_STACK_MODULE = eINSTANCE.getPageStackModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.vocabulary_model.impl.ClusterModuleImpl <em>Cluster Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.vocabulary_model.impl.ClusterModuleImpl
		 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getClusterModule()
		 * @generated
		 */
		EClass CLUSTER_MODULE = eINSTANCE.getClusterModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.vocabulary_model.impl.ConcurrentSetModuleImpl <em>Concurrent Set Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.vocabulary_model.impl.ConcurrentSetModuleImpl
		 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getConcurrentSetModule()
		 * @generated
		 */
		EClass CONCURRENT_SET_MODULE = eINSTANCE.getConcurrentSetModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.vocabulary_model.impl.CondBranchModuleImpl <em>Cond Branch Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.vocabulary_model.impl.CondBranchModuleImpl
		 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getCondBranchModule()
		 * @generated
		 */
		EClass COND_BRANCH_MODULE = eINSTANCE.getCondBranchModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.vocabulary_model.impl.ContHorzModuleImpl <em>Cont Horz Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.vocabulary_model.impl.ContHorzModuleImpl
		 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getContHorzModule()
		 * @generated
		 */
		EClass CONT_HORZ_MODULE = eINSTANCE.getContHorzModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.vocabulary_model.impl.ContVertModuleImpl <em>Cont Vert Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.vocabulary_model.impl.ContVertModuleImpl
		 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getContVertModule()
		 * @generated
		 */
		EClass CONT_VERT_MODULE = eINSTANCE.getContVertModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.vocabulary_model.impl.DecPointModuleImpl <em>Dec Point Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.vocabulary_model.impl.DecPointModuleImpl
		 * @see com.graeditor.vocabulary_model.impl.Vocabulary_modelPackageImpl#getDecPointModule()
		 * @generated
		 */
		EClass DEC_POINT_MODULE = eINSTANCE.getDecPointModule();

	}

} //Vocabulary_modelPackage
