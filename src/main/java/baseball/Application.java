package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> opponent = new ArrayList<>();
        opponent = generateOpponent();

        String player = receiveInputOfPlayer();
    }

    public static List<Integer> generateOpponent(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static String receiveInputOfPlayer(){
        System.out.print("숫자를 입력해주세요 : ");
        try {
            String randomNumber = Console.readLine();
            return randomNumber;
        }catch(IllegalStateException exception){
            throw new IllegalStateException(exception);
        }
    }
}

