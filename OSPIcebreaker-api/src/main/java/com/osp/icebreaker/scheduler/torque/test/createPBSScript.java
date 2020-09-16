package com.osp.icebreaker.scheduler.torque.test;

import java.io.IOException;

import com.osp.icebreaker.model.OSPScheduler;
import com.osp.icebreaker.service.OSPClusterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;

public class createPBSScript {
	public static void main(String[] args){
		long schedulerEntryId = 32705;
		OSPScheduler scheduler = null;
		try {
			scheduler = OSPClusterLocalServiceUtil.createOSPScheduler(schedulerEntryId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			scheduler.createExeScript(
					"/home/osp/Torque/solver/hello/1.0.0/bin", 
					"hello",
					"SEQUENTIAL",
					"-st 10", 
					"/EDISON/LDAP/DATA/edisonadm/hello", 
					"hello.log", 
					"test run", 
					"1", 
					"1", 
					"batch", 
					"1:0:0");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
