package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = makeRandomNumberList();

        // TODO : 숫자를 입력받아 분리한 다음 리스트에 넣는 부분을 함수화

        System.out.println("숫자를 입력해주세요 : ");
        String myAnswer = Console.readLine();

        String[] splitAnswer = myAnswer.split("");
        ArrayList<String> AnswerList = new ArrayList<>(Arrays.asList(splitAnswer));
        System.out.println("Answer : " + AnswerList);

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
