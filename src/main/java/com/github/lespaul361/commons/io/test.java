/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.lespaul361.commons.io;

import java.io.File;

/**
 *
 * @author lespa
 */
public class test {
    public static void main(String[] args) {
        String path="D:\\Users\\lespa\\Documents\\Adobe\\PhotoshopPrefsManager-20170226-164538.log1";
        try {
            BKFileInputStream s=new BKFileInputStream(new File(path));
            int r=s.read();
            long sz=s.size();
            long rd=s.getBytesRead();
            int i=0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        
    }
}
