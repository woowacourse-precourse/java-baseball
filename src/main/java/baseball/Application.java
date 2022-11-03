package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        playGame();
    }

    public static void playGame() {
        List<Integer> computer = generateNumber();
        getGuessNumber();

    }

    public static List<Integer> generateNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> getGuessNumber() {
        String tmpStr = Console.readLine();
        return stringToList(tmpStr);
    }

    public static List<Integer> stringToList(String tmpStr) {
        String[] tmpStrArr
        List<Integer> tmpList = new ArrayList<>();

        tmpList.add();
        return tmpList;
    }

    public static boolean validateNumber() {

        return true;
    }


}
