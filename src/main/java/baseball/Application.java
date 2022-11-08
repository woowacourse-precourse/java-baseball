package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int threeDigits = 999;

    public static void main(String[] args) throws IOException {

        String numbers = Console.readLine();

    }

    public static boolean checkNumber (int test) {

        if(test > threeDigits) {
            return false;
        }
        return true;
    }
}
