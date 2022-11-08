package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Init_game {
    public List<Integer> player_num() throws IOException {
        System.out.print("숫자를 입력해주세요 : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> player_num = new ArrayList<>();
        String input = br.readLine();

        for(String number : input.split("")) {
            player_num.add(Integer.parseInt(number));
        }

        return player_num;
    }
}
