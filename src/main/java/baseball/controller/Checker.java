package baseball.controller;

import baseball.model.Baseball;

import java.util.HashMap;
import java.util.List;

public class Checker {
    private static final String STRIKE = "strike";
    private static final String BALL = "ball";
    private HashMap<String,Integer> result;
    private Baseball computer;


    public HashMap<String,Integer> start(Baseball computer, Baseball user){
        this.computer = computer;
        result = compare(user);
        return result;
    }

    public HashMap<String,Integer> compare(Baseball userNumber){
        HashMap<String, Integer> result = new HashMap<>();
        for(int index = 0; index < userNumber.size(); index++){
            if(isStrike(index,userNumber)){
                result.put(STRIKE, result.getOrDefault(STRIKE,0) + 1);
                continue;
            }
            if(isBall(index,userNumber)){
                result.put(BALL, result.getOrDefault(BALL,0) + 1);
            }
        }
        return result;
    }


    public boolean isStrike(int index, Baseball user){
        if(computer.hasNumber(index,user.getNumber(index))){
            return true;
        }
        return false;
    }

    public boolean isBall(int index, Baseball user){
        List<Integer> computerBaseballNumber = computer.getBaseballNumber();
        if(computerBaseballNumber.contains(user.getNumber(index))){
            return true;
        }
        return false;
    }
}