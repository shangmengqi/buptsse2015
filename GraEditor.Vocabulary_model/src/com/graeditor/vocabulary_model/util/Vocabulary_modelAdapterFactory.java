/**
 */
package com.graeditor.vocabulary_model.util;

import com.graeditor.vocabulary_model.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.graeditor.vocabulary_model.Vocabulary_modelPackage
 * @generated
 */
public class Vocabulary_modelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Vocabulary_modelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vocabulary_modelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Vocabulary_modelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Vocabulary_modelSwitch<Adapter> modelSwitch =
		new Vocabulary_modelSwitch<Adapter>() {
			@Override
			public Adapter caseAreaModule(AreaModule object) {
				return createAreaModuleAdapter();
			}
			@Override
			public Adapter caseVocabularyModule(VocabularyModule object) {
				return createVocabularyModuleAdapter();
			}
			@Override
			public Adapter caseFileModule(FileModule object) {
				return createFileModuleAdapter();
			}
			@Override
			public Adapter caseFileStackModule(FileStackModule object) {
				return createFileStackModuleAdapter();
			}
			@Override
			public Adapter casePageModule(PageModule object) {
				return createPageModuleAdapter();
			}
			@Override
			public Adapter casePageStackModule(PageStackModule object) {
				return createPageStackModuleAdapter();
			}
			@Override
			public Adapter caseClusterModule(ClusterModule object) {
				return createClusterModuleAdapter();
			}
			@Override
			public Adapter caseConcurrentSetModule(ConcurrentSetModule object) {
				return createConcurrentSetModuleAdapter();
			}
			@Override
			public Adapter caseCondBranchModule(CondBranchModule object) {
				return createCondBranchModuleAdapter();
			}
			@Override
			public Adapter caseContHorzModule(ContHorzModule object) {
				return createContHorzModuleAdapter();
			}
			@Override
			public Adapter caseContVertModule(ContVertModule object) {
				return createContVertModuleAdapter();
			}
			@Override
			public Adapter caseDecPointModule(DecPointModule object) {
				return createDecPointModuleAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.vocabulary_model.AreaModule <em>Area Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.vocabulary_model.AreaModule
	 * @generated
	 */
	public Adapter createAreaModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.vocabulary_model.VocabularyModule <em>Vocabulary Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.vocabulary_model.VocabularyModule
	 * @generated
	 */
	public Adapter createVocabularyModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.vocabulary_model.FileModule <em>File Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.vocabulary_model.FileModule
	 * @generated
	 */
	public Adapter createFileModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.vocabulary_model.FileStackModule <em>File Stack Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.vocabulary_model.FileStackModule
	 * @generated
	 */
	public Adapter createFileStackModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.vocabulary_model.PageModule <em>Page Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.vocabulary_model.PageModule
	 * @generated
	 */
	public Adapter createPageModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.vocabulary_model.PageStackModule <em>Page Stack Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.vocabulary_model.PageStackModule
	 * @generated
	 */
	public Adapter createPageStackModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.vocabulary_model.ClusterModule <em>Cluster Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.vocabulary_model.ClusterModule
	 * @generated
	 */
	public Adapter createClusterModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.vocabulary_model.ConcurrentSetModule <em>Concurrent Set Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.vocabulary_model.ConcurrentSetModule
	 * @generated
	 */
	public Adapter createConcurrentSetModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.vocabulary_model.CondBranchModule <em>Cond Branch Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.vocabulary_model.CondBranchModule
	 * @generated
	 */
	public Adapter createCondBranchModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.vocabulary_model.ContHorzModule <em>Cont Horz Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.vocabulary_model.ContHorzModule
	 * @generated
	 */
	public Adapter createContHorzModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.vocabulary_model.ContVertModule <em>Cont Vert Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.vocabulary_model.ContVertModule
	 * @generated
	 */
	public Adapter createContVertModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.vocabulary_model.DecPointModule <em>Dec Point Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.vocabulary_model.DecPointModule
	 * @generated
	 */
	public Adapter createDecPointModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //Vocabulary_modelAdapterFactory
