package baseball;

import camp.nextstep.edu.missionutils.Console;

public class PlayAgainResult {

    public boolean restartIsOkay() {

        System.out.println("\n" +"3개의 숫자를 모두 맞히셨습니다! 게임 종료" + "\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int playerRestartNumber = Integer.parseInt(Console.readLine());

        // 1혹은 2가 아닐 때

        if (playerRestartNumber == '1') {
            return true;
        }
        return false;
    }


}
