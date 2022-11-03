package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
public class Application {
    public static ArrayList<Integer> GenerateNum(){ // 숫자 생성
        ArrayList<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public static ArrayList<Integer> InputNum(){
        String playerNumString = Console.readLine();
        if (InvalidInput(playerNumString)) throw new IllegalArgumentException("Invalid input");

        char[] playerNumArray = playerNumString.toCharArray();
        ArrayList<Integer> playerNum = new ArrayList<>();

        for(char num : playerNumArray){
            playerNum.add(num - '0');
        }
        return playerNum;
    }

    public static boolean InvalidInput(String num){
        return num.length() != 3;
    }
    public static String CompareNum(ArrayList<Integer> answer, ArrayList<Integer> playerNum){
        String result = "";
        int strikeNum = Strike(answer, playerNum);
        int ballNum = Ball(answer, playerNum, strikeNum);

        if(ballNum != 0 && strikeNum != 0){
            result = ballNum + "볼" + " " + strikeNum + "스트라이크";
        }else if (ballNum == 0 && strikeNum != 0){
            result = strikeNum + "스트라이크";
        }else if (ballNum != 0){
            result = ballNum + "볼";
        }else{
            return "낫싱";
        }
        return  result;
    }

    public static int Strike(ArrayList<Integer> answer, ArrayList<Integer> playerNum){
        int strike = 0;
        for (int i = 0; i < 3; i++){
            if(Objects.equals(answer.get(i), playerNum.get(i))){
                strike += 1;
            }
        }
        return strike;
    }

    public static int Ball(ArrayList<Integer> answer, ArrayList<Integer> playerNum, int strikeNum){
        int ball = 0;
        for (Integer num : answer){
            if (playerNum.contains(num)) ball += 1;
        }
        return ball - strikeNum;
    }


    public static void main(String[] args) {
//        System.out.println(answer);

        // TODO: 프로그램 구현
    }
}
