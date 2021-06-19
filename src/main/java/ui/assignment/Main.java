package ui.assignment;

import ui.assignment.security.AsymmetricKeyGen;

import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {
        try {
            AsymmetricKeyGen akg = new AsymmetricKeyGen();
            akg.genkeyPairToFile("./rsa","./rsa.pub");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }
}
