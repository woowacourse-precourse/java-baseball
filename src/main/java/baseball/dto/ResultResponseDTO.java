package baseball.dto;

import baseball.model.Hint;
import baseball.model.Success;

import java.util.HashMap;

public class ResultResponseDTO {
    private HashMap<Hint, Integer> hints;
    private Success success;

    public ResultResponseDTO(Hints hints, Success success) {
        this.hints = hints.getHints();
        this.success = success;
    }

    public HashMap<Hint, Integer> getHints() {
        return hints;
    }

    public Success getSuccess() {
        return success;
    }
}
