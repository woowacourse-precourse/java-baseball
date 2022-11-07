package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> computer = setAnswerNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");

        System.out.print("숫자를 입력해 주세요 : ");

        String numStr = userInputNumber(System.in);

        System.out.println(numStr);

        BaseBallPoint baseBallPoint = countBallAndStrike(computer, numStr);

        printBallAndStrike(baseBallPoint.getBall(), baseBallPoint.getStrike());

    }

    static class BaseBallPoint{
        int ball, strike;
        public BaseBallPoint(int ball, int strike){
            this.ball =ball;
            this.strike = strike;
        }
        public int getBall() {return ball;}
        public int getStrike() {return strike;}
    }

    private static BaseBallPoint countBallAndStrike(List<Integer> computer, String numStr) {
        int ball = 0, strike = 0;

        for(int i = 0 ; i < 3 ; i++){
            char c = Character.forDigit(computer.get(i), 10);
            int index = numStr.indexOf(c, 0);

            if(index == i){
                strike++;
            }
            if(index != -1 && index != i){
                ball++;
            }
        }

        return new BaseBallPoint(ball, strike);
    }

    public static void printBallAndStrike(int ball, int strike){

        if(ball > 0 && strike > 0){
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }else if(ball > 0 && strike == 0){
            System.out.println(ball + "볼 ");
        } else if(strike > 0 && ball == 0){
            System.out.println(strike + "스트라이크");
        } else if(strike ==0 && ball == 0) {
            System.out.println("낫싱");
        }
    }


    public static List<Integer> setAnswerNumber(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static String userInputNumber(InputStream in){
        String userStr = systemInput(in);

        if(userStr == null || userStr.length() > 3 || userStr.length() < 3){
            throw new IllegalArgumentException();
        }

        try{
            Integer.parseInt(userStr);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }

        return userStr;
    }

    public static String systemInput(InputStream in){

        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        try {
            String input = br.readLine();
            return input;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
