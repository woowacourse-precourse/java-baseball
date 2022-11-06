package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computerBall = makeRandomBall();

        while (true){
            List<Integer> userBall = StringToIntList(Console.readLine());

        }
    }

    public static List<Integer> makeRandomBall(){
        return Randoms.pickUniqueNumbersInRange(1,9,3);
    }

    public static List<Integer> StringToIntList(String user){
        List<Integer> userBall = new ArrayList<>();

        for(int i = 0; i < user.length(); i++){
            userBall.add(user.charAt(i) - '0');
        }

        return userBall;
    }
}
