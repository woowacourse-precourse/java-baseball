package baseball.game.support;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public List<Integer> parseClientInput(String input,Integer size){
        checkSize(input,size);
        return parserInt(input, size);
    }
    private List<Integer> parserInt(String input,Integer size){
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<input.length();i++){
            checkDigit(input, i);
            Integer number=convertCharToInt(input,i);
            checkDuplicate(result,number);
            result.add(number);
        }
        return result;
    }
    private int convertCharToInt(String input, Integer index) {
        return input.charAt(index) - '0';
    }
    private void checkDuplicate(List<Integer> result,Integer number){
        if(result.contains(number))
            throw new IllegalArgumentException();

    }
    private void checkDigit(String input,Integer index){
        if('0' > input.charAt(index) || input.charAt(index) > '9')
            throw new IllegalArgumentException();
    }
    private void checkSize(String input,Integer size){
        if(input.length()>size)
            throw new IllegalArgumentException();
    }
}
