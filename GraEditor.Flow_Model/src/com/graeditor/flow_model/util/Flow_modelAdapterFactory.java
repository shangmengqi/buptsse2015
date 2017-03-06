/**
 */
package com.graeditor.flow_model.util;

import com.graeditor.flow_model.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.graeditor.flow_model.Flow_modelPackage
 * @generated
 */
public class Flow_modelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Flow_modelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Flow_modelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Flow_modelPackage.eINSTANCE;
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
	protected Flow_modelSwitch<Adapter> modelSwitch =
		new Flow_modelSwitch<Adapter>() {
			@Override
			public Adapter caseContentModule(ContentModule object) {
				return createContentModuleAdapter();
			}
			@Override
			public Adapter caseEndTagModule(EndTagModule object) {
				return createEndTagModuleAdapter();
			}
			@Override
			public Adapter caseFlow(Flow object) {
				return createFlowAdapter();
			}
			@Override
			public Adapter caseFlowModule(FlowModule object) {
				return createFlowModuleAdapter();
			}
			@Override
			public Adapter caseStartTagModule(StartTagModule object) {
				return createStartTagModuleAdapter();
			}
			@Override
			public Adapter caseVerticalLineModule(VerticalLineModule object) {
				return createVerticalLineModuleAdapter();
			}
			@Override
			public Adapter caseHorizontalLineMoudle(HorizontalLineMoudle object) {
				return createHorizontalLineMoudleAdapter();
			}
			@Override
			public Adapter caseTitleMoudle(TitleMoudle object) {
				return createTitleMoudleAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.graeditor.flow_model.ContentModule <em>Content Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.flow_model.ContentModule
	 * @generated
	 */
	public Adapter createContentModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.flow_model.EndTagModule <em>End Tag Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.flow_model.EndTagModule
	 * @generated
	 */
	public Adapter createEndTagModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.flow_model.Flow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.flow_model.Flow
	 * @generated
	 */
	public Adapter createFlowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.flow_model.FlowModule <em>Flow Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.flow_model.FlowModule
	 * @generated
	 */
	public Adapter createFlowModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.flow_model.StartTagModule <em>Start Tag Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.flow_model.StartTagModule
	 * @generated
	 */
	public Adapter createStartTagModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.flow_model.VerticalLineModule <em>Vertical Line Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.flow_model.VerticalLineModule
	 * @generated
	 */
	public Adapter createVerticalLineModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.flow_model.HorizontalLineMoudle <em>Horizontal Line Moudle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.flow_model.HorizontalLineMoudle
	 * @generated
	 */
	public Adapter createHorizontalLineMoudleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.flow_model.TitleMoudle <em>Title Moudle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.flow_model.TitleMoudle
	 * @generated
	 */
	public Adapter createTitleMoudleAdapter() {
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

} //Flow_modelAdapterFactory
