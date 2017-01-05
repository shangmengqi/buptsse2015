/**
 */
package usecase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>user</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Usecase.User#getName <em>Name</em>}</li>
 *   <li>{@link Usecase.User#getUsecase <em>Usecase</em>}</li>
 * </ul>
 *
 * @see Usecase.UsecasePackage#getuser()
 * @model
 * @generated
 */
public interface User extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Usecase.UsecasePackage#getuser_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Usecase.User#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Usecase</b></em>' containment reference list.
	 * The list contents are of type {@link Usecase.usecase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usecase</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usecase</em>' containment reference list.
	 * @see Usecase.UsecasePackage#getuser_Usecase()
	 * @model containment="true"
	 * @generated
	 */
	EList<Usecase> getUsecase();

} // user
