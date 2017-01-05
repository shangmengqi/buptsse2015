/**
 */
package FlowView;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link FlowView.View#getName <em>Name</em>}</li>
 *   <li>{@link FlowView.View#getAction <em>Action</em>}</li>
 *   <li>{@link FlowView.View#getStarttag <em>Starttag</em>}</li>
 *   <li>{@link FlowView.View#getEndtag <em>Endtag</em>}</li>
 *   <li>{@link FlowView.View#getOrder <em>Order</em>}</li>
 * </ul>
 *
 * @see FlowView.FlowViewPackage#getView()
 * @model
 * @generated
 */
public interface View extends EObject {
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
	 * @see FlowView.FlowViewPackage#getView_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link FlowView.View#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' containment reference list.
	 * The list contents are of type {@link FlowView.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' containment reference list.
	 * @see FlowView.FlowViewPackage#getView_Action()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getAction();

	/**
	 * Returns the value of the '<em><b>Starttag</b></em>' containment reference list.
	 * The list contents are of type {@link FlowView.StartTag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Starttag</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Starttag</em>' containment reference list.
	 * @see FlowView.FlowViewPackage#getView_Starttag()
	 * @model containment="true"
	 * @generated
	 */
	EList<StartTag> getStarttag();

	/**
	 * Returns the value of the '<em><b>Endtag</b></em>' containment reference list.
	 * The list contents are of type {@link FlowView.EndTag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endtag</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endtag</em>' containment reference list.
	 * @see FlowView.FlowViewPackage#getView_Endtag()
	 * @model containment="true"
	 * @generated
	 */
	EList<EndTag> getEndtag();

	/**
	 * Returns the value of the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order</em>' attribute.
	 * @see #setOrder(int)
	 * @see FlowView.FlowViewPackage#getView_Order()
	 * @model
	 * @generated
	 */
	int getOrder();

	/**
	 * Sets the value of the '{@link FlowView.View#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order</em>' attribute.
	 * @see #getOrder()
	 * @generated
	 */
	void setOrder(int value);

} // View
