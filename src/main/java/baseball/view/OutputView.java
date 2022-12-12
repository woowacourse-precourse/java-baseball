package baseball.view;

import baseball.dto.Hints;
import baseball.dto.ResultResponseDTO;
import baseball.model.Hint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OutputView {

    private final String ROUND_START_MESSAGE = "숫자를 입력해주세요 : ";

    private final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private final String REPLAY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final List<Hint> orderHint = new ArrayList<>(List.of(Hint.BALL, Hint.STRIKE, Hint.NOTHING));

    public void printRoundStart() {
        System.out.print(ROUND_START_MESSAGE);
    }

    public void printRoundResult(ResultResponseDTO result) {
        HashMap<Hint, Integer> resultHints = result.getHints();
        String resultScore = getStringBuilder(resultHints);
        System.out.println(resultScore);
        System.out.println();
    }

    private String getStringBuilder(HashMap<Hint, Integer> resultHints) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Hint hint : orderHint) {
            if (resultHints.get(hint) > 0) {
                stringBuilder.append(resultHints.get(hint));
                stringBuilder.append(hint.getValue());
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public void printGameStart(){
        System.out.println(GAME_START_MESSAGE);
    }

    public void printGameEnd(){
        System.out.println(GAME_END_MESSAGE);
    }

    public void printReplayGame() {
        System.out.println(REPLAY_MESSAGE);
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
