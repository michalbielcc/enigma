import java.util.ArrayList;
import java.util.Arrays;


public class Porta {
    

    private String input;
    private String key;
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private ArrayList<String> shifted = new ArrayList<String>();
    private String encodedDecoded = "";
    private String[] indexIndicator = {"ab","cd","ef","gh","ij","kl","mn","op","qr","st","uv","wx","yz"};


    public Porta () {
    }

    public Porta (String input, String key) {
        this.input = input;
        String formatedKey = evenOutKeyToInput(key);
        this.key = formatedKey;
    }

    private String evenOutKeyToInput(String keyy) {
        String key = keyy;
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

    public Integer encodeDecode() {
        return alphabet.indexOf("e");
        
        
        
    }
}