package baseball;

import camp.nextstep.edu.missionutils.Console;


/**
 * 컴퓨터 번호를 맞추기 위한 입력(서로 다른 3자리)
 * 게임 종료 여부에 대한 입력(게임시작:1, 게임종료:2)
 */

public class UserInput {

    public String userNumberInput() {
        System.out.print("숫자를 입력해주새요 : ");
        return Console.readLine();
    }

    public String replayOrStop() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
