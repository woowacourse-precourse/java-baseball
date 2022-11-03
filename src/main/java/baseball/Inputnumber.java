package baseball;

import java.util.ArrayList;
import java.util.List;

public class Inputnumber {

    public List<Integer> stringTointList(String[] args){
        List<Integer> argList = new ArrayList<>();
        for(String arg : args){
            argList.add(Integer.valueOf(arg));
        }
        return argList;
    }

}
