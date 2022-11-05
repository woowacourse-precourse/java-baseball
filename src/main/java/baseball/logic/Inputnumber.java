package baseball.logic;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Inputnumber {

    public List<Integer> playerInput = new ArrayList<>();

    public List<Integer> inputNum(){
        System.out.println("숫자를 입력해주세요 : ");
        String playerInput = Console.readLine();
        return convertInt(playerInput);
    }

    private List<Integer> convertInt(String input){
        for(int i=0; i<input.length(); i++){
            playerInput.add(input.charAt(i)-'0');
        }
        return playerInput;
    }
}
