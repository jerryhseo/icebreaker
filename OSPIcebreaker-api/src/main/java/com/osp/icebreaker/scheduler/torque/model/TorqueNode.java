
package com.osp.icebreaker.scheduler.torque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * A node of a PBS cluster.
 *
 * @author Bruno P. Kinoshita
 * @since 0.1
 */
public class TorqueNode implements Serializable {

    private static final long serialVersionUID = 2980172720826485748L;

    private final String name;

    private final int numberOfProcessors;

    private final String nodeType;

    private final TorqueQueueState state;

    private final Map<String, String> status;

    private final List<String> properties;

    private final List<TorqueJob> jobs;

    /**
     * @param name node name
     * @param numberOfProcessors number of processors available in this node
     * @param nodeType node type
     * @param state current {@link TorqueQueue} state
     */
    public TorqueNode(String name, int numberOfProcessors, String nodeType, TorqueQueueState state) {
        super();
        this.name = name;
        this.numberOfProcessors = numberOfProcessors;
        this.nodeType = nodeType;
        this.state = state;
        this.status = new HashMap<String, String>();
        this.properties = new ArrayList<String>();
        this.jobs = new LinkedList<TorqueJob>();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the numberOfProcessors
     */
    public int getNumberOfProcessors() {
        return numberOfProcessors;
    }

    /**
     * @return the nodeType
     */
    public String getNodeType() {
        return nodeType;
    }

    /**
     * @return the state
     */
    public TorqueQueueState getState() {
        return state;
    }

    /**
     * @return the status
     */
    public Map<String, String> getStatus() {
        return status;
    }

    /**
     * @return the properties
     */
    public List<String> getProperties() {
        return properties;
    }

    /**
     * @return the jobs
     */
    public List<TorqueJob> getJobs() {
        return jobs;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
