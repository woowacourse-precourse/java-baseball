package baseball;

import baseball.constant.Finish;
import java.util.List;

public interface View {

    List<Integer> inputIntegerList();

    Finish inputFinishCode();

    void printHint(Hint hint);

    void printMessage(String message);
}
