package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Service {

    public void startGame() {
        int strike = 0;
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> answer = pick();
        while (strike < 3) {
            strike = stage(answer);
        }
        restart();
    }

    private void restart() throws IllegalArgumentException{
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            startGame();
        }
        if (input.equals("2")) {
            System.out.println("게임을 완전히 종료합니다.");
        }
    }

    private int stage(List<Integer> answer) {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> input = getUserNumber();
        return hint(answer, input);
    }

    private List<Integer> pick() {
        Set<Integer> numSet = new HashSet<>();
        while (numSet.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            numSet.add(randomNumber);
        }
        List<Integer> numList = new ArrayList<>(numSet);
        return numList;
    }

    private List<Integer> getUserNumber(){
        String input = Console.readLine();
        List<Integer> currInput = parser(input);
        return currInput;
    }

    private List<Integer> parser(String input) {
        checkException(input);
        List<Integer> currInput = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i);
            currInput.add(Character.getNumericValue(num));
        }
        return currInput;
    }

    private void checkException(String input) throws IllegalArgumentException{
        if (input.length()!=3) {
            throw new IllegalArgumentException();
        }
        checkNumber(input);
        checkDuplicate(input);
    }

    private void checkNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if ('0' <= input.charAt(i) && input.charAt(i) <= '9') {
                continue;
            }
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (countChar(input, input.charAt(i))==1) {
                continue;
            }
            throw new IllegalArgumentException();
        }
    }

    public static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }

    private int hint(List<Integer> answerList, List<Integer> inputList) {
        int strike = countStrike(answerList, inputList);
        int ball = countBall(answerList, inputList) - strike;
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        return strike;

    }

    private int countBall(List<Integer> answerList, List<Integer> inputList) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (inputList.contains(answerList.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    private int countStrike(List<Integer> answerList, List<Integer> inputList) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (answerList.get(i) == inputList.get(i)) {
                cnt++;
            }
        }
        return cnt;
    }



}
