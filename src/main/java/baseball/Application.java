package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    private static final int threeDigits = 999;

    public static void main(String[] args) throws IOException {

    }

    public static boolean checkNumber (int test) {

        if(test > threeDigits) {
            return false;
        }
        return true;
    }
}
