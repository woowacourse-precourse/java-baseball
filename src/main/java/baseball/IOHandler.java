package baseball;

public class IOHandler {
    public static void writeLaunchMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void writeInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void writeCompleteMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void writeStatusMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void writeHintMessage(int strike, int ball) {
        if (strike > 0 && ball > 0)
            System.out.println(ball + "볼 " + strike + "스트라이크");
        else if (ball > 0)
            System.out.println(ball + "볼");
        else if (strike > 0)
            System.out.println(strike + "스트라이크");
        else if (strike == 0 && ball == 0)
            System.out.println("낫싱");
    }

    public static String readInput() {
        return (camp.nextstep.edu.missionutils.Console.readLine());
    }
}
