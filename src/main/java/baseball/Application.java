package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            playGame();
            if (finishApp()) {
                break;
            }
        }
    }

    public static void playGame() {
        List<Integer> computerNumber = generateNumber();
        while (true) {
            List<Integer> guessNumber = getGuessNumber();
            boolean isAllStrike = checkNumber(guessNumber);
            if (isAllStrike) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
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
        List<Integer> numberList = stringToIntegerList(tmpStr);

        validateNumber(numberList);
        // 유효성 검사 해야함

        return numberList;
    }

    public static List<Integer> stringToIntegerList(String tmpStr) {
        String[] tmpStrArr = tmpStr.split("");
        List<Integer> tmpList = new ArrayList<>();
        for (int i = 0; i < tmpStrArr.length; i++) {
            int tmp = Integer.parseInt(tmpStrArr[i]);
            tmpList.add(tmp);
        }
        return tmpList;
    }

    public static boolean validateNumber(List<Integer> inputNumber) {
        // list 사이즈는 3
        // 1~9 까지
        // 중복 없어야 함.
        return true;
    }

    public static boolean checkNumber(List<Integer> inputNumber) {
        return true;
    }

    public static boolean finishApp() {
        return true;
    }
}
