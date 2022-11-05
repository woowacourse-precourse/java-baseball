package baseball.view;

import baseball.dto.Score;
import baseball.system.holder.ConverterHolder;
import baseball.vo.Answer;

public class OutputView {

    public static final String WINNING_MESSAGE_FORMAT = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n";

    public void printResult(Score score) {
        String resultMessage = ConverterHolder.convert(score, String.class);

        System.out.println(resultMessage);
    }

    public void printWinnerMessage() {
        System.out.printf(WINNING_MESSAGE_FORMAT, Answer.ANSWER_LIST_SIZE);
    }
}
