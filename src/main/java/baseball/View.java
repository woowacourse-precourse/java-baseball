package baseball;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public String inputBaseballNumber() {
        System.out.print("숫자를 입력해주세요 :");
        return Console.readLine();
    }

    public String inputExitOrRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public void printBaseBallResult(BaseBallDto baseBallDto) {
        System.out.println(baseBallDto.getResult());
    }
}
