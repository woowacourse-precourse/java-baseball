package baseball;

import abstracts.Game;
import java.util.*;
import java.util.function.Function;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame extends Game {

    private final int ANSWER_NUMBER_COUNT = 3;
    private List<Integer> answerNumbers;

    BaseballGame() {
        this.gameName = "Baseball";
        this.status = Status.PLAYING;
        this.initialize();
    }

    private List<Integer> getAnswerNumbers() {
        return this.answerNumbers;
    }

    private void setAnswerNumbers(List<Integer> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    private List<Integer> getRandomNumbersOf(int count) {
        List<Integer> answerNumbers = new ArrayList<>();
        while (answerNumbers.size() < count) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumbers.contains(randomNumber)) {
                answerNumbers.add(randomNumber);
            }
        }
        return answerNumbers;
    }
    @Override
    public void initialize() {
        setStatus(Status.PLAYING);
        setAnswerNumbers(getRandomNumbersOf(ANSWER_NUMBER_COUNT));
    }

    @Override
    public void terminate() {
        setStatus(Status.DONE);
        setAnswerNumbers(Collections.emptyList());
    }

    private final Map<Status, Function<String, Boolean>> operationMapper = new HashMap<>();
    {
        operationMapper.put(Status.PLAYING, this::playTurn);
        operationMapper.put(Status.DONE, this::askNewGame);
    }

    @Override
    public boolean operate(String input) {
        return operationMapper
                .get(this.status)
                .apply(input);
    }

    private boolean playTurn(String input) {
        HashMap<Result, Integer> turnResult = getGuessResult(input);
        Messages.printScore(turnResult);
        if(isGameOver(turnResult)) {
            terminate();
        }
        return true;
    }

    private HashMap<Result, Integer> getGuessResult(String input) {
        HashMap<Result, Integer> guessResult = new HashMap<>();
        for (int index = 0; index < input.length(); index++) {
            int number = Character.getNumericValue(input.charAt(index));
            Result result = getDigitResult(index, number);
            guessResult.put(result, guessResult.getOrDefault(result, 0) + 1);
        }
        return guessResult;
    }

    private Result getDigitResult(int index, int number) {
        if (answerNumbers.get(index) == number) {
            return Result.STRIKE;
        }
        if (answerNumbers.contains(number)) {
            return Result.BALL;
        }
        return Result.OUT;
    }

    private boolean isGameOver(HashMap<Result, Integer> turnResult) {
        return false;
    }

    private boolean askNewGame(String input) {
        System.out.println("stopped");
        return false;
    }
}
