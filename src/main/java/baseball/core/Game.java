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
        if (count.getStrike() == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            boolean playAgain = checkUserWill();
            if (playAgain) {
                //TODO: Reset computer pitch
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    
    private boolean checkUserWill() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userWill = Console.readLine();
        if (userWill.equals("1")) {
            return true;
        } else if (userWill.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
