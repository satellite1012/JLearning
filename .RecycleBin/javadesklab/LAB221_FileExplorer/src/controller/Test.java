/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;

/**
 *
 * @author megafyk
 */
public class Test {
    public static void main(String[] args) {
        File[] drivers = File.listRoots();
        for(File f: drivers){
            System.out.println(f);
        }
    }
}
