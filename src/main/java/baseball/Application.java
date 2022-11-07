package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final int MIN = 100;
    private static final int MAX = 999;
    private static final Scanner stdinScanner = new Scanner(System.in);
    private static int answerNumber;

    private static int checkOneAnswerNumberWithTargetNumber(int answerOneNumber, int targetNumber, int answerIdx, int targetIdx) {
        int result = 0;
        System.out.println(answerOneNumber + " " + targetNumber);

        if (answerOneNumber == targetNumber) {
            result += 1;
        }

        if (answerOneNumber == targetNumber && answerIdx == targetIdx) {
            result += 1;
        }

        return result;
    }

    private static int checkEachNumber(int targetNumber, int targetIdx) {
        int result = 0;
        int processAnswerNumber = answerNumber;
        for (int i = 1; i <= 3; i++) {
            int answerOneNumber = processAnswerNumber/(Math.max(1, (int)Math.pow(10,3-i)));
            result += checkOneAnswerNumberWithTargetNumber(answerOneNumber, targetNumber, i, targetIdx);
            processAnswerNumber -= answerOneNumber * (int)Math.pow(10,3-i);
        }
        return result;
    }

    private static List<Integer> gameResult(int inputNumber) {
        ArrayList<Integer> resultList = new ArrayList<>();


    }

    private static boolean eachGame() {
        System.out.print("숫자를 입력해주세요 : ");
        int inputNumber = stdinScanner.nextInt();

        return false;
    }

    private static void baseballGameRun() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        answerNumber = (int) ((Math.random() * (MAX - MIN)) + MIN);
        System.out.println(answerNumber);
        System.out.println(checkEachNumber(4, 1));
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        baseballGameRun();
    }
}
