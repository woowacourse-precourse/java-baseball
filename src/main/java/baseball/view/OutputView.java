package baseball.view;

import baseball.dto.Score;
import baseball.system.holder.ConverterHolder;
import baseball.vo.Answer;

public class OutputView {
    public static final String WINNING_MESSAGE_FORMAT = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n";
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public void printResult(Score score) {
        String resultMessage = ConverterHolder.convert(score, String.class);
        System.out.println(resultMessage);
    }

    public void printWinnerMessage() {
        System.out.printf(WINNING_MESSAGE_FORMAT, Answer.ANSWER_SIZE);
    }

    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }
}
