package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballComputer {
    private List<Integer> computerNumber = new ArrayList<>(); // 3자리수
    ChangeType changeType = new ChangeType();
    GameMessage gameMessage = new GameMessage();

    private String userInputNumberInGame(){
        return Console.readLine();
    }

    public void start(){
        createRandomNumber();
        init();
    }

    private void init(){
        gameMessage.inputNumberToComputerMessage();
        String answer = userInputNumberInGame();

        if(!checkHitNumber(answer)){
            init();
        }

        gameMessage.printRestartOrEnd();
        int choice = inputRestartOrEnd();

        if(1 > choice || choice > 2){
            System.out.println("out of number");
            return ;
        }

        if(choice == 1){
            start();
        }

        return ;
    }

    private void createRandomNumber() {
        computerNumber.clear();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNumber.contains(randomNumber)){
                computerNumber.add(randomNumber);
            }
        }
    }

    private boolean checkHitNumber(String answer) {
        String [] splitWord = answer.split("");
        int [] splitNumber = changeType.StringArrToIntArr(splitWord);
        List<Integer> checkHitNumber = new ArrayList<>();
        int strike = 0;
        int ball = 0;

        //strike
        for(int i = 0; i < splitNumber.length; i++){
            if(splitNumber[i] == computerNumber.get(i)){
                strike++;
            }
        }

        // 게임 승리
        if(strike == 3){
            gameMessage.endGameMessage();
            return true;
        }

        //ball
        for(int i = 0; i < splitNumber.length; i++){
            if(splitNumber[i] != computerNumber.get(i) && computerNumber.contains(splitNumber[i])){
                ball++;
            }
        }

        checkHitNumber.add(ball);
        checkHitNumber.add(strike);


        printHitStatus(checkHitNumber);

        return false;
    }

    private int inputRestartOrEnd(){
        String beforeIntChange = Console.readLine();
        return changeType.StringToInt(beforeIntChange);
    }

    private void printHitStatus(List<Integer> hitStatus){
        //아무것도 없을 때
        if(hitStatus.get(0) == 0 && hitStatus.get(1) == 0){
            System.out.println("낫싱");
        }

        //ball만 있을 때
        if(hitStatus.get(1) == 0 && hitStatus.get(0) != 0){
            System.out.println(hitStatus.get(0) + "볼");
        }

        //strike만 있을 때
        if(hitStatus.get(0) == 0 && hitStatus.get(1) != 0){
            System.out.println(hitStatus.get(1) + "스트라이크");
        }

        //둘 다 있을 때
        if(hitStatus.get(0) != 0 && hitStatus.get(1) != 0){
            System.out.println(hitStatus.get(0) + "볼 " + hitStatus.get(1) + "스트라이크");
        }
    }
}
