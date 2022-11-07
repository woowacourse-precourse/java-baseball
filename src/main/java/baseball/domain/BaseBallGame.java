package baseball.domain;

import java.util.ArrayList;

public class BaseBallGame {

    private ArrayList<Integer> answer;
    private ArrayList<Integer> userInput;
    private int strikeCount=0;
    private int ballCount= 0;

    public BaseBallGame(ArrayList<Integer> answer){
        this.answer = answer;
    }

    public void setUserInput(ArrayList<Integer> userInput){
        this.userInput = userInput;
    }

    public void setScoreZero(){
        strikeCount=0;
        ballCount=0;
    }

    public ArrayList<Integer> getUserInput(){
        return userInput;
    }

    public ArrayList<Integer> getAnswer(){
        return answer;
    }

    public void increaseStrike(){
        strikeCount+=1;
    }

    public void increaseBall(){
        ballCount+=1;
    }

    public int getStrikeCount(){
        return strikeCount;
    }

    public int getBallCount(){
        return ballCount;
    }
}
