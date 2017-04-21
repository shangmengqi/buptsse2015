/**
 */
package StructureView.impl;

import StructureView.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StructureViewFactoryImpl extends EFactoryImpl implements StructureViewFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StructureViewFactory init() {
		try {
			StructureViewFactory theStructureViewFactory = (StructureViewFactory)EPackage.Registry.INSTANCE.getEFactory(StructureViewPackage.eNS_URI);
			if (theStructureViewFactory != null) {
				return theStructureViewFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StructureViewFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructureViewFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StructureViewPackage.PAGE: return createPage();
			case StructureViewPackage.PAGE_GROUP: return createPageGroup();
			case StructureViewPackage.FILE: return createFile();
			case StructureViewPackage.FILE_GROUP: return createFileGroup();
			case StructureViewPackage.STRUCT_MODULE: return createStructModule();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Page createPage() {
		PageImpl page = new PageImpl();
		return page;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageGroup createPageGroup() {
		PageGroupImpl pageGroup = new PageGroupImpl();
		return pageGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public File createFile() {
		FileImpl file = new FileImpl();
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileGroup createFileGroup() {
		FileGroupImpl fileGroup = new FileGroupImpl();
		return fileGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructModule createStructModule() {
		StructModuleImpl structModule = new StructModuleImpl();
		return structModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructureViewPackage getStructureViewPackage() {
		return (StructureViewPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StructureViewPackage getPackage() {
		return StructureViewPackage.eINSTANCE;
	}

} //StructureViewFactoryImpl
