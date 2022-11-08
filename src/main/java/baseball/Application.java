package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO : 정답이면 잘 종료되는지 테스트
        List<Integer> computer = makeRandomNumberList();
        repeatGame(computer);
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
            if (ball == 0) {
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

    public static String repeatGame(List<Integer> computer) {
        boolean flag = true;
        while (flag){
            List<String> player = inputPlayerAnswerList();
            String hint = checkAnswerAndGiveHint(computer, player);
            System.out.println(hint);
            if (hint.contains("3스트라이크")){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                flag = false;
            }
        }
        return "종료";
    }
}
