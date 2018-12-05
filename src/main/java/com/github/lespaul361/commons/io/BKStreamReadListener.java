/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.io;

import java.util.EventListener;

/**
 *
 * @author lespa
 */
public interface BKStreamReadListener extends EventListener{
    public void bytesRead(BKStreamReadEvent evt);
}
