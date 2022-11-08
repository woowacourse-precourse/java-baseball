package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        boolean again = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(again){
            List<Integer> computer = createRandomNum();
            String result = "";

            while(!result.equals("3스트라이크")){
                List<Integer> player = playerNum();
                wrongAnswer(computer, player);
                result = judge(computer, player);
                System.out.println(result);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            again = playAgainOrNot();
        }
    }

    public static List<Integer> createRandomNum(){
        List<Integer> computerNum = new ArrayList<>();
        while(computerNum.size() < 3){
            int randomNum = pickNumberInRange(1, 9);
            if(!computerNum.contains(randomNum)){
                computerNum.add(randomNum);
            }
        }
        return computerNum;
    }

    public static List<Integer> playerNum(){
        System.out.println("숫자를 입력해주세요 : ");
        String inputNumber = readLine();
        List<Integer> playerNumber = new ArrayList<>();

        for(String number : inputNumber.split("")){
            playerNumber.add(Integer.parseInt(number));
        }
        return playerNumber;
    }

    public static int howManySame(List<Integer> computerNum, List<Integer> playerNum){
        int result = 0;
        for(int i = 0; i < playerNum.size(); i++){
            if(computerNum.contains(playerNum.get(i)))
                result += 1;
        }
        return result;
    }

    public static int howManyStrike(List<Integer>computerNum, List<Integer> playerNum){
        int strike = 0;
        for(int i = 0; i < playerNum.size(); i++){
            if(computerNum.get(i) == playerNum.get(i))
                strike += 1;
        }
        return strike;
    }

    public static String judge(List<Integer>computerNum, List<Integer> playerNum){
        int total = howManySame(computerNum, playerNum);
        int strike = howManyStrike(computerNum, playerNum);
        int ball = total - strike;

        if(total == 0){
            return "낫싱";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

    public static boolean playAgainOrNot(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        char decision = readLine().charAt(0);

        if(decision == '1'){
            return true;
        }
        return false;
    }

    public static void wrongAnswer(List<Integer>computerNum, List<Integer> playerNum) {
        if (computerNum.size() != playerNum.size())
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 종료합니다.");
    }
}