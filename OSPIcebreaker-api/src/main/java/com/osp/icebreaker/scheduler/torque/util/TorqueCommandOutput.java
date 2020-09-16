package com.osp.icebreaker.scheduler.torque.util;

/**
 * Output of a command.
 *
 * @author Jerry H. Seo
 */
public final class TorqueCommandOutput {

    private final String output;
    private final String error;

    public TorqueCommandOutput(String output, String error) {
        super();
        this.output = output;
        this.error = error;
    }

    public String getOutput() {
        return output;
    }

    public String getError() {
        return error;
    }

    @Override
    public String toString() {
        return "CommandOutput [output=" + output + ", error=" + error + "]";
    }

}
