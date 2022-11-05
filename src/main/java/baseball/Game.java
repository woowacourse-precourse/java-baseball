package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {

    public List<Integer> makeUserNumberToList(int userNumber){
        List<Integer> listNumber = new ArrayList<>();
        while(userNumber < 0){
            listNumber.add(userNumber%10);
            userNumber /= 10;
        }
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

    public int gameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        computer.makeAnswerNumber();

        while(computer.getStrike() != 3){
            System.out.print("숫자를 입력해주세요 : ");

            String userNumberString = readLine();
            checkExceptionFromUserInputData(userNumberString);

            try {
                List<Integer>userNumber = makeUserNumberToList(Integer.parseInt(userNumberString));
                computer.checkNumberCount(userNumber);
                System.out.println(computer.countResultString());
            } catch (IllegalArgumentException e) {
                return -1;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return 1;
    }

}
