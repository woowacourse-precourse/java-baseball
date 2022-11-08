package baseball;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static String RESTART_OPTION = "1";
    private static String EXIT_OPTION = "2";
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }

    static void startGame() {
        Game game = new Game();
        List<Integer> playerGuess;
        GameResult gameResult;

        do {
            playerGuess = Player.guessAnswerOfGame();
            gameResult = game.getBallStrikeResult(playerGuess);
            System.out.println(gameResult.toString());
        } while (!gameResult.isAllStrike());

        restartOrNot();
    }

    static void restartOrNot() throws IllegalArgumentException {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String selection = readLine();
        if(!isValidSelection(selection)){
            throw new IllegalArgumentException("잘못된 입력: 1 혹은 2를 입력해주세요.");
        }

        if (selection.equals(RESTART_OPTION)) {
            startGame();
        } else if (selection.equals(EXIT_OPTION)) {
            System.out.println("게임 종료");
        }
    }

    static boolean isValidSelection(String selection){
        List<String> candidates = List.of(RESTART_OPTION, EXIT_OPTION);
        return  candidates.contains(selection);
    }
}
