package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.View.*;

public class Application {
    public static void main(String[] args) {
        printStartMsg();
        playGame();
    }

    private static String getRandomNumber(){
        List<String> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(String.valueOf(randomNumber));
            }
        }
        return String.join("",computer);
    }

    public static void playGame(){
        printInputMsg();
        String computer = getRandomNumber();
        String userInput = Console.readLine();
    }
}
