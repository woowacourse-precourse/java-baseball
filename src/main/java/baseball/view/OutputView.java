package baseball.view;

import baseball.dto.Score;
import baseball.system.conversion.Converter;
import baseball.system.conversion.ScoreToMessageConverter;

public class OutputView {
    public void printResult(Score score) {
        Converter<Score, String> converter = new ScoreToMessageConverter();
        String resultMessage = converter.convert(score);

        System.out.println(resultMessage);
    }
}
