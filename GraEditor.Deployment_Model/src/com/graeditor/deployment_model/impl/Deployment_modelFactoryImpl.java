/**
 */
package com.graeditor.deployment_model.impl;

import com.graeditor.deployment_model.*;

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
public class Deployment_modelFactoryImpl extends EFactoryImpl implements Deployment_modelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Deployment_modelFactory init() {
		try {
			Deployment_modelFactory theDeployment_modelFactory = (Deployment_modelFactory)EPackage.Registry.INSTANCE.getEFactory(Deployment_modelPackage.eNS_URI);
			if (theDeployment_modelFactory != null) {
				return theDeployment_modelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Deployment_modelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deployment_modelFactoryImpl() {
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
			case Deployment_modelPackage.DEPLOYMENT_MODULE: return createDeploymentModule();
			case Deployment_modelPackage.DEVICE_NODE_MODULE: return createDeviceNodeModule();
			case Deployment_modelPackage.PROCESSOR_NODE_MODULE: return createProcessorNodeModule();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentModule createDeploymentModule() {
		DeploymentModuleImpl deploymentModule = new DeploymentModuleImpl();
		return deploymentModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceNodeModule createDeviceNodeModule() {
		DeviceNodeModuleImpl deviceNodeModule = new DeviceNodeModuleImpl();
		return deviceNodeModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessorNodeModule createProcessorNodeModule() {
		ProcessorNodeModuleImpl processorNodeModule = new ProcessorNodeModuleImpl();
		return processorNodeModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deployment_modelPackage getDeployment_modelPackage() {
		return (Deployment_modelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Deployment_modelPackage getPackage() {
		return Deployment_modelPackage.eINSTANCE;
	}

} //Deployment_modelFactoryImpl
