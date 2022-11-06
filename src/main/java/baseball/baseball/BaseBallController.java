package baseball.baseball;

import baseball.ScreenString;
import baseball.dto.BaseBallGameOutput;

public class BaseBallController {

    private BaseBallService baseBallService;
    private int doNextGame = 1;

    public BaseBallController() {
        this.baseBallService = new BaseBallService();
    }

    public void gameFlow(){
        /**
         * 게임 시작
         */

        while(doNextGame == 1){
            /**
             * 메서드를 통한 랜덤 숫자와 추리 숫자 입력 받기
             * 추리 숫자를 입력 받을 시 try catch를 이용.
             */

            /**
             * dto를 통한 service와 통신
             */


            /**
             * 게임 종료
             */
        }
    }

    private String makeGuessNumber() {
        /**
         * 추리 숫자 입력 받기
         */
        return "ok";
    }

    private String makeRandomNumber() {
        /**
         * 랜덤 숫자 만들기
         */
        return "ok";
    }

    private int endGame() {
        /**
         * 게임 종료
         */
        return 1;
    }

    private void startGame() {
        /**
         * 게임 시작
         */
    }
}
