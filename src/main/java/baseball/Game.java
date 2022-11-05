package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {

    public List<Integer> makeUserNumberToList(String userNumber){
        List<Integer> listNumber = List.of(
                userNumber.charAt(0) - '0', userNumber.charAt(1) - '0', userNumber.charAt(2) - '0');
        return listNumber;
    }

    public void checkExceptionFromUserInputData(String userNumber){

        Set<Character> setNumber = new HashSet<>();

        if(userNumber.length() != 3){
            throw new IllegalArgumentException();
        }

        for(int i=0; i<3; i++){
            if(userNumber.charAt(i) < '1' && userNumber.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
            setNumber.add(userNumber.charAt(i));
        }

        if(setNumber.size() != 3) {
            throw new IllegalArgumentException();
        }


    }

    public void gameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        computer.makeAnswerNumber();

        while(computer.getStrike() != 3){
            System.out.print("숫자를 입력해주세요 : ");

            String userNumberString = readLine();
            checkExceptionFromUserInputData(userNumberString);

            computer.clearNumberCount();
            List<Integer>userNumber = makeUserNumberToList(userNumberString);
            computer.checkNumberCount(userNumber);
            System.out.println(computer.countResultString());

        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
