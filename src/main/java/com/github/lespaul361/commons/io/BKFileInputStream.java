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

    private final long size;
    private long bytesRead = 0;

    public BKFileInputStream(String name) throws FileNotFoundException {
        this(new File(name));
    }

    public BKFileInputStream(File file) throws FileNotFoundException {
        super(file);
        long tmp = -1;
        try {
            tmp = super.getChannel().size();
        } catch (Exception e) {
            tmp = -1;
        }
        this.size = tmp;
    }

    public BKFileInputStream(FileDescriptor fdObj) {
        super(fdObj);
        long tmp = -1;
        try {
            tmp = super.getChannel().size();
        } catch (Exception e) {
            tmp = -1;
        }
        this.size = tmp;
    }

    @Override
    public long size() {
        return this.size;
    }

    @Override
    public long getBytesRead() {
        return this.bytesRead;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int r = read(b, off, len);
        this.bytesRead += r;
        return r;
    }

    @Override
    public int read(byte[] b) throws IOException {
        int r = super.read();
        this.bytesRead += r;
        return r;
    }

    @Override
    public int read() throws IOException {
        int r = read();
        this.bytesRead += r;
        return r;
    }

}
