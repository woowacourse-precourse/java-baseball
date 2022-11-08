package baseball.service;

import java.util.List;

import static baseball.constant.Message.*;
import static baseball.constant.constants.RESTART;

public class BaseballGame {


    public void start(){
        System.out.println(GAME_START_MESSAGE);
        while(true){
            startGame();
            if(!restartGame()){
                System.out.println(PROGRAM_END_MESSAGE);
                break;
            }
        }
    }
    private void startGame(){
        Computer comService = new Computer();
        List<Integer> computer = comService.getRandomNumber();

        while(true) {
            User userService = new User();

            System.out.println(USER_INPUT_MESSAGE);
            String userStr = userService.userInput();
            List<Integer> user = userService.getUserNumber(userStr);


            Referee refereeService = new Referee();
            int[] count = refereeService.getJudgementCount(computer,user);
            String printStrikeAndBall = refereeService.printStrikeAndBall(count);
            System.out.println(printStrikeAndBall);

            if(printStrikeAndBall.equals("3스트라이크")){
                System.out.println(GAME_END_MESSAGE);
                break;
            }
        }
    }
    private boolean restartGame(){
        System.out.println(GAME_RESTART_MESSAGE);

        User user = new User();
        String userInput = user.userRestartInput();

        return userInput.equals(RESTART);
    }
}
