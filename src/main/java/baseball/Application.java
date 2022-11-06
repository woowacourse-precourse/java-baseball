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

            String result = compareBall(computerBall, userBall);
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

    public static String compareBall(List<Integer> computerBall, List<Integer> userBall){
        int strike = 0;
        int ball = 0;

        for(int i = 0; i < computerBall.size(); i++){
            int computerNum = computerBall.get(i);
            int userNum = userBall.get(i);

            if(computerBall.contains(userNum) && computerNum == userNum){
                strike++;
            }else if(computerBall.contains(userNum) && computerNum != userNum){
                ball++;
            }
        }

        if(strike == 0 && ball == 0) {
            return "낫싱";
        }else if(ball == 0){
            return strike + "스크라이크";
        }else if(strike == 0){
            return ball + "볼";
        }

        return ball + "볼 " + strike + "스크라이크";
    }
}
