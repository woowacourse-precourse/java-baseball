package baseball.controller;

import baseball.validator.PlayerInputValidator;
import baseball.view.GameView;
import camp.nextstep.edu.missionutils.Console;

import baseball.model.Computer;
import baseball.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameController {

    private final PlayerInputValidator playerInputValidator = new PlayerInputValidator();
    private final GameView gameView = new GameView();
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
        gameView.printStart();
        this.player = new Player();
        this.computer = new Computer();
        computer.setRandomNumbers();
    }

    public void playGame() {
        do {
            playSet();
        } while (isResume());
    }

    public int getBallCount() {
        int ballCount = 0;
        for (int number : player.getNumbers()) {
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

    public boolean isResume() {
        gameView.printRestartOrStop();
        String input = Console.readLine();
        playerInputValidator.checkResumeInput(input);

        return input.equals("1");
    }

    private void playSet() {
        initGame();
        do {
            inputPlayerNumbers();
        } while (!isGuessed());
        gameView.printSuccess();
    }

    private boolean isGuessed() {
        int strikeCount = getStrikeCount();
        int ballCount = getBallCount();
        if (ballCount == 0 && strikeCount == 0) {
            gameView.printNothing();
        } else if (strikeCount == 0) {
            gameView.printBall(ballCount);
        } else if (ballCount == 0) {
            gameView.printStrike(strikeCount);
            return strikeCount == 3;
        } else {
            gameView.printBallAndStrike(ballCount, strikeCount);
        }
        return false;
    }

    private void inputPlayerNumbers() {
        gameView.printAskingForPlayerInput();
        String input = Console.readLine();
        playerInputValidator.checkPlayerInput(input);
        List<Integer> inputNumberList = changeInputToList(input);
        player.setPlayerNumbers(inputNumberList);
    }

    private List<Integer> changeInputToList(String input) {
        List<Integer> inputNumberList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            int digit = Character.getNumericValue(input.charAt(i));
            inputNumberList.add(digit);
        }

        return inputNumberList;
    }
}
