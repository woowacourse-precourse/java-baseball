package baseball.view;

import java.util.List;

public final class OutputHandler {
    public void printMessageForData(List<Integer> data) {
        OutputMsgContainer.printMessage(data);
    }

    public void printMessageForData(OutputMsgContainer data) {
        OutputMsgContainer.printMessage(data);
    }
}
