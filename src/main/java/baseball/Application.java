package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    //[컴퓨터] 임의의 3자리 숫자 저장
    public static List<Integer> makeNumber(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    //[플레이어] 서로 다른 3개의 숫자 입력
    public static List<Integer> input(List<Integer> inputNumber){
        String input = Console.readLine();
        for(int i=0; i<input.length(); i++){
            inputNumber.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }
        return inputNumber;
    }
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();

        while (true) {

            List<Integer> inputNumber = new ArrayList<>();

            makeNumber(computer);

            System.out.print("숫자를 입력해주세요 : ");
            input(inputNumber);
        }
    }
}
