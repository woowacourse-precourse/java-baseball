package baseball.domain;

import baseball.utils.ChangeToChar;
import baseball.utils.GetInput;

import java.util.ArrayList;
import java.util.List;

public class Player {
    final ChangeToChar changeToChar = new ChangeToChar();
    final GetInput getInput = new GetInput();
    private int strike;
    private int ball;
    private char[] input;
    public Player(){
        init();
    }
    public void init(){
        strike = 0;
        ball = 0;
    }
    public void inputGenerate(){
        int inputNumber = getInput.getInput();
        errorCheck(inputNumber);
        input = changeToChar.changetoChar(inputNumber);
        init();
    }
    public void errorCheck(int number) throws IllegalArgumentException{
        if (number< 123) throw new IllegalArgumentException();
        List<Integer> numList = new ArrayList<>();
        for(int i =0; i< 3; i++) {
            if (numList.contains(number%10)==true || number%10 == 0){
                throw new IllegalArgumentException();
            }
            numList.add(number%10);
            number = number/10;
        }
    }
    public char[] getInput() { return input; }
    public int getBall() {
        return ball;
    }
    public int getStrike(){
        return strike;
    }
    public void plusStrike() { strike++; }
    public void plusBall() { ball++; }
}
