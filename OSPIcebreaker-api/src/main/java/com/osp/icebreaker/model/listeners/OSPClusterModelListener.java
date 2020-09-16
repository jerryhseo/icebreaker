package com.osp.icebreaker.model.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.osgi.service.component.annotations.Component;

import com.osp.icebreaker.model.OSPCluster;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;


/**
 * 
 * @author Jerry H. Seo
 *
 *  Every CRUD Actions to the OSPCluster arrive to this instance.
 */
@Component(
	    immediate = true,
	    service = ModelListener.class
)
public class OSPClusterModelListener extends BaseModelListener<OSPCluster> {
	static public List<OSPCluster> createdQueue = new ArrayList<OSPCluster>();
	static public List<OSPCluster> updatedQueue = new ArrayList<OSPCluster>();
	static public List<OSPCluster> deletedQueue = new ArrayList<OSPCluster>();
	
	static public List<OSPCluster> getUpdatedModel( long groupId, long userId ){
		System.out.println("getUpdatedModel: "+groupId+", "+userId);
		List<OSPCluster> list = new ArrayList<>();

		OSPCluster entry = null;
		while( (entry = popUpdatedModel(updatedQueue, groupId, userId)) != null ){
			list.add(entry);
			System.out.println("Cluster Name: "+entry.getClusterName());
			System.out.println("Cluster GroupId: "+entry.getGroupId());
			System.out.println("Cluster User ID: "+entry.getUserId());
		}

		return list;
	}
	
	static private OSPCluster popUpdatedModel( List<OSPCluster> list, long groupId, long userId ){
		for( OSPCluster entry : list ){
			if( entry.getGroupId() == groupId && entry.getUserId() == userId ){
				updatedQueue.remove(entry);
				return entry;
			}
		}
		
		return null;
	}
	
	@Override
	public void onAfterAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		System.out.println("onAfterAddAssociation");
		super.onAfterAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterCreate(OSPCluster model) throws ModelListenerException {
		System.out.println("onAfterCreate");
		super.onAfterCreate(model);
		
		this.createdQueue.add(model);
	}

	@Override
	public void onAfterRemove(OSPCluster model) throws ModelListenerException {
		System.out.println("onAfterRemove");
		super.onAfterRemove(model);
		
		this.deletedQueue.add(model);
	}

	@Override
	public void onAfterRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		System.out.println("onAfterRemoveAssociation");
		super.onAfterRemoveAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onAfterUpdate(OSPCluster model) throws ModelListenerException {
		System.out.println("onAfterUpdate");
		super.onAfterUpdate(model);
		
		this.updatedQueue.add(model);
		System.out.println("Updated Count: "+this.updatedQueue.size());
	}

	@Override
	public void onBeforeAddAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		System.out.println("onBeforeAddAssociation");
		super.onBeforeAddAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onBeforeCreate(OSPCluster model) throws ModelListenerException {
		System.out.println("onBeforeCreate");
		super.onBeforeCreate(model);
	}

	@Override
	public void onBeforeRemove(OSPCluster model) throws ModelListenerException {
		System.out.println("onBeforeRemove");
		super.onBeforeRemove(model);
	}

	@Override
	public void onBeforeRemoveAssociation(Object classPK, String associationClassName, Object associationClassPK)
			throws ModelListenerException {
		System.out.println("onBeforeRemoveAssociation");
		super.onBeforeRemoveAssociation(classPK, associationClassName, associationClassPK);
	}

	@Override
	public void onBeforeUpdate(OSPCluster model) throws ModelListenerException {
		System.out.println("onBeforeUpdate");
		super.onBeforeUpdate(model);
	}
}
