package com.graeditor.flow_model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * @model
 */
public interface FlowModule extends EObject{

	/**
	 * @model
	 */
	EObject getPictogramElement();
	
	/**
	 * Sets the value of the '{@link com.graeditor.flow_model.FlowModule#getPictogramElement <em>Pictogram Element</em>}' reference.
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
	EList<FlowModule> getPreviousModules();
	
	/**
	 * @model opposite="previousModules"
	 */
	FlowModule getNext();
	
	/**
	 * Sets the value of the '{@link com.graeditor.flow_model.FlowModule#getNext <em>Next</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next</em>' reference.
	 * @see #getNext()
	 * @generated
	 */
	void setNext(FlowModule value);

	/**
	 * @model
	 */
	public String getName();

	/**
	 * Sets the value of the '{@link com.graeditor.flow_model.FlowModule#getName <em>Name</em>}' attribute.
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
	 * Sets the value of the '{@link com.graeditor.flow_model.FlowModule#getTextContent <em>Text Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Content</em>' attribute.
	 * @see #getTextContent()
	 * @generated
	 */
	void setTextContent(String value);
	
}
