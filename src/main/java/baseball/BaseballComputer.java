package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballComputer {
    private List<Integer> computerNumber = new ArrayList<>(); // 3자리수
    private List<Integer> userNumber = new ArrayList<>();

    public void startGameMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void endGameMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

    public void inputNumberToComputerMessage(){
        System.out.print("숫자를 입력해 주세요: ");
    }

    public String userInputNumberInGame(){
        return Console.readLine();
    }


    public void createRandomNumber() {
        computerNumber.clear();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNumber.contains(randomNumber)){
                computerNumber.add(randomNumber);
            }
        }
    }

    public void checkHitNumber() {

    }

    public List<Integer> getRandomNumber() {
        return this.computerNumber;
    }

    public int restartOrEnd(){
        return 0;
    }

    public void printHitStatus(){

    }
}
