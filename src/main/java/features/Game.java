package features;


import configuration.AppConfig;
import java.util.Map;
import java.util.Scanner;

public class Game {

    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_OVER = "게임을 재시작하려면 1, 종료하려면 2를 입력해주세요.";
    private static final String STRIKE = "3스트라이크";

    private static AppConfig game;

    private static boolean recursion = STRIKE.equals(game.printResult());

    // 생성자 주입
    private Game(AppConfig appConfig, AppConfig result) {

        this.game = appConfig;


    }

    // 게임 반복 기능
    public static String playGame() {

        System.out.println(startGame());

        do {

            recursionGame();
            boolean recursion = STRIKE.equals(game.printResult());

        }
        while (!recursion);

        victory();

        System.out.println(GAME_OVER);

        return GAME_OVER;

    }

    // 게임 시작 기능
    private static String startGame() {
        return GAME_START;
    }

    // 게임 실행 기능
    public static Game recursionGame() {
        Map<Integer, Character> user = game.inputUserNumber();
        Map<Integer, Character> computer = game.createComputerNumber();


        game.loopHint(user, computer);
        game.printResult();


        return recursionGame();
    }

    // 게임 종료 기능
    private static String victory() {
        String victory = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        return victory;
    }
}
