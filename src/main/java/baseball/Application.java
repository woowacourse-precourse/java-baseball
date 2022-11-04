package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String game_status = "1";
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(game_status.equals("1")){
            BaseBallGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            game_status = Console.readLine();
            if(!(game_status.equals("1") || game_status.equals("2"))){
                throw new IllegalArgumentException();
            }
        }

    }

    public static void BaseBallGame(){
        String user_ball_number;
        List<Integer> computer_ball_number;
        List<String> result = List.of("","");

        computer_ball_number = RandomBallNum();
        while(!result.get(1).equals("3스트라이크")){
            System.out.print("숫자를 입력해주세요 : ");
            user_ball_number = user_Input();
            result = checker(computer_ball_number, user_ball_number);
            if(!result.get(0).equals("")){
                System.out.print(result.get(0)+" ");
            }
            System.out.println(result.get(1));
        }
        System.out.println("3개의 숫자를 모구 맞히셨습니다! 게임 종료");

    }

    public static List<Integer> RandomBallNum() {
        List<Integer> BallNum = new ArrayList<>(3);
        while (BallNum.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!BallNum.contains(randomNum)) {
                BallNum.add(randomNum);
            }
        }

        return BallNum;
    }

    public static String user_Input(){
        String user_ball_number;

        user_ball_number = Console.readLine();
        if(user_ball_number.length() != 3 || !user_ball_number.matches("^[0-9]*$")){
            throw new IllegalArgumentException();
        }

        return user_ball_number;
    }

    public static List<String> checker(List<Integer> computer_ball_number, String user_ball_number){
        List<String> result = new ArrayList<>(2);
        List<Integer> user_numbers = List.of(Integer.parseInt(user_ball_number)/100, (Integer.parseInt(user_ball_number)%100)/10, Integer.parseInt(user_ball_number)%10);
        int ball_count = 0;
        int strike_count = 0;

        for(int i = 0; i < 3; i++){
            if(computer_ball_number.get(i).equals(user_numbers.get(i))){
                strike_count += 1;
            } else if (computer_ball_number.contains(user_numbers.get(i))) {
                ball_count += 1;
            }
        }

        if(ball_count == 0 && strike_count == 0){
            result.add("낫싱");
            result.add("");
            return result;
        }
        if(ball_count != 0){
            result.add(ball_count + "볼");
        }
        else{
            result.add("");
        }
        if(strike_count != 0){
            result.add(strike_count + "스트라이크");
        }
        else{
            result.add("");
        }

        return result;
    }
}
