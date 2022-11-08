package baseball.domain;

import baseball.view.InputView;

public class BaseBallGame {
    private final UserBall userBall;
    private final ComputerBall computerBall;
    private final ThrowBall throwBall;

    public BaseBallGame() {
        userBall = new UserBall();
        computerBall = new ComputerBall();
        throwBall = new ThrowBall();
    }

    public void playGame(){
        computerBall.generateComputerNum();
        userBall.generateUserBall(InputView.inputUserBall());

        while (throwBall.decideBall(computerBall.computerNumber, userBall.userNumber)){
            userBall.generateUserBall(InputView.inputUserBall());
        }

        String coin = InputView.printGameStartOrStop();

        if (coin.equals("1")){
            playGame();
        }
    }
}
