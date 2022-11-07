package baseball;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        List<Integer> answer = Game.MakeAnswer();

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> user_num_list = User.InputNum();
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
}

class User {
    static List<Integer> InputNum() {
        List<Integer> user_num_list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        String input = scanner.nextLine();
        int user_num = Integer.parseInt(input);

        int first_num = user_num / 100;
        int second_num = (user_num / 10) % 10;
        int last_num = user_num % 10;

        user_num_list.add(first_num);
        user_num_list.add(second_num);
        user_num_list.add(last_num);

        return user_num_list;
    }
}