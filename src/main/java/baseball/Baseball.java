package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Baseball {
    private int gameState = 1;
    private String compareResult = "";
    private final String answerResult = "3스트라이크";
    private List<Integer> answerNumber = new ArrayList<>();
    private List<Integer> userNumber = new ArrayList<>();

    public void setAnswerNumber(){
        answerNumber.clear();
        int digitNumber = 0;
        while (answerNumber.size()<3){
            digitNumber = Randoms.pickNumberInRange(1,9);
            if(!answerNumber.contains(digitNumber))answerNumber.add(digitNumber);
        }

    }
    public void checkInputUserName(String inputUserName){
        userNumber.clear();
        if(inputUserName.length()!=3){
            throw new IllegalArgumentException();
        }
        Character firstNum = inputUserName.charAt(0);
        Character secondNum = inputUserName.charAt(1);
        Character thirdNum = inputUserName.charAt(2);
        if(Character.isDigit(firstNum)&&!userNumber.contains(firstNum-'0')){
            userNumber.add(firstNum-'0');
        }
        if(Character.isDigit(firstNum)&&!userNumber.contains(secondNum-'0')){
            userNumber.add(secondNum-'0');
        }
        if(Character.isDigit(firstNum)&&!userNumber.contains(thirdNum-'0')){
            userNumber.add(thirdNum-'0');
        }
        if(userNumber.size()!=3){
            throw new IllegalArgumentException();
        }
    }
    public void setUserNumber(){
        userNumber.clear();
        String inputUserName = Console.readLine();
        checkInputUserName(inputUserName);
    }
}
