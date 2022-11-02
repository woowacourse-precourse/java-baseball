package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int GameSwitch=1;
        List<Integer> computer=getNumberBaseball();
        while(GameSwitch==1){

        }
        // TODO: 프로그램 구현
    }
    public static List<Integer> getNumberBaseball(){

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            checkDuplicate(randomNumber,computer);
        }
        return computer;
    }
    public static void checkDuplicate(int randomNumber,List<Integer> computer){
        if(!computer.contains(randomNumber)){
            computer.add(randomNumber);
        }
    }
    public static void playGame(List<Integer> computer){
        String tryNumber=Console.readLine();
        List<Integer> user=transformInteger(tryNumber);

    }
    public static List<Integer> transformInteger(String tryNumber){
        List<Integer> Number=new ArrayList<>();
        for(int i=0;i<3;i++){
        Number.add(Character.getNumericValue(tryNumber.charAt(i)));}

        return  Number;
    }
   /* public static String checkNumber(List<Integer> user,List<Integer> computer){

    }*/
    public static int strikeCount(List<Integer> user,List<Integer> computer){
        int strikeCount=0;
        for(int i=0;i<3;i++){
            strikeCount+=strikeCheck(user.get(i),computer.get(i));
        }
        return strikeCount;
    }
    public static int strikeCheck(int user, int computer){
        if(user==computer){
            return 1;
        } return 0;
    }
    public static int ballCount(List<Integer> user,List<Integer> computer){
        int ballCount=0;
        for(int i=0;i<3;i++){
            ballCount+=ballCheck(user.get(i),computer,i);
        }
        return ballCount;
    }
    public static int ballCheck( int user,List<Integer> computer,int index) {
        if (computer.contains(user)) {
            return ballorstrikeCheck(user,computer,index);
        }
        return 0;
    }

    public static int ballorstrikeCheck(int user,List<Integer> computer,int index){
        if (index != computer.indexOf(user)) {
            return 1;
        }
        return 0;
    }
}

