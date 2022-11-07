package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    static Scanner sc = new Scanner(System.in);
    static Integer restartCounter;
    public static void main(String[] args) {
        do{
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = randomNumberGenerator();

            List<Integer> user = new ArrayList<>();
            System.out.println("숫자를 입력해주세요 : ");
            try{
                String input = sc.nextLine();
                validateInputString(input);
                String[] splits = input.split("");
                user = changeStringArrToIntegerList(splits);
            }catch (IllegalArgumentException e){
                throw e;
            }


        }while(restartCounter==1);

        return;
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
