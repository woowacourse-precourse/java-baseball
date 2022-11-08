package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<String> answer = makeAnswer();
        int checkFinish = 0;
        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            List<String> playerInput = checkAvailable(Input());
            List<Integer> compareResult = compareNumbers(answer, playerInput);
            showResult(compareResult);

            if (compareResult.get(0).equals(3)) {
                checkFinish = chooseTerminateOrNot(answer);
            }

            if (checkFinish == 2) {
                break;
            } else if (checkFinish == 1) {
                answer = makeAnswer();
                checkFinish = 0;
            }

        }

    }

    public static List<String> makeAnswer() {
        List<String> answerList = new ArrayList<>();
        while (answerList.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1,9);
            if (!answerList.contains(Integer.toString(randomNum))) {
                answerList.add(Integer.toString(randomNum));
            }
        }
        return answerList;
    }
    public static List<String> Input() {
        String numString = Console.readLine();
        List<String> numList = new ArrayList<>(Arrays.asList(numString.split("")));
        return numList;
    }

    public static List<String> checkAvailable(List<String> numList) {
        if (numList.size() != 3) {
            throw new IllegalArgumentException();
        }
        for (String num : numList) {
            if (num.charAt(0) < '1' || num.charAt(0) > '9') {
                throw new IllegalArgumentException();
            }
        }
        Set<String> numSet = new HashSet<>(numList);
        if (numSet.size() != 3) {
            throw new IllegalArgumentException();
        }

        return numList;
    }

    public static List<Integer> compareNumbers(List<String> answer, List<String> playerInput) {
        List<Integer> countList = new ArrayList<>(Arrays.asList(0,0,0));
//        System.out.println(countList);
        for (int index = 0; index < 3; index++) {
            String playerNumber = playerInput.get(index);
            String answerNumber = answer.get(index);
            if (!answer.contains(playerNumber)) {
                countList.set(2, countList.get(2)+1);
            } else if (answer.contains(playerNumber)) {
                updateCountListIfStrikeOrBall(playerNumber, answerNumber, countList);
            }
        }
        return countList;
    }

    public static void showResult(List<Integer> countList) {
        if (countList.get(2).equals(3)) {
            System.out.println("낫싱");
        } else {
            if (countList.get(0).equals(3)) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            } else {
                showResultWithBallAndStrike(countList);
            }
        }
    }
    public static void showResultWithBallAndStrike(List<Integer> countList) {
        if (countList.get(0).equals(0)) {
            System.out.println(String.format("%d볼", countList.get(1)));
        } else if (countList.get(1).equals(0)) {
            System.out.println(String.format("%d스트라이크", countList.get(0)));
        } else {
            System.out.println(String.format("%d볼 %d스트라이크",countList.get(1), countList.get(0)));
        }
    }

    public static void updateCountListIfStrikeOrBall(String playerNumber, String answerNumber, List<Integer> countList) {
        if (playerNumber.equals(answerNumber)) {
            countList.set(0, countList.get(0)+1);
        } else {
            countList.set(1, countList.get(1)+1);
        }
    }
    public static int chooseTerminateOrNot(List<String> answer) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        List<String> checkTerminate = Input();
        if (checkTerminate.size() == 1 && checkTerminate.get(0).equals("1")) {
            return 1;
        } else if (checkTerminate.size() == 1 && checkTerminate.get(0).equals("2")) {
            return 2;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
