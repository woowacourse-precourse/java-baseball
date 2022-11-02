package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int GameSwitch=1;
        List<Integer> computer=GetNumberBaseball();
        while(GameSwitch==1){

        }
        // TODO: 프로그램 구현
    }
    public static List<Integer> GetNumberBaseball(){

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            CheckDuplicate(randomNumber,computer);
        }
        return computer;
    }
    public static void CheckDuplicate(int randomNumber,List<Integer> computer){
        if(!computer.contains(randomNumber)){
            computer.add(randomNumber);
        }
    }
    public static void playgame(List<Integer> computer){
        String tryNumber=Console.readLine();
    }
    public static List<Integer> transformInteger(String tryNumber){
        List<Integer> Number=new ArrayList<>();
        for(int i=0;i<Number.size();i++){
        Number.add(Character.getNumericValue(tryNumber.charAt(i)));}

        return  Number;
    }
}

