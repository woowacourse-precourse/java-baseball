package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String user_ball_number;

        System.out.println(RandomBallNum());

        System.out.print("숫자를 입력해주세요 : ");
        user_ball_number = user_Input();

    }

    public static List<Integer> RandomBallNum() {
        List<Integer> BallNum = new ArrayList<>(3);
        while (BallNum.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!BallNum.contains(randomNum)) {
                BallNum.add(randomNum);
            }
        }

        return BallNum;
    }

    public static String user_Input(){
        String user_ball_number;
        user_ball_number = Console.readLine();
        if(user_ball_number.length() != 3 || !user_ball_number.matches("^[0-9]*$")){
            throw new IllegalArgumentException();
        }

        return user_ball_number;
    }
}
