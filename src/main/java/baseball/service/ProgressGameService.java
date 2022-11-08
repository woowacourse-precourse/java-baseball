package baseball.service;

import baseball.repository.BaseballResult;
import baseball.utils.PlayerInputValidator;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class ProgressGameService {
    private PlayerInputValidator playerInputValidator;

    public ProgressGameService() {
        playerInputValidator = new PlayerInputValidator();
    }

    public void playGame(List<Integer> computerAnswer) {
        boolean correctAnswer = false;
        while (!correctAnswer) {
            String playerAnswerInput = InputView.requestPlayerInput();
            List<Integer> playerInputAnswer = playerInputValidator.validatePlayerAnswerInput(playerAnswerInput);
            correctAnswer = new BaseballResult().progressJudgement(computerAnswer, playerInputAnswer);
        }
    }

    public boolean endGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerReplayInput = Console.readLine();
        playerInputValidator.validateReplayInputValidation(playerReplayInput);
        return playerReplayInput.equals("1");
    }


}