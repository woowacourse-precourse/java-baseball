package baseball;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static Boolean isThree(String number){
        if(number.length()==3)
            return true;
        return false;
    }

    public static Boolean isValid(List<Integer> usernumArray){
        if(usernumArray.size() == usernumArray.stream().distinct().count()){
           return true;
        }
        return false;
    }
    public static List<Integer> RandomNum() {
       List <Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> UserNum(String usernum){
        List<Integer> usernumArray = new ArrayList<>();
        for(int i=0; i<usernum.length(); i++)
            usernumArray.add(usernum.charAt(i) - '0');
        return usernumArray;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        if(!(isThree(number) || isValid(UserNum(number)))){
            throw new IllegalArgumentException();
        }


    }
}
