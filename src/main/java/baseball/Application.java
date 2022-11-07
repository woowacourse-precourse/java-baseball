package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    class BaseBallGame{

    }
    public static void main(String[] args) {
        //기능 테스트
        int randNum = Randoms.pickNumberInRange(0,999);
        System.out.println("RandomNum : " + randNum);
        String inputData = Console.readLine();
        System.out.println("InputData : " + inputData);
    }
}
