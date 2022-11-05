package baseball;

import java.util.List;

public final class OutputMsgGenerator {
    private OutputMsgGenerator() {}
    public static String generate(List<Integer> code) {
        StringBuilder result = new StringBuilder();
        if (code.get(0) != 0) {
            result.append(code.get(0));
            result.append(OutputMsgContainer.BALL);
            result.append(OutputMsgContainer.SPACE);
        }
        result.append(code.get(1));
        result.append(OutputMsgContainer.STRIKE);
        return result.toString();
    }
}
