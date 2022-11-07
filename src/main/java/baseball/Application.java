package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

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
            int answerOneNumber = processAnswerNumber / (Math.max(1, (int) Math.pow(10, 3 - i)));
            result += checkOneAnswerNumberWithTargetNumber(answerOneNumber, targetNumber, i, targetIdx);
            processAnswerNumber -= answerOneNumber * (int) Math.pow(10, 3 - i);
        }
        return result;
    }

    private static List<Integer> gameResult(int inputNumber) {
        ArrayList<Integer> resultList = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            int inputOneNumber = inputNumber / (Math.max(1, (int) Math.pow(10, 3 - i)));
            int result = checkEachNumber(inputOneNumber, i);
            resultList.add(result);
            inputNumber -= inputOneNumber * (int) Math.pow(10, 3 - i);
        }

        return resultList;
    }

    private static boolean eachGame() {
        System.out.print("숫자를 입력해주세요 : ");
        int inputNumber = stdinScanner.nextInt();

        return false;
    }

    private static int getAnswerOneNumber(List<Integer> numberList) {
        int generatedNumber = (int) ((Math.random() * 9) + 1);
        while (numberList.contains(generatedNumber)) {
            generatedNumber = (int) ((Math.random() * 9) + 1);
        }
        return generatedNumber;
    }

    private static void generateAnswerNumber() {
        answerNumber = 0;
        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numberList.add(getAnswerOneNumber(numberList));
        }

        for (int i = 0; i < 3; i++) {
            answerNumber += numberList.get(i) * Math.max(1, Math.pow(10, 2 - i));
        }
    }

    private static void baseballGameRun() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        generateAnswerNumber();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        baseballGameRun();
    }
}
