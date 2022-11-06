package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int gameStart = 1;
        do {
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameStart = Integer.parseInt(readLine());
            System.out.println(gameStart);
        } while (gameStart == 1);
    }

    private static void playGame() {
    }
}
