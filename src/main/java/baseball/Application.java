package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true){
            List<Integer> computer = startGame();

            int endGame = game(computer);

            if (endStatus(endGame)){
                break;
            }
        }
    }

    private static int game(List<Integer> computer) {
        int endGame = 0;

        while (true) {
            System.out.println("숫자를 입력해주세요 :");

            List<Integer> user = userNumber();

            int strike = strike(computer, user);
            int ball = ball(computer, user);

            String hint = hint(strike, ball);

            System.out.println(hint);

            if(threeStrike(strike)){
                endGame = reGame();
            }

            if (endGame == 1 || endGame == 2){
                break;
            } else if (endGame ==0) {
                continue;
            } else {
                throw new IllegalArgumentException();
            }
        }
        return endGame;
    }

    private static List<Integer> startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        return computerNumber();
    }

    private static List<Integer> computerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List<Integer> userNumber() {
        String input = Console.readLine();
        List<Integer> user = new ArrayList<>();

        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < input.length(); i++){
            user.add(input.charAt(i) - '0');
        }
        return user;
    }

    static int strike(List<Integer> computer, List<Integer> user) {
        int strike = 0;

        for (int i = 0; i < user.size(); i++) {
            if (Objects.equals(computer.get(i),user.get(i))){
                strike += 1;
            }
        }
        return strike;
    }

    static int ball(List<Integer> computer, List<Integer> user){
        int ball = 0;

        for (int i = 0; i < user.size(); i++) {
            if (Objects.equals(computer.get(i), user.get(i))){
                continue;
            } else if (user.contains(computer.get(i))){
                ball += 1;
            }
        }
        return ball;
    }

    static String hint(int strike, int ball){
        String hint;

        if (strike == 0 && ball == 0){
            hint = "낫싱";
        }else if (strike > 0 && ball == 0){
            hint = strike + "스트라이크";
        }else if (strike == 0 && ball > 0){
            hint = ball + "볼";
        }else {
            hint = ball + "볼" + strike + "스트라이크";
        }
        return hint;
    }

    private static  boolean threeStrike(int strike){
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private static int reGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        int endGame = Integer.parseInt(Console.readLine());

        return endGame;
    }
    private static boolean endStatus(int endGame){
        if(endGame == 2){
            return true;
        }
        return false;
    }
}
