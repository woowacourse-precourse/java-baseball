package baseball;

import baseball.constant.Finish;
import java.util.List;

public interface View {

    public List<Integer> inputIntegerList();

    public Finish inputFinishCode();

    public void printHint(Hint hint);

    public void printMessage(String message);
}
