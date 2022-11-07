package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        int restart = 1;


        while(restart == 1) {


            List<Integer> computer = computer_input();
            // System.out.println(computer.toString());
            boolean strike3 = false;

            while (!strike3) {
                List<Integer> user = user_input();
                strike3 = evaluate_gameplay(user, computer);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart = Integer.parseInt(Console.readLine());

        }



    }
    //ArrayIndexOutOfBoundsException
    // IllegalArgumentException

    public static List<Integer> user_input(){
        List<Integer> user = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String threeNumber = Console.readLine();

        if(threeNumber.length() != 3 ) throw new ArrayIndexOutOfBoundsException();
        for(Character letter: threeNumber.toCharArray())
        {
            if(!Character.isDigit(letter)) throw new ArrayIndexOutOfBoundsException();

            int num = Character.getNumericValue(letter);
            if(num == 0) throw new ArrayIndexOutOfBoundsException();
            if(user.contains(num)) throw new ArrayIndexOutOfBoundsException();

            user.add(num);
        }

        return user;
    }

    public static List<Integer> computer_input(){
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3)
        {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)) computer.add(randomNumber);
        }

        return computer;
    }

    public static boolean evaluate_gameplay(List<Integer> user, List<Integer> computer) {
        int strike = 0, ball = 0;

        for(int i = 0; i < 3; i++)
        {
            if(Objects.equals(user.get(i), computer.get(i))) { strike++; ball--; }
            if(computer.contains(user.get(i))) ball++;
        }

        
        if(ball != 0 && strike != 0) System.out.printf("볼 %d 스트라이크 %d\n", ball, strike);
        if(ball != 0 && strike == 0) System.out.printf("볼 %d\n", ball);
        if(ball == 0 && strike != 0) System.out.printf("스트라이크 %d\n", strike);
        if(ball == 0 && strike == 0) System.out.println("낫싱");

        return strike == 3;
    }

}
