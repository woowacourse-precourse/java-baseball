package baseball.controller;

import baseball.validator.PlayerInputValidator;
import camp.nextstep.edu.missionutils.Console;

import baseball.model.Computer;
import baseball.model.Player;

import java.util.List;
import java.util.Objects;

public class GameController {

    private final PlayerInputValidator playerInputValidator = new PlayerInputValidator();
    private Computer computer;
    private Player player;

    public void setGamerForTest(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        Player player = new Player();
        player.setNumbers(playerNumbers);
        Computer computer = new Computer();
        computer.setNumbers(computerNumbers);
        this.player = player;
        this.computer = computer;
    }

    public void initGame() {
        this.player = new Player();
        this.computer = new Computer();
        computer.setRandomNumbers();
    }

    public void playGame() {
        do {
            playSingleSet();
        } while (isResume());
    }

    private void playSingleSet() {
        initGame();
        do {
            inputPlayerNumbers();
        } while (!isGuessed());
    }

    public boolean isResume() {
        String input = Console.readLine();
        playerInputValidator.checkResumeInput(input);

        return input.equals("1");
    }

    private boolean isGuessed() {
        int strikeCount = getStrikeCount();
        int ballCount = getBallCount();
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        } else if (strikeCount == 0) {
            System.out.println(ballCount + "볼");
        } else if (ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
            return strikeCount == 3;
        } else {
            System.out.println(ballCount + "볼" + strikeCount + "스트라이크");
        }
        return false;
    }

    public void inputPlayerNumbers() {
        String input = Console.readLine();
        List<Integer> inputNumberList = playerInputValidator.getDigitList(input);
        player.setPlayerNumbers(inputNumberList);
    }

    public int getBallCount() {
        int ballCount = 0;
        for (int number: player.getNumbers()) {
            if (computer.getNumbers().contains(number)) {
                ballCount++;
            }
        }
        ballCount -= getStrikeCount();

        return ballCount;
    }

    public int getStrikeCount() {
        int strikeCount = 0;
        List<Integer> playerNumbers = player.getNumbers();
        List<Integer> computerNumbers = computer.getNumbers();
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (Objects.equals(playerNumbers.get(i), computerNumbers.get(i))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }
}
