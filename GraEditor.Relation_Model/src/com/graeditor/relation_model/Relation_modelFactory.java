/**
 */
package com.graeditor.relation_model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.graeditor.relation_model.Relation_modelPackage
 * @generated
 */
public interface Relation_modelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Relation_modelFactory eINSTANCE = com.graeditor.relation_model.impl.Relation_modelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Horizontal Line Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Horizontal Line Module</em>'.
	 * @generated
	 */
	HorizontalLineModule createHorizontalLineModule();

	/**
	 * Returns a new object of class '<em>Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation</em>'.
	 * @generated
	 */
	Relation createRelation();

	/**
	 * Returns a new object of class '<em>Relation Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Module</em>'.
	 * @generated
	 */
	RelationModule createRelationModule();

	/**
	 * Returns a new object of class '<em>Title Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Title Module</em>'.
	 * @generated
	 */
	TitleModule createTitleModule();

	/**
	 * Returns a new object of class '<em>Content Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Content Module</em>'.
	 * @generated
	 */
	ContentModule createContentModule();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Relation_modelPackage getRelation_modelPackage();

} //Relation_modelFactory
