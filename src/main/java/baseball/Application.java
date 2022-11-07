package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        String restart_or_not = "";
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> answer = Game.MakeAnswer();
        while(true) {
            int ball_num = 0, strike_num = 0;
            if (restart_or_not.equals("1")) {
                restart_or_not = "";
                answer = Game.MakeAnswer();
                continue;
            } else if (restart_or_not.equals("2")) {
                System.out.println("게임을 종료합니다.");
                break;
            } else {
                List<Integer> user_num_list = User.InputNum();

                strike_num = Game.HowManyStrike(answer, user_num_list);
                ball_num = Game.HowManyBall(answer, user_num_list) - strike_num;
                System.out.println(Game.WhatBallStrike(ball_num, strike_num));
            }
            if (strike_num == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                restart_or_not = Console.readLine();
            }
        }
    }
}

class Game {
    static List<Integer> MakeAnswer() {
        List<Integer> answer = new ArrayList<>();

        while(answer.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if(!(answer.contains(num))) {
                answer.add(num);
            }
        }

        return answer;
    }

    static int HowManyBall(List<Integer> answer, List<Integer> user_num_list) {
        int ball_num = 0;

        for(int user_num : user_num_list) {
            if(answer.contains(user_num)) {
                ball_num++;
            }
        }

        return ball_num;
    }

    static int HowManyStrike(List<Integer> answer, List<Integer> user_num_list) {
        int strike_num = 0;

        for(int i = 0; i < 3; i++) {
            if(user_num_list.get(i) == answer.get(i)) {
                strike_num++;
            }
        }

        return strike_num;
    }

    static String WhatBallStrike(int ball_num, int strike_num) {
        if(ball_num == 0 && strike_num == 0) {
            return "낫싱";
        } else if(ball_num == 0) {
            return strike_num + "스트라이크";
        } else if(strike_num == 0) {
            return ball_num + "볼";
        } else {
            return ball_num + "볼 " + strike_num + "스트라이크";
        }
    }
}

class User {
    static List<Integer> InputNum() {
        List<Integer> user_num_list = new ArrayList<>();

        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            if(CheckInput(input)) {
                String[] nums = input.split("");
                user_num_list = MakeNumList(nums);
                return user_num_list;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    static List<Integer> MakeNumList(String[] nums) {
        List<Integer> num_list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = Integer.parseInt(nums[i]);
            num_list.add(num);
        }

        return num_list;
    }

    static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    static boolean CheckInput(String input) {
        if (!(isNumeric(input)) || input.length() != 3 || input.contains("0")) return false;
        else return true;
    }
}