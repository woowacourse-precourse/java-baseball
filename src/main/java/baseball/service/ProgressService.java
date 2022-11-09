package baseball.service;

import baseball.message.GameProgressMessage;
import baseball.validation.NumberValidation;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.message.GameProgressMessage.END;
import static baseball.message.GameProgressMessage.RESTART;
import static baseball.message.ScoreMessage.NOTHING;
import static baseball.util.GameCode.*;

public class ProgressService {

    private final NumberValidation validation;
    private ScoreService scoreService;

    private boolean endFlag = false;

    public ProgressService() {
        validation = new NumberValidation();
        initProgress();
    }

    public void initProgress() {
        List<Integer> answerNumber = createAnswerNumber();
        scoreService = new ScoreService(answerNumber);
        endFlag = false;
    }

    private List<Integer> createAnswerNumber() {
        List<Integer> answerNumberList = new ArrayList<>();

        while (answerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumberList.contains(randomNumber)) {
                answerNumberList.add(randomNumber);
            }
        }
        validation.validateRandomAnswer(answerNumberList);

        return answerNumberList;
    }

    public String getResultMessageOfGuessNumber(String userInput) {
        List<Integer> convertedUserInput = parseStringToListInteger(userInput);

        if (scoreService.isNothing(convertedUserInput)) {
            return NOTHING.getMessage();
        }

        int strikeScore = scoreService.getStrikeScore(convertedUserInput);
        checkEndOfGame(strikeScore);

        return scoreService.getResultScore(convertedUserInput);
    }

    public GameProgressMessage getResultOfEndGame(String userInput) {
        int flag = Integer.parseInt(userInput);

        if (flag == (RESTART_GAME.getCode())) {
            return RESTART;
        }

        if (flag == END_GAME.getCode()) {
            return END;
        }

        throw new IllegalArgumentException("Game is over, you must input only flag number");
    }

    public boolean isEnd() {
        return endFlag;
    }

    private void checkEndOfGame(int score) {
        if (score == STRIKE_COUNT_FOR_END.getCode()) {
            this.endFlag = true;
        }
    }

    private List<Integer> parseStringToListInteger(String userInput) {

        return Arrays.stream(userInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
