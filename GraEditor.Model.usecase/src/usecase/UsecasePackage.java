/**
 */
package usecase;

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
 * @see usecase.UsecaseFactory
 * @model kind="package"
 * @generated
 */
public interface UsecasePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "usecase";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/usecase";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "usecase";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UsecasePackage eINSTANCE = usecase.impl.UsecasePackageImpl.init();

	/**
	 * The meta object id for the '{@link usecase.impl.UsercaseModuleImpl <em>Usercase Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see usecase.impl.UsercaseModuleImpl
	 * @see usecase.impl.UsecasePackageImpl#getUsercaseModule()
	 * @generated
	 */
	int USERCASE_MODULE = 2;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERCASE_MODULE__PICTOGRAM_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Usercase Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERCASE_MODULE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Usercase Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERCASE_MODULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link usecase.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see usecase.impl.UserImpl
	 * @see usecase.impl.UsecasePackageImpl#getUser()
	 * @generated
	 */
	int USER = 0;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__PICTOGRAM_ELEMENT = USERCASE_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__NAME = USERCASE_MODULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Usecase</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__USECASE = USERCASE_MODULE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = USERCASE_MODULE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_OPERATION_COUNT = USERCASE_MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link usecase.impl.UsecaseImpl <em>Usecase</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see usecase.impl.UsecaseImpl
	 * @see usecase.impl.UsecasePackageImpl#getUsecase()
	 * @generated
	 */
	int USECASE = 1;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USECASE__PICTOGRAM_ELEMENT = USERCASE_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USECASE__NAME = USERCASE_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Usecase</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USECASE_FEATURE_COUNT = USERCASE_MODULE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Usecase</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USECASE_OPERATION_COUNT = USERCASE_MODULE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link usecase.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see usecase.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for the attribute '{@link usecase.User#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see usecase.User#getName()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link usecase.User#getUsecase <em>Usecase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Usecase</em>'.
	 * @see usecase.User#getUsecase()
	 * @see #getUser()
	 * @generated
	 */
	EReference getUser_Usecase();

	/**
	 * Returns the meta object for class '{@link usecase.Usecase <em>Usecase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Usecase</em>'.
	 * @see usecase.Usecase
	 * @generated
	 */
	EClass getUsecase();

	/**
	 * Returns the meta object for the attribute '{@link usecase.Usecase#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see usecase.Usecase#getName()
	 * @see #getUsecase()
	 * @generated
	 */
	EAttribute getUsecase_Name();

	/**
	 * Returns the meta object for class '{@link usecase.UsercaseModule <em>Usercase Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Usercase Module</em>'.
	 * @see usecase.UsercaseModule
	 * @generated
	 */
	EClass getUsercaseModule();

	/**
	 * Returns the meta object for the reference '{@link usecase.UsercaseModule#getPictogramElement <em>Pictogram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pictogram Element</em>'.
	 * @see usecase.UsercaseModule#getPictogramElement()
	 * @see #getUsercaseModule()
	 * @generated
	 */
	EReference getUsercaseModule_PictogramElement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UsecaseFactory getUsecaseFactory();

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
		 * The meta object literal for the '{@link usecase.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see usecase.impl.UserImpl
		 * @see usecase.impl.UsecasePackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__NAME = eINSTANCE.getUser_Name();

		/**
		 * The meta object literal for the '<em><b>Usecase</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__USECASE = eINSTANCE.getUser_Usecase();

		/**
		 * The meta object literal for the '{@link usecase.impl.UsecaseImpl <em>Usecase</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see usecase.impl.UsecaseImpl
		 * @see usecase.impl.UsecasePackageImpl#getUsecase()
		 * @generated
		 */
		EClass USECASE = eINSTANCE.getUsecase();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USECASE__NAME = eINSTANCE.getUsecase_Name();

		/**
		 * The meta object literal for the '{@link usecase.impl.UsercaseModuleImpl <em>Usercase Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see usecase.impl.UsercaseModuleImpl
		 * @see usecase.impl.UsecasePackageImpl#getUsercaseModule()
		 * @generated
		 */
		EClass USERCASE_MODULE = eINSTANCE.getUsercaseModule();

		/**
		 * The meta object literal for the '<em><b>Pictogram Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USERCASE_MODULE__PICTOGRAM_ELEMENT = eINSTANCE.getUsercaseModule_PictogramElement();

	}

} //UsecasePackage
