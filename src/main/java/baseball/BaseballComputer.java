package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballComputer {
    private List<Integer> computerNumber = new ArrayList<>(); // 3자리수

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

    public int init(){
        inputNumberToComputerMessage();
        String answer = userInputNumberInGame();

        if(!checkHitNumber(answer)){
            init();
        }

        printRestartOrEnd();
        int choice = inputRestartOrEnd();

        if(1< choice && choice < 3){
            System.out.println("out of number");
            return 0;
        }

        if(choice == 1){
            init();
        }
        return 0;
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

    public boolean checkHitNumber(String answer) {
        return true;
    }

    public List<Integer> getRandomNumber() {
        return this.computerNumber;
    }

    public int inputRestartOrEnd(){
        String beforeIntChange = Console.readLine();
        int afterIntChange = Integer.parseInt(beforeIntChange);
        return afterIntChange;
    }

    public void printRestartOrEnd(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printHitStatus(){

    }
}
