package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> input = new ArrayList<>();
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        answerValidate();
        gmae();

    }
    public static void gmae(){
        while(true){
            System.out.println("숫자를 입력해주세요: ");
            inputValidate(Console.readLine());
            boolean result = resultCheck();
            input.removeAll(input);
            if(result){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public static void answerValidate(){
        while(true){
            if(answer.size() == 3) break;
            int rd = Randoms.pickNumberInRange(1,9);
            if(!answer.contains(rd)) {
                answer.add(rd);
            }
        }
    }

    public static void inputValidate(String input){
        lengthCheck(input);
        numberCheck(input);
        notEqualCheck();

    }

    public static void numberCheck(String str){
        try{
            for(int i=0; i<str.length(); i++){
                int value = Integer.parseInt(str.substring(i, i+1));
                input.add(value);
            }
        }catch(NumberFormatException nfe){throw new IllegalArgumentException();}
    }
    public static void lengthCheck(String input){
        if(input.length() != 3){
            throw new IllegalArgumentException();
        }
    }
    public static void notEqualCheck(){
        for(int i=0; i<input.size(); i++){
            int value = input.get(i);
            if(input.indexOf(value) != input.lastIndexOf(value)) throw new IllegalArgumentException();  // 리스트에 값이 여러 개 존재한다는 의미이므로 IllegalArgumentException 발생
        }
    }

    public static boolean resultCheck(){
        int strike = strikeCheck();
        int ball = ballCheck(strike);
        printResult(strike, ball);
        return (strike == 3);
    }

    public static int ballCheck(int strike){
        int ball = 0;
        for(int i=0; i<input.size(); i++){
            if(answer.contains(input.get(i))) {
                ball++;
            }
        }
        return (ball-strike);
    }
    public static int strikeCheck(){
        int strike = 0;
        for(int i=0; i<input.size(); i++){
            if(input.get(i).intValue() == answer.get(i).intValue()) {
                strike++;
            }
        }
        return strike;
    }

    public static void printResult(int strike, int ball){
        if(strike ==0 && ball ==0){
            System.out.println("낫싱");
        } else if (strike != 0 && ball == 0) {
            System.out.println(strike+"스트라이크");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println(ball + "볼" + strike + "스트라이크");
        }
    }
    public static boolean exitGameValidate(){
        throw new IllegalArgumentException();
    }

}