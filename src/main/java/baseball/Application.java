package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        Scanner sc = new Scanner(System.in);
        String answer = "";
        final String ANSWER = "3스트라이크";

        while (!answer.equals(ANSWER)) {
            System.out.println(answer);
            answer = game.beingGame();
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String playerInput = sc.nextLine();
        game.isGameRestart(playerInput);
        if(!game.getGameStatus()) {
            game = null;
        }
    }
}
