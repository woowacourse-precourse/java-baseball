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

    public void resultView(int strike, int ball) {
        if(ball != 0) System.out.print(ball + "볼");
        if(strike != 0) System.out.print(strike + "스트라이크");
        System.out.println();
    }
}
