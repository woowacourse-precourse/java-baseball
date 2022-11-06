package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static final char INTEGER_MAKER = '0';
    private static final String GAME_REPLAY = "1";

    public void playGame() throws IllegalArgumentException {
        InputView.printGameStart();
        boolean isRunning = true;
        List<Integer> computerNumbers = RandomNumberCreator.getRandomNumbers();
        System.out.println(computerNumbers);
        while (isRunning) {
            String userInput = InputView.getUserInput();

            NumberValidator.checkInput(userInput);

            List<Integer> userNumbers = getNumbersByInput(userInput);

            int ballCount = getBallCount(userNumbers, computerNumbers);
            int strikeCount = getStrikeCount(userNumbers, computerNumbers);

            isRunning = OutputView.printGameResult(ballCount, strikeCount);
        }

        boolean gameStop = getReplayOrNot();
    }

    private boolean getReplayOrNot() throws IllegalArgumentException {
        String replayInput = InputView.getReplayOrNotByInput();
        
        NumberValidator.checkReplayInput(replayInput);

        return convertReplayInputToBool(replayInput);
    }

    private boolean convertReplayInputToBool(String replayInput) {
        return replayInput.equals(GAME_REPLAY);
    }

    private List<Integer> getNumbersByInput(String userInput) {
        List<Integer> numbers = new ArrayList<>();

        for (int index = 0; index < userInput.length(); index++) {
            char number = userInput.charAt(index);
            numbers.add(number - INTEGER_MAKER);
        }

        return numbers;
    }

    private int getBallCount(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int ballCount = 0;
        for (int userIndex = 0; userIndex < userNumbers.size(); userIndex++) {
            for (int computerIndex = 0; computerIndex < computerNumbers.size(); computerIndex++) {
                ballCount += getEachBallCount(userNumbers, computerNumbers, userIndex, computerIndex);
            }
        }
        return ballCount;
    }

    private int getEachBallCount(List<Integer> userNumbers, List<Integer> computerNumbers, int userIndex, int computerIndex) {
        int userNumber = userNumbers.get(userIndex);
        int computerNumber = computerNumbers.get(computerIndex);

        if (userNumber == computerNumber && userIndex != computerIndex) {
            return 1;
        }

        return 0;
    }

    private int getStrikeCount(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int strikeCount = 0;
        for (int userIndex = 0; userIndex < userNumbers.size(); userIndex++) {
            for (int computerIndex = 0; computerIndex < computerNumbers.size(); computerIndex++) {
                strikeCount += getEachStrikeCount(userNumbers, computerNumbers, userIndex, computerIndex);
            }
        }
        return strikeCount;
    }

    private int getEachStrikeCount(List<Integer> userNumbers, List<Integer> computerNumbers, int userIndex, int computerIndex) {
        int userNumber = userNumbers.get(userIndex);
        int computerNumber = computerNumbers.get(computerIndex);

        if (userNumber == computerNumber && userIndex == computerIndex) {
            return 1;
        }

        return 0;
    }

}
