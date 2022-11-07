package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {


    public static List<Integer> make_number(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> compare_answer(List<Integer> computer, char[] user_answer){
        List<Integer> current_score = Arrays.asList(0, 0, 0);
        int strike = 0;
        int ball = 0;
        int nothing = 0;
        for(int i=0; i<user_answer.length; i++){
            int each_number = Character.getNumericValue(user_answer[i]);
            if(computer.get(i)==each_number){
                strike++;
            }
            else if(computer.contains(each_number)){
                ball++;
            }
            else{
                nothing++;
            }
        }
        current_score.set(0, strike);
        current_score.set(1, ball);
        current_score.set(2, nothing);
        return current_score;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> computer_number = make_number();

        for(int i=0; i<3; i++){
            System.out.print(computer_number.get(i)+" ");
        }
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){


            while(true){
                System.out.print("숫자를 입력해주세요 : ");
                // 숫자 랜덤
                String user_answer = readLine();
                char[] user_input = user_answer.toCharArray();

                List<Integer> compare_result = compare_answer(computer_number, user_input);
                int strike_result = compare_result.get(0);
                int ball_result = compare_result.get(1);
                int nothing_result = compare_result.get(2);

                if(nothing_result==3){
                    System.out.println("낫싱");
                }
                else if(strike_result==3){
                    System.out.println(strike_result + "스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    String stay = readLine();

                    // System.out.println(stay);
                }
                else{
                    System.out.println(ball_result + "볼" + strike_result + "스트라이크");
                }

                break;
                }
            break;
        }
    }
}
