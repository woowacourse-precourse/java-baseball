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
    public void compareAnswerUserNum(){
        int strikeCount = 0;
        int ballCount = 0;
        compareResult="";
        for(int index = 0;index<3;index++){
            if(userNumber.get(index)==answerNumber.get(index))strikeCount++;
            else if(answerNumber.contains(userNumber.get(index)))ballCount++;
        }
        if(strikeCount==3){
            compareResult = answerResult;
            System.out.println(compareResult);
        }
        else if(strikeCount == 0 ){
            System.out.println("낫싱");
        }
        else if(strikeCount<3){
            System.out.println(ballCount+"볼 "+strikeCount+"스트라이크 ");
        }

    }
    public void startBaseball(){
        do{
            setUserNumber();
            compareAnswerUserNum();

        }while (compareResult!=answerResult);
    }
    public void checkContinue(){
        gameState = Integer.parseInt(Console.readLine());
    }

    public void startGame(){
        while (gameState==1){
            setAnswerNumber();
            startBaseball();
            checkContinue();
        }
        System.out.println("게임 종료");
    }
}
