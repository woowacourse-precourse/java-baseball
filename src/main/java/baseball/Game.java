package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private ScoreJudge scoreJudge;
    private CreateRandom createrandom;

    private static final String ENDOFGAME  = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASKRESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public Game() {
        this.scoreJudge = new ScoreJudge();
        this.createrandom = new CreateRandom();
    }

    public void startGame() {
        createrandom.initializer();
        String result = "";
        int[] random = createrandom.makeRandomNums();

        persistGame(result, random);
    }

    public int askRegame() {
        System.out.println(ENDOFGAME);
        System.out.println(ASKRESTART);

        int input = Integer.parseInt(Console.readLine());

        return input;
    }

    private void persistGame(String result, int[] random) {
        while (!result.equals("3스트라이크")) {
            System.out.print("숫자를 입력해주세요 : ");
            result = scoreJudge.Judge(random);
            System.out.println(result);
            scoreJudge.Initializer();
        }
    }
}
