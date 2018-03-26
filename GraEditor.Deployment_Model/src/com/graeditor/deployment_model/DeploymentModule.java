package com.graeditor.deployment_model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;


/**
 * @model
 */
public interface DeploymentModule extends EObject{
	
	/**
	 * @model
	 */
	EObject getPictogramElement();
	
	/**
	 * Sets the value of the '{@link com.graeditor.deployment_model.DeploymentModule#getPictogramElement <em>Pictogram Element</em>}' reference.
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
	DeploymentModule getPreviousModules();
	
	/**
	 * Sets the value of the '{@link com.graeditor.deployment_model.DeploymentModule#getPreviousModules <em>Previous Modules</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Previous Modules</em>' reference.
	 * @see #getPreviousModules()
	 * @generated
	 */
	void setPreviousModules(DeploymentModule value);

	/**
	 * @model opposite="previousModules"
	 */
	EList<DeploymentModule> getNext();
	
	/**
	 * @model
	 */
	public String getName();
	
	/**
	 * Sets the value of the '{@link com.graeditor.deployment_model.DeploymentModule#getName <em>Name</em>}' attribute.
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
	 * Sets the value of the '{@link com.graeditor.deployment_model.DeploymentModule#getTextContent <em>Text Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Content</em>' attribute.
	 * @see #getTextContent()
	 * @generated
	 */
	void setTextContent(String value);

}
