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

    public ArrayList<Integer> getUserInput(){
        return userInput;
    }
}
