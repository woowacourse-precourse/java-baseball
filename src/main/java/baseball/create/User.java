package baseball.create;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String userNum;
    public String getUserNum(){
        return userNum;
    }

    public User(String userNum){
        if(isLengthThree(userNum) && isUserNumber(userNum) && isDup(userNum)){
            this.userNum = userNum;
        }
    }

    public boolean isUserNumber(String num){
        for(int i=0; i<num.length(); i++){
            isAllDigit(num, i);
        }
        return true;
    }

    public boolean isAllDigit(String num, int idx) throws IllegalArgumentException{
        if(!Character.isDigit(num.charAt(idx))){
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean isLengthThree(String num) throws IllegalArgumentException{
        if(num.length() != 3){
            throw new IllegalArgumentException();
        }
        return true;
    }
    public boolean isDup(String num) throws IllegalArgumentException{
        Set<Character> set = new HashSet<>();
        for(int i=0; i<num.length(); i++){
            set.add(num.charAt(i));
        }
        if(set.size() != num.length()){
            throw new IllegalArgumentException();
        }
        return true;
    }
}

