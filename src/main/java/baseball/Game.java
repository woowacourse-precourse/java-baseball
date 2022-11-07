package baseball;

import java.util.ArrayList;

public class Game {

    protected boolean nothing = true;

    protected int same_cnt = 0;

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputNumber() {
        System.out.print("숫자를 입력해주세요: ");
    }

    public void checkNothing(ArrayList<Integer> computer, ArrayList<Character> user) {

        for (int i = 0; i < 3; i++) {
            if (computer.contains(user.get(i) - '0')) {
                this.nothing = false;
                same_cnt++;
            }
        }

        if (this.nothing) {
            System.out.println("낫싱");
        }
    }

}
