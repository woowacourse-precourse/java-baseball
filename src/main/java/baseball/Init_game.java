package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Init_game {
    public List<Integer> player_num() {
        System.out.print("숫자를 입력해주세요 : ");
        Scanner sc = new Scanner(System.in);
        List<Integer> player_num = new ArrayList<>();
        String input = sc.next();

        for(String number : input.split("")) {
            player_num.add(Integer.parseInt(number));
        }

        return player_num;
    }
}
