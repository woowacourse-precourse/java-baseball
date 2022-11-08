package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Integer restartCounter;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = randomNumberGenerator();
            List<Integer> user ;
            Integer strike = 0;
            Integer ball;
            while(strike!=3) {
                String input = getInputByUser(sc);
                user = makeListOfUser(input);
                strike = checkStrike(computer,user);
                ball = checkBall(computer,user);
                ball -= strike;
                printResult(strike,ball);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restartCounter= Integer.parseInt(sc.nextLine());
        }while(restartCounter==1);

        return;
    }

    public static String getInputByUser(Scanner sc) throws IllegalArgumentException{
        System.out.println("숫자를 입력해주세요 :");
        String input = sc.nextLine();
        validateInputString(input);

        return input;
    }

    public static void printResult(Integer strike, Integer ball) {
        if(ball==0 && strike ==0){
            System.out.println("낫싱");
            return;
        }
        if(ball!= 0 && strike == 0){
            System.out.println(ball+"볼");
            return;
        }
        if(strike!=0 && ball == 0){
            System.out.println(strike+"스트라이크");
            return ;
        }
        System.out.println(ball+"볼 "+strike+"스트라이크");
        return ;
    }

    public static Integer checkBall(List<Integer> computer, List<Integer> user) {
        Integer ball = 0;
        for(Integer n : user){
            if(computer.contains(n)) ball++;
        }
        return ball;
    }

    public static Integer checkStrike(List<Integer> computer, List<Integer> user) {
        Integer strike = 0;
        for(int i = 0; i<3; i++){
            if(computer.get(i).equals(user.get(i))) strike++;
        }
        return strike;
    }

    public static List<Integer> makeListOfUser(String input) {
        List<Integer> user;
        String[] splits = input.split("");
        user = changeStringArrToIntegerList(splits);
        validateList(user);
        return user;
    }

    public static List<Integer> randomNumberGenerator(){
        List<Integer> temp = new ArrayList<>();
        while (temp.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!temp.contains(randomNumber)) {
                temp.add(randomNumber);
            }
        }
        return temp;
    }

    public static void validateList(List<Integer> user){
        List<Integer> temp = user.stream().distinct().collect(Collectors.toList());
        if(temp.size()<2) throw new IllegalArgumentException();
    }

    public static void validateChangedInteger(Integer a){
        if(a<1||a>9) throw new IllegalArgumentException();
    }
    public static List<Integer> changeStringArrToIntegerList(String[] splits){
        List<Integer> temp = new ArrayList<>();
        for(String s : splits){
            Integer a = Integer.parseInt(s);
            validateChangedInteger(a);
            temp.add(a);
        }
        return temp;
    }

    public static void validateInputString(String s){
        if(s.length()>3) throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
    }
}
