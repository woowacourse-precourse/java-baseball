package baseball;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        String restart_or_not = "";
        System.out.println("숫자 야구 게임을 시작합니다.");
        int ball_num = 0, strike_num = 0;

        List<Integer> answer = Game.MakeAnswer();
        while(true) {
            if (restart_or_not.equals("1")) {
                restart_or_not = "";
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
                restart_or_not = Game.RestartOrNot();
                answer = Game.MakeAnswer();
                strike_num = 0;
            }
        }
    }
}

class Game {
    static List<Integer> MakeAnswer() {
        List<Integer> answer = new ArrayList<>();

        while(answer.size() < 3) {
            int num = (int) (Math.random() * 9 + 1);
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

    static String RestartOrNot() {
        String restart_or_not = "";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restart_or_not = scanner.nextLine();
            if (!(restart_or_not.equals("1")) && !(restart_or_not.equals("2"))) {
                System.out.println("1 또는 2를 입력해 주세요.");
            } else {
                break;
            }
        }

        return restart_or_not;
    }
}

class User {
    static List<Integer> InputNum() {
        List<Integer> user_num_list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = scanner.nextLine();
            if(CheckInput(input)) {
                int user_num = Integer.parseInt(input);

                int first_num = user_num / 100;
                int second_num = (user_num / 10) % 10;
                int last_num = user_num % 10;

                user_num_list.add(first_num);
                user_num_list.add(second_num);
                user_num_list.add(last_num);

                return user_num_list;
            } else {
                throw new IllegalArgumentException();
            }
        }
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
        if (!(isNumeric(input))) return false;
        else if(input.length() != 3) return false;
        else if(input.contains("0")) return false;
        else return true;
    }
}