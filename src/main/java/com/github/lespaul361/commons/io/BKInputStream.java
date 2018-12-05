/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import javax.swing.event.EventListenerList;

/**
 *
 * @author lespa
 */
public abstract class BKInputStream extends InputStream implements BKStreamInput {

    private long size;
    private long bytesRead = 0;
    private EventListenerList events = new EventListenerList();

    @Override
    public synchronized void reset() throws IOException {
        super.reset(); //To change body of generated methods, choose Tools | Templates.
    }

    protected void setStreamSize(long streamSize) {
        this.size = streamSize;
    }

    @Override
    public long skip(long n) throws IOException {
        long s = super.skip(n);
        this.bytesRead += s;
        return s;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int r = super.read(b, off, len);
        this.bytesRead += r;
        return r;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int read(byte[] b) throws IOException {
        int r = super.read(b);
        this.bytesRead += r;
        return r;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public abstract int read() throws IOException;

    protected void increaseBytesRead(long byteCount) {
        this.bytesRead += byteCount;
    }

    public void addBKStreamListener(BKStreamListener l) {
        events.add(BKStreamListener.class, l);
    }

    public void removeBKStreamListener(BKStreamListener l) {
        events.remove(BKStreamListener.class, l);
    }

    @Override
    public long size() {
        return this.size;
    }

    @Override
    public long getBytesRead() {
        return this.bytesRead;
    }

    protected void fireStreamRead() {
        BKStreamEvent evt = new BKStreamEvent(this, this.size, this.getBytesRead());
        List<BKStreamListener> listeners = Arrays.asList(events.getListeners(BKStreamListener.class));
        for (BKStreamListener l : listeners) {
            l.bytesRead(evt);
        }
    }
}
