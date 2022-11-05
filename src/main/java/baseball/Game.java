package baseball;

import java.util.ArrayList;
import java.util.List;

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

    public void gameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        computer.makeAnswerNumber();

        while(computer.getStrike() != 3){
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer>userNumber = makeUserNumberToList(readLine());

            computer.checkNumberCount(userNumber);
            System.out.println(computer.countResultString());
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
