import java.io.IOException;
import java.util.ArrayList;


class Enigma {

    private static ArrayList<String> readData(String[] args) {

        ArrayList<String> data = new ArrayList<String>();
        for (String argument : args) {
            data.add(argument);
        }
        return data;
    }


    public static void main(String[] args) throws IOException {

        System.out.println(readData(args));
    }
    
}