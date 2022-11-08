package baseball;

public class Application {

    static String NOITCE_GAMESTART = "숫자 야구 게임을 시작합니다.";
    public static void main(String[] args) {
        System.out.println(NOITCE_GAMESTART);

        User user = new User();
        Computer computer = new Computer();
        boolean GameOver = false;

        while(!GameOver){
            user.inputFortheGame();
            user.inputThrowsException();
            System.out.println(computer.state(user.input));
            if(computer.isGameOver(user.input)){
                GameOver = true;
            }
        }
        // TODO: 프로그램 구현
    }
}
