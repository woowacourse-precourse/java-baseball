package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

class Game {
    public void startGame() {
        // 컴퓨터 객체
        Computer computer = new Computer();

        // 플레이어 객체 생성
        Player player = new Player();

        // 컴퓨터 랜덤 숫자 생성 ->
        computer.makeRandomNumber();
        System.out.println("컴퓨터 랜덤숫자 : " + computer.myNumberList);


        while (true) {
            // 사용자로부터 숫자 입력받기
            player.inputNumber();
            System.out.println("사용자 핸덤숫자 : " + player.myInputNumber);

            System.out.println("사용자 랜덤 숫자 무한 인풋...");
            return;

            // 숫자 비교하기


            // 출력하기


            // 출력 결과값이 다 맞췄다면 break;
        }
    }

    public void compareNumbers(List<Integer> comNum, List<Integer> userNum) {

    }

    public void printCompareResult() {
        System.out.println("test : 프린트함수 호출");
    }

}

class Computer {
    public List<Integer> myNumberList = new ArrayList<>();

    public void makeRandomNumber() {
        while (myNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!myNumberList.contains(randomNumber)) {
                myNumberList.add(randomNumber);
            }
        }
    }
}

class Player {
    List<Integer> myInputNumber = new ArrayList<>();

    public void inputNumber() {
        myInputNumber.clear();

        String inputNum = Console.readLine();
        for (int i = 0; i < 3; i++) {
            int num = ((int) inputNum.charAt(i) % 10);
            myInputNumber.add(num);
        }
    }

}


public class Application {
    public static void main(String[] args) {
        boolean checkPlayGame = true;

        Game game = new Game();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (checkPlayGame) {
            // 게임 시작
            game.startGame();

            // 게임 종료 조건 확인
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restartCheckNum = Console.readLine();
            if (restartCheckNum == "2") {
                checkPlayGame = false;
            }
        }


    }
}
