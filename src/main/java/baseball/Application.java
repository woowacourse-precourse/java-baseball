package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO : 힌트가 잘 출력되는지 테스트
        List<Integer> computer = makeRandomNumberList();
        List<String> player = inputPlayerAnswerList();
        String hint = checkAnswerAndGiveHint(computer, player);
        System.out.println(hint);

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

    private static List<String> inputPlayerAnswerList(){
        System.out.println("숫자를 입력해주세요 : ");
        String myAnswer = Console.readLine();

        String[] splitAnswer = myAnswer.split("");
        ArrayList<String> answerList = new ArrayList<>(Arrays.asList(splitAnswer));
        return answerList;
    }

    public static String checkAnswerAndGiveHint(List<Integer> computer, List<String> player){
        int strike = 0;
        int ball = 0;
        for(int i = 0; i < 3; i++){
            if (Objects.equals(computer.get(i), Integer.valueOf(player.get(i)))){
                strike++;
            }
            if (!Objects.equals(computer.get(i), Integer.valueOf(player.get(i))) && computer.contains(Integer.valueOf(player.get(i)))){
                ball++;
            }
        }
        int nothing = (3 - strike - ball);

        if (nothing != 3){
            return (ball + "볼 " + strike + "스트라이크");
        }
        else {
           return ("낫싱");
        }
    }

}
