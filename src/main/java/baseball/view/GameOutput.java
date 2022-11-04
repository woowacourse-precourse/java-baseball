package baseball.view;

public class GameOutput {
    public static void Strike(){
        System.out.println("스트라이크");
    }
    public static void Ball(){
        System.out.println("볼");
    }
    public static void Nothing(){
        System.out.println("낫싱");
    }
    public static void finishGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
