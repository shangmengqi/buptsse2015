package com.graeditor.flow_model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * @model
 */
public interface Flow extends EObject{

	/**
	 * @model containment="true"
	 */
	EList<FlowModule> getModules();
	
	/**
	 * @model
	 */
	EndTagModule getEndTag();

	/**
	 * Sets the value of the '{@link com.graeditor.flow_model.Flow#getEndTag <em>End Tag</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Tag</em>' reference.
	 * @see #getEndTag()
	 * @generated
	 */
	void setEndTag(EndTagModule value);
}
