/**
 */
package com.graeditor.relation_model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.graeditor.relation_model.Relation_modelFactory
 * @model kind="package"
 * @generated
 */
public interface Relation_modelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "relation_model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///com/graeditor/relation_model.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.graeditor.relation_model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Relation_modelPackage eINSTANCE = com.graeditor.relation_model.impl.Relation_modelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.graeditor.relation_model.impl.RelationModuleImpl <em>Relation Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.relation_model.impl.RelationModuleImpl
	 * @see com.graeditor.relation_model.impl.Relation_modelPackageImpl#getRelationModule()
	 * @generated
	 */
	int RELATION_MODULE = 2;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_MODULE__PICTOGRAM_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_MODULE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_MODULE__TEXT_CONTENT = 2;

	/**
	 * The number of structural features of the '<em>Relation Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_MODULE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Relation Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_MODULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.graeditor.relation_model.impl.HorizontalLineModuleImpl <em>Horizontal Line Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.relation_model.impl.HorizontalLineModuleImpl
	 * @see com.graeditor.relation_model.impl.Relation_modelPackageImpl#getHorizontalLineModule()
	 * @generated
	 */
	int HORIZONTAL_LINE_MODULE = 0;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HORIZONTAL_LINE_MODULE__PICTOGRAM_ELEMENT = RELATION_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HORIZONTAL_LINE_MODULE__NAME = RELATION_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HORIZONTAL_LINE_MODULE__TEXT_CONTENT = RELATION_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Horizontal Line Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HORIZONTAL_LINE_MODULE_FEATURE_COUNT = RELATION_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Horizontal Line Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HORIZONTAL_LINE_MODULE_OPERATION_COUNT = RELATION_MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.graeditor.relation_model.impl.RelationImpl <em>Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.relation_model.impl.RelationImpl
	 * @see com.graeditor.relation_model.impl.Relation_modelPackageImpl#getRelation()
	 * @generated
	 */
	int RELATION = 1;

	/**
	 * The feature id for the '<em><b>Modules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__MODULES = 0;

	/**
	 * The number of structural features of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.graeditor.relation_model.impl.TitleModuleImpl <em>Title Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.relation_model.impl.TitleModuleImpl
	 * @see com.graeditor.relation_model.impl.Relation_modelPackageImpl#getTitleModule()
	 * @generated
	 */
	int TITLE_MODULE = 3;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_MODULE__PICTOGRAM_ELEMENT = RELATION_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_MODULE__NAME = RELATION_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_MODULE__TEXT_CONTENT = RELATION_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Title Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_MODULE_FEATURE_COUNT = RELATION_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Title Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_MODULE_OPERATION_COUNT = RELATION_MODULE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link com.graeditor.relation_model.impl.ContentModuleImpl <em>Content Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.relation_model.impl.ContentModuleImpl
	 * @see com.graeditor.relation_model.impl.Relation_modelPackageImpl#getContentModule()
	 * @generated
	 */
	int CONTENT_MODULE = 4;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_MODULE__PICTOGRAM_ELEMENT = RELATION_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_MODULE__NAME = RELATION_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_MODULE__TEXT_CONTENT = RELATION_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Content Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_MODULE_FEATURE_COUNT = RELATION_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Content Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_MODULE_OPERATION_COUNT = RELATION_MODULE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link com.graeditor.relation_model.HorizontalLineModule <em>Horizontal Line Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Horizontal Line Module</em>'.
	 * @see com.graeditor.relation_model.HorizontalLineModule
	 * @generated
	 */
	EClass getHorizontalLineModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.relation_model.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation</em>'.
	 * @see com.graeditor.relation_model.Relation
	 * @generated
	 */
	EClass getRelation();

	/**
	 * Returns the meta object for the containment reference list '{@link com.graeditor.relation_model.Relation#getModules <em>Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Modules</em>'.
	 * @see com.graeditor.relation_model.Relation#getModules()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_Modules();

	/**
	 * Returns the meta object for class '{@link com.graeditor.relation_model.RelationModule <em>Relation Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Module</em>'.
	 * @see com.graeditor.relation_model.RelationModule
	 * @generated
	 */
	EClass getRelationModule();

	/**
	 * Returns the meta object for the reference '{@link com.graeditor.relation_model.RelationModule#getPictogramElement <em>Pictogram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pictogram Element</em>'.
	 * @see com.graeditor.relation_model.RelationModule#getPictogramElement()
	 * @see #getRelationModule()
	 * @generated
	 */
	EReference getRelationModule_PictogramElement();

	/**
	 * Returns the meta object for the attribute '{@link com.graeditor.relation_model.RelationModule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.graeditor.relation_model.RelationModule#getName()
	 * @see #getRelationModule()
	 * @generated
	 */
	EAttribute getRelationModule_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.graeditor.relation_model.RelationModule#getTextContent <em>Text Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Content</em>'.
	 * @see com.graeditor.relation_model.RelationModule#getTextContent()
	 * @see #getRelationModule()
	 * @generated
	 */
	EAttribute getRelationModule_TextContent();

	/**
	 * Returns the meta object for class '{@link com.graeditor.relation_model.TitleModule <em>Title Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Title Module</em>'.
	 * @see com.graeditor.relation_model.TitleModule
	 * @generated
	 */
	EClass getTitleModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.relation_model.ContentModule <em>Content Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Content Module</em>'.
	 * @see com.graeditor.relation_model.ContentModule
	 * @generated
	 */
	EClass getContentModule();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Relation_modelFactory getRelation_modelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.graeditor.relation_model.impl.HorizontalLineModuleImpl <em>Horizontal Line Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.relation_model.impl.HorizontalLineModuleImpl
		 * @see com.graeditor.relation_model.impl.Relation_modelPackageImpl#getHorizontalLineModule()
		 * @generated
		 */
		EClass HORIZONTAL_LINE_MODULE = eINSTANCE.getHorizontalLineModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.relation_model.impl.RelationImpl <em>Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.relation_model.impl.RelationImpl
		 * @see com.graeditor.relation_model.impl.Relation_modelPackageImpl#getRelation()
		 * @generated
		 */
		EClass RELATION = eINSTANCE.getRelation();

		/**
		 * The meta object literal for the '<em><b>Modules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__MODULES = eINSTANCE.getRelation_Modules();

		/**
		 * The meta object literal for the '{@link com.graeditor.relation_model.impl.RelationModuleImpl <em>Relation Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.relation_model.impl.RelationModuleImpl
		 * @see com.graeditor.relation_model.impl.Relation_modelPackageImpl#getRelationModule()
		 * @generated
		 */
		EClass RELATION_MODULE = eINSTANCE.getRelationModule();

		/**
		 * The meta object literal for the '<em><b>Pictogram Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_MODULE__PICTOGRAM_ELEMENT = eINSTANCE.getRelationModule_PictogramElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_MODULE__NAME = eINSTANCE.getRelationModule_Name();

		/**
		 * The meta object literal for the '<em><b>Text Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_MODULE__TEXT_CONTENT = eINSTANCE.getRelationModule_TextContent();

		/**
		 * The meta object literal for the '{@link com.graeditor.relation_model.impl.TitleModuleImpl <em>Title Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.relation_model.impl.TitleModuleImpl
		 * @see com.graeditor.relation_model.impl.Relation_modelPackageImpl#getTitleModule()
		 * @generated
		 */
		EClass TITLE_MODULE = eINSTANCE.getTitleModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.relation_model.impl.ContentModuleImpl <em>Content Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.relation_model.impl.ContentModuleImpl
		 * @see com.graeditor.relation_model.impl.Relation_modelPackageImpl#getContentModule()
		 * @generated
		 */
		EClass CONTENT_MODULE = eINSTANCE.getContentModule();

	}

} //Relation_modelPackage
