package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

class BaseballGame {
    private final List<Integer> computer;
    private final List<Integer> player;
    private static final String pleaseInput = "숫자를 입력해주세요 : ";
    private static boolean inputCondition;
    int ball;
    int strike;

    public BaseballGame() {
        computer = new ArrayList<>();
        player = new ArrayList<>();
        inputCondition = true;
        ball = 0;
        strike = 0;
    }

    private void newGame() {
        selectNumbersByComputer(computer);

        while (inputCondition) {
            System.out.print(getPleaseInput());
            String input = Console.readLine();
            isPlayerInputValid(input);

            getBallCounts(getComputerNumberList(), getPlayerNumberList());
            inputCondition = checkGameCondition(ball, strike);
            ball = 0;
            strike = 0;
            player.clear();
        }
    }

    public void getNewGame() {
        newGame();
    }

    private void selectNumbersByComputer(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addNumberIfDifferent(computer, randomNumber);
        }
    }

    private void addNumberIfDifferent(List<Integer> integerList, int randomNumber) {
        if (!integerList.contains(randomNumber)) {
            integerList.add(randomNumber);
        }
    }

    private void isPlayerInputValid(String input) throws IllegalArgumentException {
        try {
            throwExceptionIfInvalid(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private void throwExceptionIfInvalid(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력이 변환가능한 정수가 아님");
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력이 규정길이를 초과");
        } else {
            checkEqualityOfPlayerInput(input);
        }
    }

    private void checkEqualityOfPlayerInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            addNumberIfDifferent(player, Integer.parseInt(String.valueOf(input.charAt(i))));
        }
        if (player.size() < 3) {
            throw new IllegalArgumentException("서로 다른 임의의 수가 아님");
        }
    }

    private boolean checkGameCondition(int ball, int strike) {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
            System.out.println("게임 종료");
            return false;
        } else if (ball > 0) {
            System.out.printf("%d볼 %d스트라이크", ball - strike, strike);
        } else {
            System.out.println("낫싱");
        }
        return true;
    }

    private void getBallCounts(List<Integer> computerNumberList, List<Integer> playerNumberList) {
        for (Integer n : computerNumberList) {
            increaseBallCount(playerNumberList, n);
        }
        for (int i = 0; i < computerNumberList.size(); i++) {
            increaseStrikeCount(computerNumberList, playerNumberList, i);
        }
    }

    private void increaseStrikeCount(List<Integer> computerNumberList, List<Integer> playerNumberList, Integer i) {
        if (computerNumberList.get(i).equals(playerNumberList.get(i))) {
            strike++;
        }
    }

    private void increaseBallCount(List<Integer> playerNumberList, Integer n) {
        if (playerNumberList.contains(n)) {
            ball++;
        }
    }

    public List<Integer> getComputerNumberList() {
        return this.computer;
    }

    public List<Integer> getPlayerNumberList() {
        return this.player;
    }

    public static String getPleaseInput() {
        return pleaseInput;
    }
}

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean restartFlag = true;
        while (restartFlag) {
            BaseballGame game = new BaseballGame();
            game.getNewGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String exitCode = Console.readLine();
            isExitCodeValid(exitCode);
            if (exitCode.equals("2")) {
                restartFlag = false;
            }
        }
    }

    static void isExitCodeValid(String exitCode) {
        if (!(exitCode.equals("1") || exitCode.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }
}