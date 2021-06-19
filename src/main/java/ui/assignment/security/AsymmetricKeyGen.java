package ui.assignment.security;

import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

public class AsymmetricKeyGen {
    KeyPairGenerator keyGen = null;
    String KEY_ALGORITHM_RSA = "RSA";

    public AsymmetricKeyGen() throws NoSuchAlgorithmException {
        keyGen = KeyPairGenerator.getInstance(KEY_ALGORITHM_RSA);
    }

    public void genkeyPairToFile(String privateKey, String publicKey) {
        KeyPair pair = keyGen.generateKeyPair();
        RSAPrivateKey priv = (RSAPrivateKey) pair.getPrivate();
        RSAPublicKey pub =  (RSAPublicKey)pair.getPublic();
        try {
            FileWriter privateKeyFile = new FileWriter(privateKey);
            privateKeyFile.write(Base64.getEncoder().encodeToString(priv.getEncoded()));
            privateKeyFile.close();
            FileWriter publicKeyFile = new FileWriter(publicKey);
            publicKeyFile.write(Base64.getEncoder().encodeToString(pub.getEncoded()));
            publicKeyFile.close();
        } catch (IOException e) {
            System.out.println("An error occurred when generating private/public keys");
            e.printStackTrace();
        }
    }
}
