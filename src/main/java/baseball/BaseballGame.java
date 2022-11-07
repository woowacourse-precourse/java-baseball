package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.mockito.internal.matchers.Null;

import java.util.ArrayList;

public class BaseballGame {
    private int strikeNumber = 0;
    private int ballNumber = 0;

    public void SetStrikeNumber(BaseballNumber oppositeNumber, BaseballNumber myNumber){
        ArrayList<Integer> oppositeList = oppositeNumber.getNumbers();
        ArrayList<Integer> myList = myNumber.getNumbers();

        strikeNumber = 0;
        for(int i = 0; i < 3; i++){
            if(oppositeList.get(i) == myList.get(i))
                strikeNumber++;
        }
    }

    public void SetBallNumber(BaseballNumber oppositeNumber, BaseballNumber myNumber){
        ArrayList<Integer> oppositeList = oppositeNumber.getNumbers();
        ArrayList<Integer> myList = myNumber.getNumbers();
        int currentOppositeNumber;

        ballNumber = 0;
        currentOppositeNumber = oppositeList.get(0);
        for(int i = 0; i < 3; i++){
            if(currentOppositeNumber == myList.get(i)) {
                ballNumber++;
                break;
            }
        }
        currentOppositeNumber = oppositeList.get(2);
        for(int i = 0; i < 3; i++){
            if(currentOppositeNumber == myList.get(i)){
                ballNumber++; break;
            }
        }
        currentOppositeNumber = oppositeList.get(2);
        for(int i = 0; i < 3; i++){
            if(currentOppositeNumber == myList.get(i)){
                ballNumber++; break;
            }
        }
    }

    public void PrintResult(){
        if(strikeNumber == 0 && ballNumber == 0)
            System.out.println("낫싱");
        if(strikeNumber == 0 && ballNumber > 0)
            System.out.println(ballNumber + "볼");
        if(strikeNumber > 0 && ballNumber == 0)
            System.out.println(strikeNumber + "스트라이크");
        if(strikeNumber > 0 && ballNumber > 0)
            System.out.println(ballNumber + "볼 " + strikeNumber + "스트라이크");
    }

    public boolean isRestart(){
        int restartNumber = Integer.valueOf(Console.readLine());

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        if(restartNumber == 1)
            return true;
        if(restartNumber == 2)
            return false;
        if(restartNumber != 1 || restartNumber != 2)
            throw new IllegalArgumentException();
        return false;
    }

    public void StartGame(){
        BaseballNumber OppositeNumber = new BaseballNumber();
        BaseballNumber MyNumber = new BaseballNumber();

        System.out.println("숫자 야구 게임을 시작합니다.");
        OppositeNumber.setNumbersByRandom();

        while(true){
            MyNumber.setNumbers();
            SetStrikeNumber(OppositeNumber, MyNumber);
            SetBallNumber(OppositeNumber, MyNumber);
            PrintResult();

            if(strikeNumber == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}
