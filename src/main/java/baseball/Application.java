package baseball;
public class Application {
    static GamePlay gamePlay=new GamePlay();
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            if (GamePlay.gamePlay().equals(String.valueOf('2'))){
                break;
            }
        }
    }
}