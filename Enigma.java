import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


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

        if (args.length < 3) {
            System.out.println("Missing program parameters, try again. \nFor help type: 'java Enigma -h'");
            System.exit(0);
        }
        String encodeDecode = args[0];
        String cipherType = args[1].toLowerCase();
        String messageToCode = args[2];
        if (encodeDecode.equals("-l")) {
            System.out.println("Aviable ciphers: Caesar, Porta\nCaesar cypher takes shift parameter (number between 1 and 50)\nPorta cipher takes argument in form of string\nThis string will be striped of everything except letters");
            System.exit(0);
        } else if (encodeDecode.equals("-h")) {
            System.out.println("For program to work type:\n\n'java Enigma [parameter] [cipher] [key]' where key is optional.\n\nParameters: '-e' to encode your message, '-d' to decode it.\n\nFor list of cyphers type 'java Enigma -l'.");
            System.exit(0);         
        } else if (cipherType.equals("caesar")) {
            try {
                int foo = Integer.parseInt(args[2]);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid parameter for Caesar cypher.\nType java Enigma -h");
                System.exit(0);
            }
            Caesar cipher = new Caesar(getInputs("Type your input (hit [enter] to finish): "), encodeDecode, messageToCode);
            cipher.EncryptDecrypt();
            System.out.println(cipher.getCodedDecodedMessage());
            System.exit(0);
        } else if (cipherType.equals("porta")) {
            if (args[2].replaceAll("[^a-z]", "").length() < 1) {
                System.out.println("Everything from encryption key was filtered out.\nMake sure to use letters.");
                System.exit(0);
            }
            Porta cipher = new Porta(filterInputs(getInputs("Type your input (hit [enter] to finish): ")), filterInputs(args[2]));
            cipher.EncryptDecrypt();
            System.out.println(cipher.getCodedDecodedMessage());
            System.exit(0);
        }        
    }   
}