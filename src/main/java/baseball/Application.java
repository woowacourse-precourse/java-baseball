package baseball;

public class Application {

    static User user;
    static String OPTION_RESTART = "1";
    static String NOITCE_GAMESTART = "숫자 야구 게임을 시작합니다.";
    public static void main(String[] args) {
        System.out.println(NOITCE_GAMESTART);
        String option = OPTION_RESTART;
        user = new User();

        while(option.equals("1")){
            playGame();
            user.inputRestartOption();
            user.optionThrowsException();
            option = user.input;
            if(option.equals("2")){
                System.out.println("게임을 완전히 종료합니다.");
            }
        }
        // TODO: 프로그램 구현
    }
    static void playGame(){
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
    }
}
