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
        getPlayerNumber();
    }

    private void getPlayerNumber(){
        player = new ArrayList<>();
        String input = Console.readLine();
        int number = Integer.parseInt(input);
        for(int i = LENGTH_OF_NUMBER-1; i >= 0; i--) {
            int digit = number % 10;
            number = number / 10;
            player.add(0, digit);
        }
    }

}
