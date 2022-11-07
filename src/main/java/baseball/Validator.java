package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Validator {

    public List<Integer> getInput(){
        System.out.println(Message.INPUT_ASK.getMessage());
        String inputNum = Console.readLine();
        return convertor(inputNum);
    }

    public List<Integer> convertor(String inputNum){
        List<Integer> playerAnswer = new ArrayList<>();
        if (validateTotal(inputNum)){
            for (int i=0;i<inputNum.length();i++){
                playerAnswer.add(inputNum.charAt(i)-'0');
            }
        }
        return playerAnswer;
    }

    public boolean checkDuplicate(String playerNum){
        List<Integer> playerAnswer = new ArrayList<>();
        for(int i=0;i<playerNum.length();i++){
            playerAnswer.add(playerNum.charAt(i)-'0');
        }
        Set<Integer> inputSet = new HashSet<>(playerAnswer);
        return inputSet.size() != playerNum.length();
    }

    public boolean checkLength(String playerNum){
        return playerNum.length() == Range.DIGIT;
    }

    public boolean checkNum(String playerNum){
        boolean check = false;
        for (int i=0;i<playerNum.length();i++){
            int idxNum = playerNum.charAt(i) - '0';
            if (idxNum<=9 && idxNum>=1){
                check = true;
            }else{
                check = false;
            }
        }
        return check;
    }

    public boolean validateTotal(String playerNum){
        return checkDuplicate(playerNum) && checkLength(playerNum) && checkNum(playerNum);
    }

}
