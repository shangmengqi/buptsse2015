package com.graeditor.vocabulary_model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;


/**
 * @model
 */
public interface VocabularyModule extends EObject{
	
	/**
	 * @model
	 */
	EObject getPictogramElement();
	
	/**
	 * Sets the value of the '{@link com.graeditor.vocabulary_model.VocabularyModule#getPictogramElement <em>Pictogram Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pictogram Element</em>' reference.
	 * @see #getPictogramElement()
	 * @generated
	 */
	void setPictogramElement(EObject value);

	/**
	 * @model opposite="next"
	 */
	EList<VocabularyModule> getPreviousModules();
	
	/**
	 * @model opposite="previousModules"
	 */
	VocabularyModule getNext();
	
	/**
	 * Sets the value of the '{@link com.graeditor.vocabulary_model.VocabularyModule#getNext <em>Next</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next</em>' reference.
	 * @see #getNext()
	 * @generated
	 */
	void setNext(VocabularyModule value);

	/**
	 * @model
	 */
	public String getName();
	
	/**
	 * Sets the value of the '{@link com.graeditor.vocabulary_model.VocabularyModule#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 *@model
	 */
	public String getTextContent();

	/**
	 * Sets the value of the '{@link com.graeditor.vocabulary_model.VocabularyModule#getTextContent <em>Text Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Content</em>' attribute.
	 * @see #getTextContent()
	 * @generated
	 */
	void setTextContent(String value);

}
