package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        String restartCheckInput = "";
        while (true) {
            Game.start();
            restartCheckInput = Console.readLine();
            if (restartCheckInput.equals("2")) {
                System.out.println("게임 종료");
                break;
            }
        }
    }
}
