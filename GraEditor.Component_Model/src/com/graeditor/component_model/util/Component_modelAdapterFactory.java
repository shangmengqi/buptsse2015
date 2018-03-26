/**
 */
package com.graeditor.component_model.util;

import com.graeditor.component_model.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.graeditor.component_model.Component_modelPackage
 * @generated
 */
public class Component_modelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Component_modelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component_modelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Component_modelPackage.eINSTANCE;
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
	protected Component_modelSwitch<Adapter> modelSwitch =
		new Component_modelSwitch<Adapter>() {
			@Override
			public Adapter caseComponentModule(ComponentModule object) {
				return createComponentModuleAdapter();
			}
			@Override
			public Adapter caseDatabaseModule(DatabaseModule object) {
				return createDatabaseModuleAdapter();
			}
			@Override
			public Adapter caseLittleComponentModule(LittleComponentModule object) {
				return createLittleComponentModuleAdapter();
			}
			@Override
			public Adapter caseLittleFramworkModule(LittleFramworkModule object) {
				return createLittleFramworkModuleAdapter();
			}
			@Override
			public Adapter caseLittleInterfaceModule(LittleInterfaceModule object) {
				return createLittleInterfaceModuleAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.graeditor.component_model.ComponentModule <em>Component Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.component_model.ComponentModule
	 * @generated
	 */
	public Adapter createComponentModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.component_model.DatabaseModule <em>Database Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.component_model.DatabaseModule
	 * @generated
	 */
	public Adapter createDatabaseModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.component_model.LittleComponentModule <em>Little Component Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.component_model.LittleComponentModule
	 * @generated
	 */
	public Adapter createLittleComponentModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.component_model.LittleFramworkModule <em>Little Framwork Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.component_model.LittleFramworkModule
	 * @generated
	 */
	public Adapter createLittleFramworkModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.graeditor.component_model.LittleInterfaceModule <em>Little Interface Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.graeditor.component_model.LittleInterfaceModule
	 * @generated
	 */
	public Adapter createLittleInterfaceModuleAdapter() {
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

} //Component_modelAdapterFactory
