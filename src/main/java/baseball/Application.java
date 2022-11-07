package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static void verification_user_answer(char[] user_answer){
        List<Character> user_list = Arrays.asList(user_answer[0], user_answer[1], user_answer[2]);

        if(user_answer.length != 3){
            // System.out.println("잘못입력하였습니다.");
            throw new IllegalArgumentException("잘못입력하였습니다");
        }
        if(user_list.size() != user_list.stream().distinct().count()){
            // System.out.println("중복된 숫자가 있습니다.");
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
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
        // 사용자 입력값 검증
        verification_user_answer(user_answer);
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

    public static Integer print_result(List<Integer> result){
        int strike_result = result.get(0);
        int ball_result = result.get(1);
        int nothing_result = result.get(2);

        int correct = -1;

        if(nothing_result==3){
            System.out.println("낫싱");
        }
        else if(strike_result==3){
            System.out.println(strike_result + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            correct = 1;
        }
        else{
            System.out.println(ball_result + "볼 " + strike_result + "스트라이크");
        }

        return correct;
    }

    public static void game_start(){
        List<Integer> computer_number = make_number();

        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            // 숫자 랜덤
            String user_answer = readLine();
            char[] user_input = user_answer.toCharArray();
            // 비교 결과 리스트 저장
            List<Integer> compare_result = compare_answer(computer_number, user_input);
            // 결과 출력
            int result = print_result(compare_result);
            // 맞추었을 때
            if(result == 1){
                ask_replay();
            }
            // 틀렸을 때
            else if(result == -1){
                continue;
            }
            break;
        }
    }

    public static void ask_replay(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String stay = readLine();
        if(stay.equals("1")){
            game_start();
        }
        if(stay.equals("2")){
            // 게임종료
        }

    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){
            game_start();
            break;
        }
    }
}
