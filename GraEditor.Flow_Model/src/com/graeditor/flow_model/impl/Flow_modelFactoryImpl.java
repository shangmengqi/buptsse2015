/**
 */
package com.graeditor.flow_model.impl;

import com.graeditor.flow_model.*;

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
public class Flow_modelFactoryImpl extends EFactoryImpl implements Flow_modelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Flow_modelFactory init() {
		try {
			Flow_modelFactory theFlow_modelFactory = (Flow_modelFactory)EPackage.Registry.INSTANCE.getEFactory(Flow_modelPackage.eNS_URI);
			if (theFlow_modelFactory != null) {
				return theFlow_modelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Flow_modelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Flow_modelFactoryImpl() {
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
			case Flow_modelPackage.CONTENT_MODULE: return createContentModule();
			case Flow_modelPackage.END_TAG_MODULE: return createEndTagModule();
			case Flow_modelPackage.FLOW: return createFlow();
			case Flow_modelPackage.FLOW_MODULE: return createFlowModule();
			case Flow_modelPackage.START_TAG_MODULE: return createStartTagModule();
			case Flow_modelPackage.VERTICAL_LINE_MODULE: return createVerticalLineModule();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContentModule createContentModule() {
		ContentModuleImpl contentModule = new ContentModuleImpl();
		return contentModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndTagModule createEndTagModule() {
		EndTagModuleImpl endTagModule = new EndTagModuleImpl();
		return endTagModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Flow createFlow() {
		FlowImpl flow = new FlowImpl();
		return flow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowModule createFlowModule() {
		FlowModuleImpl flowModule = new FlowModuleImpl();
		return flowModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartTagModule createStartTagModule() {
		StartTagModuleImpl startTagModule = new StartTagModuleImpl();
		return startTagModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VerticalLineModule createVerticalLineModule() {
		VerticalLineModuleImpl verticalLineModule = new VerticalLineModuleImpl();
		return verticalLineModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Flow_modelPackage getFlow_modelPackage() {
		return (Flow_modelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Flow_modelPackage getPackage() {
		return Flow_modelPackage.eINSTANCE;
	}

} //Flow_modelFactoryImpl
