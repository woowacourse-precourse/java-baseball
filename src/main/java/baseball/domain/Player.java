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
        strike = 0;
        ball = 0;
    }
    public void inputGenerate(){
        int inputNumber = getInput.getInput();
        errorCheck(inputNumber);
        input = changeToChar.changetoChar(inputNumber);
    }
    public void check(Game game, int cur) {
        for(int i = 0; i < 3; ++i) {
            if (game.getNumber()[i] == input[cur] && i==cur) {
                strike++;
                return;
            }else if(game.getNumber()[i]==input[cur]){
                ball++;
                return;
            }
        }
    }
    public void printBaseBallCount() {
        if (strike == 3) {
            System.out.println("3스트라이크");
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        }
    }
    public void errorCheck(int number) throws IllegalArgumentException{
        if (number< 123) throw new IllegalArgumentException();
        List<Integer> numList = new ArrayList<>();
        int digit = 100;
        for(int i =0; i< 3; i++) {
            if (numList.contains(number)==true){
                throw new IllegalArgumentException();
            }
            numList.add(number%10);
            number = number/10;
        }
    }
    public int getBall() {
        return ball;
    }
    public int getStrike(){
        return strike;
    }
}
