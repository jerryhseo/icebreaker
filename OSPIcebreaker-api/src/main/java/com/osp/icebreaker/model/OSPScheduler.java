package com.osp.icebreaker.model;

import java.io.IOException;
import java.util.Map;

import com.osp.icebreaker.model.Job;
import com.liferay.portal.kernel.json.JSONArray;

public interface OSPScheduler {
	public String submitJob(
			String appBinDir,
			String appExe,
			String runType,
			String inputArgs,
			String wokringDir,
			String logFileName,
			String jobTitle,
			String nodes,
			String ppn,
			String qName,
			String wallTime
			) throws IOException;
	public JSONArray nodes();
	public JSONArray nodes( String qName );
	public JSONArray queueState(); 
	public void createExeScript(
			String appBinDir,
			String appExe,
			String runType,
			String inputArgs,
			String wokringDir,
			String logFileName,
			String jobTitle,
			String nodes,
			String ppn,
			String qName,
			String wallTime
			) throws IOException;
	public void delete();
}
