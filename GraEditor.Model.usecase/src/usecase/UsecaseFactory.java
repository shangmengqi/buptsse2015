/**
 */
package usecase;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see Usecase.UsecasePackage
 * @generated
 */
public interface UsecaseFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UsecaseFactory eINSTANCE = usecase.impl.UsecaseFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>user</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>user</em>'.
	 * @generated
	 */
	User createuser();

	/**
	 * Returns a new object of class '<em>usecase</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>usecase</em>'.
	 * @generated
	 */
	Usecase createusecase();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UsecasePackage getUsecasePackage();

} //UsecaseFactory
