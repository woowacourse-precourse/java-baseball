package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Inputnumber {
    String arg;

    Inputnumber(){

    }
    Inputnumber(String[] args){
        for(String arg : args){
           this.arg +=arg;
        }
    }

    public List<Integer> stringTointList(){
        List<Integer> argList = new ArrayList<>();
        String[] argsTemp = arg.split("");
        for(String args: argsTemp) argList.add(Integer.valueOf(args));
        return argList;
    }

    public boolean is1to10(){
        for(int i =0; i<arg.length();i++){
            int checkNumber = Integer.valueOf(arg.substring(i));
            if(checkNumber<1 || checkNumber>9) return false;
        }
        return true;
    }

    public boolean isdifferentNumber(){ //123
        String sub = arg.substring(0);
        String compare = arg.substring(1);
        if(sub.equals(compare)) return false;

        compare = arg.substring(2);
        if(sub.equals(compare)) return false;

        sub = arg.substring(1);
        compare = arg.substring(2);
        if(sub.equals(compare)) return false;
        return true;
    }

    public boolean isNumber(){
        return arg.chars().allMatch(Character::isDigit);
    }
    public void inputCheck(){
        if(!is1to10()) new IllegalArgumentException("1부터 9사이의 값이 아닙니다.");
        if(!isdifferentNumber()) new IllegalArgumentException("중복된 값이 포함되어 있습니다.");
        if(!isNumber()) new IllegalArgumentException("숫자가 아닌 다른 값이 포함되어 있습니다.");
    }





}
