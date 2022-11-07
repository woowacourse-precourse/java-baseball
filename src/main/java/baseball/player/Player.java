package baseball.player;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private static List<Integer> inputNum;
    private static final String INPUT_STRING = "숫자를 입력해주세요 : ";
    private static final int GAME_STRING_LENGTH = 3;
    private static final int INT_MIN = 1;
    private static final int INT_MAX = 9;

    public void inputNumber(){
        System.out.print(INPUT_STRING);
        String input = Console.readLine();
        checkValidateInput(input);
        setInputNum(input);
    }

    public void checkValidateInput(String input){
        List<Integer> tempInput = new ArrayList<>();

        isInt(input);

        tempInput = changeInputToList(input);

        checkInputLength(tempInput);
        isIntRange(tempInput);
        isDifferent(tempInput);
    }

    public List<Integer> changeInputToList(String input){
        List<Integer> inputList = new ArrayList<>();

        for (int i = 0; i < input.length(); i++){
            inputList.add(input.charAt(i) - '0');
        }

        return inputList;
    }

    public void isInt(String input){
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    public void checkInputLength(List<Integer> input){
        if (input.size() != GAME_STRING_LENGTH){
            throw new IllegalArgumentException("세자리 숫자를 입력해주세요.");
        }
    }

    public void isIntRange(List<Integer> input){
        for (int i = 0; i < input.size(); i++){
            if(input.get(i) < INT_MIN || input.get(i) > INT_MAX){
                throw new IllegalArgumentException("0을 제외한 1~9 숫자만 입력해주세요.");
            }
        }
    }

    public void isDifferent(List<Integer> input){
        Set<Integer> inputSet = new HashSet<>(input);

        if(inputSet.size() != input.size()){
            throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
        }
    }

}
