package cn.bupt.sse508.versioncontrol.popup.actions;

import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import cn.bupt.sse508.versioncontrol.network.HttpAgent;
import cn.bupt.sse508.versioncontrol.network.HttpResponceVO;

public class PullAction implements IObjectActionDelegate{
	
	public PullAction() {
		super();
	}

	
	/* 
	 * 执行pull功能的主函数
	 */
	@Override
	public void run(IAction action) {
		// TODO Auto-generated method stub
		pull();
		
	}

	private void pull() {
		// TODO Auto-generated method stub
		HttpAgent agent = HttpAgent.getInstance();
    	List<HttpResponceVO> resultList = agent.pullReq();
	}


	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub
		
	}

}
