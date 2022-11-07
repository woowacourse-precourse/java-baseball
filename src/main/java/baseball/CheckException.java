package baseball;

public class CheckException {

    private static void occurException() {
        throw new IllegalArgumentException();
    }

    public static void restartStatusValue(String restartStatus) {
        try {
            if(!(restartStatus.equals("1") || restartStatus.equals("2")))
                occurException();
        } catch (IllegalArgumentException e) {
            System.out.println(e +" 재시작 관련 값을 잘못 입력하셨습니다. 게임을 종료합니다.");
        }
    }
}
