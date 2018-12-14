import java.util.ArrayList;
import java.util.Arrays;


public class Porta {
    

    private String input;
    private String key;
    private String encodedDecoded = "";


    public Porta () {
    }

    public Porta (String input, String key) {
        this.input = input;
        String formatedKey = evenOutKeyToInput(key);
        this.key = formatedKey;
    }

    private String evenOutKeyToInput(String key1) {
        String key = key1;
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
            }
            while (input.length() < actualKey.size()) {
                actualKey.remove(actualKey.size()- 1);
        } 
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

    public String getCodedDecodedMessage() {
        return encodedDecoded;
    }
    
    private Integer getCodeKeyIdIndex(String letter) {
        String[] codeKeysIdList = {"ab","cd","ef","gh","ij","kl","mn","op","qr","st","uv","wx","yz"};
        Integer output = 0;
        for (String element : codeKeysIdList) {
            if (element.contains(letter)) {
                return output;
            }
            output ++;
        }       
        return output;
    }

    public void encodeDecode() {
        ArrayList<String> output = new ArrayList<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<String> codeKeys = new ArrayList<>();
        codeKeys.add("nopqrstuvwxyzabcdefghijklm");
        codeKeys.add("opqrstuvwxyznmabcdefghijkl");
        codeKeys.add("pqrstuvwxyznolmabcdefghijk");
        codeKeys.add("qrstuvwxyznopklmabcdefghij");
        codeKeys.add("rstuvwxyznopqjklmabcdefghi");
        codeKeys.add("stuvwxyznopqrijklmabcdefgh");
        codeKeys.add("tuvwxyznopqrshijklmabcdefg");
        codeKeys.add("uvwxyznopqrstghijklmabcdef");
        codeKeys.add("vwxyznopqrstufghijklmabcde");
        codeKeys.add("wxyznopqrstuvefghijklmabcd");
        codeKeys.add("xyznopqrstuvwdefghijklmabc");
        codeKeys.add("yznopqrstuvwxcdefghijklmab");
        codeKeys.add("znopqrstuvwxybcdefghijklma");
        for (int index = 0; index < input.length(); index++) {
            String temp = codeKeys.get(getCodeKeyIdIndex(Character.toString(key.charAt(index))));
            int tempIndex = temp.indexOf(input.charAt(index));
            output.add(Character.toString(alphabet.charAt(tempIndex))); 
        }
        this.encodedDecoded = String.join("", output);
    }
        
    
}