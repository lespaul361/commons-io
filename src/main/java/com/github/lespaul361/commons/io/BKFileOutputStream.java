/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.io;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author lespa
 */
public class BKFileOutputStream extends FileOutputStream implements BKStreamOutput{
    BKStreamOutImp outputImp = new BKStreamOutImp();

    public BKFileOutputStream(String name) throws FileNotFoundException {
        super(name);
    }

    public BKFileOutputStream(String name, boolean append) throws FileNotFoundException {
        super(name, append);
    }

    public BKFileOutputStream(File file) throws FileNotFoundException {
        super(file);
    }

    public BKFileOutputStream(File file, boolean append) throws FileNotFoundException {
        super(file, append);
    }

    public BKFileOutputStream(FileDescriptor fdObj) {
        super(fdObj);
    }

    public long size() {
        return outputImp.size();
    }

    public long getBytesWritten() {
        return outputImp.getBytesWritten();
    }

    protected void increaseByteRead(long bytesRead) {
        outputImp.increaseByteRead(bytesRead);
    }

    public void addBKStreamListener(BKStreamListener l) {
        outputImp.addBKStreamListener(l);
    }

    public void removeBKStreamListener(BKStreamListener l) {
        outputImp.removeBKStreamListener(l);
    }

    protected void fireStreamChange() {
        outputImp.fireStreamChange();
    }
    
}
