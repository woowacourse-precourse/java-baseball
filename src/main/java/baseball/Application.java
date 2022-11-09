package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static List<Integer> makeNumber(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static List<Integer> input(){
        List<Integer> inputNumber = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        //세자리 숫자 이외의 입력 시
        if (input.isBlank()) {
            System.out.println("아무것도 입력하지 않았습니다.");
            throw new IllegalArgumentException();
        } else if (input.length() != 3) {
            System.out.println("3자리 숫자를 입력하시오.");
            throw new IllegalArgumentException();
        }
        //세자리 숫자 입력 시
        for(int index=0; index<3; index++){
            int eachNumber = Integer.parseInt(String.valueOf(input.charAt(index)));
            if( inputNumber.contains(eachNumber)) {
                System.out.println("중복된 숫자를 입력했습니다.");
                throw new IllegalArgumentException();
            } else {
                inputNumber.add(eachNumber);
            }
        }
        return inputNumber;
    }
    public static HashMap<String, Integer> caseCheck(List<Integer> computer, List<Integer>inputNumber) {
        HashMap<String, Integer> gameResult = new HashMap<>();
        int strike = 0;
        int ball = 0;
        for(int index=0; index<3; index++){
            if( inputNumber.get(index) == computer.get(index) ) strike ++;
            else if ( computer.contains(inputNumber.get(index)) ) ball++;
        }
        gameResult.put("strike", strike);
        gameResult.put("ball", ball);
        return gameResult;
    }
    public static void output(int strike, int ball) {
        if ( ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if ( strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } else if ( ball == 0 ){
            System.out.println(strike+"스트라이크");
        } else if ( strike == 0 ){
            System.out.println(ball+"볼");
        } else {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();

        while (true) {

            List<Integer> inputNumber;
            HashMap<String, Integer> gameResult;
            int strike = 0;
            int ball = 0;

            makeNumber(computer);

            inputNumber = input();

            gameResult = caseCheck(computer, inputNumber);
            strike = gameResult.get("strike");
            ball = gameResult.get("ball");
            output(strike, ball);

            //정답 맞췄을 시, 게임 종료 혹은 반복 가능
            if ( strike == 3) {
                String repeat = Console.readLine();
                if (repeat.equals("2")) break;
                else computer.clear();
            }
        }
    }

}
