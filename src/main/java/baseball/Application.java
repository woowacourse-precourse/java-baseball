package baseball;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static int BALL_INDEX = 0;
    public static int STRIKE_INDEX = 1;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    static void startGame() {
        Game game = new Game();

        List<Integer> playerGuess;
        int ball;
        int strike;

        do {
            playerGuess = Player.guessAnswerOfGame();

            List<Integer> ballStrikeCnt = game.getBallStrikeCnt(playerGuess);
            ball = ballStrikeCnt.get(BALL_INDEX);
            strike = ballStrikeCnt.get(STRIKE_INDEX);

            System.out.println(Game.getResultOfPlayerGuess(ball, strike));
        } while (!Game.isAllStrike(strike));

        restartOrNot();
    }

    static void restartOrNot() throws IllegalArgumentException {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String selection = readLine();
        if(!isValidSelection(selection)){
            throw new IllegalArgumentException("잘못된 입력: 1 혹은 2를 입력해주세요.");
        }

        if (selection.equals("1")) {
            startGame();
        } else if (selection.equals("2")) {
            System.out.println("게임 종료");
        }
    }

    static boolean isValidSelection(String selection){
        List<String> candidates = List.of("1", "2");
        return  candidates.contains(selection);
    }
}
