package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean ch_more_game = true;
        while(ch_more_game){
            boolean ch_more_input = true;
            List<Integer> computer_number = pick_randomNumber(); // 숫자 3개 뽑기
            while(ch_more_input) {
                System.out.println("숫자를 입력해주세요 : ");
                String input_number = readLine(); // 입력
                maybe_this_number_length_over_3(input_number);
                List<Integer> input_number_integer = this_number_transformed_to_integer_array(input_number);
                if (play_ball(computer_number, input_number_integer)) {
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String input_coin = readLine(); // 입력
                    if (Integer.parseInt(input_coin) != 1) {
                        System.out.println("게임 종료");
                        ch_more_game = false;
                    }
                    ch_more_input = false;
                }
            }
        }
    }
    public static void maybe_this_number_length_over_3(String check_number){
        if(check_number.length() > 3){
            throw new IllegalArgumentException("#길이가 3자리인 양의 정수를 입력해주세요.");
        }
    }
    public static List<Integer> this_number_transformed_to_integer_array(String number){
        List<Integer> returning = new ArrayList<>();
        for(String tmp : number.split("")) {
            returning.add(Integer.parseInt(tmp));
        }
        return returning;
    }
    public static List<Integer> pick_randomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static boolean play_ball(List<Integer> Computer_team, List<Integer> human_team){
        int strike = 0;
        int ball = 0;
        for(int word_bit = 0; word_bit < 3; word_bit++){
            if(Computer_team.get(word_bit) == human_team.get(word_bit)){
                strike++;
            }
            else if(Computer_team.contains(human_team.get(word_bit))){
                ball++;
            }
        }
        System.out.println(Sign(strike,ball));
        return Sign(strike,ball).equals("3스트라이크");
    }
    public static String Sign(int strike, int ball){
        if(strike != 0 && ball != 0){
            return ball + "볼 " + strike + "스트라이크";
        }
        else if(strike != 0 && ball == 0){
            return strike + "스트라이크";
        }
        else if(strike == 0 && ball != 0){
            return ball + "볼";
        }
        else{
            return "낫싱";
        }
    }
}