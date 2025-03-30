package com.adazes.k8s.demo.be.util;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * App-wide pool of markers.
 *
 * @author  Resat SABIQ
 * @since   1.3.19
 */
public class MarkerPool {
    /**
     * For filtering logging messages with extra general utility.
     */
    public static final Marker GOOD_TO_KNOW = MarkerFactory.getMarker("GOOD_TO_KNOW");
}
