/**
 */
package com.graeditor.component_model.util;

import com.graeditor.component_model.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.graeditor.component_model.Component_modelPackage
 * @generated
 */
public class Component_modelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Component_modelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component_modelSwitch() {
		if (modelPackage == null) {
			modelPackage = Component_modelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case Component_modelPackage.COMPONENT_MODULE: {
				ComponentModule componentModule = (ComponentModule)theEObject;
				T result = caseComponentModule(componentModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Component_modelPackage.DATABASE_MODULE: {
				DatabaseModule databaseModule = (DatabaseModule)theEObject;
				T result = caseDatabaseModule(databaseModule);
				if (result == null) result = caseComponentModule(databaseModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Component_modelPackage.LITTLE_COMPONENT_MODULE: {
				LittleComponentModule littleComponentModule = (LittleComponentModule)theEObject;
				T result = caseLittleComponentModule(littleComponentModule);
				if (result == null) result = caseComponentModule(littleComponentModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Component_modelPackage.LITTLE_FRAMWORK_MODULE: {
				LittleFramworkModule littleFramworkModule = (LittleFramworkModule)theEObject;
				T result = caseLittleFramworkModule(littleFramworkModule);
				if (result == null) result = caseComponentModule(littleFramworkModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Component_modelPackage.LITTLE_INTERFACE_MODULE: {
				LittleInterfaceModule littleInterfaceModule = (LittleInterfaceModule)theEObject;
				T result = caseLittleInterfaceModule(littleInterfaceModule);
				if (result == null) result = caseComponentModule(littleInterfaceModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentModule(ComponentModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Database Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Database Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDatabaseModule(DatabaseModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Little Component Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Little Component Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLittleComponentModule(LittleComponentModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Little Framwork Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Little Framwork Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLittleFramworkModule(LittleFramworkModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Little Interface Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Little Interface Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLittleInterfaceModule(LittleInterfaceModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //Component_modelSwitch
