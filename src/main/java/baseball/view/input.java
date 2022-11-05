package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class input {

    public String threeNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public boolean continueGame() {
        int replay;
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            replay = Integer.parseInt(Console.readLine());
            if (replay == 1)
                return true;
            if (replay == 2)
                return false;
        }
    }
}
