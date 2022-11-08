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
        List<Integer> result = null;
        if(!flag) {
            result = stopOrGo(rareinput);
        }
        if(flag) {
            result = makeInputList(rareinput);
        }

        return result;
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

    private List<Integer> makeInputList(String input) {
        List<String> preResult = List.of(input.split(""));
        ArrayList<Integer> result = new ArrayList<>();
        if(input.length() > 3 || input.length() < 1 || !isNum(input)) {
            throw new IllegalArgumentException("Please input right arguments!");
        }
        for(int i = 0 ; i < 3 ; i++) {
            result.add(Integer.parseInt(preResult.get(i)));
        }
        return result;
    }

    private boolean isNum(String input) {
        for(int i = 0 ; i < input.length() ; i++) {
            if(!Character.isDigit(input.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public void initInputer(){
        this.flag = false;
    }


}
