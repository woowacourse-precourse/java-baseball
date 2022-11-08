package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public void continueOrQuit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String checkContinue = Console.readLine();
        if (checkContinue.equals("1")) {
            playGame();
        }
        else if (checkContinue.equals("2")) {
            System.out.println("게임 종료");
        }
        else {
            System.out.println("잘못된 입력값입니다.");
        }
    }

    public void playGame() {
        List<Integer> computerNumberList = selectNumbers();

        Player player = new Player();
        String result = "";

        while (!result.equals("3스트라이크")) {
            String playerInput = player.getInput();
            List<Integer> playerNumberList = player.StringToList(playerInput);

            int sameNumbersCnt = checkSameNumbersCount(computerNumberList, playerNumberList);
            int sameNumberOfDigit = checkSameNumberOfDigit(computerNumberList, playerNumberList);
            List<Integer> ballStrikeList = getBallStrikeList(sameNumbersCnt, sameNumberOfDigit);
            result = printResult(ballStrikeList);
            System.out.println(result);
        }

        continueOrQuit();
    }

    public List<Integer> selectNumbers() {
        List<Integer> selectNumberList = new ArrayList<>();
        Ball ball = new Ball();

        while (selectNumberList.size() < 3) {
            int randomNumber = ball.getRandomNumber();
            if (selectNumberList.contains(randomNumber)) continue;
            selectNumberList.add(randomNumber);
        }

        return selectNumberList;
    }

    public String printResult(List<Integer> ballStrikeList) {
        String result = "";
        Player player = new Player();
        if (ballStrikeList.get(0) != 0) {
            result += ballStrikeList.get(0) + "볼 ";
        }
        if (ballStrikeList.get(1) != 0) {
            result += ballStrikeList.get(1) + "스트라이크";
        }
        if (result.equals("")) result = "낫싱";
        return result;
    }

    public List<Integer> getBallStrikeList(int sameNumbersCnt, int numberOfDigitCnt) {
        int strike = numberOfDigitCnt;
        int ball = sameNumbersCnt - strike;
        return new ArrayList<>(List.of(ball, strike));
    }

    public int checkSameNumbersCount(List<Integer> computerList, List<Integer> playerList) {
        int sameNumbersCnt = 0;

        for (Integer number : computerList) {
            if (playerList.contains(number)) sameNumbersCnt++;
        }

        return sameNumbersCnt;
    }

    public int checkSameNumberOfDigit(List<Integer> computerList, List<Integer> playerList) {
        int numberOfDigitCnt = 0;

        for (int idx = 0; idx < 3; idx++) {
            if (computerList.get(idx) == playerList.get(idx)) numberOfDigitCnt++;
        }

        return numberOfDigitCnt;
    }
}
