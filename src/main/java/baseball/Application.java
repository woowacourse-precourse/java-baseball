package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
public class Application {
    public static void main(String[] args) {

    }
}

class Computer {
    List<Integer> pickRandomNumber(){
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
    public static int getInputNumber(){
        String input = Console.readLine();
        int inputNumber = Integer.parseInt(input);
        System.out.println(inputNumber);
        return inputNumber;
    }
}

class game {
    public int ball;
    public int strike;

    static boolean nbrInAnswer(Integer nbr, List<Integer> answer){
        if (answer.contains(nbr)) {
            return true;
        }
        return false;
    }


}

class print {
    static void nothing(){
        System.out.println("낫싱");
    }

    static void threeStrike(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
