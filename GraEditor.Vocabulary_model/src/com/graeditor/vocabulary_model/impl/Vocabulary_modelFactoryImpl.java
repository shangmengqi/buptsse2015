/**
 */
package com.graeditor.vocabulary_model.impl;

import com.graeditor.vocabulary_model.*;

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
public class Vocabulary_modelFactoryImpl extends EFactoryImpl implements Vocabulary_modelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Vocabulary_modelFactory init() {
		try {
			Vocabulary_modelFactory theVocabulary_modelFactory = (Vocabulary_modelFactory)EPackage.Registry.INSTANCE.getEFactory(Vocabulary_modelPackage.eNS_URI);
			if (theVocabulary_modelFactory != null) {
				return theVocabulary_modelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Vocabulary_modelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vocabulary_modelFactoryImpl() {
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
			case Vocabulary_modelPackage.AREA_MODULE: return createAreaModule();
			case Vocabulary_modelPackage.VOCABULARY_MODULE: return createVocabularyModule();
			case Vocabulary_modelPackage.FILE_MODULE: return createFileModule();
			case Vocabulary_modelPackage.FILE_STACK_MODULE: return createFileStackModule();
			case Vocabulary_modelPackage.PAGE_MODULE: return createPageModule();
			case Vocabulary_modelPackage.PAGE_STACK_MODULE: return createPageStackModule();
			case Vocabulary_modelPackage.CLUSTER_MODULE: return createClusterModule();
			case Vocabulary_modelPackage.CONCURRENT_SET_MODULE: return createConcurrentSetModule();
			case Vocabulary_modelPackage.COND_BRANCH_MODULE: return createCondBranchModule();
			case Vocabulary_modelPackage.CONT_HORZ_MODULE: return createContHorzModule();
			case Vocabulary_modelPackage.CONT_VERT_MODULE: return createContVertModule();
			case Vocabulary_modelPackage.DEC_POINT_MODULE: return createDecPointModule();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AreaModule createAreaModule() {
		AreaModuleImpl areaModule = new AreaModuleImpl();
		return areaModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VocabularyModule createVocabularyModule() {
		VocabularyModuleImpl vocabularyModule = new VocabularyModuleImpl();
		return vocabularyModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileModule createFileModule() {
		FileModuleImpl fileModule = new FileModuleImpl();
		return fileModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileStackModule createFileStackModule() {
		FileStackModuleImpl fileStackModule = new FileStackModuleImpl();
		return fileStackModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageModule createPageModule() {
		PageModuleImpl pageModule = new PageModuleImpl();
		return pageModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageStackModule createPageStackModule() {
		PageStackModuleImpl pageStackModule = new PageStackModuleImpl();
		return pageStackModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClusterModule createClusterModule() {
		ClusterModuleImpl clusterModule = new ClusterModuleImpl();
		return clusterModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcurrentSetModule createConcurrentSetModule() {
		ConcurrentSetModuleImpl concurrentSetModule = new ConcurrentSetModuleImpl();
		return concurrentSetModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CondBranchModule createCondBranchModule() {
		CondBranchModuleImpl condBranchModule = new CondBranchModuleImpl();
		return condBranchModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContHorzModule createContHorzModule() {
		ContHorzModuleImpl contHorzModule = new ContHorzModuleImpl();
		return contHorzModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContVertModule createContVertModule() {
		ContVertModuleImpl contVertModule = new ContVertModuleImpl();
		return contVertModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecPointModule createDecPointModule() {
		DecPointModuleImpl decPointModule = new DecPointModuleImpl();
		return decPointModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vocabulary_modelPackage getVocabulary_modelPackage() {
		return (Vocabulary_modelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Vocabulary_modelPackage getPackage() {
		return Vocabulary_modelPackage.eINSTANCE;
	}

} //Vocabulary_modelFactoryImpl
