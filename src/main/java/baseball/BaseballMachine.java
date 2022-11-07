package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballMachine {

    /**
     * 컴퓨터가 가지는 숫자
     * 랜덤으로 중복되는거 없게 지급
     */
    public static List<Integer> computerSet(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    /**
     * 사용자가 사용하는 숫자
     * 입력받고 유효한 숫자인지 확인
     */
    public static List<Integer> inputUserNumber(){
        List<Integer> user = new ArrayList<>();
        String userInput = Console.readLine();
        //유효한 건지 확인
        if(checkNumber(userInput)){
            user = stringToInt(userInput);
        }
        else{
            throw new IllegalArgumentException();
        }
        return user;
    }

    public static boolean checkNumber(String userInput){
        String check = "";
        //3자리 확인
        if(userInput.length() != 3){
            return false;
        }
        //숫자인지 확인
        for(char single : userInput.toCharArray()){
            if(single < 49 || single > 57)
                return false;
        }
        //중복되는 숫자 확인
        for(char single : userInput.toCharArray()){
            if(check.indexOf(single) != -1){
                return false;
            }
            check += single;
        }

        return true;
    }

    //String을 List<Integer>로 바꾸는 함수
    public static List<Integer> stringToInt(String str){
        List<Integer> integerList = new ArrayList<>();
        for(char single : str.toCharArray()){
            int tmp;
            tmp = single - '0';
            integerList.add(tmp);
        }
        return integerList;
    }
}
