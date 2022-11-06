package baseball;

import static baseball.Constants.DEFAULT_NUMBER_COUNT;
import static baseball.Constants.Messages;
import static baseball.Constants.PROCESS_CONTINUE;
import static baseball.Constants.PROCESS_FINISH;
import static baseball.Constants.Result;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Game extends abstracts.Game {

    private int answerNumberCount;
    private List<Integer> answerNumbers;

    Game() {
        this.gameName = "Baseball";
        this.status = Status.PLAYING;
        this.answerNumberCount = DEFAULT_NUMBER_COUNT;
        Messages.INIT.printMessage();
        this.initialize();
    }

    public List<Integer> getAnswerNumbers() {
        return this.answerNumbers;
    }

    private void setAnswerNumbers(List<Integer> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }


    @Override
    public void initialize() {
        setStatus(Status.PLAYING);
        setAnswerNumbers(getRandomNumbersOf(answerNumberCount));
        Messages.INPUT.printMessage();
    }
    private List<Integer> getRandomNumbersOf(int count) {
        count = Math.max(1, Math.min(9, count));
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < count) {
            addNewRandomNumberTo(numbers);
        }
        return numbers;
    }
    private void addNewRandomNumberTo(List<Integer> numbers) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (numbers.contains(randomNumber)) {
            return;
        }
        numbers.add(randomNumber);
    }

    @Override
    public void terminate() {
        setStatus(Status.DONE);
        setAnswerNumbers(Collections.emptyList());
    }

    @Override
    public boolean operate(String input) {
        System.out.println(input);
        return operationMapper
                .get(this.status)
                .test(input);
    }
    private final Map<Status, Predicate<String>> operationMapper = new HashMap<>();
    {
        operationMapper.put(Status.PLAYING, this::playTurn);
        operationMapper.put(Status.DONE, this::askAfterGameOption);
    }

    private boolean playTurn(String input) {
        HashMap<Result, Integer> resultCount = getGuessResult(input);
        Messages.printScore(resultCount);
        if (isGameOver(resultCount)) {
            terminate();
            Messages.END.printMessage();
            Messages.ASK.printMessage();
            return PROCESS_CONTINUE;
        }
        Messages.INPUT.printMessage();
        return PROCESS_CONTINUE;
    }

    private HashMap<Result, Integer> getGuessResult(String input) {
        HashMap<Result, Integer> guessResult = new HashMap<>();
        IntStream.range(0, input.length())
                .forEach((index) -> {
                    int number = Character.getNumericValue(input.charAt(index));
                    Result result = getIndexResult(index, number);
                    guessResult.put(result, guessResult.getOrDefault(result, 0) + 1);
                });
        return guessResult;
    }


    private Result getIndexResult(int index, int number) {
        return Arrays.stream(Result.values())
                .filter(result -> resultMapper
                        .get(result)
                        .test(index, number))
                .findFirst()
                .get();
    }
    private final Map<Result, BiPredicate<Integer, Integer>> resultMapper = new HashMap<>();
    {
        resultMapper.put(Result.STRIKE, this::isNumberStrike);
        resultMapper.put(Result.BALL, this::isNumberBall);
        resultMapper.put(Result.OUT, this::isNumberOut);
    }

    private Boolean isNumberStrike(Integer index, Integer number) {
        return answerNumbers.get(index).equals(number);
    }
    private Boolean isNumberBall(Integer index, Integer number) {
        return answerNumbers.contains(number);
    }
    private Boolean isNumberOut(Integer index, Integer number) {
        return !answerNumbers.contains(number);
    }

    private boolean isGameOver(HashMap<Result, Integer> turnResult) {
        int strikeCount = turnResult.getOrDefault(Result.STRIKE, 0);
        return strikeCount == answerNumberCount;
    }

    private boolean askAfterGameOption(String input) {
        return optionMapper
                .get(input)
                .get();
    }
    private final Map<String, Supplier<Boolean>> optionMapper = new HashMap<>();
    {
        optionMapper.put("1", this::restartProcess);
        optionMapper.put("2", this::endProcess);
    }
    private Boolean restartProcess() {
        this.initialize();
        return PROCESS_CONTINUE;
    }
    private Boolean endProcess() {
        return PROCESS_FINISH;
    }


}
