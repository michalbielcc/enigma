import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


class Enigma {


    private static ArrayList<String> readData(String[] input) {

        ArrayList<String> data = new ArrayList<String>();
        Collections.addAll(data, input);
        if (data.size() == 0) {
            System.out.println("Missing input/parameter, try again");
            System.exit(0);
        }
        return data;
    }


    private static ArrayList<String> getParameters(ArrayList<String> data) {

        ArrayList<String> parameters = new ArrayList<String>(data.subList(1, 3));
        return parameters;
    }


    private static String toCipher(ArrayList<String> data) {

        return data.get(0);
    }


    public static void main(String[] args) throws IOException {

        readData(args);
        System.out.println(getParameters(readData(args)));
        System.out.println(toCipher(readData(args)));
    }
    
}