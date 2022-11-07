package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        playGame();
    }
    public static List<Integer> makeRandomNumList() {
        List<Integer> randomNumList = new ArrayList<>();
        while(randomNumList.size() < 3) {
            int newRandomNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNumList.contains(newRandomNum)) {
                randomNumList.add(newRandomNum);
            }
        }
        return randomNumList;
    }
    public static List<Integer> makeInputNumList() {
        System.out.print("숫자를 입력해주세요 : ");

        String inputString = Console.readLine();

        List<Integer> inputNumList = new ArrayList<>();
        for (int inputStringIdx = 0; inputStringIdx < inputString.length(); inputStringIdx++) {
            int inputNum = (int) inputString.charAt(inputStringIdx) - 48;
//            int inputNum = inputString.charAt(inputStringIdx);
            inputNumList.add(inputNum);
        }
        if (isValidList(inputNumList)) {
            return inputNumList;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
    public static boolean isValidList(List<Integer> numList) {
        if (numList.size() != 3) {
            return false;
        }
        Set<Integer> numSet= new HashSet<>(numList);
        if (numList.size() != numSet.size()) {
            return false;
        }
        for (int num : numList) {
            if (num < 1 || num > 9) {
                return false;
            }
        }
        return true;
    }
    public static Integer cntContain(List<Integer> inputNumInfo, List<Integer> answerNumInfo) {
        int contain = 0;
        int inputNum = inputNumInfo.get(1);
        int answerNum = answerNumInfo.get(1);

        if (inputNum == answerNum) {
            contain ++;
        }
        return contain;
    }
    public static Integer cntStrike(List<Integer> inputNumInfo, List<Integer> answerNumInfo) {
        int strike = 0;
        int inputIdx = inputNumInfo.get(0);
        int inputNum = inputNumInfo.get(1);
        int answerIdx = answerNumInfo.get(0);
        int answerNum = answerNumInfo.get(1);

        if (inputNum == answerNum) {
            if (inputIdx == answerIdx) {
                strike ++;
            }
        }
        return  strike;
    }
    public static List<Integer> makeResultList (List<Integer> inputNumList, List<Integer> answerList) {
        int strike = 0, contain = 0;
        for (int inputIdx = 0; inputIdx < 3; inputIdx++) {
            for (int answerIdx = 0; answerIdx < 3; answerIdx++) {
                int inputNum = inputNumList.get(inputIdx);
                int answerNum = answerList.get(answerIdx);
                List<Integer> inputNumInfo = List.of(inputIdx, inputNum);
                List<Integer> answerNumInfo = List.of(answerIdx, answerNum);
                contain = contain + cntContain(inputNumInfo, answerNumInfo);
                strike = strike + cntStrike(inputNumInfo, answerNumInfo);
            }
        }
        int ball = contain - strike;
        return List.of(ball, strike);
    }
    public static String makeResultString (List<Integer> resultList) {
        String resultString = "";
        int ball = resultList.get(0);
        int strike = resultList.get(1);
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }
        if (ball != 0) {
            resultString += ball + "볼 ";
        }
        if (strike != 0) {
            resultString += strike + "스트라이크";
        }
        return  resultString;
    }
    public static void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> answerNumList = makeRandomNumList();
        while (true) {
            List<Integer> inputNumList = makeInputNumList();
            List<Integer> resultList = makeResultList(inputNumList, answerNumList);
            String resultString = makeResultString(resultList);
            printResult(resultString);
            if (Objects.equals(resultString, "3스트라이크")) break;
        }
    }
    public static void printResult(String resultString) {
        System.out.println(resultString);
        if (Objects.equals(resultString, "3스트라이크")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            if (isReplayGame()) playGame();
        }
    }
    public static boolean isReplayGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputOneOrTwo = Console.readLine();
        if (Objects.equals(inputOneOrTwo, "1")) {
            return true;
        }
        else if (Objects.equals(inputOneOrTwo, "2")) {
            return false;
        }
        else {
            isReplayGame();
            return false;
        }
    }
}
