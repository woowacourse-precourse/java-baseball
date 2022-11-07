package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int answerNum = createRandomNum();
        while(true){

            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            inputValidator(input);

            String ballStrike = compareInput(Integer.toString(answerNum),input);
            System.out.println(ballStrike);
            if(Objects.equals(ballStrike, "1")){
                answerNum = createRandomNum();
            }
            if(Objects.equals(ballStrike, "2")){
                break;
            }

        }
    }

    public static int createRandomNum(){

        int randomNum =0;
        List<Integer> numList = new ArrayList<>();
        while(numList.size()<3){
            int newNum = Randoms.pickNumberInRange(1,9);
            if(!numList.contains(newNum)){
                numList.add(newNum);
                randomNum = randomNum*10+newNum;
            }
        }
        return randomNum;

    }

    public static boolean inputValidator(String input){


        if(input.length()!=3){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            if(input.charAt(i)<'1'|| input.charAt(i)>'9'){
                throw new IllegalArgumentException();
            }
        }
        if(input.charAt(0)==input.charAt(1)||input.charAt(1)==input.charAt(2)||input.charAt(2)==input.charAt(0)){
            throw new IllegalArgumentException();
        }
        return true;

    }

    public static String compareInput(String answer, String input){

        int strike = 0, ball=0;
        for (int i = 0; i < 3; i++) {
            if(answer.charAt(i)==input.charAt(i)){
                strike++;
            }else if(answer.contains(String.valueOf(input.charAt(i)))){
                ball++;
            }
        }

        if(ball>0 && strike>0){
            return ball + "볼 " + strike+"스트라이크";
        }
        if(ball>0){
            return ball+ "볼";
        }
        if(strike==3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String oneTwo = Console.readLine();
            if(Objects.equals(oneTwo, "2") || Objects.equals(oneTwo, "1")){
                return oneTwo;
            }else {
                throw new IllegalArgumentException();
            }
        }

        if(strike>0){
            return strike+ "스트라이크";
        }
        return "낫싱";
    }
}
