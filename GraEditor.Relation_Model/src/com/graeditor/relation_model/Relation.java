package com.graeditor.relation_model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * @model
 */
public interface Relation extends EObject{

	/**
	 * @model containment="true"
	 */
	EList<RelationModule> getModules();
}
