package baseball.domain;

import baseball.message.PromptMessage;

import java.util.ArrayList;

public class Ball {
    private ArrayList<Integer> numbersChosenByTheComputer;
    private ArrayList<Integer> numberSelectedByTheUser;

    private static int strike;
    private static int ball;

    public Ball(ArrayList<Integer> numbersChosenByTheComputer, ArrayList<Integer> numbersChosenByUser) {
        this.numbersChosenByTheComputer = numbersChosenByTheComputer;
        this.numberSelectedByTheUser = numbersChosenByUser;
    }

    public void judgeWhichBallItIs(){
        strike = 0;
        ball = 0;
        for(int i=0;i<3;i++){
            if(!checkIfItIsAStrike(numbersChosenByTheComputer.get(i), numberSelectedByTheUser.get(i))){
                checkIfItIsABall(numberSelectedByTheUser.get(i));
            }
        }
    }

    private boolean checkIfItIsAStrike(int chosenByTheComputer, int selectedByTheUser) {
        if(chosenByTheComputer == selectedByTheUser){
            strike++;
            return true;
        }
        return false;
    }

    private void checkIfItIsABall(int selectedByTheUser) {
        if(numbersChosenByTheComputer.contains(selectedByTheUser)){
            ball++;
        }
    }

    public boolean determineWhetherTheBallIsAStrikeOrABall(){
        if(strike > 0 && ball > 0){
            System.out.println(ball + PromptMessage.BALL + " " + strike + PromptMessage.STRIKE);
        }
        else if(strike < 3 && strike > 0 && ball == 0){
            System.out.println(strike + PromptMessage.STRIKE);
        }
        else if(strike == 0 && ball > 0){
            System.out.println(ball + PromptMessage.BALL);
        }
        else if(strike == 3){
            System.out.println(strike + PromptMessage.STRIKE);
            return true;
        }
        else{
            System.out.println(PromptMessage.NOTHING);
        }
        return false;
    }

    public static int getStrike() {
        return strike;
    }

    public static int getBall() {
        return ball;
    }
}
