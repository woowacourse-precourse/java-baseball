package baseball;

import java.util.*;

public class Validator {

    public static List<Integer> convertor(String inputNum){
        List<Integer> playerAnswer = new ArrayList<>();
        if (validateTotal(inputNum)){
            for (int i=0;i<inputNum.length();i++){
                playerAnswer.add(inputNum.charAt(i)-'0');
            }
        }
        return playerAnswer;
    }

    private static boolean checkDuplicate(String playerNum){
        List<Integer> playerAnswer = new ArrayList<>();
        for(int i=0;i<playerNum.length();i++){
            playerAnswer.add(playerNum.charAt(i)-'0');
        }
        Set<Integer> inputSet = new HashSet<>(playerAnswer);
        return inputSet.size() == playerNum.length();
    }

    private static boolean checkLength(String playerNum){
        return playerNum.length() == Range.DIGIT;
    }

    private static boolean checkNum(String playerNum){
        boolean check = false;
        for (int i=0;i<playerNum.length();i++){
            int idxNum = playerNum.charAt(i) - '0';
            if (idxNum<=9 && idxNum>=1){
                check = true;
            }else{
                return false;
            }
        }
        return check;
    }

    private static boolean validateTotal(String playerNum){
        if (checkDuplicate(playerNum) && checkLength(playerNum) && checkNum(playerNum)){
            return true;
        }else{
            throw new IllegalArgumentException();
        }
    }

}
