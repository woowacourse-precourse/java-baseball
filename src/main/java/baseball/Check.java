package baseball;

import java.util.Arrays;
import java.util.List;
public class Check {
    private static final int LENGTH = 3;
    private static final String ZERO = "0";

    public static void isEmptyComputer(List<Integer> computerList){
        if(!computerList.isEmpty()){
            computerList.clear();
        }
    }
    public static void isEmptyUserList(List<Integer> userNumberList){
        if(!userNumberList.isEmpty()){
            userNumberList.clear();
        }
    }
    public static void checkInputNumberDuplicate(List<Integer> userInput){
        for(int i=0;i<LENGTH-1;i++){
            if(userInput.get(i) == userInput.get(i+1)){
                Exception.inputNumberDuplicate();
            }
        }
    }
    public static void checkinputSize(String[] splitStr){
        if(splitStr.length < LENGTH || splitStr.length > LENGTH){
            Exception.inputSizeException();
        }
    }
    public static void checkInputZero(String str){
        boolean iszero = (str != null && str.contains(ZERO));
        if(iszero){
            Exception.inputIsZeroException();
        }
    }
    public static void checkNumberOnly(String str){
        try{
            Integer.parseInt(str);
        }catch (NumberFormatException e){
            Exception.numberOnlyException();
        }
    }
    public static void compareAnswer(List<Integer> user,List<Integer> computer){
        int strikeCount ;
        int ballCount ;
        strikeCount = findStrike(user,computer);
        if(!isThreeStrikeCount(strikeCount)){
            ballCount = findBall(user,computer);
            Print.resultPrint(strikeCount,ballCount);
            Game.gameStart(computer);
        }
    }
    public static boolean isThreeStrikeCount(int strikeCount){
        boolean isThreeStrike = false;
        if(strikeCount==LENGTH){
            System.out.println(LENGTH+Print.STRIKE);
            Game.getNewGame();
            isThreeStrike = true;
        }
        return isThreeStrike;
    }
    public static int findStrike(List<Integer> user, List<Integer> computer){
        int strikeCount = 0;
        for(int i=0;i<LENGTH;i++){
            if(user.get(i)==computer.get(i)){
                strikeCount++;
            }
        }
        return strikeCount;
    }
    public static int findBall(List<Integer> user,List<Integer> computer){
        int ballCount = 0;
        for(int i=0;i<LENGTH;i++){
            if(user.contains(computer.get(i)) && computer.get(i)!=user.get(i)){
                ballCount++;
            }
        }
        return ballCount;

    }
}
