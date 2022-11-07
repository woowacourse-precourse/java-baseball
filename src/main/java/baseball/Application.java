package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static ArrayList<String> ComPuterNumber() {

        ArrayList<String> computer_num = new ArrayList<>();

        while (computer_num.size() < 3) {
            String randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!computer_num.contains(randomNumber)) {
                computer_num.add(randomNumber);
            }
        }
        return (computer_num);
    }

    public static String UserNumber() {

        System.out.print("숫자를 입력해주세요: ");
        String user_num = Console.readLine();

        if (user_num.length() != 3) {
            throw new IllegalArgumentException("숫자 3개를 입력해야 합니다!");
        }

        for (int i = 0; i < user_num.length(); i++) {
            if (!Character.isDigit(user_num.charAt(i))) {
                throw new IllegalArgumentException("숫자에 문자가 들어있습니다!");
            }
        }

        return (user_num);
    }

    public static List<Integer> CompareNumber(List<String> computer, String user) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            String my_number = Character.toString(user.charAt(i));

            if ((computer.contains(my_number)) && (computer.indexOf(my_number) == i)) {
                strike += 1;
            } else if (computer.contains(my_number)) {
                ball += 1;
            }
        }
        List<Integer> ball_strike = List.of(ball, strike);
        return (ball_strike);
    }

    public static String ResultAnswer(List<Integer> ballStrike) {
        String choice = "";

        int ball = ballStrike.get(0);
        int strike = ballStrike.get(1);

        if (ball + strike == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            choice = Console.readLine();

        } else if (ball != 0 && strike != 0) {
            System.out.print(Integer.toString(ball) + "볼 ");
            System.out.println(Integer.toString(strike) + "스트라이크");
        } else if (ball != 0 && strike == 0) {
            System.out.println(Integer.toString(ball) + "볼");
        } else if (ball == 0 && strike != 0) {
            System.out.println(Integer.toString(strike) + "스트라이크");
        }

        if(strike == 3) {
            if (!(choice.equals("1") || choice.equals("2"))) {
                throw new IllegalArgumentException("1 아니면 2를 입력해주세요!");
            }
        }

        return choice;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int regame_code_num = 0;
        System.out.println("숫자 야구 게임을 시작합니다.");
        ArrayList<String> computer_num = ComPuterNumber();

        while (true) {

            if(regame_code_num == 1) {
                computer_num = ComPuterNumber();
                regame_code_num = 0;
            }
            //System.out.println("컴퓨터 번호: " + computer_num);

            String user_num = UserNumber();

            List<Integer> ball_strike = CompareNumber(computer_num, user_num);

            String regame_or_endgame = ResultAnswer(ball_strike); // 입력한 결과 확인

            if(regame_or_endgame.equals("1")) {
                regame_code_num = 1;
            } else if (regame_or_endgame.equals("2")) {
                break;
            }
        }
    }
}