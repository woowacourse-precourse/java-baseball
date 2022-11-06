package baseball.logic;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Inputnumber {
    public Exception exception;
    public List<Integer> playerInput = new ArrayList<>();

    public List<Integer> getNum(){
        List<Integer> convertNum = convertNum();
        if(exception.inputException(convertNum)){
            throw new IllegalArgumentException();
        }
        playerInput = convertNum;
        return playerInput;
    }

    public List<Integer> convertNum(){
        System.out.println("숫자를 입력해주세요 : ");
        String playerInput = Console.readLine();
        List<Integer> Numlist = new ArrayList<>();

        for(int i=0; i<playerInput.length(); i++){
            Numlist.add(playerInput.charAt(i)-'0');
        }
        return Numlist;
    }
}
