package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class NumberBaseBallView {
    public void start(){
        System.out.println("숫자 야구게임을 시작합니다.");
    }

    public String askInputNumber(){
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
}
