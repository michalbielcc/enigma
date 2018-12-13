import java.util.ArrayList;
import java.util.Arrays;


public class Porta {
    

    private String input;
    private String key;
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private String zeroPosition = "nopqrstuvwxyzabcdefghijklm";
    private String encodedDecoded = "";
    private String[] indexIndicator = {"ab","cd","ef","gh","ij","kl","mn","op","qr","st","uv","wx","yz"};


    public Porta () {
    }

    public Porta (String input, String key) {
        this.input = input;
        String formatedKey = evenOutKeyToInput(key);
        this.key = formatedKey;
    }

    private String evenOutKeyToInput(String input) {
        String key = input;
        ArrayList<String> actualKey = new ArrayList<>();
        if (input.length() == key.length()){
            for (String letter : key.split("")) {
                actualKey.add(letter);
            }
        } else if (input.length() > key.length()) {
            while (input.length() > actualKey.size()) {
                for (String letter : key.split("")) {
                    actualKey.add(letter);
                }
                System.out.println(actualKey.size());
            }
            while (input.length() < actualKey.size()) {
                actualKey.remove(actualKey.size());
        } System.out.println(actualKey.size());
        } else {
            ArrayList<String> tempo = new ArrayList<>();
            for (String letter : key.split("")) {
                tempo.add(letter);
            }            
            for (int index = 0; index < input.length(); index++) {
                actualKey.add(tempo.get(index));
            }
        }             
        return String.join("", actualKey);
    }

    public String getOutput() {
        return input;
    }

    public String getKey() {
        return key;
    }

  /*   private int keyConstructor(int index) {
        ArrayList<String> pairs = new ArrayList<>();
        for (String element: indexIndicator) {
            pairs.add(element);
        }
        for (String element : pairs) {
            for (String letter : element.split("")) {
                if (input.charAt(index) == (letter)) {
                    return element.indexOf(element);
                }
            }
        }
        

    }

   public Integer encodeDecode() {

        for (int index = 0; index < input.length(); index++) {
            if (input.charAt(index) )
            (key.charAt(index));
        }


        input.charAt(index);
        return alphabet.indexOf("e");
    } */
}