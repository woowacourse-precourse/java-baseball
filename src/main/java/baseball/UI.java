/* 
<해결해야 할 것>
1. readline()메서드가 왜 WARING을 부르는지 이해하기 -> 일단 Pass
2. IllegalArgumentException이 발생했을 때, 프로그램을 종료할 수 있도록 하기
 */
package baseball;

class UI {
    public static void printGameStartMsg() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printAnswerMsg() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printBallCount(String ballCount) {
        System.out.println(ballCount);
    }

    public static void printInputNumOfUserMsg() {
        System.out.print("숫자를 입력해주세요 : ");
    }
}

