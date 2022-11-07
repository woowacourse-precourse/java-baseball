package baseball;

import static baseball.Constants.*;
import static baseball.InputChecker.*;
import baseball.Constants.EndCommand;

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

public class BaseballGame extends abstracts.Game {

    /**
     * 미션 구현사항엔 없지만, 숫자 개수를 바꾸는 기능을 추가할 수 있도록
     * 확장성을 고려해 상수화 하지 않았습니다.
     */
    private int answerNumberCount;
    private List<Integer> answerNumbers;

    BaseballGame() {
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

    /**
     * 게임 진행 상태에 따라 다르게 입력을 처리합니다.
     * 프로세스 종료 여부를 판단하기 위해 논리값을 반환합니다.
     */
    @Override
    public boolean operate(String input) {
        return operationMapper
                .get(this.status)
                .test(input);
    }

    /**
     * 게임 진행 상태에 따라 입력을 달리 처리할 때,
     * if문 없이 분기 처리를 하기 위해 사용되는 해시맵입니다.
     */
    private final Map<Status, Predicate<String>> operationMapper = new HashMap<>();
    {
        operationMapper.put(Status.PLAYING, this::playTurn);
        operationMapper.put(Status.DONE, this::askAfterGameOption);
    }

    /**
     * 게임이 진행중이라면, 입력값을 추측 명령어로 판단해 처리합니다.
     * 게임이 완료되더라도 프로세스는 진행되어야 하므로,
     * 반환값은 어느 경우든 true입니다.
     */
    private boolean playTurn(String input) {
        isGuessCommandValid(input, answerNumberCount);
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

    /**
     * 특정 숫자의 추측 결과를 알려줄 때,
     * if문 없이 분기 처리를 하기 위해 사용되는 해시맵입니다.
     */
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
        isEndCommandValid(input);
        EndCommand endCommand = EndCommand.find(input);
        return endCommandMapper
                .get(endCommand)
                .get();
    }

    /**
     * 게임 종료 후, 입력에 따라 다음 동작을 처리할 때,
     * if문 없이 분기 처리를 하기 위해 사용되는 해시맵입니다.
     */
    private final Map<EndCommand, Supplier<Boolean>> endCommandMapper = new HashMap<>();
    {
        endCommandMapper.put(EndCommand.RESTART, this::restartProcess);
        endCommandMapper.put(EndCommand.FINISH, this::endProcess);
    }
    private Boolean restartProcess() {
        this.initialize();
        return PROCESS_CONTINUE;
    }
    private Boolean endProcess() {
        return PROCESS_FINISH;
    }


}
