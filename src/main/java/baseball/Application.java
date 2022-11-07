package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static int answerNumber;

    private static int checkOneAnswerNumberWithTargetNumber(int answerOneNumber, int targetNumber, int answerIdx, int targetIdx) {
        int result = 0;

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
        int strike = 0;
        int ball = 0;

        System.out.print("숫자를 입력해주세요 : ");
        int inputNumber = Integer.parseInt(Console.readLine());
        List<Integer> score = gameResult(inputNumber);

        for (Integer eachScore : score) {
            if (eachScore == 1) {
                ball += 1;
            } else if (eachScore == 2) {
                strike += 1;
            }
        }

        StringBuilder resultString = new StringBuilder();
        if (ball > 0){
            resultString.append(ball).append("볼");
        }
        if (resultString.length() > 0){
            resultString.append(" ");
        }
        if (strike > 0){
            resultString.append(strike).append("스트라이크");
        }

        if ((ball + strike) == 0){
            resultString.append("낫싱");
        }

        System.out.println(resultString);

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    private static int getAnswerOneNumber(List<Integer> numberList) {
        int generatedNumber = (Randoms.pickNumberInRange(1, 9));
        while (numberList.contains(generatedNumber)) {
            generatedNumber = (Randoms.pickNumberInRange(1, 9));
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
        System.out.println(answerNumber);
        boolean gameResult = false;

        while (!gameResult){
            gameResult = eachGame();
        }
    }

    private static boolean isEndGame(){
        int inputNumber;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        inputNumber = Integer.parseInt(Console.readLine());
        if (inputNumber == 1){
            return true;
        } else if (inputNumber == 2){
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean isContinueGame = false;
        do {
            baseballGameRun();
            isContinueGame = isEndGame();
        } while (isContinueGame);
    }
}
