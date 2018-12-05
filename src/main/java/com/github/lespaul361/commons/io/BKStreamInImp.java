/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.io;

import java.util.Arrays;
import java.util.List;
import javax.swing.event.EventListenerList;

/**
 *
 * @author lespa
 */
class BKStreamInImp implements BKStreamInput {

    protected long size;
    protected long bytesRead = 0;
    private EventListenerList events = new EventListenerList();

    public BKStreamInImp() {

    }

    public BKStreamInImp(long size) {
        this.size = size;
    }

    @Override
    public long size() {
        return this.size;
    }

    @Override
    public long getBytesRead() {
        return this.bytesRead;
    }

    protected void increaseByteRead(long bytesRead) {
        this.bytesRead += bytesRead;
        fireStreamChange();
    }

    public void addBKStreamListener(BKStreamListener l) {
        events.add(BKStreamListener.class, l);
    }

    public void removeBKStreamListener(BKStreamListener l) {
        events.remove(BKStreamListener.class, l);
    }

    protected void fireStreamChange() {
        BKStreamEvent evt = new BKStreamEvent(this, size, bytesRead);
        List<BKStreamListener> listeners = Arrays.asList(events.getListeners(BKStreamListener.class));
        for (BKStreamListener listener : listeners) {
            listener.bytesRead(evt);
        }

    }
}
