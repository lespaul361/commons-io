/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.io;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author lespa
 */
public abstract class BKOutputStream extends OutputStream implements BKStreamOutput{
    BKStreamOutImp streamImp=new BKStreamOutImp();

    public BKOutputStream() {
    }

    public long size() {
        return streamImp.size();
    }

    public long getBytesWritten() {
        return streamImp.getBytesWritten();
    }

    protected void increaseByteRead(long bytesRead) {
        streamImp.increaseByteRead(bytesRead);
    }

    public void addBKStreamListener(BKStreamListener l) {
        streamImp.addBKStreamListener(l);
    }

    public void removeBKStreamListener(BKStreamListener l) {
        streamImp.removeBKStreamListener(l);
    }

    protected void fireStreamChange() {
        streamImp.fireStreamChange();
    }

   
    
}
