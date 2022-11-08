package baseball;

public class Application {
    public static void main(String[] args) {
        try {
            BaseBallGameManager baseBallGameManager = new BaseBallGameManager();
            baseBallGameManager.startGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("예기치 못한 오류 발생");
        }
    }
}

