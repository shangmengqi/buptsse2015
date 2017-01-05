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
 * @see Usecase.UsecaseFactory
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
	 * The meta object id for the '{@link Usecase.impl.UserImpl <em>user</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Usecase.impl.UserImpl
	 * @see Usecase.impl.UsecasePackageImpl#getuser()
	 * @generated
	 */
	int USER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Usecase</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__USECASE = 1;

	/**
	 * The number of structural features of the '<em>user</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>user</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Usecase.impl.UsecaseImpl <em>usecase</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Usecase.impl.UsecaseImpl
	 * @see Usecase.impl.UsecasePackageImpl#getusecase()
	 * @generated
	 */
	int USECASE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USECASE__NAME = 0;

	/**
	 * The number of structural features of the '<em>usecase</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USECASE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>usecase</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USECASE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link Usecase.User <em>user</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>user</em>'.
	 * @see Usecase.User
	 * @generated
	 */
	EClass getuser();

	/**
	 * Returns the meta object for the attribute '{@link Usecase.User#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Usecase.User#getName()
	 * @see #getuser()
	 * @generated
	 */
	EAttribute getuser_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link Usecase.User#getUsecase <em>Usecase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Usecase</em>'.
	 * @see Usecase.User#getUsecase()
	 * @see #getuser()
	 * @generated
	 */
	EReference getuser_Usecase();

	/**
	 * Returns the meta object for class '{@link Usecase.usecase <em>usecase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>usecase</em>'.
	 * @see Usecase.usecase
	 * @generated
	 */
	EClass getusecase();

	/**
	 * Returns the meta object for the attribute '{@link Usecase.usecase#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Usecase.usecase#getName()
	 * @see #getusecase()
	 * @generated
	 */
	EAttribute getusecase_Name();

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
		 * The meta object literal for the '{@link Usecase.impl.UserImpl <em>user</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Usecase.impl.UserImpl
		 * @see Usecase.impl.UsecasePackageImpl#getuser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getuser();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__NAME = eINSTANCE.getuser_Name();

		/**
		 * The meta object literal for the '<em><b>Usecase</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER__USECASE = eINSTANCE.getuser_Usecase();

		/**
		 * The meta object literal for the '{@link Usecase.impl.UsecaseImpl <em>usecase</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Usecase.impl.UsecaseImpl
		 * @see Usecase.impl.UsecasePackageImpl#getusecase()
		 * @generated
		 */
		EClass USECASE = eINSTANCE.getusecase();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USECASE__NAME = eINSTANCE.getusecase_Name();

	}

} //UsecasePackage
