package baseball;

import camp.nextstep.edu.missionutils.Console;


public class Application {

    public static void main(String[] args) {
        boolean status = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (status) {
            Game game = new Game();
            game.start();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String line = Console.readLine();
            if ("2".equals(line)) {
                status = false;
                System.out.println("게임 종료");
            }
        }
    }
}
