/**
 */
package com.graeditor.component_model.impl;

import com.graeditor.component_model.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Component_modelFactoryImpl extends EFactoryImpl implements Component_modelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Component_modelFactory init() {
		try {
			Component_modelFactory theComponent_modelFactory = (Component_modelFactory)EPackage.Registry.INSTANCE.getEFactory(Component_modelPackage.eNS_URI);
			if (theComponent_modelFactory != null) {
				return theComponent_modelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Component_modelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component_modelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Component_modelPackage.COMPONENT_MODULE: return createComponentModule();
			case Component_modelPackage.DATABASE_MODULE: return createDatabaseModule();
			case Component_modelPackage.LITTLE_COMPONENT_MODULE: return createLittleComponentModule();
			case Component_modelPackage.LITTLE_FRAMWORK_MODULE: return createLittleFramworkModule();
			case Component_modelPackage.LITTLE_INTERFACE_MODULE: return createLittleInterfaceModule();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentModule createComponentModule() {
		ComponentModuleImpl componentModule = new ComponentModuleImpl();
		return componentModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseModule createDatabaseModule() {
		DatabaseModuleImpl databaseModule = new DatabaseModuleImpl();
		return databaseModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LittleComponentModule createLittleComponentModule() {
		LittleComponentModuleImpl littleComponentModule = new LittleComponentModuleImpl();
		return littleComponentModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LittleFramworkModule createLittleFramworkModule() {
		LittleFramworkModuleImpl littleFramworkModule = new LittleFramworkModuleImpl();
		return littleFramworkModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LittleInterfaceModule createLittleInterfaceModule() {
		LittleInterfaceModuleImpl littleInterfaceModule = new LittleInterfaceModuleImpl();
		return littleInterfaceModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component_modelPackage getComponent_modelPackage() {
		return (Component_modelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Component_modelPackage getPackage() {
		return Component_modelPackage.eINSTANCE;
	}

} //Component_modelFactoryImpl
