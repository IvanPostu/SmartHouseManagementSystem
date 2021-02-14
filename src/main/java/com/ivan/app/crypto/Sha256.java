
package com.ivan.app.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author ivan
 */
public class Sha256 implements HashFunction {

    public Sha256(){}
    
    @Override
    public String hashFunctionName() {
        return "SHA-256";
    }

    @Override
    public byte[] encode(byte[] plainText) {
        try {
            final String hashFunctionName = hashFunctionName();
            final MessageDigest digest = MessageDigest
                    .getInstance(hashFunctionName);
            byte[] encodedHash = digest.digest(plainText);

            return encodedHash;
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

}
