/**
 */
package StructureView;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link StructureView.Page#getName <em>Name</em>}</li>
 *   <li>{@link StructureView.Page#getFile <em>File</em>}</li>
 *   <li>{@link StructureView.Page#getFilegroup <em>Filegroup</em>}</li>
 *   <li>{@link StructureView.Page#getPagegroup <em>Pagegroup</em>}</li>
 *   <li>{@link StructureView.Page#getPage <em>Page</em>}</li>
 * </ul>
 *
 * @see StructureView.StructureViewPackage#getPage()
 * @model
 * @generated
 */
public interface Page extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see StructureView.StructureViewPackage#getPage_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link StructureView.Page#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>File</b></em>' containment reference list.
	 * The list contents are of type {@link StructureView.File}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' containment reference list.
	 * @see StructureView.StructureViewPackage#getPage_File()
	 * @model containment="true"
	 * @generated
	 */
	EList<File> getFile();

	/**
	 * Returns the value of the '<em><b>Filegroup</b></em>' containment reference list.
	 * The list contents are of type {@link StructureView.FileGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filegroup</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filegroup</em>' containment reference list.
	 * @see StructureView.StructureViewPackage#getPage_Filegroup()
	 * @model containment="true"
	 * @generated
	 */
	EList<FileGroup> getFilegroup();

	/**
	 * Returns the value of the '<em><b>Pagegroup</b></em>' containment reference list.
	 * The list contents are of type {@link StructureView.PageGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pagegroup</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pagegroup</em>' containment reference list.
	 * @see StructureView.StructureViewPackage#getPage_Pagegroup()
	 * @model containment="true"
	 * @generated
	 */
	EList<PageGroup> getPagegroup();

	/**
	 * Returns the value of the '<em><b>Page</b></em>' containment reference list.
	 * The list contents are of type {@link StructureView.Page}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Page</em>' containment reference list.
	 * @see StructureView.StructureViewPackage#getPage_Page()
	 * @model containment="true"
	 * @generated
	 */
	EList<Page> getPage();

} // Page
