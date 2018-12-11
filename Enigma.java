import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.lang.Integer;


class Enigma {


    private static ArrayList<Integer> convertToAscii(String data) {

        ArrayList<Integer> asciiConverted = new ArrayList<Integer>();
        char[] output = data.toCharArray();
        for (char letter : output) {
            asciiConverted.add((int) letter);
        }
        return asciiConverted;
    } 


    private static String convertToLetters(List<Integer> input) {

        List<String> output = new ArrayList<>();
        String str = null;
        for (int number : input) {
            str = Character.toString((char)number);
            output.add(str);
        }
        String message = String.join("", output);
        System.out.println(input);
        return message;
    }


    private static String caesarEncryptDecrypt(String toShift, String encodeDecode) {

        int shift = Integer.parseInt(toShift);
        if (shift > 20 || shift < 1) {
            System.out.println("Keep step between 1 and 20");
            System.exit(0);
        }
        ArrayList<Integer> forConversion = new ArrayList<Integer>();
        List<Integer> converted = new ArrayList<>();
        for (int number : convertToAscii(getInput("Type something: "))) {
            forConversion.add(number);
        }
        System.out.println(forConversion);
        if (encodeDecode.equals("-e")) {
            for (int number : forConversion) {
                if (number < 107) {
                    converted.add(number + shift);
                } else {
                    converted.add(number + shift - 95);
                }
            }
        } else {
            for (int number : forConversion) {
                if (number > 21) {
                    converted.add(number - shift);
                } else {
                    converted.add(number - shift + 95);
                }
            }
        }
        return convertToLetters(converted);
    }

    
    private static String getInput(String message) {

        Scanner reader = new Scanner(System.in); 
        System.out.print(message);
        String choice = reader.nextLine();
        return choice;
      }


    public static void main(String[] args) throws IOException {

        ArrayList<String> data = new ArrayList<String>();
        for (String element : args) {
            data.add(element);
        }
        data.add("1");
        if (data.get(0).equals("-l")) {
            System.out.println("Aviable ciphers: Caesar, donKnowYet");
            System.exit(0);
        } else if (data.get(0).equals("-h")) {
            System.out.println("For program to work type:\n\n'java Enigma [parameter] [cipher] [key]' where key is optional.\n\nParameters: '-e' to encode your message, '-d' to decode it.\n\nFor list of cyphers type 'java Enigma -l'.");
            System.exit(0);         
        } else if (data.get(1).equals("caesar")) {
            System.out.println(caesarEncryptDecrypt(data.get(2), data.get(0)));
        } else if (data.get(1).equals("dontKnowYet")) {
            //dontKnowYet();
        }
        else {
            System.out.println("Invalid program parameters, try again. \nFor help type: 'java Enigma -h'");
        }
    }   
}