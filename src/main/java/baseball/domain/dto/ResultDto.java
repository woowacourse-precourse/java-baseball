package baseball.domain.dto;

import baseball.domain.model.Score;
import java.util.Map;

public class ResultDto {
    private final Map<String, Integer> result;

    public ResultDto(Score score) {
        this.result = getResult(score);
    }

    private Map<String, Integer> getResult(Score score) {
        return score.getResult();
    }
}
