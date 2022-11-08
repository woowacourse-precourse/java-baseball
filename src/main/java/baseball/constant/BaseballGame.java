package baseball.constant;

import static baseball.service.Message.GAME_START_MESSAGE;
import static baseball.service.Message.PROGRAM_END_MESSAGE;

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
        while(true) {
            //User 입력

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
