package cn.bupt.sse508.versioncontrol.popup.actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import cn.bupt.sse508.versioncontrol.network.HttpAgent;
import cn.bupt.sse508.versioncontrol.network.HttpResponceVO;
import cn.bupt.sse508.versioncontrol.network.NetworkUtils;
import cn.bupt.sse508.versioncontrol.util.ProjectUtil;
import midfile.json.graphiti.FromMidFile;

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
		String fileName;
		
		HttpAgent agent = HttpAgent.getInstance();
    	String resultString = agent.pullReq();
    	System.out.println("resultString: " + resultString);
    	
    	//将返回的结果分段
    	String[] resultArr = resultString.split(NetworkUtils.RESULT_SPLITER);
    	int fileCount = resultArr.length - 1;
    	System.out.println("resultArr.length: " + fileCount);
    	for(int i = 1; i < resultArr.length; i = i + 2){
    		fileName = resultArr[i].trim();   		
    		String fileContent = resultArr[i+1];
    		System.out.println("fileName: " +fileName );
    		
    		String[]  fileNameArr = fileName.split("\\.");
    		String fileName1 = fileNameArr[0];
    		System.out.println("fileName1: " + fileName1);

    		//将拉取到的文件内容进行格式转换   		
    		String xml = FromMidFile.fromMidFile(fileContent, null);
    		System.out.println("Pull Req xml: " + xml);
    		
    		/**
    		 * 额外将拉取的文件存入本地一个临时文件夹下
    		 */
    		String fileContater = "E:/Git/diagrams/" + fileName;
    		System.out.println("fileName33333333: " + fileName);
    		System.out.println("fileContater: " + fileContater);
    		File file = new File(fileContater);
    		writeToFile(xml, file);
    		
    		//遍历当前项目文件，将拉取到的内容重新写进相应路径的文件中
    		List<IFile> fileNameAndPathList = getDiagramFiles(ProjectUtil.getCurrentProject()); 
    		for(int a = 0; a < fileNameAndPathList.size(); a++){
    			System.out.println("fileNameAndPathList: " + fileNameAndPathList.get(a));
    			String filePath = fileNameAndPathList.get(a).toString();
    			String filePathTrue = filePath.substring(1, filePath.length());
    			String filePathTrue2 = "E:/Git/buptsse2015/runtime-EclipseApplication" + filePathTrue;
    			System.out.println("filePathTrue: " + filePathTrue2);
    			String[] filePathSpilt = filePath.split("/");
    			String fileNameSpilt = filePathSpilt[4];
    			System.out.println("fileNameSpilt: " + fileNameSpilt);
    			   			
    			if(fileName.contains(fileNameSpilt)){
    				try {
						fileNameAndPathList.get(a).delete(true, null);
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    				File file1 = new File(filePathTrue2);
    				writeToFile(xml, file1);
    			}
    		}
    	}
	}


	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 删除该工程目录下的所有.diagrams文件
	 * 
	 */
	private void deleteAllDiagrams() {
		List<IFile> files = getDiagramFiles(ProjectUtil.getCurrentProject());
		try {
			for (int i = files.size() - 1; i >= 0; i--) {
				files.get(i).delete(true, null);
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 递归的搜索所有.diagrams文件
	 * @param folder
	 * @return
	 */
	private List<IFile> getDiagramFiles(IContainer folder) { // folder = ProjectUtil.getCurrentProject()
		final List<IFile> ret = new ArrayList<IFile>();
		try {
			final IResource[] members = folder.members(); // 获得该项目下所有的文件夹、文件
			for (final IResource resource : members) {
				if (resource instanceof IContainer) {
					System.out.println("111: " + resource);
					ret.addAll(getDiagramFiles((IContainer) resource));					
				} else if (resource instanceof IFile) {
					System.out.println("222: " + resource);
					final IFile file = (IFile) resource;
					if (file.getName().endsWith(".diagram")) { //$NON-NLS-1$
						ret.add(file);
						System.out.println("444: " + ret);
					}
				}
			}
		} catch (final CoreException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	/**
	 * 将字符串内容写入到某个文件中
	 * @param content String，字符串内容
	 * @param file File，文件对象
	 */
	private void writeToFile(String content, File file) {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
