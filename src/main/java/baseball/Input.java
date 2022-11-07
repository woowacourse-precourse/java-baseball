package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    String input;

    Input(){
        String input = Console.readLine();
        this.input =input;
    }

    public List<Integer> stringTointList(){
        List<Integer> argList = new ArrayList<>();
        String[] argsTemp = input.split("");
        for(String args: argsTemp) argList.add(Integer.valueOf(args));
        return argList;
    }

    public boolean is1to10(){
        return input.replace("^[1-9]","").length() == 3;
    }
    public boolean isnumbersize(){
        return input.length() == 3;
    }

    public boolean isdifferentNumber(){ //123
        String[] num = input.split("");
        if(num[0].equals(num[1])) return false;
        if(num[0].equals(num[2])) return false;
        if(num[1].equals(num[2])) return false;
        else return true;
    }

    public boolean isNumber(){
        return input.chars().allMatch(Character::isDigit);
    }
    public void inputCheck(){
        if(!is1to10()) throw new IllegalArgumentException("1부터 9사이의 값이 아닙니다.");
        if(!isdifferentNumber()) throw new IllegalArgumentException("중복된 값이 포함되어 있습니다.");
        if(!isNumber()) throw new IllegalArgumentException("숫자가 아닌 다른 값이 포함되어 있습니다.");
        if(!isnumbersize()) throw new IllegalArgumentException("3자리를 초과하여 입력하였습니다.");
    }





}
