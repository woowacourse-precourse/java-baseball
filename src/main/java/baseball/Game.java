package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    static Scanner sc = new Scanner(System.in);

    public Game() {
        title();
    }
    private void title() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void play() {
        System.out.println("숫자를 입력해주세요 : ");

        // TODO computerNumber, userNumber 받기

        // TODO compare computerNumber,userNumber

        // TODO print result (X strike, X ball)

        // TODO Restart or Not
    }
    public boolean end() {
        // TODO get User's Input
        // TODO check Execption

        return true;
    }
    // TODO Method: List<Integer> getComputerNumber

    // TODO Method: List<Integer> getUserNumber

    // TODO Method: boolean restart
}
