/**
 */
package com.graeditor.flow_model.util;

import com.graeditor.flow_model.*;

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
 * @see com.graeditor.flow_model.Flow_modelPackage
 * @generated
 */
public class Flow_modelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Flow_modelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Flow_modelSwitch() {
		if (modelPackage == null) {
			modelPackage = Flow_modelPackage.eINSTANCE;
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
			case Flow_modelPackage.CONTENT_MODULE: {
				ContentModule contentModule = (ContentModule)theEObject;
				T result = caseContentModule(contentModule);
				if (result == null) result = caseFlowModule(contentModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Flow_modelPackage.END_TAG_MODULE: {
				EndTagModule endTagModule = (EndTagModule)theEObject;
				T result = caseEndTagModule(endTagModule);
				if (result == null) result = caseFlowModule(endTagModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Flow_modelPackage.FLOW: {
				Flow flow = (Flow)theEObject;
				T result = caseFlow(flow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Flow_modelPackage.FLOW_MODULE: {
				FlowModule flowModule = (FlowModule)theEObject;
				T result = caseFlowModule(flowModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Flow_modelPackage.START_TAG_MODULE: {
				StartTagModule startTagModule = (StartTagModule)theEObject;
				T result = caseStartTagModule(startTagModule);
				if (result == null) result = caseFlowModule(startTagModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Flow_modelPackage.VERTICAL_LINE_MODULE: {
				VerticalLineModule verticalLineModule = (VerticalLineModule)theEObject;
				T result = caseVerticalLineModule(verticalLineModule);
				if (result == null) result = caseFlowModule(verticalLineModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Flow_modelPackage.HORIZONTAL_LINE_MOUDLE: {
				HorizontalLineMoudle horizontalLineMoudle = (HorizontalLineMoudle)theEObject;
				T result = caseHorizontalLineMoudle(horizontalLineMoudle);
				if (result == null) result = caseFlowModule(horizontalLineMoudle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Flow_modelPackage.TITLE_MOUDLE: {
				TitleMoudle titleMoudle = (TitleMoudle)theEObject;
				T result = caseTitleMoudle(titleMoudle);
				if (result == null) result = caseFlowModule(titleMoudle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Flow_modelPackage.PRE_LOG_IN_TAG_MODULE: {
				PreLogInTagModule preLogInTagModule = (PreLogInTagModule)theEObject;
				T result = casePreLogInTagModule(preLogInTagModule);
				if (result == null) result = caseFlowModule(preLogInTagModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Flow_modelPackage.CONTROL_TAG_MODULE: {
				ControlTagModule controlTagModule = (ControlTagModule)theEObject;
				T result = caseControlTagModule(controlTagModule);
				if (result == null) result = caseFlowModule(controlTagModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Flow_modelPackage.FEN_CHA_MODULE: {
				FenChaModule fenChaModule = (FenChaModule)theEObject;
				T result = caseFenChaModule(fenChaModule);
				if (result == null) result = caseFlowModule(fenChaModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Flow_modelPackage.HE_BING_MODULE: {
				HeBingModule heBingModule = (HeBingModule)theEObject;
				T result = caseHeBingModule(heBingModule);
				if (result == null) result = caseFlowModule(heBingModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Flow_modelPackage.HUI_HE_MODULE: {
				HuiHeModule huiHeModule = (HuiHeModule)theEObject;
				T result = caseHuiHeModule(huiHeModule);
				if (result == null) result = caseFlowModule(huiHeModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Content Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Content Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContentModule(ContentModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End Tag Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End Tag Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndTagModule(EndTagModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlow(Flow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowModule(FlowModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Start Tag Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Start Tag Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStartTagModule(StartTagModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vertical Line Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vertical Line Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVerticalLineModule(VerticalLineModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Horizontal Line Moudle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Horizontal Line Moudle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHorizontalLineMoudle(HorizontalLineMoudle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Title Moudle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Title Moudle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTitleMoudle(TitleMoudle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pre Log In Tag Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pre Log In Tag Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreLogInTagModule(PreLogInTagModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Control Tag Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Control Tag Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseControlTagModule(ControlTagModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fen Cha Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fen Cha Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFenChaModule(FenChaModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>He Bing Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>He Bing Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHeBingModule(HeBingModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hui He Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hui He Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHuiHeModule(HuiHeModule object) {
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

} //Flow_modelSwitch
