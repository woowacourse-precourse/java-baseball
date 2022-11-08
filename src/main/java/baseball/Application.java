package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = makeRandomNumberList();

        // TODO : 입력 받은 숫자를 분리하여 리스트에 넣기

        System.out.println("숫자를 입력해주세요 : ");
        String myAnswer = Console.readLine();
        System.out.println("myAnswer : " + myAnswer);
        System.out.println("computer : " + computer);
    }

    public static List<Integer> makeRandomNumberList(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
