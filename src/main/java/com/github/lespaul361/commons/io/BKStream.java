/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.io;

/**
 *
 * @author lespa
 */
public interface BKStream {

    public long size();

    public long getBytesRead();
    
    public void addBKStreamReadListener(BKStreamReadListener l);

    public void removeBKStreamReadListener(BKStreamReadListener l);
}
