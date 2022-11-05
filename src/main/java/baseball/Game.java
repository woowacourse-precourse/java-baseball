package baseball;

public class Game {
    private static final String START_MSG  = "숫자 야구 게임을 시작합니다.";
    private static final Computer computer = new Computer();
    private static final User user = new User();

    public void start() {
        System.out.println(START_MSG);
        //테스트용 출력
        System.out.println(computer);
        user.scanUserNums();
        //테스트용 출력
        System.out.println(user);
    }


}
