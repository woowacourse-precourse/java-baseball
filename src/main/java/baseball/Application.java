package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static List<Integer> Computer_Number() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static void isValidLength(String s) {
        if (s.length() != 3) {
            throw new IllegalArgumentException("세자리 수보다 크거나 작음");
        }
    }
    public static void Check_Strike_or_Ball(List count, int user_index, int computer_index){
        int ball = 0;
        int strike = 0;
        if (computer_index == user_index)
            strike++;
        else
            ball++;
        count.set(0, (int)count.get(0) + ball);
        count.set(1, (int)count.get(1) + strike);
    }
    public static void Check_contain_Number(String user, List computer, List count) {
        for (int i = 0; i < 3; i++) {
            int current_user = user.charAt(i) - '0';

            if (computer.contains(current_user)) {
                int computer_index = computer.indexOf(current_user);
                Check_Strike_or_Ball(count, i, computer_index);
            }
        }
    }
    public static void Baseball_print(List count){
        if ((int)count.get(0) > 0) {
            System.out.print(count.get(0) + "볼 ");
        }
        if ((int)count.get(1) > 0) {
            System.out.println(count.get(1) + "스트라이크");
        }
        if ((int)count.get(1) == 0 && (int)count.get(0) == 0) {
            System.out.println("낫싱");
        } else if ((int)count.get(1) == 0) {
            System.out.println();
        }
    }

    public static int Check_All_Correct(List count){
        if (count.get(1).equals(3)){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return 1;
        }
        return 0;
    }
    public static String Re_Start_Game(){
        String restart;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        restart = Console.readLine();
        return restart;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String gamestart = "1";
        while (gamestart.matches("1")) {
            List<Integer> computer = Computer_Number();

            System.out.println("숫자 야구 게임을 시작합니다.");

            int All_correct = 0;
            while (All_correct == 0) {
                System.out.print("숫자를 입력해주세요 : ");
                String user = Console.readLine();
                isValidLength(user);

                List<Integer> count = new ArrayList<Integer>(Arrays.asList(0, 0));
                Check_contain_Number(user, computer, count);

                Baseball_print(count);
                All_correct = Check_All_Correct(count);
            }
            gamestart = Re_Start_Game();
        }
    }
}
