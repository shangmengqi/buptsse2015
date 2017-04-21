/**
 */
package StructureView.impl;

import StructureView.File;
import StructureView.FileGroup;
import StructureView.Page;
import StructureView.PageGroup;
import StructureView.StructureViewPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link StructureView.impl.PageImpl#getName <em>Name</em>}</li>
 *   <li>{@link StructureView.impl.PageImpl#getFile <em>File</em>}</li>
 *   <li>{@link StructureView.impl.PageImpl#getFilegroup <em>Filegroup</em>}</li>
 *   <li>{@link StructureView.impl.PageImpl#getPagegroup <em>Pagegroup</em>}</li>
 *   <li>{@link StructureView.impl.PageImpl#getPage <em>Page</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PageImpl extends StructModuleImpl implements Page {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFile() <em>File</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected EList<File> file;

	/**
	 * The cached value of the '{@link #getFilegroup() <em>Filegroup</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilegroup()
	 * @generated
	 * @ordered
	 */
	protected EList<FileGroup> filegroup;

	/**
	 * The cached value of the '{@link #getPagegroup() <em>Pagegroup</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPagegroup()
	 * @generated
	 * @ordered
	 */
	protected EList<PageGroup> pagegroup;

	/**
	 * The cached value of the '{@link #getPage() <em>Page</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPage()
	 * @generated
	 * @ordered
	 */
	protected EList<Page> page;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StructureViewPackage.Literals.PAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StructureViewPackage.PAGE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<File> getFile() {
		if (file == null) {
			file = new EObjectContainmentEList<File>(File.class, this, StructureViewPackage.PAGE__FILE);
		}
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FileGroup> getFilegroup() {
		if (filegroup == null) {
			filegroup = new EObjectContainmentEList<FileGroup>(FileGroup.class, this, StructureViewPackage.PAGE__FILEGROUP);
		}
		return filegroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PageGroup> getPagegroup() {
		if (pagegroup == null) {
			pagegroup = new EObjectContainmentEList<PageGroup>(PageGroup.class, this, StructureViewPackage.PAGE__PAGEGROUP);
		}
		return pagegroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Page> getPage() {
		if (page == null) {
			page = new EObjectContainmentEList<Page>(Page.class, this, StructureViewPackage.PAGE__PAGE);
		}
		return page;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StructureViewPackage.PAGE__FILE:
				return ((InternalEList<?>)getFile()).basicRemove(otherEnd, msgs);
			case StructureViewPackage.PAGE__FILEGROUP:
				return ((InternalEList<?>)getFilegroup()).basicRemove(otherEnd, msgs);
			case StructureViewPackage.PAGE__PAGEGROUP:
				return ((InternalEList<?>)getPagegroup()).basicRemove(otherEnd, msgs);
			case StructureViewPackage.PAGE__PAGE:
				return ((InternalEList<?>)getPage()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StructureViewPackage.PAGE__NAME:
				return getName();
			case StructureViewPackage.PAGE__FILE:
				return getFile();
			case StructureViewPackage.PAGE__FILEGROUP:
				return getFilegroup();
			case StructureViewPackage.PAGE__PAGEGROUP:
				return getPagegroup();
			case StructureViewPackage.PAGE__PAGE:
				return getPage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StructureViewPackage.PAGE__NAME:
				setName((String)newValue);
				return;
			case StructureViewPackage.PAGE__FILE:
				getFile().clear();
				getFile().addAll((Collection<? extends File>)newValue);
				return;
			case StructureViewPackage.PAGE__FILEGROUP:
				getFilegroup().clear();
				getFilegroup().addAll((Collection<? extends FileGroup>)newValue);
				return;
			case StructureViewPackage.PAGE__PAGEGROUP:
				getPagegroup().clear();
				getPagegroup().addAll((Collection<? extends PageGroup>)newValue);
				return;
			case StructureViewPackage.PAGE__PAGE:
				getPage().clear();
				getPage().addAll((Collection<? extends Page>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StructureViewPackage.PAGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StructureViewPackage.PAGE__FILE:
				getFile().clear();
				return;
			case StructureViewPackage.PAGE__FILEGROUP:
				getFilegroup().clear();
				return;
			case StructureViewPackage.PAGE__PAGEGROUP:
				getPagegroup().clear();
				return;
			case StructureViewPackage.PAGE__PAGE:
				getPage().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StructureViewPackage.PAGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StructureViewPackage.PAGE__FILE:
				return file != null && !file.isEmpty();
			case StructureViewPackage.PAGE__FILEGROUP:
				return filegroup != null && !filegroup.isEmpty();
			case StructureViewPackage.PAGE__PAGEGROUP:
				return pagegroup != null && !pagegroup.isEmpty();
			case StructureViewPackage.PAGE__PAGE:
				return page != null && !page.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //PageImpl
