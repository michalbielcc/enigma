import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.lang.Integer;


public class Enigma{


    public static String getInputs(String message) {

        boolean validator = true;
        List<String> output = new ArrayList<String>();
        while (validator == true) {
            validator = false;
            String input = getInput(message);
            if (input.isEmpty() != true) {
                output.add(input);
                validator = true;
            }
            if (output.isEmpty() == true) {
                System.out.println("Cannot encode empty input");
                System.exit(0);
            }           
        }
        String str = String.join("|", output);
        return str;
    }

    
    public static String getInput(String message) {

        Scanner reader = new Scanner(System.in); 
        System.out.print(message);
        String choice = reader.nextLine();
        return choice;
    }

    public static  String filterInputs(String input) {
        return input.toLowerCase().replaceAll("[^a-z]", "");
    }
    

    public static void main(String[] args) {

        ArrayList<String> data = new ArrayList<String>();
        for (String element : args) {
            data.add(element);
        }
        try {
            if (data.get(0).equals("-l")) {
                System.out.println("Aviable ciphers: Caesar, donKnowYet");
                System.exit(0);
            } else if (data.get(0).equals("-h")) {
                System.out.println("For program to work type:\n\n'java Enigma [parameter] [cipher] [key]' where key is optional.\n\nParameters: '-e' to encode your message, '-d' to decode it.\n\nFor list of cyphers type 'java Enigma -l'.");
                System.exit(0);         
            } else if (data.get(1).equals("caesar") && data.size() > 3) {
                Cipher cipher = new Cipher(getInputs("Type your input (hit [enter] to finish): "), data.get(0), data.get(2));
                cipher.caesarEncryptDecrypt();
                System.out.println(cipher.getCodedEncodedMessage());
            } else if (data.get(1).equals("caesar")) {
                Cipher cipher = new Cipher(getInputs("Type your input (hit [enter] to finish): "), data.get(0));
                cipher.caesarEncryptDecrypt();
                System.out.println(cipher.getCodedEncodedMessage());
            } else if (data.get(1).equals("porta")) {
                //System.out.println(filterInputs(getInputs()));
                Porta cipher1 = new Porta(filterInputs(getInputs("Type your input (hit [enter] to finish): ")), filterInputs(getInputs("Type your Key here [enter to finish] : ")));
                System.out.println(cipher1.getKey());
                System.out.println(cipher1.encodeDecode());
            }
            else {
                System.out.println("Invalid program parameters, try again. \nFor help type: 'java Enigma -h'");
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Invalid (or lacking) program parameters, try again. \nFor help type: 'java Enigma -h'");
        }
    }   
}