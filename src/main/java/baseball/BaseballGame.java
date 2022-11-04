package baseball;

import abstracts.Game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private static final Map<Status, Function<String, Boolean>> operationMapper = new HashMap<>();
    static {
        operationMapper.put(Status.PLAYING, BaseballGame::playTurn);
        operationMapper.put(Status.DONE, BaseballGame::askNewGame);
    }

    @Override
    public boolean operate(String input) {
        return operationMapper
                .get(this.status)
                .apply(input);
    }

    private static boolean playTurn(String input) {
        System.out.println("playing");
        return false;
    }

    private static boolean askNewGame(String input) {
        System.out.println("stopped");
        return false;
    }


}
