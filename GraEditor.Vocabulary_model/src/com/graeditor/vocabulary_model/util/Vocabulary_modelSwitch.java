/**
 */
package com.graeditor.vocabulary_model.util;

import com.graeditor.vocabulary_model.*;

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
 * @see com.graeditor.vocabulary_model.Vocabulary_modelPackage
 * @generated
 */
public class Vocabulary_modelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Vocabulary_modelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vocabulary_modelSwitch() {
		if (modelPackage == null) {
			modelPackage = Vocabulary_modelPackage.eINSTANCE;
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
			case Vocabulary_modelPackage.AREA_MODULE: {
				AreaModule areaModule = (AreaModule)theEObject;
				T result = caseAreaModule(areaModule);
				if (result == null) result = caseVocabularyModule(areaModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Vocabulary_modelPackage.VOCABULARY_MODULE: {
				VocabularyModule vocabularyModule = (VocabularyModule)theEObject;
				T result = caseVocabularyModule(vocabularyModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Vocabulary_modelPackage.FILE_MODULE: {
				FileModule fileModule = (FileModule)theEObject;
				T result = caseFileModule(fileModule);
				if (result == null) result = caseVocabularyModule(fileModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Vocabulary_modelPackage.FILE_STACK_MODULE: {
				FileStackModule fileStackModule = (FileStackModule)theEObject;
				T result = caseFileStackModule(fileStackModule);
				if (result == null) result = caseVocabularyModule(fileStackModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Vocabulary_modelPackage.PAGE_MODULE: {
				PageModule pageModule = (PageModule)theEObject;
				T result = casePageModule(pageModule);
				if (result == null) result = caseVocabularyModule(pageModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Vocabulary_modelPackage.PAGE_STACK_MODULE: {
				PageStackModule pageStackModule = (PageStackModule)theEObject;
				T result = casePageStackModule(pageStackModule);
				if (result == null) result = caseVocabularyModule(pageStackModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Vocabulary_modelPackage.CLUSTER_MODULE: {
				ClusterModule clusterModule = (ClusterModule)theEObject;
				T result = caseClusterModule(clusterModule);
				if (result == null) result = caseVocabularyModule(clusterModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Vocabulary_modelPackage.CONCURRENT_SET_MODULE: {
				ConcurrentSetModule concurrentSetModule = (ConcurrentSetModule)theEObject;
				T result = caseConcurrentSetModule(concurrentSetModule);
				if (result == null) result = caseVocabularyModule(concurrentSetModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Vocabulary_modelPackage.COND_BRANCH_MODULE: {
				CondBranchModule condBranchModule = (CondBranchModule)theEObject;
				T result = caseCondBranchModule(condBranchModule);
				if (result == null) result = caseVocabularyModule(condBranchModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Vocabulary_modelPackage.CONT_HORZ_MODULE: {
				ContHorzModule contHorzModule = (ContHorzModule)theEObject;
				T result = caseContHorzModule(contHorzModule);
				if (result == null) result = caseVocabularyModule(contHorzModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Vocabulary_modelPackage.CONT_VERT_MODULE: {
				ContVertModule contVertModule = (ContVertModule)theEObject;
				T result = caseContVertModule(contVertModule);
				if (result == null) result = caseVocabularyModule(contVertModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Vocabulary_modelPackage.DEC_POINT_MODULE: {
				DecPointModule decPointModule = (DecPointModule)theEObject;
				T result = caseDecPointModule(decPointModule);
				if (result == null) result = caseVocabularyModule(decPointModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Area Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Area Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAreaModule(AreaModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vocabulary Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vocabulary Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVocabularyModule(VocabularyModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileModule(FileModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Stack Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Stack Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileStackModule(FileStackModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePageModule(PageModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page Stack Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page Stack Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePageStackModule(PageStackModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cluster Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cluster Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClusterModule(ClusterModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concurrent Set Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concurrent Set Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConcurrentSetModule(ConcurrentSetModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cond Branch Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cond Branch Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCondBranchModule(CondBranchModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cont Horz Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cont Horz Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContHorzModule(ContHorzModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cont Vert Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cont Vert Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContVertModule(ContVertModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dec Point Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dec Point Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDecPointModule(DecPointModule object) {
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

} //Vocabulary_modelSwitch
