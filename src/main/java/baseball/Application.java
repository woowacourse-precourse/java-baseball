package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        while(true){
            System.out.println("숫자 야구 게임을 시작합니다.");


            while(true) {
                System.out.print("숫자를 입력해주세요 :");

                List<Integer> user = validationAndConvert(Console.readLine());

                Integer ball = calculationBall(computer, user);

                Integer strike = calculationStrike(computer, user);

                String result = printCurrentSituation(ball, strike);
                System.out.println(result);


            }

        }

    }

    public static Boolean isDone(String result){
        if(result.equals("3스트라이크")) return true;
        else return false;
    }
    public static String printCurrentSituation(Integer ball , Integer strike){
        if(ball == 0 && strike == 0) return "낫싱";
        else if(ball == 0) return strike + "스트라이크";
        else if(strike == 0) return ball + "볼";
        else return ball + "볼" + " " + strike + "스트라이크";
    }
    public static Integer calculationStrike(List<Integer> computer,List<Integer> user){
        Integer strike = 0;
        for(int i = 0;i<computer.size();i++){
            for(int k = 0;k<user.size();k++){
                if(computer.get(i).equals(user.get(k)) && i == k)
                    strike +=1;
            }
        }
        return strike;
    }
    public static Integer calculationBall(List<Integer> computer,List<Integer> user){
        Integer ball = 0;
        for(int i = 0;i<computer.size();i++){
            for(int k = 0;k<user.size();k++){
                if(computer.get(i).equals(user.get(k)) && i != k)
                    ball +=1;
            }
        }
        return ball;
    }
    public static List<Integer> validationAndConvert(String input){
        if(input.length() != 3)  throw new IllegalArgumentException();
        Set<Integer> result = input.chars()
                .filter(c->(c >= '1' && c <= '9'))
                .map(c -> c - '0').boxed()
                .collect(toSet());
        if(result.size() != 3) throw new IllegalArgumentException();
        return result.stream().collect(toList());
    }



}
