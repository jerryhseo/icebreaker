package com.osp.icebreaker.scheduler.torque.util;

/**
 * PBS Exception.
 *
 * @author Jerry H. Seo
 * @since 0.1
 */
public class TorqueException extends RuntimeException {

    private static final long serialVersionUID = -308538480475052665L;

    /**
     * Defaut constructor.
     */
    public TorqueException() {
    }

    /**
     * Constructor with message.
     *
     * @param message exception message
     */
    public TorqueException(String message) {
        super(message);
    }

    /**
     * Constructor with cause.
     *
     * @param cause exception cause
     */
    public TorqueException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor with message and cause.
     *
     * @param message exception message
     * @param cause exception cause
     */
    public TorqueException(String message, Throwable cause) {
        super(message, cause);
    }

}
