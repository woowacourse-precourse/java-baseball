package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computerNumber = makeRandomNumber();

        String userNumber = inputUserNumber();
    }

    public static List<Integer> makeRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) { //중복 방지
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static String inputUserNumber(){
        System.out.println("숫자를 입력해주세요 :");
        String userNumber = Console.readLine();

        return userNumber;
    }

}
