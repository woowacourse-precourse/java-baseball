package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Inputnumber {
    String[] args;

    Inputnumber(){

    }
    Inputnumber(String[] args){
        this.args = args;
    }

    public List<Integer> stringTointList(){
        List<Integer> argList = new ArrayList<>();
        for(String arg : args){
            argList.add(Integer.valueOf(arg));
        }
        return argList;
    }

    public boolean is1to10(List<Integer> list){
        for(int number : list){
            if(number <1 || number >9) return false;
        }
        return true;
    }



}
