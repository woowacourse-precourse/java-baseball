package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computerNumber = Utils.pickComputerNumber();

        String line = Console.readLine();
        List<Integer> userNumber = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            userNumber.add(Character.getNumericValue(line.charAt(i)));
        }


    }
}
