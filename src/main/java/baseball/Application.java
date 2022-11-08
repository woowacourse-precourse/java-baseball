package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    static final String START_MASSAGE = "숫자 야구 게임을 시작합니다.";
    static final String INPUT_MASSAGE = "숫자를 입력해주세요 : ";
    static final String THREE_STRIKE_MASSAGE = "3스트라이크";
    static final String END_MASSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String RESTART_MASSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    static final String BALL_MASSAGE = "볼";
    static final String STRIKE_MASSAGE= "스트라이크";
    static final String NOTHING_MASSAGE= "낫싱";
    static final String END_CONDITION= "2";
    static final String RESTART_CONDITION= "1";

    public static void main(String[] args) {
        System.out.println(START_MASSAGE);
        int answerNum = createRandomNum();
        while(true){

            System.out.print(INPUT_MASSAGE);
            String input = Console.readLine();
            inputValidator(input);

            String ballStrike = compareInput(Integer.toString(answerNum),input);
            System.out.println(ballStrike);
            if(Objects.equals(ballStrike, RESTART_CONDITION)){
                answerNum = createRandomNum();
            }
            if(Objects.equals(ballStrike, END_CONDITION)){
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
            return ball + BALL_MASSAGE +" "+ strike+STRIKE_MASSAGE;
        }
        if(ball>0){
            return ball+ BALL_MASSAGE;
        }
        if(strike==3){
            System.out.println(THREE_STRIKE_MASSAGE);
            System.out.println(END_MASSAGE);
            System.out.println(RESTART_MASSAGE);
            String oneTwo = Console.readLine();
            if(Objects.equals(oneTwo, RESTART_CONDITION) || Objects.equals(oneTwo, END_CONDITION)){
                return oneTwo;
            }else {
                throw new IllegalArgumentException();
            }
        }

        if(strike>0){
            return strike+ STRIKE_MASSAGE;
        }
        return NOTHING_MASSAGE;
    }
}
