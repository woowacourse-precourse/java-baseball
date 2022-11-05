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
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = Computer_Number();

        System.out.println("숫자 야구 게임을 시작합니다.");

        System.out.print("숫자를 입력해주세요 : ");
        String user = Console.readLine();
        isValidLength(user);

        List<Integer> count = new ArrayList<Integer>(Arrays.asList(0, 0));
        Check_contain_Number(user, computer, count);
    }
}
