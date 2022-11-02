package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Boolean moreGame = true;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (moreGame){
            try {
                playGame();
                moreGame = playOrExit();
            }
            catch (IllegalArgumentException e){
                System.err.println("잘못된 입력입니다.\n"+
                        "종료합니다.");
                System.exit(0);
            }

        }
    }

    public static Boolean playOrExit() throws IllegalArgumentException{
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userInput = readLine();

        if (userInput.equals("1")){
            return true;
        }
        else if(userInput.equals("2")){
            System.exit(1);
        }
        else{
            throw new IllegalArgumentException();
        }
        return true;
    }
    public static Boolean playGame(){
        String answer = makeAnswer();
        String userInput = "";

        do{
            userInput = input();

        } while(!checkStrikeBall(answer, userInput));

        return false;
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
        return str.charAt(0) == str.charAt(1) || str.charAt(1) == str.charAt(2) || str.charAt(0) == str.charAt(2);
    }
    public static String input() throws IllegalArgumentException{
        System.out.print("숫자를 입력해주세요 : ");
        String result = readLine();
        System.out.println(result.toCharArray());
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
            result+= ball +"볼";
        if (strike != 0)
            result+= " " + strike +"스트라이크";
        if (result.length() == 0)
            result = "낫싱";

        System.out.println(result.strip());
    }

    public static Boolean checkStrikeBall(String answer, String user){
        int[] count = countStrikeBall(answer, user);
        int ball = count[0], strike = count[1];

        printCheckResult(ball, strike);

        return strike == 3;
    }
}
