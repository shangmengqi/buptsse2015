package FlowView;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * @model
 */
public interface ActionModule extends EObject{

	/**
	 * @model
	 */
	EObject getPictogramElement();
	
	/**
	 * @model opposite="next"
	 */
	EList<ActionModule> getPreviousModules();
	
	/**
	 * @model opposite="previousModules"
	 */
	ActionModule getNext();
}
