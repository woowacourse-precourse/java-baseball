package baseball;

import java.util.List;

public class InputException {

    public void checkInput(String input){
        BaseballGame baseballGame = new BaseballGame();
        if(checkSize(input)){
            throw new IllegalArgumentException("3자리 숫자만 입력 가능");
        }
    }

    public boolean checkSize(String input){
        boolean check = false;
        if (input.length() != 3){

            check = true;
        }
        return check;
    }
}
