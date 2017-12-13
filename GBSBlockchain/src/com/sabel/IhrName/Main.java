package com.sabel.IhrName;

/**
 * @author Koenig Michael
 */
public class Main {
    public static void main(String[] args) {
        String ihrName = "König";
        System.out.println(ihrName + ", SHA-256-Hashwert: " + Util.hashFunction(ihrName));

        GBSBlockchain gbsBlockchain = new GBSBlockchain();
        gbsBlockchain.printData();

    }
}

