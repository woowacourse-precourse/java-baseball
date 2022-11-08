package baseball;

public class printConsoleMessage {
    public static void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void printInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }
    public static void printResult() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public static void printScore(int strike, int ball) {
        if(ball != 0) {
            System.out.print(ball+"볼 ");
        }
        if(strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        if(ball == 0 && strike == 0){
            System.out.print("낫싱");
        }
        System.out.println();
    }
}
