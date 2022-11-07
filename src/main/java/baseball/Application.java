package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    // 컴퓨터가 서로 다른 랜덤의 3자리 수를 정하는 함수
    private static void rand_num_decision(List<Integer> randnum){
        while (randnum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randnum.contains(randomNumber)) {
                randnum.add(randomNumber);
            }
        }
    }

    private static String user_num_input(){
        return Console.readLine();
    }

    private static void game(){
        int game_status;
        String user_num;
        List<Integer> computer = new ArrayList<>();

        do {
            rand_num_decision(computer);

        } while (game_status == 1);
    }

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        game();

    }
}
