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
			case Flow_modelPackage.HORIZONTAL_LINE_MOUDLE: return createHorizontalLineMoudle();
			case Flow_modelPackage.TITLE_MOUDLE: return createTitleMoudle();
			case Flow_modelPackage.PRE_LOG_IN_TAG_MODULE: return createPreLogInTagModule();
			case Flow_modelPackage.CONTROL_TAG_MODULE: return createControlTagModule();
			case Flow_modelPackage.FEN_CHA_MODULE: return createFenChaModule();
			case Flow_modelPackage.HE_BING_MODULE: return createHeBingModule();
			case Flow_modelPackage.HUI_HE_MODULE: return createHuiHeModule();
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
	public HorizontalLineMoudle createHorizontalLineMoudle() {
		HorizontalLineMoudleImpl horizontalLineMoudle = new HorizontalLineMoudleImpl();
		return horizontalLineMoudle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TitleMoudle createTitleMoudle() {
		TitleMoudleImpl titleMoudle = new TitleMoudleImpl();
		return titleMoudle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PreLogInTagModule createPreLogInTagModule() {
		PreLogInTagModuleImpl preLogInTagModule = new PreLogInTagModuleImpl();
		return preLogInTagModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlTagModule createControlTagModule() {
		ControlTagModuleImpl controlTagModule = new ControlTagModuleImpl();
		return controlTagModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FenChaModule createFenChaModule() {
		FenChaModuleImpl fenChaModule = new FenChaModuleImpl();
		return fenChaModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HeBingModule createHeBingModule() {
		HeBingModuleImpl heBingModule = new HeBingModuleImpl();
		return heBingModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HuiHeModule createHuiHeModule() {
		HuiHeModuleImpl huiHeModule = new HuiHeModuleImpl();
		return huiHeModule;
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
