package baseball.service;

import java.util.List;

import static baseball.constant.Message.*;

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
        //Computer 난수 생성
        Computer comService = new Computer();
        List<Integer> computer = comService.getRandomNumber();

        while(true) {
            User userService = new User();
            //User 입력
            System.out.println(USER_INPUT_MESSAGE);
            String userStr = userService.userInput();
            List<Integer> user = userService.getUserNumber(userStr);

            //Computer User 비교
            Referee refereeService = new Referee();
            int[] count = refereeService.getJudgementCount(computer,user);
            String printStrikeAndBall = refereeService.printStrikeAndBall(count);
            System.out.println(printStrikeAndBall);

            //스트라이크 3개가 나오면 break;
            if(printStrikeAndBall.equals("3스트라이크")){
                System.out.println(GAME_END_MESSAGE);
                break;
            }
        }
    }
    private boolean restartGame(){
        System.out.println(GAME_RESTART_MESSAGE);
        //사용자 입력
        User user = new User();
        String userInput = user.userRestartInput();

        //1 -> Restart, 2-> Exit
        if(userInput.equals("1"))
            return true;
        return false;
    }
}
