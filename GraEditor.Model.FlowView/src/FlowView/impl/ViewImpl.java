/**
 */
package FlowView.impl;

import FlowView.Action;
import FlowView.EndTag;
import FlowView.FlowViewPackage;
import FlowView.StartTag;
import FlowView.View;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link FlowView.impl.ViewImpl#getName <em>Name</em>}</li>
 *   <li>{@link FlowView.impl.ViewImpl#getAction <em>Action</em>}</li>
 *   <li>{@link FlowView.impl.ViewImpl#getStarttag <em>Starttag</em>}</li>
 *   <li>{@link FlowView.impl.ViewImpl#getEndtag <em>Endtag</em>}</li>
 *   <li>{@link FlowView.impl.ViewImpl#getOrder <em>Order</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ViewImpl extends MinimalEObjectImpl.Container implements View {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> action;

	/**
	 * The cached value of the '{@link #getStarttag() <em>Starttag</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStarttag()
	 * @generated
	 * @ordered
	 */
	protected EList<StartTag> starttag;

	/**
	 * The cached value of the '{@link #getEndtag() <em>Endtag</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndtag()
	 * @generated
	 * @ordered
	 */
	protected EList<EndTag> endtag;

	/**
	 * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected static final int ORDER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected int order = ORDER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowViewPackage.Literals.VIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlowViewPackage.VIEW__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getAction() {
		if (action == null) {
			action = new EObjectContainmentEList<Action>(Action.class, this, FlowViewPackage.VIEW__ACTION);
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StartTag> getStarttag() {
		if (starttag == null) {
			starttag = new EObjectContainmentEList<StartTag>(StartTag.class, this, FlowViewPackage.VIEW__STARTTAG);
		}
		return starttag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EndTag> getEndtag() {
		if (endtag == null) {
			endtag = new EObjectContainmentEList<EndTag>(EndTag.class, this, FlowViewPackage.VIEW__ENDTAG);
		}
		return endtag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrder(int newOrder) {
		int oldOrder = order;
		order = newOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlowViewPackage.VIEW__ORDER, oldOrder, order));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FlowViewPackage.VIEW__ACTION:
				return ((InternalEList<?>)getAction()).basicRemove(otherEnd, msgs);
			case FlowViewPackage.VIEW__STARTTAG:
				return ((InternalEList<?>)getStarttag()).basicRemove(otherEnd, msgs);
			case FlowViewPackage.VIEW__ENDTAG:
				return ((InternalEList<?>)getEndtag()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FlowViewPackage.VIEW__NAME:
				return getName();
			case FlowViewPackage.VIEW__ACTION:
				return getAction();
			case FlowViewPackage.VIEW__STARTTAG:
				return getStarttag();
			case FlowViewPackage.VIEW__ENDTAG:
				return getEndtag();
			case FlowViewPackage.VIEW__ORDER:
				return getOrder();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FlowViewPackage.VIEW__NAME:
				setName((String)newValue);
				return;
			case FlowViewPackage.VIEW__ACTION:
				getAction().clear();
				getAction().addAll((Collection<? extends Action>)newValue);
				return;
			case FlowViewPackage.VIEW__STARTTAG:
				getStarttag().clear();
				getStarttag().addAll((Collection<? extends StartTag>)newValue);
				return;
			case FlowViewPackage.VIEW__ENDTAG:
				getEndtag().clear();
				getEndtag().addAll((Collection<? extends EndTag>)newValue);
				return;
			case FlowViewPackage.VIEW__ORDER:
				setOrder((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FlowViewPackage.VIEW__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FlowViewPackage.VIEW__ACTION:
				getAction().clear();
				return;
			case FlowViewPackage.VIEW__STARTTAG:
				getStarttag().clear();
				return;
			case FlowViewPackage.VIEW__ENDTAG:
				getEndtag().clear();
				return;
			case FlowViewPackage.VIEW__ORDER:
				setOrder(ORDER_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FlowViewPackage.VIEW__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FlowViewPackage.VIEW__ACTION:
				return action != null && !action.isEmpty();
			case FlowViewPackage.VIEW__STARTTAG:
				return starttag != null && !starttag.isEmpty();
			case FlowViewPackage.VIEW__ENDTAG:
				return endtag != null && !endtag.isEmpty();
			case FlowViewPackage.VIEW__ORDER:
				return order != ORDER_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", order: ");
		result.append(order);
		result.append(')');
		return result.toString();
	}

} //ViewImpl
