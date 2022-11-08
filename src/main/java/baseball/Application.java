package baseball;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit){
            start();
            exit = getRestartInfo();
        }
    }


    public static List<Integer> getRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> getInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<String> str_list = Arrays.asList(input.split(""));
        List<Integer> input_list =str_list.stream().map(s->Integer.parseInt(s)).collect(Collectors.toList());
        validNumber(input_list);
        return input_list;
    }
    public static void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean exit = false;
        List<Integer> ans = getRandomNumber();
        while (!exit) {
            List<Integer> user = getInputNumber();
            List<String> str = new ArrayList<String>();
            for(int i = 0; i<ans.size(); i++) {
                String hint = getHint(ans.get(i), i, user);
                str.add(hint);
            }
            String hint_msg = getHintMsg(str);
            System.out.println(hint_msg);
            if (hint_msg.equals("3스트라이크")){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                exit = true;
            }
        }
    }
    public static String getHint(Integer ans, int index, List<Integer> user){
        for (int i = 0; i<user.size() ;i++){

            if (ans == user.get(i) && index==i){
                return "스트라이크";
            } else if (ans == user.get(i)){
                return  "볼";
            }
        }
        return "낫싱";
    }

    public static String getHintMsg(List<String> str) {

        int ball = Collections.frequency(str, "볼");
        int strike = Collections.frequency(str, "스트라이크");
        int nothing = Collections.frequency(str, "낫싱");

        if (nothing == 3){
            return "낫싱";
        } else if (ball == 3){
            return "3볼";
        } else if (strike == 3){
            return "3스트라이크";
        } else if (ball>0 && strike>0) {
            return String.valueOf(ball)+"볼 "+String.valueOf(strike)+"스트라이크";
        } else if (ball>0 && strike==0) {
            return String.valueOf(ball)+"볼 ";
        }

        return String.valueOf(strike)+"스트라이크";

    }
    public static boolean getRestartInfo(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")){
            return false;
        }
        return true;
    }

    private static void validNumber(final List<Integer> number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException("numbers cannot be empty.");
        } else if(number.size()!=3){
            throw new IllegalArgumentException("numbers must be 3 digits.");
        } else if (number.size() != number.stream().distinct().count()) {
            throw new IllegalArgumentException("Numbers must not overlap.");
        }
    }
}
