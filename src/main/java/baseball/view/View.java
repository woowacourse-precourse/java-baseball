package baseball.view;

import baseball.constant.Finish;
import baseball.hint.Hint;
import java.util.List;

public interface View {

    List<Integer> inputIntegerList();

    Finish inputFinishCode();

    void printHint(Hint hint);

    void printMessage(String message);
}
