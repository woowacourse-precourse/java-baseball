package baseball.view;

import java.util.List;

public interface Viewable {

    public void printHint(List<Integer> hints);

    public void printStart();

    public void printInput();

    public void printEnd();

    public void printIsContinue();
}
