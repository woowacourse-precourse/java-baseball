package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
//    게임 시작 초기값 생성 (위치, 값)


    public static void main(String[] args) {
        //기능 테스트
//        int randNum = Randoms.pickNumberInRange(0,999);
//        System.out.println("RandomNum : " + randNum);
//        String inputData = Console.readLine();
//        System.out.println("InputData : " + inputData);

//        초기값 생성
        ArrayList<Integer> randomArray = new ArrayList<>();
        int loc = 0;
        while (loc<3){
            int randNum = Randoms.pickNumberInRange(1,9);
            if (randomArray.contains(randNum)) continue;

            randomArray.add(randNum);
            loc++;
        }
    }
}
