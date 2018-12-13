import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.lang.Integer;


public class Cipher {

    private String input;
    private String cipher;
    private String key;
    private String encodeDecode;
    private String codedDecodedMessage;


    public Cipher() {
        this.input = "";
        this.cipher = "";
        this.encodeDecode = "";
        this.key = "";
        this.codedDecodedMessage = "";
    }

    public Cipher(String input, String cipher, String encodeDecode) {
        this.input = input;
        this.cipher = cipher;
        this.encodeDecode = encodeDecode;
        this.key = "30";
        this.codedDecodedMessage = "";
    }

    public Cipher(String input, String cipher, String encodeDecode, String key) {
        this.input = input;
        this.cipher = cipher;
        this.encodeDecode = encodeDecode;
        this.key = key;
        this.codedDecodedMessage = "";

    }
  
    private ArrayList<Integer> convertToAscii(String data) {

        ArrayList<Integer> asciiConverted = new ArrayList<Integer>();
        char[] output = data.toCharArray();
        for (char letter : output) {
            asciiConverted.add((int) letter);
        }
        return asciiConverted;
    } 

    private void convertToLetters(List<Integer> input) {

        List<String> output = new ArrayList<>();
        String str = null;
        for (int number : input) {
            str = Character.toString((char)number);
            output.add(str);
        }
        String message = String.join("", output).replace("|", " ");
        this.codedDecodedMessage = message;
    }

    private String getKey() {
        return key;
    }

    private String getEncodeDecode() {
        return encodeDecode;
    }

    public String getCodedEncodedMessage() {
        return codedDecodedMessage;
    }

    private String getInput() {
        return input;
    }

    public void caesarEncryptDecrypt() {

        int shift = Integer.parseInt(getKey());
        ArrayList<Integer> forConversion = new ArrayList<Integer>();
        List<Integer> converted = new ArrayList<>();
        for (int number : convertToAscii(getInput())) {
            forConversion.add(number);
        }
        if (encodeDecode.equals("-e")) {
            for (int number : forConversion) {
                if (number + shift < 127) {
                    converted.add(number + shift);
                } else {
                    converted.add(number + shift - 95);
                }
            }
        } else {
            for (int number : forConversion) {
                if (number - shift > 32) {
                    converted.add(number - shift);
                } else {
                    converted.add(number - shift + 95);
                }
            }
        }
        convertToLetters(converted);
    }
}