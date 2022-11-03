package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static List<Integer> computerRandomNumber = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            if (computerRandomNumber.size() == 0) {
                System.out.println("숫자 야구 게임을 시작합니다.");
                computerRandomNumber = makeRandomNumber();
            }

            System.out.print("숫자를 입력해주세요 : ");
            String userInput=readLine();
            if(!checkUserInput(userInput)){
                break;
            }

        }
    }

    //컴퓨터 랜덤 숫자 생성
    static List<Integer> makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    //유저 입력 체크
    static boolean checkUserInput(String userInput){
        Set<Integer> numbersSet = new HashSet<>();
        for (int strIndex = 0; strIndex < userInput.length(); strIndex++) {
            int number=userInput.charAt(strIndex)-'0';
            numbersSet.add(number);
        }
        if(numbersSet.size()==3){
            return true;
        }
        try{
            if (userInput.equals("1")||userInput.equals("2")){
                return true;
            }
            else{
                throw new IllegalArgumentException();
            }

        }catch (IllegalArgumentException e){
            return false;
        }
    }

}
