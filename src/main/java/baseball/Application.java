package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
public class Application {

    private static final int finalRound = 3;
    private static final int numberLength = 3;
    private static int currentRound = 0;
    private static String StartSymbol = "숫자 야구 게임을 시작합니다.";
    private static String InputSymbol = "숫자를 입력해주세요 : ";
    private static String EndSymbol = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
        + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    private static ArrayList<ArrayList<Integer>> number = new ArrayList<ArrayList<Integer>>(3);

    public static int getInput() {
        System.out.println(StartSymbol);
        System.out.print(InputSymbol);
        String userInput = Console.readLine();
        if (!inputValidation(userInput))
            throw new IllegalArgumentException();
        return Integer.parseInt(userInput);
    }

    public static boolean inputValidation(String num){
        try {

        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public static void getRandomDifferentNumber() {
        ArrayList<Integer> currentRoundNum = new ArrayList<>();
        for (int i = 0; i < numberLength; i++) {
            int newNum = getRandomNumber();
            if (numberDuplication(newNum, i, currentRoundNum)) {
                i--;
                continue;
            }
            currentRoundNum.add(newNum);
        }
        number.add(currentRoundNum);
    }

    public static void gameInit() {
        for (int i = 0; i < finalRound; i++) {
            getRandomDifferentNumber();
            currentRound = currentRound + 1;
        }
        getInput();
    }

    public static boolean numberDuplication(int newNum, int numberIndex,
        ArrayList<Integer> number) {
        for (int i = 0; i < numberIndex; i++) {
            if (number.get(i) == newNum) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameInit();
        //System.out.println(number.get(0));
        // System.out.println(number.get(1));
        // System.out.println(number.get(2));

    }
}
