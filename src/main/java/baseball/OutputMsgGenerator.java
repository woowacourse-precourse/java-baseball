package baseball;

import java.util.List;

public final class OutputMsgGenerator {
    private OutputMsgGenerator() {}
    public static String generate(List<Integer> code) {
        StringBuffer result = new StringBuffer();
        if (code.get(0) != 0) {
            result += code.get(0) + OutputMsgContainer.BALL;
        }
        result += code.get(1) + OutputMsgContainer.STRIKE;
        return result.toString();
    }
}
