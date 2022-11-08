package baseball;

import java.util.ArrayList;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Character.isDigit;

public class Player {
    private ArrayList<Integer> playerNumberList; // 플레이어 숫자(서로 다른 임의의 숫자 세 개)를 담고 있는 Arraylist

    public void inputPlayerNumber() // 플레이어 숫자 입력
    {
        String input = readLine();
        if(isValidInput(input)){
            playerNumberList =convertInputToArrayList(input);
        }
    }

    private boolean isValidInput(String input) // 유효한 입력인지 검증
    {
        if ( input.length() != 3 ) {
            throw new IllegalArgumentException("Your input is wrong.");
        }

        ArrayList<Character> exist = new ArrayList<>();
        for(int i=0; i<input.length(); i++){
            if(!(isDigit(input.charAt(i)) && input.charAt(i)!='0') && !exist.contains(input.charAt(i))){
                throw new IllegalArgumentException("Your input is wrong.");
            }
            exist.add(input.charAt(i));
        }
        return true;
    }

    private ArrayList<Integer> convertInputToArrayList(String input) // 입력 받은 문자열을 ArrayList로 변환
    {
        ArrayList<Integer> numberList=new ArrayList<>();
        for(int i=0; i<input.length(); i++){
            numberList.add(input.charAt(i)-'0');
        }
        return numberList;
    }

    public ArrayList<Integer> getPlayerNumberList()
    {
        return playerNumberList;
    }
}
