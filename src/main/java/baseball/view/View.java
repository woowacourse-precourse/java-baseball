package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {
    private String INPUT_PHRASES = "숫자를 입력해주세요 : ";
    private String END_PHRASES = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String inputView() {
        System.out.println(INPUT_PHRASES);
        return readLine();
    }

    public String endView() {
        System.out.println(END_PHRASES);
        return readLine();
    }
}
