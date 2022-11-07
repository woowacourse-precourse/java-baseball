package util;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Inputer {

    private boolean flag;

    public Inputer() {
        this.flag = false;
    }

    public List<Integer> getInput() throws IllegalArgumentException{
        String rareinput = Console.readLine();
        if(!flag) {
            return stopOrGo(rareinput);
        }

    }

    private List<Integer> stopOrGo(String input){
        if(Integer.parseInt(input) == 1) {
            return List.of(1);
        }
        else if(Integer.parseInt(input) == 2) {
            return List.of(2);
        }
        else {
            throw new IllegalArgumentException("Please input right arguments!");
        }
    }

}
