package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {
    private String INPUT_PHRASES = "숫자를 입력해주세요 : ";

    public String inputView() {
        System.out.println(INPUT_PHRASES);
        return readLine();
    }

    public void endView() {

    }
}
