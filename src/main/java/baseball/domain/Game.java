package baseball.domain;

import baseball.view.InputView;

import java.util.List;

import static baseball.view.OutputView.gameRestartOrStop;
import static baseball.view.OutputView.gameResult;

public class Game {
    private final Computer computer;
    private final User user;
    private final Referee referee;

    public Game(){
        user = new User();
        computer = new Computer();
        referee = new Referee();
    }

    public void startGame(){
        computer.createThreeNumbers();
        while (true){
            List<Integer> computerList = computer.getComputer();
            int userNumber = user.stringToInteger(InputView.getInput());

            List<Integer> userList = user.reverseListOrder(user.numbersToList(userNumber));

            referee.initBallAndStrike();

            int strike = referee.countStrike(computerList, userList);
            int ball = referee.countBall(computerList, userList);

            String gameResult = gameResult(ball, strike);
            System.out.println(gameResult);

            if(gameRestartOrStop(gameResult)){
                break;
            }
        }
    }
}
