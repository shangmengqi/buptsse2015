/**
 */
package com.graeditor.vocabulary_model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.graeditor.vocabulary_model.Vocabulary_modelPackage
 * @generated
 */
public interface Vocabulary_modelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Vocabulary_modelFactory eINSTANCE = com.graeditor.vocabulary_model.impl.Vocabulary_modelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Area Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Area Module</em>'.
	 * @generated
	 */
	AreaModule createAreaModule();

	/**
	 * Returns a new object of class '<em>Vocabulary Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vocabulary Module</em>'.
	 * @generated
	 */
	VocabularyModule createVocabularyModule();

	/**
	 * Returns a new object of class '<em>File Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Module</em>'.
	 * @generated
	 */
	FileModule createFileModule();

	/**
	 * Returns a new object of class '<em>File Stack Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>File Stack Module</em>'.
	 * @generated
	 */
	FileStackModule createFileStackModule();

	/**
	 * Returns a new object of class '<em>Page Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Page Module</em>'.
	 * @generated
	 */
	PageModule createPageModule();

	/**
	 * Returns a new object of class '<em>Page Stack Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Page Stack Module</em>'.
	 * @generated
	 */
	PageStackModule createPageStackModule();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Vocabulary_modelPackage getVocabulary_modelPackage();

} //Vocabulary_modelFactory
