package com.ivan.app.crypto;

/**
 *
 * @author ivan
 */
public interface IDifficulty {

    static IDifficulty difficultyCreate(Integer passwordLength) {
        if (passwordLength <= 5) {
            System.out.println("Complexitatea password - ului este scazuta,"
                    + " se v-a utiliza hash functie compusa.");
            return new com.ivan.app.crypto.MediumDifficulty();
        }

        System.out.println("Complexitatea password - ului este inalta,"
                + " se v-a utiliza hash functie mai slaba.");
        return new com.ivan.app.crypto.HardDifficulty();
    }

    HashFunction getHashFunction();

}
