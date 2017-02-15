/**
 */
package com.graeditor.flow_model.impl;

import com.graeditor.flow_model.EndTagModule;
import com.graeditor.flow_model.Flow;
import com.graeditor.flow_model.FlowModule;
import com.graeditor.flow_model.Flow_modelPackage;

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
 * An implementation of the model object '<em><b>Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.graeditor.flow_model.impl.FlowImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link com.graeditor.flow_model.impl.FlowImpl#getEndTag <em>End Tag</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FlowImpl extends MinimalEObjectImpl.Container implements Flow {
	/**
	 * The cached value of the '{@link #getModules() <em>Modules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModules()
	 * @generated
	 * @ordered
	 */
	protected EList<FlowModule> modules;

	/**
	 * The cached value of the '{@link #getEndTag() <em>End Tag</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndTag()
	 * @generated
	 * @ordered
	 */
	protected EndTagModule endTag;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Flow_modelPackage.Literals.FLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FlowModule> getModules() {
		if (modules == null) {
			modules = new EObjectContainmentEList<FlowModule>(FlowModule.class, this, Flow_modelPackage.FLOW__MODULES);
		}
		return modules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndTagModule getEndTag() {
		if (endTag != null && endTag.eIsProxy()) {
			InternalEObject oldEndTag = (InternalEObject)endTag;
			endTag = (EndTagModule)eResolveProxy(oldEndTag);
			if (endTag != oldEndTag) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Flow_modelPackage.FLOW__END_TAG, oldEndTag, endTag));
			}
		}
		return endTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public EndTagModule basicGetEndTag() {
		for (FlowModule module : getModules()) {
			if (module.equals(endTag)) {
				return (EndTagModule) module;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndTag(EndTagModule newEndTag) {
		EndTagModule oldEndTag = endTag;
		endTag = newEndTag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Flow_modelPackage.FLOW__END_TAG, oldEndTag, endTag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Flow_modelPackage.FLOW__MODULES:
				return ((InternalEList<?>)getModules()).basicRemove(otherEnd, msgs);
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
			case Flow_modelPackage.FLOW__MODULES:
				return getModules();
			case Flow_modelPackage.FLOW__END_TAG:
				if (resolve) return getEndTag();
				return basicGetEndTag();
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
			case Flow_modelPackage.FLOW__MODULES:
				getModules().clear();
				getModules().addAll((Collection<? extends FlowModule>)newValue);
				return;
			case Flow_modelPackage.FLOW__END_TAG:
				setEndTag((EndTagModule)newValue);
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
			case Flow_modelPackage.FLOW__MODULES:
				getModules().clear();
				return;
			case Flow_modelPackage.FLOW__END_TAG:
				setEndTag((EndTagModule)null);
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
			case Flow_modelPackage.FLOW__MODULES:
				return modules != null && !modules.isEmpty();
			case Flow_modelPackage.FLOW__END_TAG:
				return endTag != null;
		}
		return super.eIsSet(featureID);
	}

} //FlowImpl
