package com.osp.icebreaker.scheduler.torque.util;

import java.util.Vector;

/**
 * Utils class.
 *
 * @author Jerry H. Seo
 * @since 0.1
 */
public final class TorqueUtils {

    /**
     * Hidden constructor of the utility class.
     */
    private TorqueUtils() {
    };

    /**
     * Split the source into two strings at the first occurrence of the splitter Subsequent occurrences are not treated
     * specially, and may be part of the second string.
     *
     * @author Jerry H. Seo
     * @param source The string to split
     * @param splitter The string that forms the boundary between the two strings returned.
     * @return An array of two strings split from source by splitter.
     */
    public static String[] splitFirst(String source, String splitter) {
        // hold the results as we find them
        Vector<String> rv = new Vector<String>();
        int last = 0;
        int next = 0;

        // find first splitter in source
        next = source.indexOf(splitter, last);
        if (next != -1) {
            // isolate from last thru before next
            rv.add(source.substring(last, next));
            last = next + splitter.length();
        }

        if (last < source.length()) {
            rv.add(source.substring(last, source.length()));
        }

        // convert to array
        return rv.toArray(new String[rv.size()]);
    }
}
