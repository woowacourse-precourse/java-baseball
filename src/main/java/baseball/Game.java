package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private ScoreJudge scoreJudge;
    private CreateRandom createRandom;

    private static final String END_OF_GAME  = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public Game() {
        this.scoreJudge = new ScoreJudge();
        this.createRandom = new CreateRandom();
    }

    public void startGame() {
        createRandom.initializer();
        String result = "";
        int[] random = createRandom.makeRandomNums();

        persistGame(result, random);
    }

    public int askRegame() {
        System.out.println(END_OF_GAME);
        System.out.println(ASK_RESTART);

        int input = Integer.parseInt(Console.readLine());

        return input;
    }

    private void persistGame(String result, int[] random) {
        while (!result.equals("3스트라이크")) {
            System.out.print("숫자를 입력해주세요 : ");
            result = scoreJudge.judge(random);
            System.out.println(result);
            scoreJudge.initializer();
        }
    }
}
