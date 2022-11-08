package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    List<Integer> integerList;

    public void inputIntegerList(){
        String string = Console.readLine();
        this.integerList = getUserIntegerList(string);
    }
    public void checkUserInput(String userString){
        if(userString.charAt(0)=='0'){
            throw new IllegalArgumentException();
        }
        if(userString.length()!=3){ //이런 건 메소드로 나누는게 좋은가?
            throw new IllegalArgumentException();
        }
        for(int i=0;i<userString.length();i++){
            char c = userString.charAt(i);
            if(c<'0' || c >'9'){
                throw new IllegalArgumentException();
            }
        }
    }
    public List<Integer> getUserIntegerList(String userString) {
        checkUserInput(userString);
        return StringToIntegerList(userString);
    }
    public List<Integer> StringToIntegerList(String string){
        List<Integer> integerList = new ArrayList<>();
        for(int i=0;i<string.length();i++){
            integerList.add(string.charAt(i)-'0');
        }
        return integerList;
    }
}
