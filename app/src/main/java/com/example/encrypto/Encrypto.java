package com.example.encrypto;

public class Encrypto {
    //Constants
    private final char[] alphabet1 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private final char[] alphabet2 = {'A', 'B', 'C', 'Ç','D', 'E', 'F', 'G', 'Ğ', 'H', 'I', 'İ','J', 'K', 'L', 'M',
            'N', 'O', 'Ö','P', 'R','S', 'Ş', 'T', 'U', 'Ü','V', 'Y', 'Z', 'a', 'b', 'c', 'ç','d', 'e',
            'f', 'g', 'ğ','h', 'ı','i', 'j', 'k', 'l', 'm', 'n', 'o', 'ö','p', 'r', 's', 'ş', 't', 'u', 'ü', 'v', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    //Properties
    char[] alphabet;


    //Methods
    public char[] getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(char[] alphabet) {
        this.alphabet = alphabet;
    }

    private int getNumValue ( char ch) {
        for (int i = 0; i < alphabet.length; i++) {
            if ( alphabet[i] == ch)
                return i;
        }
        return -1;
    }

    private char getCharValue ( int i) {
        return alphabet[i];
    }

    public String encrypt (String msg, int key){
        String output = "";
         for ( int i = 0; i < msg.length(); i++) {
            char ch = msg.charAt(i);
            int temp = getNumValue( msg.charAt(i));
            if ( temp != -1) {
                int temp2 = temp + key;
                temp2 = temp2 % alphabet.length;
                ch = getCharValue(temp2);
            }
            output += ch;
         }
         return output;
    }

    public String decrypt ( String msg, int key) {
        String output = "";
        for ( int i = 0; i < msg.length(); i++) {
            char ch = msg.charAt(i);
            int temp = getNumValue( msg.charAt(i));
            if ( temp != -1) {
                int temp2 = temp - key;
                if (temp2 < 0)
                    temp2 += alphabet.length;
                ch = getCharValue(temp2);
            }
            output += ch;
        }
        return output;
    }

}
