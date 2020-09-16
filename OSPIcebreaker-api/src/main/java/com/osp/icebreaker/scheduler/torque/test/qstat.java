package com.osp.icebreaker.scheduler.torque.test;

import java.util.List;

import com.osp.icebreaker.scheduler.torque.Torque;
import com.osp.icebreaker.scheduler.torque.model.TorqueJob;

public class qstat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Torque torque = new Torque("osp", "osp2017!!", "192.168.56.102", "22");
		
		List<TorqueJob> jobs = torque.qstat();
		
		for( TorqueJob job : jobs ){
			System.out.println(job.toString());
		}
	}
}
