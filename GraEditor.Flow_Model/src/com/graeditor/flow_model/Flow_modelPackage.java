/**
 */
package com.graeditor.flow_model;

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
 * @see com.graeditor.flow_model.Flow_modelFactory
 * @model kind="package"
 * @generated
 */
public interface Flow_modelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "flow_model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///com/graeditor/flow_model.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "com.graeditor.flow_model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Flow_modelPackage eINSTANCE = com.graeditor.flow_model.impl.Flow_modelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.graeditor.flow_model.impl.FlowModuleImpl <em>Flow Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.flow_model.impl.FlowModuleImpl
	 * @see com.graeditor.flow_model.impl.Flow_modelPackageImpl#getFlowModule()
	 * @generated
	 */
	int FLOW_MODULE = 3;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_MODULE__PICTOGRAM_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_MODULE__PREVIOUS_MODULES = 1;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_MODULE__NEXT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_MODULE__NAME = 3;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_MODULE__TEXT_CONTENT = 4;

	/**
	 * The number of structural features of the '<em>Flow Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_MODULE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Flow Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_MODULE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.graeditor.flow_model.impl.ContentModuleImpl <em>Content Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.flow_model.impl.ContentModuleImpl
	 * @see com.graeditor.flow_model.impl.Flow_modelPackageImpl#getContentModule()
	 * @generated
	 */
	int CONTENT_MODULE = 0;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_MODULE__PICTOGRAM_ELEMENT = FLOW_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_MODULE__PREVIOUS_MODULES = FLOW_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_MODULE__NEXT = FLOW_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_MODULE__NAME = FLOW_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_MODULE__TEXT_CONTENT = FLOW_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Content Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_MODULE_FEATURE_COUNT = FLOW_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Content Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_MODULE_OPERATION_COUNT = FLOW_MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.graeditor.flow_model.impl.EndTagModuleImpl <em>End Tag Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.flow_model.impl.EndTagModuleImpl
	 * @see com.graeditor.flow_model.impl.Flow_modelPackageImpl#getEndTagModule()
	 * @generated
	 */
	int END_TAG_MODULE = 1;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_TAG_MODULE__PICTOGRAM_ELEMENT = FLOW_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_TAG_MODULE__PREVIOUS_MODULES = FLOW_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_TAG_MODULE__NEXT = FLOW_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_TAG_MODULE__NAME = FLOW_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_TAG_MODULE__TEXT_CONTENT = FLOW_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>End Tag Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_TAG_MODULE_FEATURE_COUNT = FLOW_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>End Tag Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_TAG_MODULE_OPERATION_COUNT = FLOW_MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.graeditor.flow_model.impl.FlowImpl <em>Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.flow_model.impl.FlowImpl
	 * @see com.graeditor.flow_model.impl.Flow_modelPackageImpl#getFlow()
	 * @generated
	 */
	int FLOW = 2;

	/**
	 * The feature id for the '<em><b>Modules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__MODULES = 0;

	/**
	 * The feature id for the '<em><b>End Tag</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__END_TAG = 1;

	/**
	 * The number of structural features of the '<em>Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.graeditor.flow_model.impl.StartTagModuleImpl <em>Start Tag Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.flow_model.impl.StartTagModuleImpl
	 * @see com.graeditor.flow_model.impl.Flow_modelPackageImpl#getStartTagModule()
	 * @generated
	 */
	int START_TAG_MODULE = 4;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_TAG_MODULE__PICTOGRAM_ELEMENT = FLOW_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_TAG_MODULE__PREVIOUS_MODULES = FLOW_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_TAG_MODULE__NEXT = FLOW_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_TAG_MODULE__NAME = FLOW_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_TAG_MODULE__TEXT_CONTENT = FLOW_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Start Tag Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_TAG_MODULE_FEATURE_COUNT = FLOW_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Start Tag Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_TAG_MODULE_OPERATION_COUNT = FLOW_MODULE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link com.graeditor.flow_model.impl.VerticalLineModuleImpl <em>Vertical Line Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.flow_model.impl.VerticalLineModuleImpl
	 * @see com.graeditor.flow_model.impl.Flow_modelPackageImpl#getVerticalLineModule()
	 * @generated
	 */
	int VERTICAL_LINE_MODULE = 5;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTICAL_LINE_MODULE__PICTOGRAM_ELEMENT = FLOW_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTICAL_LINE_MODULE__PREVIOUS_MODULES = FLOW_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTICAL_LINE_MODULE__NEXT = FLOW_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTICAL_LINE_MODULE__NAME = FLOW_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTICAL_LINE_MODULE__TEXT_CONTENT = FLOW_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Vertical Line Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTICAL_LINE_MODULE_FEATURE_COUNT = FLOW_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Vertical Line Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTICAL_LINE_MODULE_OPERATION_COUNT = FLOW_MODULE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link com.graeditor.flow_model.impl.HorizontalLineMoudleImpl <em>Horizontal Line Moudle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.flow_model.impl.HorizontalLineMoudleImpl
	 * @see com.graeditor.flow_model.impl.Flow_modelPackageImpl#getHorizontalLineMoudle()
	 * @generated
	 */
	int HORIZONTAL_LINE_MOUDLE = 6;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HORIZONTAL_LINE_MOUDLE__PICTOGRAM_ELEMENT = FLOW_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HORIZONTAL_LINE_MOUDLE__PREVIOUS_MODULES = FLOW_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HORIZONTAL_LINE_MOUDLE__NEXT = FLOW_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HORIZONTAL_LINE_MOUDLE__NAME = FLOW_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HORIZONTAL_LINE_MOUDLE__TEXT_CONTENT = FLOW_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Horizontal Line Moudle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HORIZONTAL_LINE_MOUDLE_FEATURE_COUNT = FLOW_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Horizontal Line Moudle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HORIZONTAL_LINE_MOUDLE_OPERATION_COUNT = FLOW_MODULE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.graeditor.flow_model.impl.TitleMoudleImpl <em>Title Moudle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.flow_model.impl.TitleMoudleImpl
	 * @see com.graeditor.flow_model.impl.Flow_modelPackageImpl#getTitleMoudle()
	 * @generated
	 */
	int TITLE_MOUDLE = 7;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_MOUDLE__PICTOGRAM_ELEMENT = FLOW_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_MOUDLE__PREVIOUS_MODULES = FLOW_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_MOUDLE__NEXT = FLOW_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_MOUDLE__NAME = FLOW_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_MOUDLE__TEXT_CONTENT = FLOW_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Title Moudle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_MOUDLE_FEATURE_COUNT = FLOW_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Title Moudle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TITLE_MOUDLE_OPERATION_COUNT = FLOW_MODULE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link com.graeditor.flow_model.impl.PreLogInTagModuleImpl <em>Pre Log In Tag Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.flow_model.impl.PreLogInTagModuleImpl
	 * @see com.graeditor.flow_model.impl.Flow_modelPackageImpl#getPreLogInTagModule()
	 * @generated
	 */
	int PRE_LOG_IN_TAG_MODULE = 8;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_LOG_IN_TAG_MODULE__PICTOGRAM_ELEMENT = FLOW_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_LOG_IN_TAG_MODULE__PREVIOUS_MODULES = FLOW_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_LOG_IN_TAG_MODULE__NEXT = FLOW_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_LOG_IN_TAG_MODULE__NAME = FLOW_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_LOG_IN_TAG_MODULE__TEXT_CONTENT = FLOW_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Pre Log In Tag Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_LOG_IN_TAG_MODULE_FEATURE_COUNT = FLOW_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Pre Log In Tag Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_LOG_IN_TAG_MODULE_OPERATION_COUNT = FLOW_MODULE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link com.graeditor.flow_model.impl.ControlTagModuleImpl <em>Control Tag Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.graeditor.flow_model.impl.ControlTagModuleImpl
	 * @see com.graeditor.flow_model.impl.Flow_modelPackageImpl#getControlTagModule()
	 * @generated
	 */
	int CONTROL_TAG_MODULE = 9;

	/**
	 * The feature id for the '<em><b>Pictogram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_TAG_MODULE__PICTOGRAM_ELEMENT = FLOW_MODULE__PICTOGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Previous Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_TAG_MODULE__PREVIOUS_MODULES = FLOW_MODULE__PREVIOUS_MODULES;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_TAG_MODULE__NEXT = FLOW_MODULE__NEXT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_TAG_MODULE__NAME = FLOW_MODULE__NAME;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_TAG_MODULE__TEXT_CONTENT = FLOW_MODULE__TEXT_CONTENT;

	/**
	 * The number of structural features of the '<em>Control Tag Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_TAG_MODULE_FEATURE_COUNT = FLOW_MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Control Tag Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_TAG_MODULE_OPERATION_COUNT = FLOW_MODULE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link com.graeditor.flow_model.ContentModule <em>Content Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Content Module</em>'.
	 * @see com.graeditor.flow_model.ContentModule
	 * @generated
	 */
	EClass getContentModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.flow_model.EndTagModule <em>End Tag Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Tag Module</em>'.
	 * @see com.graeditor.flow_model.EndTagModule
	 * @generated
	 */
	EClass getEndTagModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.flow_model.Flow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow</em>'.
	 * @see com.graeditor.flow_model.Flow
	 * @generated
	 */
	EClass getFlow();

	/**
	 * Returns the meta object for the containment reference list '{@link com.graeditor.flow_model.Flow#getModules <em>Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Modules</em>'.
	 * @see com.graeditor.flow_model.Flow#getModules()
	 * @see #getFlow()
	 * @generated
	 */
	EReference getFlow_Modules();

	/**
	 * Returns the meta object for the reference '{@link com.graeditor.flow_model.Flow#getEndTag <em>End Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End Tag</em>'.
	 * @see com.graeditor.flow_model.Flow#getEndTag()
	 * @see #getFlow()
	 * @generated
	 */
	EReference getFlow_EndTag();

	/**
	 * Returns the meta object for class '{@link com.graeditor.flow_model.FlowModule <em>Flow Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow Module</em>'.
	 * @see com.graeditor.flow_model.FlowModule
	 * @generated
	 */
	EClass getFlowModule();

	/**
	 * Returns the meta object for the reference '{@link com.graeditor.flow_model.FlowModule#getPictogramElement <em>Pictogram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pictogram Element</em>'.
	 * @see com.graeditor.flow_model.FlowModule#getPictogramElement()
	 * @see #getFlowModule()
	 * @generated
	 */
	EReference getFlowModule_PictogramElement();

	/**
	 * Returns the meta object for the reference list '{@link com.graeditor.flow_model.FlowModule#getPreviousModules <em>Previous Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Previous Modules</em>'.
	 * @see com.graeditor.flow_model.FlowModule#getPreviousModules()
	 * @see #getFlowModule()
	 * @generated
	 */
	EReference getFlowModule_PreviousModules();

	/**
	 * Returns the meta object for the reference '{@link com.graeditor.flow_model.FlowModule#getNext <em>Next</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next</em>'.
	 * @see com.graeditor.flow_model.FlowModule#getNext()
	 * @see #getFlowModule()
	 * @generated
	 */
	EReference getFlowModule_Next();

	/**
	 * Returns the meta object for the attribute '{@link com.graeditor.flow_model.FlowModule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.graeditor.flow_model.FlowModule#getName()
	 * @see #getFlowModule()
	 * @generated
	 */
	EAttribute getFlowModule_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.graeditor.flow_model.FlowModule#getTextContent <em>Text Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Content</em>'.
	 * @see com.graeditor.flow_model.FlowModule#getTextContent()
	 * @see #getFlowModule()
	 * @generated
	 */
	EAttribute getFlowModule_TextContent();

	/**
	 * Returns the meta object for class '{@link com.graeditor.flow_model.StartTagModule <em>Start Tag Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Tag Module</em>'.
	 * @see com.graeditor.flow_model.StartTagModule
	 * @generated
	 */
	EClass getStartTagModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.flow_model.VerticalLineModule <em>Vertical Line Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vertical Line Module</em>'.
	 * @see com.graeditor.flow_model.VerticalLineModule
	 * @generated
	 */
	EClass getVerticalLineModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.flow_model.HorizontalLineMoudle <em>Horizontal Line Moudle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Horizontal Line Moudle</em>'.
	 * @see com.graeditor.flow_model.HorizontalLineMoudle
	 * @generated
	 */
	EClass getHorizontalLineMoudle();

	/**
	 * Returns the meta object for class '{@link com.graeditor.flow_model.TitleMoudle <em>Title Moudle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Title Moudle</em>'.
	 * @see com.graeditor.flow_model.TitleMoudle
	 * @generated
	 */
	EClass getTitleMoudle();

	/**
	 * Returns the meta object for class '{@link com.graeditor.flow_model.PreLogInTagModule <em>Pre Log In Tag Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pre Log In Tag Module</em>'.
	 * @see com.graeditor.flow_model.PreLogInTagModule
	 * @generated
	 */
	EClass getPreLogInTagModule();

	/**
	 * Returns the meta object for class '{@link com.graeditor.flow_model.ControlTagModule <em>Control Tag Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Tag Module</em>'.
	 * @see com.graeditor.flow_model.ControlTagModule
	 * @generated
	 */
	EClass getControlTagModule();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Flow_modelFactory getFlow_modelFactory();

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
		 * The meta object literal for the '{@link com.graeditor.flow_model.impl.ContentModuleImpl <em>Content Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.flow_model.impl.ContentModuleImpl
		 * @see com.graeditor.flow_model.impl.Flow_modelPackageImpl#getContentModule()
		 * @generated
		 */
		EClass CONTENT_MODULE = eINSTANCE.getContentModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.flow_model.impl.EndTagModuleImpl <em>End Tag Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.flow_model.impl.EndTagModuleImpl
		 * @see com.graeditor.flow_model.impl.Flow_modelPackageImpl#getEndTagModule()
		 * @generated
		 */
		EClass END_TAG_MODULE = eINSTANCE.getEndTagModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.flow_model.impl.FlowImpl <em>Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.flow_model.impl.FlowImpl
		 * @see com.graeditor.flow_model.impl.Flow_modelPackageImpl#getFlow()
		 * @generated
		 */
		EClass FLOW = eINSTANCE.getFlow();

		/**
		 * The meta object literal for the '<em><b>Modules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW__MODULES = eINSTANCE.getFlow_Modules();

		/**
		 * The meta object literal for the '<em><b>End Tag</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW__END_TAG = eINSTANCE.getFlow_EndTag();

		/**
		 * The meta object literal for the '{@link com.graeditor.flow_model.impl.FlowModuleImpl <em>Flow Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.flow_model.impl.FlowModuleImpl
		 * @see com.graeditor.flow_model.impl.Flow_modelPackageImpl#getFlowModule()
		 * @generated
		 */
		EClass FLOW_MODULE = eINSTANCE.getFlowModule();

		/**
		 * The meta object literal for the '<em><b>Pictogram Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_MODULE__PICTOGRAM_ELEMENT = eINSTANCE.getFlowModule_PictogramElement();

		/**
		 * The meta object literal for the '<em><b>Previous Modules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_MODULE__PREVIOUS_MODULES = eINSTANCE.getFlowModule_PreviousModules();

		/**
		 * The meta object literal for the '<em><b>Next</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_MODULE__NEXT = eINSTANCE.getFlowModule_Next();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOW_MODULE__NAME = eINSTANCE.getFlowModule_Name();

		/**
		 * The meta object literal for the '<em><b>Text Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOW_MODULE__TEXT_CONTENT = eINSTANCE.getFlowModule_TextContent();

		/**
		 * The meta object literal for the '{@link com.graeditor.flow_model.impl.StartTagModuleImpl <em>Start Tag Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.flow_model.impl.StartTagModuleImpl
		 * @see com.graeditor.flow_model.impl.Flow_modelPackageImpl#getStartTagModule()
		 * @generated
		 */
		EClass START_TAG_MODULE = eINSTANCE.getStartTagModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.flow_model.impl.VerticalLineModuleImpl <em>Vertical Line Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.flow_model.impl.VerticalLineModuleImpl
		 * @see com.graeditor.flow_model.impl.Flow_modelPackageImpl#getVerticalLineModule()
		 * @generated
		 */
		EClass VERTICAL_LINE_MODULE = eINSTANCE.getVerticalLineModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.flow_model.impl.HorizontalLineMoudleImpl <em>Horizontal Line Moudle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.flow_model.impl.HorizontalLineMoudleImpl
		 * @see com.graeditor.flow_model.impl.Flow_modelPackageImpl#getHorizontalLineMoudle()
		 * @generated
		 */
		EClass HORIZONTAL_LINE_MOUDLE = eINSTANCE.getHorizontalLineMoudle();

		/**
		 * The meta object literal for the '{@link com.graeditor.flow_model.impl.TitleMoudleImpl <em>Title Moudle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.flow_model.impl.TitleMoudleImpl
		 * @see com.graeditor.flow_model.impl.Flow_modelPackageImpl#getTitleMoudle()
		 * @generated
		 */
		EClass TITLE_MOUDLE = eINSTANCE.getTitleMoudle();

		/**
		 * The meta object literal for the '{@link com.graeditor.flow_model.impl.PreLogInTagModuleImpl <em>Pre Log In Tag Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.flow_model.impl.PreLogInTagModuleImpl
		 * @see com.graeditor.flow_model.impl.Flow_modelPackageImpl#getPreLogInTagModule()
		 * @generated
		 */
		EClass PRE_LOG_IN_TAG_MODULE = eINSTANCE.getPreLogInTagModule();

		/**
		 * The meta object literal for the '{@link com.graeditor.flow_model.impl.ControlTagModuleImpl <em>Control Tag Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.graeditor.flow_model.impl.ControlTagModuleImpl
		 * @see com.graeditor.flow_model.impl.Flow_modelPackageImpl#getControlTagModule()
		 * @generated
		 */
		EClass CONTROL_TAG_MODULE = eINSTANCE.getControlTagModule();		

	}
	

} //Flow_modelPackage
