
package com.osp.icebreaker.scheduler.torque.model;

/**
 * Queue state. Valid values are:
 * <ul>
 * <li>free</li>
 * <li>offline</li>
 * <li>down</li>
 * <li>reserve</li>
 * <li>job-exclusive</li>
 * <li>job-sharing</li>
 * <li>busy</li>
 * <li>time-shared</li>
 * <li>state-unknown</li>
 * <li>unknown</li>
 * </ul>
 *
 * @author Bruno P. Kinoshita
 * @see TorqueQueue
 * @since 0.1
 */
public enum TorqueQueueState {

    FREE("free"), OFFLINE("offline"), DOWN("down"), RESERVE("reserve"), JOB_EXCLUSIVE("job-exclusive"), JOB_SHARING(
            "job-sharing"), BUSY("busy"), TIME_SHARED("time-shared"), STATE_UNKNOWN("state-unknown"), UNKNOWN(
                    "unknown");

    private final String state;

    TorqueQueueState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public static TorqueQueueState fromString(String state) {
        if ( "free".equalsIgnoreCase(state) )
            return FREE;
        if ( "down".equalsIgnoreCase(state) )
            return DOWN;
        return UNKNOWN;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return this.state;
    }

}
