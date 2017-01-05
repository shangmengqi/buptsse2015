package cn.bupt.sse508.versioncontrol.popup.actions;

import javax.swing.JOptionPane;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import cn.bupt.sse508.versioncontrol.network.NetworkUtils;

public class Config implements IObjectActionDelegate {

	private Shell shell;
	
	/**
	 * Constructor for Action1.
	 */
	public Config() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		// 弹出让用户配置ip地址的对话框
		getAddress();
	}
	
	private void getAddress() {
		String address = JOptionPane.showInputDialog("Server Address：\n",NetworkUtils.SERVER_ADDRESS);
		if (null != address) {
			address = address.replace("\n", "");
			NetworkUtils.SERVER_ADDRESS = address;
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

}
