package cn.bupt.sse508.versioncontrol.network;

import java.util.List;

import org.json.JSONObject;

public class HttpResponceVO {
	public static final int OK = 200;
	
	/** http返回值，有200，404，502等，网络连通性上的 */
	public int status;
	/** 服务器处理的返回值，业务逻辑上的 */
	public String result;
	/** 所对应的文件名 */
	public String fileName;
	/** 这个文件经过服务器处理后的内容 */
	public String fileContent;
	/** 若成功操作，则是这个版本的版本号 */
	public String versionNo;
	/** 冲突描述的列表 */
	public List<JSONObject> conflictList;
	/** 合并的描述列表 */
	public List<JSONObject> mergeList;
}
