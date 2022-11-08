package baseball.domain;

import baseball.message.PromptMessage;
import baseball.validation.Validation;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    static boolean notFoundTheRightAnswer;

    public void start() {
        Computer computer = new Computer();
        User user;
        System.out.println(PromptMessage.WELCOME_MESSAGE);
        notFoundTheRightAnswer = true;
        while (true) {
            if (notFoundTheRightAnswer) computer.chooseThreeNumbers();
            System.out.print(PromptMessage.ENTER_NUMBERS);
            user = new User();
            user.pickANumber();
            Ball ball = new Ball(computer.getNumbersChosenByTheComputer(), user.getUser_selectedNumbers());
            ball.judgeWhichBallItIs();
            boolean guessTheRightAnswer = ball.determineWhetherTheBallIsAStrikeOrABall();
            if (!guessTheRightAnswer) {
                notFoundTheRightAnswer = false;
            } else if (!restartOrQuitTheGame()) {
                break;
            } else {
                computer = new Computer();
                notFoundTheRightAnswer = true;
            }

        }
    }

    private boolean restartOrQuitTheGame() {
        System.out.println(PromptMessage.endOfGameMessage);
        System.out.println(PromptMessage.START_OR_END);
        String answer = Console.readLine();
        Validation validation = new Validation();
        int certifiedNumbers = validation.validationRestartOrShutDown(answer);
        return certifiedNumbers != 2;
    }
}