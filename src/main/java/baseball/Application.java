package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = Game.makeRandomNumberList();
        Game.oneGameSet(computer);

        restartOrEndTheGame();
    }

    public static class Game {
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

        public static String oneGameSet(List<Integer> computer) {
            boolean flag = true;
            while (flag){
                List<String> player = inputPlayerAnswerList();
                String hint = checkAnswer(computer, player);
                System.out.println(hint);
                if (hint.contains("3스트라이크")){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    flag = false;
                }
            }
            return "종료";
        }

        private static List<String> inputPlayerAnswerList(){
            System.out.print("숫자를 입력해주세요 : ");
            String myAnswer = Console.readLine();

            String[] splitAnswer = myAnswer.split("");
            ArrayList<String> answerList = new ArrayList<>(Arrays.asList(splitAnswer));

            if (!(answerList.size() == 3)){
                throw new IllegalArgumentException();
            }
            else {
                System.out.println(myAnswer);
            }

            return answerList;
        }

        public static String checkAnswer(List<Integer> computer, List<String> player){
            int strike = 0;
            int ball = 0;
            for(int i = 0; i < 3; i++){
                if (Objects.equals(computer.get(i), Integer.valueOf(player.get(i)))){
                    strike++;
                }
                if (!Objects.equals(computer.get(i), Integer.valueOf(player.get(i)))
                        && computer.contains(Integer.valueOf(player.get(i)))){
                    ball++;
                }
            }
            int nothing = (3 - strike - ball);
            return giveHint(strike, ball, nothing);
        }

        private static String giveHint(int strike, int ball, int nothing){
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
    }

    private static void restartOrEndTheGame(){
        boolean flag = true;
        while (flag){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restartOrEnd = Console.readLine();
            System.out.println(restartOrEnd);
            if (Objects.equals(restartOrEnd, "1")){
                List<Integer> computerturn = Game.makeRandomNumberList();
                Game.oneGameSet(computerturn);
            }
            else {
                flag = false;
                System.out.println("게임을 종료합니다.");
            }
        }
    }
}