package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String answer = makeAnswer();
        System.out.println(answer);
        String input = input();
        System.out.println(input);
        System.out.println(checkStrikeBall(answer, input));
    }

    public static String makeAnswer(){
        String result = "";
        List<Integer> nums = new ArrayList<Integer>();

        while (true){
            if (nums.size() == 3) break;
            int rand_num = Randoms.pickNumberInRange(1, 9);
            if (!nums.contains(rand_num)) nums.add(rand_num);
        }
        for (Integer num: nums) result += Integer.toString(num);

        return result;
    }

    public static Boolean checkSameInput(String str){
        if (str.charAt(0) == str.charAt(1) || str.charAt(1) == str.charAt(2) || str.charAt(0) == str.charAt(2))
            return true;
        return false;
    }
    public static String input() throws IllegalArgumentException{
        String result = camp.nextstep.edu.missionutils.Console.readLine();

        if (!result.matches("[1-9][1-9][1-9]") ||
             result.length() != 3 ||
             checkSameInput(result))
            throw new IllegalArgumentException();

        return result;
    }

    public static int[] countStrikeBall(String answer, String user){
        int ball = 0, strike = 0;

        for (int i=0; i<3; i++){
            if (answer.charAt(i) == user.charAt(i))
                strike++;
            else if (answer.contains(user.subSequence(i,i+1))){
                ball++;
            }
        }
        return new int[]{ball, strike};
    }
    public static void printCheckResult(int ball, int strike){
        String result = "";

        if (ball != 0)
            result+=Integer.toString(ball)+"볼";
        if (strike != 0)
            result+= " " + Integer.toString(strike)+"스트라이크";
        if (result.length() == 0)
            result = "낫싱";

        System.out.println(result.strip());
    }

    public static Boolean checkStrikeBall(String answer, String user){
        int[] count = countStrikeBall(answer, user);
        int ball = count[0], strike = count[1];

        printCheckResult(ball, strike);

        if (strike == 3) return true;
        return false;
    }
}
