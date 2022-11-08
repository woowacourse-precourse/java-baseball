package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import baseball.view.UserView;


public class BaseballGame {
    private static final int CNT_NUMBER = 3;
    private static final UserView userView = new UserView();

    private int strike = 0;
    private int ball = 0;
    private boolean restart = false;

    public BaseballGame(){}

    public void StartGame(){
        ComputerNumber computerNumber = new ComputerNumber();
        UserNumber userNumber = new UserNumber();

        computerNumber.setRandom();

        while(!restart){
            String input = userView.UserAnswer();
            userNumber.setDigits(input);

             strike = 0;
             ball = 0;

             for(int i=0;i<CNT_NUMBER;i++){
                 //점수 계산 함수 먼저 구현
             }

        }

    }


}
