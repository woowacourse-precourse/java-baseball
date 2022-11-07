package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Game.ball;
import static baseball.Game.strike;
import static baseball.GameStatus.EXIT;
import static baseball.GameStatus.ON;


public class Application {
    public static void main(String[] args) {

        GameStatus gameStatus = ON;
        while (gameStatus == ON){
            List<Integer> inputNumber = User.getInputNumber();
            List<Integer> answer = Computer.pickRandomNumber();
            strike(inputNumber, answer);
            ball(inputNumber, answer);
            Print.result(ball, strike);
//             3번 스트라이크면 게임 status input 받기
//            termainte 면 game status 상태 변경



    }
}

class Computer {
    static List<Integer> pickRandomNumber(){
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3){
            int number = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(number)){
                answer.add(number);
            }
        }
        return answer;
    }
}

class User {
    public static int INPUT_LENGTH = 3;
    static List<Integer> getInputNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (input.length() > INPUT_LENGTH){
            throw new IllegalArgumentException();
        }
        for (int idx = 0; idx < INPUT_LENGTH; idx++){
            if (input.charAt(idx) < '1' || input.charAt(idx) > '9'){
                throw new IllegalArgumentException();
            }
        }
        List<Integer> inputNum = new ArrayList<>();
        for (int idx = 0; idx < INPUT_LENGTH; idx++){
            inputNum.add(input.charAt(idx) -'0');
        }
        int num1 = inputNum.get(0);
        int num2 = inputNum.get(1);
        int num3 = inputNum.get(2);
        if (num1 == num2 || num2 == num3 || num1 == num3){
            throw new IllegalArgumentException();
        }
        return inputNum;
    }

    static String getExitOrRestart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputStatus = Console.readLine();
        if (!inputStatus.equals(ON) && !inputStatus.equals(EXIT)){
            throw new IllegalArgumentException();
        }
        return inputStatus;
    }
}



}

class Game {
    public static int ball;
    public static int strike;

    public static void strike(List<Integer> input, List<Integer> answer){
        for (int idx = 0; idx < User.INPUT_LENGTH; idx++){
            if (input.get(idx) == answer.get(idx)){
                strike++;
            }
        }
    }

    public static void ball(List<Integer> input, List<Integer> answer){
        int idx = 0;
        for (int Number : input){
            if (answer.contains(Number) && answer.indexOf(Number) != idx){
                ball++;
            }
            idx++;
        }
    }
}

enum GameStatus {
    ON(1),
    EXIT(2);

    private final int value;
    GameStatus(int value){
        this.value = value;
    }
}

class Print {
    static void nothing(){
        System.out.println("낫싱");
    }

    static void threeStrike(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    static void result(int ball, int strike){
        if (strike == 3) {
            Print.threeStrike();
            return ;
        }
        if (ball == 0 && strike == 0){
            Print.nothing();
            return ;
        }
        if (ball > 0){
            System.out.print(ball + "볼 ");
        }
        if (strike > 0){
            System.out.print(strike + "스트라이크 ");
        }
        System.out.println();
        return ;
    }
}
