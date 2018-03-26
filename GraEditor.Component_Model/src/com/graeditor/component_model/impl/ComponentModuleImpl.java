/**
 */
package com.graeditor.component_model.impl;

import com.graeditor.component_model.ComponentModule;
import com.graeditor.component_model.Component_modelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.graeditor.component_model.impl.ComponentModuleImpl#getPictogramElement <em>Pictogram Element</em>}</li>
 *   <li>{@link com.graeditor.component_model.impl.ComponentModuleImpl#getPreviousModules <em>Previous Modules</em>}</li>
 *   <li>{@link com.graeditor.component_model.impl.ComponentModuleImpl#getNext <em>Next</em>}</li>
 *   <li>{@link com.graeditor.component_model.impl.ComponentModuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.graeditor.component_model.impl.ComponentModuleImpl#getTextContent <em>Text Content</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComponentModuleImpl extends MinimalEObjectImpl.Container implements ComponentModule {
	/**
	 * The cached value of the '{@link #getPictogramElement() <em>Pictogram Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPictogramElement()
	 * @generated
	 * @ordered
	 */
	protected EObject pictogramElement;

	/**
	 * The cached value of the '{@link #getPreviousModules() <em>Previous Modules</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreviousModules()
	 * @generated
	 * @ordered
	 */
	protected ComponentModule previousModules;

	/**
	 * The cached value of the '{@link #getNext() <em>Next</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNext()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentModule> next;

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
	 * The default value of the '{@link #getTextContent() <em>Text Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextContent()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_CONTENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTextContent() <em>Text Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextContent()
	 * @generated
	 * @ordered
	 */
	protected String textContent = TEXT_CONTENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Component_modelPackage.Literals.COMPONENT_MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getPictogramElement() {
		if (pictogramElement != null && pictogramElement.eIsProxy()) {
			InternalEObject oldPictogramElement = (InternalEObject)pictogramElement;
			pictogramElement = eResolveProxy(oldPictogramElement);
			if (pictogramElement != oldPictogramElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Component_modelPackage.COMPONENT_MODULE__PICTOGRAM_ELEMENT, oldPictogramElement, pictogramElement));
			}
		}
		return pictogramElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetPictogramElement() {
		return pictogramElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPictogramElement(EObject newPictogramElement) {
		EObject oldPictogramElement = pictogramElement;
		pictogramElement = newPictogramElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Component_modelPackage.COMPONENT_MODULE__PICTOGRAM_ELEMENT, oldPictogramElement, pictogramElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentModule getPreviousModules() {
		if (previousModules != null && previousModules.eIsProxy()) {
			InternalEObject oldPreviousModules = (InternalEObject)previousModules;
			previousModules = (ComponentModule)eResolveProxy(oldPreviousModules);
			if (previousModules != oldPreviousModules) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Component_modelPackage.COMPONENT_MODULE__PREVIOUS_MODULES, oldPreviousModules, previousModules));
			}
		}
		return previousModules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentModule basicGetPreviousModules() {
		return previousModules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPreviousModules(ComponentModule newPreviousModules, NotificationChain msgs) {
		ComponentModule oldPreviousModules = previousModules;
		previousModules = newPreviousModules;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Component_modelPackage.COMPONENT_MODULE__PREVIOUS_MODULES, oldPreviousModules, newPreviousModules);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreviousModules(ComponentModule newPreviousModules) {
		if (newPreviousModules != previousModules) {
			NotificationChain msgs = null;
			if (previousModules != null)
				msgs = ((InternalEObject)previousModules).eInverseRemove(this, Component_modelPackage.COMPONENT_MODULE__NEXT, ComponentModule.class, msgs);
			if (newPreviousModules != null)
				msgs = ((InternalEObject)newPreviousModules).eInverseAdd(this, Component_modelPackage.COMPONENT_MODULE__NEXT, ComponentModule.class, msgs);
			msgs = basicSetPreviousModules(newPreviousModules, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Component_modelPackage.COMPONENT_MODULE__PREVIOUS_MODULES, newPreviousModules, newPreviousModules));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentModule> getNext() {
		if (next == null) {
			next = new EObjectWithInverseResolvingEList<ComponentModule>(ComponentModule.class, this, Component_modelPackage.COMPONENT_MODULE__NEXT, Component_modelPackage.COMPONENT_MODULE__PREVIOUS_MODULES);
		}
		return next;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Component_modelPackage.COMPONENT_MODULE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextContent() {
		return textContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextContent(String newTextContent) {
		String oldTextContent = textContent;
		textContent = newTextContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Component_modelPackage.COMPONENT_MODULE__TEXT_CONTENT, oldTextContent, textContent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Component_modelPackage.COMPONENT_MODULE__PREVIOUS_MODULES:
				if (previousModules != null)
					msgs = ((InternalEObject)previousModules).eInverseRemove(this, Component_modelPackage.COMPONENT_MODULE__NEXT, ComponentModule.class, msgs);
				return basicSetPreviousModules((ComponentModule)otherEnd, msgs);
			case Component_modelPackage.COMPONENT_MODULE__NEXT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNext()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Component_modelPackage.COMPONENT_MODULE__PREVIOUS_MODULES:
				return basicSetPreviousModules(null, msgs);
			case Component_modelPackage.COMPONENT_MODULE__NEXT:
				return ((InternalEList<?>)getNext()).basicRemove(otherEnd, msgs);
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
			case Component_modelPackage.COMPONENT_MODULE__PICTOGRAM_ELEMENT:
				if (resolve) return getPictogramElement();
				return basicGetPictogramElement();
			case Component_modelPackage.COMPONENT_MODULE__PREVIOUS_MODULES:
				if (resolve) return getPreviousModules();
				return basicGetPreviousModules();
			case Component_modelPackage.COMPONENT_MODULE__NEXT:
				return getNext();
			case Component_modelPackage.COMPONENT_MODULE__NAME:
				return getName();
			case Component_modelPackage.COMPONENT_MODULE__TEXT_CONTENT:
				return getTextContent();
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
			case Component_modelPackage.COMPONENT_MODULE__PICTOGRAM_ELEMENT:
				setPictogramElement((EObject)newValue);
				return;
			case Component_modelPackage.COMPONENT_MODULE__PREVIOUS_MODULES:
				setPreviousModules((ComponentModule)newValue);
				return;
			case Component_modelPackage.COMPONENT_MODULE__NEXT:
				getNext().clear();
				getNext().addAll((Collection<? extends ComponentModule>)newValue);
				return;
			case Component_modelPackage.COMPONENT_MODULE__NAME:
				setName((String)newValue);
				return;
			case Component_modelPackage.COMPONENT_MODULE__TEXT_CONTENT:
				setTextContent((String)newValue);
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
			case Component_modelPackage.COMPONENT_MODULE__PICTOGRAM_ELEMENT:
				setPictogramElement((EObject)null);
				return;
			case Component_modelPackage.COMPONENT_MODULE__PREVIOUS_MODULES:
				setPreviousModules((ComponentModule)null);
				return;
			case Component_modelPackage.COMPONENT_MODULE__NEXT:
				getNext().clear();
				return;
			case Component_modelPackage.COMPONENT_MODULE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Component_modelPackage.COMPONENT_MODULE__TEXT_CONTENT:
				setTextContent(TEXT_CONTENT_EDEFAULT);
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
			case Component_modelPackage.COMPONENT_MODULE__PICTOGRAM_ELEMENT:
				return pictogramElement != null;
			case Component_modelPackage.COMPONENT_MODULE__PREVIOUS_MODULES:
				return previousModules != null;
			case Component_modelPackage.COMPONENT_MODULE__NEXT:
				return next != null && !next.isEmpty();
			case Component_modelPackage.COMPONENT_MODULE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Component_modelPackage.COMPONENT_MODULE__TEXT_CONTENT:
				return TEXT_CONTENT_EDEFAULT == null ? textContent != null : !TEXT_CONTENT_EDEFAULT.equals(textContent);
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
		result.append(", textContent: ");
		result.append(textContent);
		result.append(')');
		return result.toString();
	}

} //ComponentModuleImpl
