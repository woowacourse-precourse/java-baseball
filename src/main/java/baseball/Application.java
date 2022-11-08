package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        int checkPoint = 0;
        do {
            Play.playStart();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            checkPoint = Exception.validateCheckPoint(Console.readLine());
        } while (checkPoint != 2);
    }
}
