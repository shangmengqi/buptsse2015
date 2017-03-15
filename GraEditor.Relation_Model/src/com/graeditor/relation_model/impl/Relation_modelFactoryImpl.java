/**
 */
package com.graeditor.relation_model.impl;

import com.graeditor.relation_model.*;

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
public class Relation_modelFactoryImpl extends EFactoryImpl implements Relation_modelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Relation_modelFactory init() {
		try {
			Relation_modelFactory theRelation_modelFactory = (Relation_modelFactory)EPackage.Registry.INSTANCE.getEFactory(Relation_modelPackage.eNS_URI);
			if (theRelation_modelFactory != null) {
				return theRelation_modelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Relation_modelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation_modelFactoryImpl() {
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
			case Relation_modelPackage.HORIZONTAL_LINE_MODULE: return createHorizontalLineModule();
			case Relation_modelPackage.RELATION: return createRelation();
			case Relation_modelPackage.RELATION_MODULE: return createRelationModule();
			case Relation_modelPackage.TITLE_MODULE: return createTitleModule();
			case Relation_modelPackage.CONTENT_MODULE: return createContentModule();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HorizontalLineModule createHorizontalLineModule() {
		HorizontalLineModuleImpl horizontalLineModule = new HorizontalLineModuleImpl();
		return horizontalLineModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation createRelation() {
		RelationImpl relation = new RelationImpl();
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationModule createRelationModule() {
		RelationModuleImpl relationModule = new RelationModuleImpl();
		return relationModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TitleModule createTitleModule() {
		TitleModuleImpl titleModule = new TitleModuleImpl();
		return titleModule;
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
	public Relation_modelPackage getRelation_modelPackage() {
		return (Relation_modelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Relation_modelPackage getPackage() {
		return Relation_modelPackage.eINSTANCE;
	}

} //Relation_modelFactoryImpl
