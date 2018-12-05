/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.io;

import javax.swing.event.EventListenerList;

/**
 *
 * @author lespa
 */
class BKStreamImp implements BKStream {

    protected long size;
    protected long bytesRead = 0;
    private EventListenerList events = new EventListenerList();

    public BKStreamImp() {

    }

    public BKStreamImp(long size) {
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
    }

    public void addBKStreamReadListener(BKStreamReadListener l) {
        events.add(BKStreamReadListener.class, l);
    }

    public void removeBKStreamReadListener(BKStreamReadListener l) {
        events.remove(BKStreamReadListener.class, l);
    }
}
