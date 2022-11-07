package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.lang.reflect.Array;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class Application {

    private static final int finalRound = 3;
    private static final int numberLength = 3;
    private static int currentRound = 0;
    private static String StartSymbol = "숫자 야구 게임을 시작합니다.";
    private static String InputSymbol = "숫자를 입력해주세요 : ";
    private static String EndSymbol = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
        + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    private static ArrayList<Integer> computerNumber = new ArrayList<>();
    private static ArrayList<Integer> userNumber = new ArrayList<>();

    public static void storeUserNumberArrayList(String num) {
        for (int i = 0; i < numberLength; i++) {
            userNumber.add(num.charAt(i) - '0');
        }
    }

    public static void getInput() {
        System.out.println(StartSymbol);
        System.out.print(InputSymbol);
        String userInput = Console.readLine();
        storeUserNumberArrayList(userInput);
        inputValidation(userInput);
    }


    public static boolean checkNumLength(String num) {
        return num.length() == 3;
    }

    public static boolean checkNumFormat(String num) {
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void inputValidation(String num) {
        if (!checkNumFormat(num) || !checkNumLength(num) || isNumDuplicate(userNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public static void getRandomDifferentNumber() {
        for (int i = 0; i < numberLength; i++) {
            int newNum = getRandomNumber();
            computerNumber.add(newNum);
            if (isNumDuplicate(computerNumber)) {
                computerNumber.remove(i);
                i--;
                continue;
            }
        }
    }

    public static void gameInit() {
        getRandomDifferentNumber();
        getInput();
    }

    public static boolean isNumDuplicate(ArrayList<Integer> numberList ){
        Set<Integer> numberSet = new HashSet<>();
        for (int i =  0 ; i< numberList.size() ; i++)
            numberSet.add(numberList.get(i));
        return numberSet.size() != numberList.size();
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameInit();
        //System.out.println(number.get(0));
        // System.out.println(number.get(1));
        // System.out.println(number.get(2));

    }
}
