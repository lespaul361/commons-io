/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.io;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author lespa
 */
public class BKFileInputStream extends FileInputStream implements BKStream {

    BKStreamImp streamImp = new BKStreamImp();
    
    public BKFileInputStream(String name) throws FileNotFoundException {
        super(new File(name));
    }
    
    public BKFileInputStream(File file) throws FileNotFoundException {
        super(file);
        this.streamImp.size = file.length();
    }
    
    public BKFileInputStream(FileDescriptor fdObj) {
        super(fdObj);
        try {
            this.streamImp.size = super.getChannel().size();
        } catch (Exception e) {
        }        
    }
    
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int r = super.read(b, off, len);
        this.streamImp.increaseByteRead(r);
        return r;
    }
    
    @Override
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }
    
    @Override
    public int read() throws IOException {
        int r = super.read();
        if (r > -1) {
            this.streamImp.increaseByteRead(1);
        }
        return r;        
    }

    @Override
    public long skip(long n) throws IOException {
        long s=super.skip(n);
        this.streamImp.increaseByteRead(s);
        return s;
    }
    
    @Override
    public long size() {
        return streamImp.size();
    }
    
    @Override
    public long getBytesRead() {
        return streamImp.getBytesRead();
    }
    
    @Override
    public void addBKStreamReadListener(BKStreamReadListener l) {
        streamImp.addBKStreamReadListener(l);
    }
    
    @Override
    public void removeBKStreamReadListener(BKStreamReadListener l) {
        streamImp.removeBKStreamReadListener(l);
    }
}
