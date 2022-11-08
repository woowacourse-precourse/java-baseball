package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    static Scanner sc = new Scanner(System.in);
    static Integer restartCounter;
    public static void main(String[] args) {
        do{
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = randomNumberGenerator(); //컴퓨터의 랜덤 숫자 생성

            List<Integer> user;
            Integer strike = 0;
            Integer ball = 0;
            while(strike!=3) {
                user.clear();
                user = makeListOfUser();
                strike = checkStrike(computer,user);
                ball = checkBall(computer,user);
            }



            sc =


        }while(restartCounter==1);

        return;
    }

    private static Integer checkStrike(List<Integer> computer, List<Integer> user) {
        Integer strike = 0;
        for(int i = 0; i<3; i++){
            if(computer.get(i).equals(user.get(i))) strike++;
        }
        return strike;
    }

    private static List<Integer> makeListOfUser() {
        List<Integer> user;
        try{
            System.out.println("숫자를 입력해주세요 : ");
            String input = sc.nextLine();
            validateInputString(input);
            String[] splits = input.split("");
            user = changeStringArrToIntegerList(splits);
            validateList(user);
        }catch (IllegalArgumentException e){
            throw e;
        }
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
        if(s.length()>3) throw new IllegalArgumentException();
    }
}
