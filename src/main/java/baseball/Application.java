package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();


    }
}
    //ArrayIndexOutOfBoundsException
    // IllegalArgumentException

//    public static List<Integer> user_input(){
//        List<Integer> user = new ArrayList<>();
//
//        System.out.print("숫자를 입력해주세요 : ");
//        String threeNumber = Console.readLine();
//
//        if(threeNumber.length() != 3 ) throw new ArrayIndexOutOfBoundsException();
//        for(Character letter: threeNumber.toCharArray())
//        {
//            if(!Character.isDigit(letter)) throw new ArrayIndexOutOfBoundsException();
//
//            int num = Character.getNumericValue(letter);
//            if(num == 0) throw new ArrayIndexOutOfBoundsException();
//            if(user.contains(num)) throw new ArrayIndexOutOfBoundsException();
//
//            user.add(num);
//        }
//
//        return user;



//    public static boolean evaluate_gameplay(List<Integer> user, List<Integer> computer) {
//        int strike = 0, ball = 0;
//
//        for(int i = 0; i < 3; i++)
//        {
//            if(Objects.equals(user.get(i), computer.get(i))) { strike++; ball--; }
//            if(computer.contains(user.get(i))) ball++;
//        }
//
//
//        if(ball != 0 && strike != 0) System.out.printf("볼 %d 스트라이크 %d\n", ball, strike);
//        if(ball != 0 && strike == 0) System.out.printf("볼 %d\n", ball);
//        if(ball == 0 && strike != 0) System.out.printf("스트라이크 %d\n", strike);
//        if(ball == 0 && strike == 0) System.out.println("낫싱");
//
//        return strike == 3;
//    }


