package com.sabel.IhrName;

/**
 * @author Ihr Name
 */
public class Main {
    public static void main(String[] args) {
        String ihrName = "Maier";
        System.out.println(ihrName + ", SHA-256-Hashwert: " + Util.hashFunction(ihrName));
    }
}
