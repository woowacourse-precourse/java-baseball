package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.mockito.stubbing.Answer;

public class Application {

    //  중복되지 않는 랜덤한 3자리 수 선택
    public static List<Integer> Answer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static String UserInput(){
        String userInputString = Console.readLine();
        return userInputString;
    }

    //  ball strike 판별
    public static List<Integer> BallStrike(List<Integer> answer, List<Integer> user) {
        List<Integer> ballstrike = new ArrayList<>(2);
        int ball_cnt = 0;
        int strike_cnt = 0;
        for(int i = 0; i < user.size(); i++) {
            for(int j = 0; j < answer.size(); j++) {
                if(user.get(i) == answer.get(j) && i ==j) {
                    strike_cnt ++;
                } else if (user.get(i) == answer.get(j) && i != j) {
                    ball_cnt ++;
                }
            }
        }
        ballstrike.add(ball_cnt);
        ballstrike.add(strike_cnt);
        return ballstrike;
    }

    public static void main(String[] args) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();
        List<Integer> ballstrike = Arrays.asList(0,0);
        int user_input = Integer.MAX_VALUE;

        game :while(true) {
            answer = Answer();
            try {
                System.out.print("숫자 입력 : ");
                user_input = Integer.parseInt(UserInput());

                if ( user_input < 100 || user_input > 999) {
                    throw new IllegalArgumentException();
                }

                user.add(user_input / 100);
                user.add((user_input % 100) / 10);
                user.add(user_input % 10);

                if( user.contains(0)) {
                    throw new IllegalArgumentException();
                }

                if ( user.get(0) == user.get(1) || user.get(1) == user.get(2) || user.get(0) == user.get(2)) {
                    throw new IllegalArgumentException();
                }

            } catch (IllegalArgumentException e) {
                System.out.println("error");
                break game;
            }

            ballstrike = BallStrike(answer, user);

        }


    }
}