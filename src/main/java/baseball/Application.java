package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static void endGameState(){

    }

    static void compareNumber(){

    }

    static List<Integer> pickMyNum(){
        List<Integer> myNumber = new ArrayList<>();

        return myNumber;
    }

    static List<Integer> pickComputerNum(){
        List<Integer> computer = new ArrayList<>();

        return computer;
    }

    static void startGameState(){
        List<Integer> computerNum = pickComputerNum();

    }

    static void startApplicationState(){
        // 리턴값에 따라 반복 여부 결정 필요
        startGameState();
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        startApplicationState();
        System.out.println("게임 종료");
    }
}
