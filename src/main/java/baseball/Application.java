package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    private static String chooseComputerNumber() {
        String computer = "";
        while(computer.length() != 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (computer.contains(randomNumber + "0")) {
                continue;
            }
            computer += randomNumber + "0";
        }
        return computer;
    }

    private static Integer playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String computer = chooseComputerNumber();
        return 1;
    }

    public static void main(String[] args) {
        do {
            playGame();
        }while(playGame() == 1);
        System.out.println("게임 종료");
    }
}