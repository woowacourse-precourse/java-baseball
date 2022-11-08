package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO : 힌트 출력 함수화
        List<Integer> computer = makeRandomNumberList();
        List<String> playerAnswer = inputPlayerAnswerList();

        int strike = 0;
        int ball = 0;
        for(int i = 0; i < 3; i++){
            if (Objects.equals(computer.get(i), Integer.valueOf(playerAnswer.get(i)))){
                strike++;
            }
            if (!Objects.equals(computer.get(i), Integer.valueOf(playerAnswer.get(i))) && computer.contains(Integer.valueOf(playerAnswer.get(i)))){
                ball++;
            }
        }
        int nothing = (3 - strike - ball);
        System.out.println(strike);
        System.out.println(ball);
        System.out.println(nothing);
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

    public static List<String> inputPlayerAnswerList(){
        System.out.println("숫자를 입력해주세요 : ");
        String myAnswer = Console.readLine();

        String[] splitAnswer = myAnswer.split("");
        ArrayList<String> answerList = new ArrayList<>(Arrays.asList(splitAnswer));
        return answerList;
    }

}
