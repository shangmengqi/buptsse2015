/**
 */
package usecase.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import usecase.UsecasePackage;
import usecase.UsercaseModule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Usercase Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link usecase.impl.UsercaseModuleImpl#getPictogramElement <em>Pictogram Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UsercaseModuleImpl extends MinimalEObjectImpl.Container implements UsercaseModule {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UsercaseModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsecasePackage.Literals.USERCASE_MODULE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsecasePackage.USERCASE_MODULE__PICTOGRAM_ELEMENT, oldPictogramElement, pictogramElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasePackage.USERCASE_MODULE__PICTOGRAM_ELEMENT, oldPictogramElement, pictogramElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UsecasePackage.USERCASE_MODULE__PICTOGRAM_ELEMENT:
				if (resolve) return getPictogramElement();
				return basicGetPictogramElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UsecasePackage.USERCASE_MODULE__PICTOGRAM_ELEMENT:
				setPictogramElement((EObject)newValue);
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
			case UsecasePackage.USERCASE_MODULE__PICTOGRAM_ELEMENT:
				setPictogramElement((EObject)null);
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
			case UsecasePackage.USERCASE_MODULE__PICTOGRAM_ELEMENT:
				return pictogramElement != null;
		}
		return super.eIsSet(featureID);
	}

} //UsercaseModuleImpl
