/**
 */
package com.graeditor.component_model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.graeditor.component_model.Component_modelFactory
 * @model kind="package"
 * @generated
 */
public interface Component_modelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "component_model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///com/graeditor/component_model.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.graeditor.component_model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Component_modelPackage eINSTANCE = com.graeditor.component_model.impl.Component_modelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.graeditor.component_model.impl.ComponentModuleImpl <em>Component Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.component_model.impl.ComponentModuleImpl
	 * @see com.graeditor.component_model.impl.Component_modelPackageImpl#getComponentModule()
	 * @generated
	 */
	int COMPONENT_MODULE = 0;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_MODULE__PICTOGRAM_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_MODULE__PREVIOUS_MODULES = 1;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_MODULE__NEXT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_MODULE__NAME = 3;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_MODULE__TEXT_CONTENT = 4;

	/**
	 * The number of structural features of the '<em>Component Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_MODULE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Component Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_MODULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.graeditor.component_model.impl.DatabaseModuleImpl <em>Database Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.component_model.impl.DatabaseModuleImpl
	 * @see com.graeditor.component_model.impl.Component_modelPackageImpl#getDatabaseModule()
	 * @generated
	 */
	int DATABASE_MODULE = 1;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_MODULE__PICTOGRAM_ELEMENT = COMPONENT_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_MODULE__PREVIOUS_MODULES = COMPONENT_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_MODULE__NEXT = COMPONENT_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_MODULE__NAME = COMPONENT_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_MODULE__TEXT_CONTENT = COMPONENT_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Database Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_MODULE_FEATURE_COUNT = COMPONENT_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Database Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_MODULE_OPERATION_COUNT = COMPONENT_MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.graeditor.component_model.impl.LittleComponentModuleImpl <em>Little Component Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.component_model.impl.LittleComponentModuleImpl
	 * @see com.graeditor.component_model.impl.Component_modelPackageImpl#getLittleComponentModule()
	 * @generated
	 */
	int LITTLE_COMPONENT_MODULE = 2;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_COMPONENT_MODULE__PICTOGRAM_ELEMENT = COMPONENT_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_COMPONENT_MODULE__PREVIOUS_MODULES = COMPONENT_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_COMPONENT_MODULE__NEXT = COMPONENT_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_COMPONENT_MODULE__NAME = COMPONENT_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_COMPONENT_MODULE__TEXT_CONTENT = COMPONENT_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Little Component Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_COMPONENT_MODULE_FEATURE_COUNT = COMPONENT_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Little Component Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_COMPONENT_MODULE_OPERATION_COUNT = COMPONENT_MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.graeditor.component_model.impl.LittleFramworkModuleImpl <em>Little Framwork Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.component_model.impl.LittleFramworkModuleImpl
	 * @see com.graeditor.component_model.impl.Component_modelPackageImpl#getLittleFramworkModule()
	 * @generated
	 */
	int LITTLE_FRAMWORK_MODULE = 3;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_FRAMWORK_MODULE__PICTOGRAM_ELEMENT = COMPONENT_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_FRAMWORK_MODULE__PREVIOUS_MODULES = COMPONENT_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_FRAMWORK_MODULE__NEXT = COMPONENT_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_FRAMWORK_MODULE__NAME = COMPONENT_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_FRAMWORK_MODULE__TEXT_CONTENT = COMPONENT_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Little Framwork Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_FRAMWORK_MODULE_FEATURE_COUNT = COMPONENT_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Little Framwork Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_FRAMWORK_MODULE_OPERATION_COUNT = COMPONENT_MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.graeditor.component_model.impl.LittleInterfaceModuleImpl <em>Little Interface Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.component_model.impl.LittleInterfaceModuleImpl
	 * @see com.graeditor.component_model.impl.Component_modelPackageImpl#getLittleInterfaceModule()
	 * @generated
	 */
	int LITTLE_INTERFACE_MODULE = 4;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_INTERFACE_MODULE__PICTOGRAM_ELEMENT = COMPONENT_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_INTERFACE_MODULE__PREVIOUS_MODULES = COMPONENT_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_INTERFACE_MODULE__NEXT = COMPONENT_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_INTERFACE_MODULE__NAME = COMPONENT_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_INTERFACE_MODULE__TEXT_CONTENT = COMPONENT_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Little Interface Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_INTERFACE_MODULE_FEATURE_COUNT = COMPONENT_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Little Interface Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITTLE_INTERFACE_MODULE_OPERATION_COUNT = COMPONENT_MODULE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link com.graeditor.component_model.ComponentModule <em>Component Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Module</em>'.
	 * @see com.graeditor.component_model.ComponentModule
	 * @generated
	 */
	EClass getComponentModule();

	/**
	 * Returns the meta object for the reference '{@link com.graeditor.component_model.ComponentModule#getPictogramElement <em>Pictogram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pictogram Element</em>'.
	 * @see com.graeditor.component_model.ComponentModule#getPictogramElement()
	 * @see #getComponentModule()
	 * @generated
	 */
	EReference getComponentModule_PictogramElement();

	/**
	 * Returns the meta object for the reference '{@link com.graeditor.component_model.ComponentModule#getPreviousModules <em>Previous Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Previous Modules</em>'.
	 * @see com.graeditor.component_model.ComponentModule#getPreviousModules()
	 * @see #getComponentModule()
	 * @generated
	 */
	EReference getComponentModule_PreviousModules();

	/**
	 * Returns the meta object for the reference list '{@link com.graeditor.component_model.ComponentModule#getNext <em>Next</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Next</em>'.
	 * @see com.graeditor.component_model.ComponentModule#getNext()
	 * @see #getComponentModule()
	 * @generated
	 */
	EReference getComponentModule_Next();

	/**
	 * Returns the meta object for the attribute '{@link com.graeditor.component_model.ComponentModule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.graeditor.component_model.ComponentModule#getName()
	 * @see #getComponentModule()
	 * @generated
	 */
	EAttribute getComponentModule_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.graeditor.component_model.ComponentModule#getTextContent <em>Text Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Content</em>'.
	 * @see com.graeditor.component_model.ComponentModule#getTextContent()
	 * @see #getComponentModule()
	 * @generated
	 */
	EAttribute getComponentModule_TextContent();

	/**
	 * Returns the meta object for class '{@link com.graeditor.component_model.DatabaseModule <em>Database Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Database Module</em>'.
	 * @see com.graeditor.component_model.DatabaseModule
	 * @generated
	 */
	EClass getDatabaseModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.component_model.LittleComponentModule <em>Little Component Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Little Component Module</em>'.
	 * @see com.graeditor.component_model.LittleComponentModule
	 * @generated
	 */
	EClass getLittleComponentModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.component_model.LittleFramworkModule <em>Little Framwork Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Little Framwork Module</em>'.
	 * @see com.graeditor.component_model.LittleFramworkModule
	 * @generated
	 */
	EClass getLittleFramworkModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.component_model.LittleInterfaceModule <em>Little Interface Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Little Interface Module</em>'.
	 * @see com.graeditor.component_model.LittleInterfaceModule
	 * @generated
	 */
	EClass getLittleInterfaceModule();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Component_modelFactory getComponent_modelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.graeditor.component_model.impl.ComponentModuleImpl <em>Component Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.component_model.impl.ComponentModuleImpl
		 * @see com.graeditor.component_model.impl.Component_modelPackageImpl#getComponentModule()
		 * @generated
		 */
		EClass COMPONENT_MODULE = eINSTANCE.getComponentModule();

		/**
		 * The meta object literal for the '<em><b>Pictogram Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_MODULE__PICTOGRAM_ELEMENT = eINSTANCE.getComponentModule_PictogramElement();

		/**
		 * The meta object literal for the '<em><b>Previous Modules</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_MODULE__PREVIOUS_MODULES = eINSTANCE.getComponentModule_PreviousModules();

		/**
		 * The meta object literal for the '<em><b>Next</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_MODULE__NEXT = eINSTANCE.getComponentModule_Next();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_MODULE__NAME = eINSTANCE.getComponentModule_Name();

		/**
		 * The meta object literal for the '<em><b>Text Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_MODULE__TEXT_CONTENT = eINSTANCE.getComponentModule_TextContent();

		/**
		 * The meta object literal for the '{@link com.graeditor.component_model.impl.DatabaseModuleImpl <em>Database Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.component_model.impl.DatabaseModuleImpl
		 * @see com.graeditor.component_model.impl.Component_modelPackageImpl#getDatabaseModule()
		 * @generated
		 */
		EClass DATABASE_MODULE = eINSTANCE.getDatabaseModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.component_model.impl.LittleComponentModuleImpl <em>Little Component Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.component_model.impl.LittleComponentModuleImpl
		 * @see com.graeditor.component_model.impl.Component_modelPackageImpl#getLittleComponentModule()
		 * @generated
		 */
		EClass LITTLE_COMPONENT_MODULE = eINSTANCE.getLittleComponentModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.component_model.impl.LittleFramworkModuleImpl <em>Little Framwork Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.component_model.impl.LittleFramworkModuleImpl
		 * @see com.graeditor.component_model.impl.Component_modelPackageImpl#getLittleFramworkModule()
		 * @generated
		 */
		EClass LITTLE_FRAMWORK_MODULE = eINSTANCE.getLittleFramworkModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.component_model.impl.LittleInterfaceModuleImpl <em>Little Interface Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.component_model.impl.LittleInterfaceModuleImpl
		 * @see com.graeditor.component_model.impl.Component_modelPackageImpl#getLittleInterfaceModule()
		 * @generated
		 */
		EClass LITTLE_INTERFACE_MODULE = eINSTANCE.getLittleInterfaceModule();

	}

} //Component_modelPackage
