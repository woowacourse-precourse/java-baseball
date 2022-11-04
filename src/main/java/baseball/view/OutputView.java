package baseball.view;

import baseball.dto.Score;
import baseball.system.conversion.Converter;
import baseball.system.conversion.ScoreToMessageConverter;
import baseball.vo.Answer;

public class OutputView {

    public static final String WINNING_MESSAGE_FORMAT = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n";

    public void printResult(Score score) {
        Converter<Score, String> converter = new ScoreToMessageConverter();
        String resultMessage = converter.convert(score);

        System.out.println(resultMessage);
    }

    public void printWinnerMessage() {
        System.out.printf(WINNING_MESSAGE_FORMAT, Answer.ANSWER_LIST_SIZE);
    }
}
