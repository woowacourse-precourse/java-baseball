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





}
