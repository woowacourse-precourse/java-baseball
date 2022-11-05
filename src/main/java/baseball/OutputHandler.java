package baseball;

import java.util.List;

public final class OutputHandler {
    public void printMessageForData(List<Integer> data) {
        System.out.println(OutputMsgGenerator.generate(data));
    }
}
