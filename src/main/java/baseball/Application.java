package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class Application {

    private static final int NumberLength = 3;

    private static final String StartSymbol = "숫자 야구 게임을 시작합니다.";
    private static final String InputSymbol = "숫자를 입력해주세요 : ";
    private static final String EndSymbol = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
        + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static String computerNumber = "";
    private static String userNumber = "";

    private static int ballNum =0;
    private static int strikeNum =0;

    public static void getInput() {
        System.out.print(InputSymbol);
        userNumber = Console.readLine();
        inputValidation(userNumber);
        System.out.print(computerNumber);
        System.out.print(userNumber);
    }

    public static void printGetResult(int ballNum, int strikeNum) {

    }

    public static void calculateNum() {
        ballNum = 0;
        strikeNum =0;
        for (int i = 0; i < NumberLength; i++) {
            if (IsStrike(computerNumber.charAt(i) - '0', userNumber.charAt(i) - '0')) {
                addStrike();
                continue;
            }
            if (IsBall(computerNumber.charAt(i) - '0', userNumber)) {
                addBall();
            }
        }
    }

    public static void addBall() {
        ballNum++;
    }

    public static void addStrike() {
        strikeNum++;
    }

    public static void printOutput(int ballNum, int strikeNum) {
        if (ballNum > 0) {
            System.out.print(ballNum + "볼 ");
        }
        if (strikeNum > 0) {
            System.out.print(strikeNum + "스트라이크");
        }
        if (ballNum == 0 && strikeNum == 0) {
            System.out.print("낫씽");
        }
        System.out.println();
    }

    public static boolean IsBall(int computerOneNumber, String userNumber) {
        return userNumber.contains(Integer.toString(computerOneNumber));
    }

    public static boolean IsStrike(int computerOneNumber, int userOneNumber) {
        return computerOneNumber == userOneNumber;
    }

    public static boolean checkNumLength(String num) {
        return num.length() == NumberLength;
    }

    public static boolean checkNumFormat(String num) {
        try {
            Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean checkNumDuplication(String num) {
        HashSet<Integer> checkEqualHashSet = new HashSet<>();
        for (int i = 0; i < NumberLength; i++) {
            checkEqualHashSet.add(num.charAt(i) - '0');
        }
        return checkEqualHashSet.size() == NumberLength;
    }

    public static void inputValidation(String num) {
        if (!checkNumFormat(num) || !checkNumLength(num) || !checkNumDuplication(num)) {
            throw new IllegalArgumentException();
        }
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public static String getRandomDifferentNumber() {
        String number = "";
        HashSet<Integer> differentNumSet = new HashSet<>();
        for (int i = 0; i < NumberLength; i++) {
            int newNum = getRandomNumber();
            if (differentNumSet.contains(newNum)) {
                i--;
                continue;
            }
            differentNumSet.add(newNum);
            number += Integer.toString(newNum);
        }
        return number;
    }

    public static Boolean checkEndGame(int StrikeNum) {
        return StrikeNum == NumberLength;
    }
    public static void gameStart() {
        System.out.println(StartSymbol);
        computerNumber =getRandomDifferentNumber();

    }
    public static void printEndMsg(){
        System.out.println(EndSymbol);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
        while (!checkEndGame(strikeNum)) {
            getInput();
            calculateNum();
            printOutput(ballNum, strikeNum);
        }
        printEndMsg();
    }
}
