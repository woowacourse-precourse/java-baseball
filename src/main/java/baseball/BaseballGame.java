package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final int LENGTH_OF_NUMBER = 3;
    private Rival computer;
    private List<Integer> player;

    BaseballGame(){
        computer = new Rival();
    }

    public void play(){
        computer.createNumber();
        try{
            getPlayerNumber();
        }catch(IllegalArgumentException e){
            System.out.println("잘못된 값을 입력하셨습니다. 게임 종료");
        }
    }

    private void getPlayerNumber() throws IllegalArgumentException {
        player = new ArrayList<>();
        String input = Console.readLine();
        if(input.length() != LENGTH_OF_NUMBER){
            throw new IllegalArgumentException();
        }
        int number = Integer.parseInt(input);
        for(int i = LENGTH_OF_NUMBER-1; i >= 0; i--) {
            int digit = number % 10;
            if(!isUniqueDigit(digit)){
                throw new IllegalArgumentException();
            }
            player.add(0, digit);
            number = number / 10;
        }
    }

    private boolean isUniqueDigit(int digit){
        for(int i = 0; i < player.size(); i++){
            if(digit == player.get(i)){
                return false;
            }
        }
        return true;
    }

}
