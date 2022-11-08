package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.Constant.Score;
import baseball.model.UserNumber;
import baseball.view.UserView;

import static baseball.model.Constant.Score.BALL;
import static baseball.model.Constant.Score.STRIKE;


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
                 Score score = computerNumber.getScore(userNumber.getDigit(i),i);

                 if(score == STRIKE){
                     strike++;
                 }else if(score == BALL){
                     ball++;
                 }

             }



        }

    }


}
