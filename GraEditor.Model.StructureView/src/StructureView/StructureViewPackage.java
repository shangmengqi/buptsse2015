/**
 */
package StructureView;

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
 * @see StructureView.StructureViewFactory
 * @model kind="package"
 * @generated
 */
public interface StructureViewPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "StructureView";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/StructureView";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "StructureView";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StructureViewPackage eINSTANCE = StructureView.impl.StructureViewPackageImpl.init();

	/**
	 * The meta object id for the '{@link StructureView.impl.StructModuleImpl <em>Struct Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see StructureView.impl.StructModuleImpl
	 * @see StructureView.impl.StructureViewPackageImpl#getStructModule()
	 * @generated
	 */
	int STRUCT_MODULE = 4;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_MODULE__PICTOGRAM_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Struct Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_MODULE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Struct Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_MODULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link StructureView.impl.PageImpl <em>Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see StructureView.impl.PageImpl
	 * @see StructureView.impl.StructureViewPackageImpl#getPage()
	 * @generated
	 */
	int PAGE = 0;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__PICTOGRAM_ELEMENT = STRUCT_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__NAME = STRUCT_MODULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>File</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__FILE = STRUCT_MODULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Filegroup</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__FILEGROUP = STRUCT_MODULE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Pagegroup</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__PAGEGROUP = STRUCT_MODULE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Page</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__PAGE = STRUCT_MODULE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_FEATURE_COUNT = STRUCT_MODULE_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_OPERATION_COUNT = STRUCT_MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link StructureView.impl.PageGroupImpl <em>Page Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see StructureView.impl.PageGroupImpl
	 * @see StructureView.impl.StructureViewPackageImpl#getPageGroup()
	 * @generated
	 */
	int PAGE_GROUP = 1;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_GROUP__PICTOGRAM_ELEMENT = STRUCT_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_GROUP__NAME = STRUCT_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Page Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_GROUP_FEATURE_COUNT = STRUCT_MODULE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Page Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_GROUP_OPERATION_COUNT = STRUCT_MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link StructureView.impl.FileImpl <em>File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see StructureView.impl.FileImpl
	 * @see StructureView.impl.StructureViewPackageImpl#getFile()
	 * @generated
	 */
	int FILE = 2;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__PICTOGRAM_ELEMENT = STRUCT_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE__NAME = STRUCT_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_FEATURE_COUNT = STRUCT_MODULE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_OPERATION_COUNT = STRUCT_MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link StructureView.impl.FileGroupImpl <em>File Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see StructureView.impl.FileGroupImpl
	 * @see StructureView.impl.StructureViewPackageImpl#getFileGroup()
	 * @generated
	 */
	int FILE_GROUP = 3;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_GROUP__PICTOGRAM_ELEMENT = STRUCT_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_GROUP__NAME = STRUCT_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>File Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_GROUP_FEATURE_COUNT = STRUCT_MODULE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>File Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_GROUP_OPERATION_COUNT = STRUCT_MODULE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link StructureView.Page <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page</em>'.
	 * @see StructureView.Page
	 * @generated
	 */
	EClass getPage();

	/**
	 * Returns the meta object for the attribute '{@link StructureView.Page#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see StructureView.Page#getName()
	 * @see #getPage()
	 * @generated
	 */
	EAttribute getPage_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link StructureView.Page#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>File</em>'.
	 * @see StructureView.Page#getFile()
	 * @see #getPage()
	 * @generated
	 */
	EReference getPage_File();

	/**
	 * Returns the meta object for the containment reference list '{@link StructureView.Page#getFilegroup <em>Filegroup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Filegroup</em>'.
	 * @see StructureView.Page#getFilegroup()
	 * @see #getPage()
	 * @generated
	 */
	EReference getPage_Filegroup();

	/**
	 * Returns the meta object for the containment reference list '{@link StructureView.Page#getPagegroup <em>Pagegroup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pagegroup</em>'.
	 * @see StructureView.Page#getPagegroup()
	 * @see #getPage()
	 * @generated
	 */
	EReference getPage_Pagegroup();

	/**
	 * Returns the meta object for the containment reference list '{@link StructureView.Page#getPage <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Page</em>'.
	 * @see StructureView.Page#getPage()
	 * @see #getPage()
	 * @generated
	 */
	EReference getPage_Page();

	/**
	 * Returns the meta object for class '{@link StructureView.PageGroup <em>Page Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Group</em>'.
	 * @see StructureView.PageGroup
	 * @generated
	 */
	EClass getPageGroup();

	/**
	 * Returns the meta object for the attribute '{@link StructureView.PageGroup#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see StructureView.PageGroup#getName()
	 * @see #getPageGroup()
	 * @generated
	 */
	EAttribute getPageGroup_Name();

	/**
	 * Returns the meta object for class '{@link StructureView.File <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File</em>'.
	 * @see StructureView.File
	 * @generated
	 */
	EClass getFile();

	/**
	 * Returns the meta object for the attribute '{@link StructureView.File#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see StructureView.File#getName()
	 * @see #getFile()
	 * @generated
	 */
	EAttribute getFile_Name();

	/**
	 * Returns the meta object for class '{@link StructureView.FileGroup <em>File Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Group</em>'.
	 * @see StructureView.FileGroup
	 * @generated
	 */
	EClass getFileGroup();

	/**
	 * Returns the meta object for the attribute '{@link StructureView.FileGroup#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see StructureView.FileGroup#getName()
	 * @see #getFileGroup()
	 * @generated
	 */
	EAttribute getFileGroup_Name();

	/**
	 * Returns the meta object for class '{@link StructureView.StructModule <em>Struct Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Struct Module</em>'.
	 * @see StructureView.StructModule
	 * @generated
	 */
	EClass getStructModule();

	/**
	 * Returns the meta object for the reference '{@link StructureView.StructModule#getPictogramElement <em>Pictogram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pictogram Element</em>'.
	 * @see StructureView.StructModule#getPictogramElement()
	 * @see #getStructModule()
	 * @generated
	 */
	EReference getStructModule_PictogramElement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StructureViewFactory getStructureViewFactory();

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
		 * The meta object literal for the '{@link StructureView.impl.PageImpl <em>Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see StructureView.impl.PageImpl
		 * @see StructureView.impl.StructureViewPackageImpl#getPage()
		 * @generated
		 */
		EClass PAGE = eINSTANCE.getPage();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE__NAME = eINSTANCE.getPage_Name();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE__FILE = eINSTANCE.getPage_File();

		/**
		 * The meta object literal for the '<em><b>Filegroup</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE__FILEGROUP = eINSTANCE.getPage_Filegroup();

		/**
		 * The meta object literal for the '<em><b>Pagegroup</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE__PAGEGROUP = eINSTANCE.getPage_Pagegroup();

		/**
		 * The meta object literal for the '<em><b>Page</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE__PAGE = eINSTANCE.getPage_Page();

		/**
		 * The meta object literal for the '{@link StructureView.impl.PageGroupImpl <em>Page Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see StructureView.impl.PageGroupImpl
		 * @see StructureView.impl.StructureViewPackageImpl#getPageGroup()
		 * @generated
		 */
		EClass PAGE_GROUP = eINSTANCE.getPageGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_GROUP__NAME = eINSTANCE.getPageGroup_Name();

		/**
		 * The meta object literal for the '{@link StructureView.impl.FileImpl <em>File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see StructureView.impl.FileImpl
		 * @see StructureView.impl.StructureViewPackageImpl#getFile()
		 * @generated
		 */
		EClass FILE = eINSTANCE.getFile();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE__NAME = eINSTANCE.getFile_Name();

		/**
		 * The meta object literal for the '{@link StructureView.impl.FileGroupImpl <em>File Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see StructureView.impl.FileGroupImpl
		 * @see StructureView.impl.StructureViewPackageImpl#getFileGroup()
		 * @generated
		 */
		EClass FILE_GROUP = eINSTANCE.getFileGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_GROUP__NAME = eINSTANCE.getFileGroup_Name();

		/**
		 * The meta object literal for the '{@link StructureView.impl.StructModuleImpl <em>Struct Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see StructureView.impl.StructModuleImpl
		 * @see StructureView.impl.StructureViewPackageImpl#getStructModule()
		 * @generated
		 */
		EClass STRUCT_MODULE = eINSTANCE.getStructModule();

		/**
		 * The meta object literal for the '<em><b>Pictogram Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCT_MODULE__PICTOGRAM_ELEMENT = eINSTANCE.getStructModule_PictogramElement();

	}

} //StructureViewPackage
