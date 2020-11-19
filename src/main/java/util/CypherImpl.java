/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import abstractions.Cypher;

/**
 *
 * @author roland
 */
public class CypherImpl implements Cypher {

    @Override
    public byte[] decrypt(byte[] input) {
        return input;
    }

    @Override
    public byte[] encrypt(byte[] input) {
        return input;
    }
    
}
