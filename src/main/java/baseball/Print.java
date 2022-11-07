package baseball;

public class Print {

    public static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void ballAndStrike(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        if (ball == 0 && strike != 0) {
            System.out.printf("%s스트라이크\n", strike);
        }
        if (ball != 0 && strike == 0) {
            System.out.printf("%s볼\n", ball);
        }
        if (ball != 0 && strike != 0) {
            System.out.printf("%s볼 %s스트라이크\n", ball, strike);
        }
        if (ball == 0 && strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public static void inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void inputOneOrTwo() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
