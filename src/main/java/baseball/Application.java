package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO : 반복해서 3개의 숫자를 모두 맞히면 “3개의 숫자를 모두 맞히셨습니다! 게임 종료” 라는 말과 함께 종료
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
            if (strike == 3) {
                return null;
            }
            else if (ball == 0) {
                return (strike + "스트라이크");
            }
            else if (strike == 0) {
                return (ball + "볼 ");
            }
            else {
            return (ball + "볼 " + strike + "스트라이크");
            }
        }
        else {
           return ("낫싱");
        }
    }

}
