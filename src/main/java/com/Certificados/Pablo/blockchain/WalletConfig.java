package com.Certificados.Pablo.blockchain;


import org.web3j.crypto.Credentials;

public class WalletConfig {

    private static final String PRIVATE_KEY =
            "0xf3dfbedf113cfc90de630b3ec6ae6f536fffd2a3d951f80fe5a39b3b2e6fa216";

    public static Credentials getCredentials() {

        return Credentials.create(PRIVATE_KEY);
    }
}