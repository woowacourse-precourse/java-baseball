package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Set;
import java.util.HashSet;

public class User {
    static final char INPUT_LOWER_BOUND='1';
    static final char INPUT_UPPER_BOUND='9';

    String value;

    User(){
    }

    public void inputUser(){
        System.out.print("숫자를 입력해주세요 : ");
        this.value=Console.readLine();
        checkInputException();
    }

    boolean checkRange(){
        for(int idx=0;idx<3;idx++){
            char digit=this.value.charAt(idx);
            if(digit<INPUT_LOWER_BOUND||digit>INPUT_UPPER_BOUND){
                return true;
            }
        }
        return false;
    }

    boolean checkOverlap(){
        Set<Character> overlap=new HashSet<Character>();

        for(int idx=0;idx<3;idx++){
            overlap.add(this.value.charAt(idx));
        }

        if(overlap.size()<3){
            return true;
        }
        else{
            return false;
        }
    }

    void checkInputException(){
        if(value.length()!=3|| checkRange()|| checkOverlap()){
            IllegalArgumentException exception=new IllegalArgumentException("입력 오류");
            throw exception;
        }
    }
}
