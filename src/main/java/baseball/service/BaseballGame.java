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
            String user = userService.userInput(); // ->List<Integer> 형태로 바꿔야함

            //Computer User 비교

            //스트라이크 3개가 나오면 break;
        }
    }
    private boolean restartGame(){
        //사용자 입력

        //1 -> Restart, 2-> Exit
        return false;
    }
}
