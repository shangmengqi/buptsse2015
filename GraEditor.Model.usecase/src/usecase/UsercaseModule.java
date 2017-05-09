package usecase;

import org.eclipse.emf.ecore.EObject;

/**
 * @model
 */
public interface UsercaseModule extends EObject{
	
	/**
	 * @model
	 */
	EObject getPictogramElement();

	/**
	 * Sets the value of the '{@link usecase.UsercaseModule#getPictogramElement <em>Pictogram Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pictogram Element</em>' reference.
	 * @see #getPictogramElement()
	 * @generated
	 */
	void setPictogramElement(EObject value);

}
