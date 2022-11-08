package baseball.core;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private Pitch computerPitch;
    private Pitch userPitch;

    public Game() {
        this.computerPitch = new Pitch().random();
        this.userPitch = new Pitch();
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            System.out.print("숫자를 입력해주세요 : ");
            userPitch.update(Console.readLine());
        } while (!isGameOver(computerPitch.compareTo(userPitch)));
    }

    private boolean isGameOver(Count count) {
        System.out.println(count);
        return true;
    }
}
