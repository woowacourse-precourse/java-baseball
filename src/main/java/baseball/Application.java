package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
}

class Baseball {
    private List<Integer> computerRandom = List.of(0, 0, 0);
    private List<Integer> playerNumber = List.of(0, 0, 0);
    private List<Integer> baseballCount = List.of(0, 0);


    public void pickRandomNumber() {
        int i = 0;
        while (computerRandom.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerRandom.contains(randomNumber)) {
                computerRandom.set(i, randomNumber);
                i++;
            }
        }
    }

    public void playerNumberList () {
        String getPlayerNumber = null;
        try {
            InputStreamReader ir = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ir);
            getPlayerNumber = br.readLine();
        } catch (Exception e) { }

        int num = Integer.parseInt(getPlayerNumber);
        for (int i = 0; i < 3; i++) {
            playerNumber.set(i, (num % 10));
            num /= 10;
        }
    }
}