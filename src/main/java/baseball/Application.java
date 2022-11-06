package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.mockito.stubbing.Answer;

public class Application {

    //  중복되지 않는 랜덤한 3자리 수 선택
    public static List<Integer> Answer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static String UserInput(){
        String userInputString = Console.readLine();
        return userInputString;
    }

    //  입력값을 list로 변환
    public static List<Integer> UserInput_list(String input) {
        List<Integer> user_list = new ArrayList<>();
        int user_input = Integer.MAX_VALUE;

        user_input = Integer.parseInt(input);

        if (user_input < 100 || user_input > 999) {
            throw new IllegalArgumentException();
        }

        user_list.add(user_input / 100);
        user_list.add((user_input % 100) / 10);
        user_list.add(user_input % 10);

        if (user_list.contains(0)) {
            throw new IllegalArgumentException();
        }

        if (user_list.get(0) == user_list.get(1) ||
                user_list.get(1) == user_list.get(2) ||
                user_list.get(0) == user_list.get(2)) {
            throw new IllegalArgumentException();
        }

        return user_list;
    }

    // ball strike 수 출력
    public static void Print_BallStrike(List<Integer> ballstrike) {
        if(ballstrike.get(0) == 0 && ballstrike.get(1) == 0){
            System.out.println("낫싱");
        } else if (ballstrike.get(1) == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }else if(ballstrike.get(0) == 0 && ballstrike.get(1) > 0){
            System.out.println(ballstrike.get(1) + "스트라이크");
        }else if (ballstrike.get(0) > 0 && ballstrike.get(1) == 0){
            System.out.println(ballstrike.get(0) + "볼");
        }else {
            System.out.println(ballstrike.get(0) + "볼 " + ballstrike.get(1) + "스트라이크");
        }
    }


    //  ball strike 판별
    public static List<Integer> BallStrike(List<Integer> answer, List<Integer> user) {
        List<Integer> ballstrike = new ArrayList<>(2);
        int ball_cnt = 0;
        int strike_cnt = 0;
        int game_set = Integer.MAX_VALUE;
        for(int i = 0; i < user.size(); i++) {
            for(int j = 0; j < answer.size(); j++) {
                if(user.get(i) == answer.get(j) && i ==j) {
                    strike_cnt ++;
                } else if (user.get(i) == answer.get(j) && i != j) {
                    ball_cnt ++;
                }
            }
        }
        ballstrike.add(ball_cnt);
        ballstrike.add(strike_cnt);

        return ballstrike;
    }

    public static void main(String[] args) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();
        List<Integer> ballstrike = Arrays.asList(0,0);
        int user_input = Integer.MAX_VALUE;
        int game_set = Integer.MAX_VALUE;

        game :while(true) {
            answer = Answer();
            System.out.println(answer);
            input: while(true){
                System.out.print("숫자 입력 : ");
                try {
                    user = UserInput_list(UserInput());
                } catch (IllegalArgumentException e) {
                    System.out.println("error");
                    break game;
                }

                ballstrike = BallStrike(answer, user);
                Print_BallStrike(ballstrike);
                if(ballstrike.get(1) ==3) {
                    try {
                        game_set = Integer.parseInt(UserInput());
                        if(game_set == 1) {
                            return;
                        }else if (game_set == 2) {
                            return;
                        }else {
                            throw new Exception();
                        }
                    }catch (Exception e){
                        System.out.println("알맞은 값을 입력하세요");
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    }
                }
                user.clear();
            }


        }


    }
}