package baseball;

import java.util.List;



public class Game {
    Computer computer = new Computer();
    User user = new User();

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void inputNumber() {
        System.out.println("숫자를 입력해주세요 :");
    }

    public int toStrike(List<Integer> toList, List<Integer> computer) {

        int strikenum = 0;
        for (int i = 0; i < toList.size(); i++) {
            if (computer.contains(toList.get(i))) {
                strikenum++;
            }

        }
        return strikenum;
    }


    public int toBall(List<Integer> toList, List<Integer> computer) {

        int Ballnum = 0;
        for (int i = 0; i < toList.size(); i++) {
            if (computer.contains(toList.get(i))) {
                Ballnum++;
            }
        }
        return Ballnum;
    }

    public void resultHint(int toStrike, int toBall) {
        if (toStrike > 0 && toBall > 0) {
            System.out.println(toStrike + "스트라이크" + toBall + "볼");
        } else if (toStrike > 0) {
            System.out.println(toStrike + "스트라이크");
        } else if (toBall > 0) {
            System.out.println(toBall + "볼");
        } else if (toStrike == 0 && toBall == 0) {
            System.out.println("낫싱");
        }
    }

    public void succesGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void restartGameV() {
        System.out.println("게임을 새로 시작하면 1, 종료하려면 2를 입력하세요");
    }

    public void allCorrect() {

        while (true) {
            List<Integer> computerInput = computer.computerNum();
            System.out.println(computerInput);
            inputNumber();
            String UserInput = user.userInput();
            List<Integer> toUserInput = user.tolistUser(UserInput);
            System.out.println(toUserInput);

            int toStrike = toStrike(toUserInput, computerInput);
            int toBall = toBall(toUserInput, computerInput);

            resultHint(toStrike, toBall);

            if (toStrike == 3) {
                succesGame();
                break;
            }
        }
    }
        public int validatorNumber() {

            restartGameV();

            String restartGame = user.restartGame();
            int startAndEnd = user.startAndEnd(restartGame);

            if (startAndEnd == 1) {
                System.out.println("게임 새로 시작합니다");
                return 1;
            }
            if (startAndEnd == 2) {
                System.out.println("게임 종료 합니다");
                return 2;
            }

            return startAndEnd;
        }
}
