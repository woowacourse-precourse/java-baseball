package baseball;

import java.util.regex.Pattern;

public class BallParameters {
    private static final Pattern ballFilter = Pattern.compile("^(?=.*\\d)(?!.*(\\d)(?!.*(\\d)).{0,3}$)");

    public BallParameters(String hits) {
        if (!ballFilter.matcher(hits).matches()) {
            throw new BallInputException("세자리 이상 입력할 수 없습니다.");
        }

    }
}
