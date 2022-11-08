package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameSet {

    private Answer answer;
    private Input input;
    private GameResult gameResult;

    public GameSet() {
        this.answer = new Answer();
        this.input = new Input();
        this.gameResult = new GameResult();
    }

    public void startGame() throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        answer.makeAnswers();

        while (!gameResult.isGameEnd()) {
            gameResult.resetGameResult();
            input.makeInputs();
            gameResult.setGameResult(input.getInputs(), answer.getAnswers());
            gameResult.getResult();
            input.resetInputs();
        }
        if (gameResult.isThreeStrike()) {
            reGame();

        }

    }

    private void reGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = Integer.parseInt(readLine());
        if (choice == 1) {
            answer.resetAnswers();
            input.resetInputs();
            gameResult.resetGameResult();
            startGame();
        }
    }
}
