package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.Constant.Score;
import baseball.model.UserNumber;
import baseball.view.UserView;

import static baseball.model.Constant.Score.*;


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
             CheckScore(computerNumber,userNumber);

            System.out.println(this);
            if(strike == CNT_NUMBER){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                ReStartGame(computerNumber);
            }

        }

    }

    private void CheckScore(ComputerNumber computerNumber, UserNumber userNumber){

        for(int i=0;i<CNT_NUMBER;i++){
            Score score = computerNumber.getScore(userNumber.getDigit(i),i);

            if(score == STRIKE){
                strike++;
            }else if(score == BALL){
                ball++;
            }

        }

    }

    private void ReStartGame(ComputerNumber computerNumber){
        String input = userView.RestartAnswer();
        if(input.equals("2")){
            restart = true;
        }else{
            computerNumber.setRandom();
        }
    }

    @Override
    public String toString(){
        if(strike == 0 && ball == 0){
            return NOTHING.getValue();
        }

        StringBuilder sb = new StringBuilder();
        if(ball > 0){
            sb.append(ball).append(BALL.getValue()).append(" ");
        }

        if(strike > 0){
            sb.append(strike).append(STRIKE.getValue());
        }

        return sb.toString();
    }


}
