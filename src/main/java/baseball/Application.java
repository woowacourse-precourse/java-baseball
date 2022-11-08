package baseball;

import java.sql.SQLOutput;
import java.util.*;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    static public String answer = null;
    static  Scanner sc = new Scanner(System.in);
   /*
    public static String inputCheck(String input) {
        if (input.length() >= 4) {
            System.out.println("뭐가 틀렸는데");
            throw new IllegalArgumentException("");
        }else{
            return input;
        }
    }
*/
    
    public static String Random() {
        Set<String> rand = new HashSet<>();
        while (rand.size() != 3) {
            rand.add(String.valueOf(camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1,9)));
        }

        return String.join("", rand);
    }


   public static boolean print(List<Integer> ball) {
        if (ball.get(0) == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if (camp.nextstep.edu.missionutils.Console.readLine().equals("1")) {
                answer = "589";
                return false;
            } else {
                System.out.println("게임 종료");
                return true;
            }
        } else if (ball.get(0) == 0 && ball.get(1) == 0) {
            System.out.println("낫싱");
        } else System.out.println(ball.get(1) + "볼 " + ball.get(0) + "스트라이크");
        return false;
    }


    public static List<Integer> check(List<Character> answer, List<Character> input) {
        List<Integer> ball = new ArrayList<>();
        int strike_count = 0;
        int ball_count = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.get(i) == input.get(i)) strike_count++;
            else if (answer.contains(input.get(i))) {
                ball_count++;
            }
        }
        ball.add(strike_count);
        ball.add(ball_count);
        return ball;
    }

   public static List<Integer> compare(String answer, String input) {
        List<Character> answer_List = new ArrayList<>();
        List<Character> input_List = new ArrayList<>();
        List<Integer> ball = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            answer_List.add(answer.charAt(i));
            input_List.add(input.charAt(i));
        }
        return check(answer_List, input_List);

    }

    public static void main(String[] args) {
        List<Integer> ball = new ArrayList<>();
        System.out.println("숫자 야구 게임을 시작합니다.");
        // answer = Random();
        answer = "135";
        boolean check = false;
        while (check == false) {
              String input =inputCheck(camp.nextstep.edu.missionutils.Console.readLine());
               ball = compare(answer, input);
               check = print(ball);
        }


    }

}
