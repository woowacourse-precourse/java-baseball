package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameSet {

    private final Answer answer;
    private final Input input;
    private final GameResult gameResult;

    public GameSet(Answer answer, Input input, GameResult gameResult) {
        this.answer = answer;
        this.input = input;
        this.gameResult = gameResult;
    }

    public void startGame() {
        answer.makeAnswers();
        while (true) {
            input.makeInputs();
            gameResult.setGameResult(answer.getAnswers(), input.getInputs());
            if (gameResult.getResult()) {
                break;
            }
            gameResult.resetGameResult();
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = Integer.parseInt(readLine());
        if (choice == 1) {
            startGame();
        }
    }
}
