package baseball;

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



}
