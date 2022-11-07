package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {

    private static final int NUMBER_LENGTH = 3;
    private static final String RESTART = "1";
    private static final String EXIT = "2";

    public void restart() {
        while (true) {
            play();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restartState = checkInputValidity(Console.readLine());
            if (restartState.equals(EXIT)) break;
        }
    }

    private String checkInputValidity(String restartState) {
        if (!restartState.equals(RESTART) && !restartState.equals(EXIT)) {
            throw new IllegalArgumentException("1이나 2가 아닌 숫자가 입력됐습니다.");
        }
        return restartState;
    }

    private void play() {
        List<Character> computerNumberList = getComputerNumberList();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Character> userNumberList = getUserNumberList(Console.readLine());

            int strike = countStrike(computerNumberList, userNumberList);
            int ball = countBall(computerNumberList, userNumberList);

            if (checkNothing(strike, ball)) continue;
            System.out.println(printState(strike, ball));
            if (strike == 3) break;
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private List<Character> getUserNumberList(String userInput) {
        UserNumber userNumber = new UserNumber(userInput);
        List<Character> userNumberList = userNumber.getNumberList();
        return userNumberList;
    }

    private List<Character> getComputerNumberList() {
        ComputerNumber computerNumber = new ComputerNumber();
        List<Character> computerNumberList = computerNumber.getNumberList();
        return computerNumberList;
    }

    private String printState(int strike, int ball) {
        String state = "";
        if (ball != 0) {
            state += ball + "볼";
        }
        if (strike != 0) {
            if(ball != 0) state += " ";
            state += strike + "스트라이크";
        }
        return state;
    }

    private int countStrike(List<Character> computerNumber, List<Character> userNumber) {
        int strike = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }

    private int countBall(List<Character> computerNumber, List<Character> userNumber) {
        int ball = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (!computerNumber.get(i).equals(userNumber.get(i)) && computerNumber.contains(userNumber.get(i))) {
                ball += 1;
            }
        }
        return ball;
    }

    private boolean checkNothing(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return true;
        }
        return false;
    }
}
