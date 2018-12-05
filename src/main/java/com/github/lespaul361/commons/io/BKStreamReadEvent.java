/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.io;

import java.util.EventObject;

/**
 *
 * @author lespa
 */
public class BKStreamReadEvent extends EventObject {

    private final long streamSize;
    private final long currentLocation;

    public BKStreamReadEvent(Object source, long streamSize, long currentLocation) {
        super(source);
        this.streamSize = streamSize;
        this.currentLocation = currentLocation;
    }

    /**
     * @return the streamSize
     */
    public long getStreamSize() {
        return streamSize;
    }

    /**
     * @return the currentLocation
     */
    public long getCurrentLocation() {
        return currentLocation;
    }

}
