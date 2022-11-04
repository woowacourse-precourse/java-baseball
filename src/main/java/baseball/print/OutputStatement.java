package baseball.print;

public class OutputStatement {
    public static void informStartNumberBaseballGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void requestNumberInput(){
        System.out.print(("숫자를 입력해주세요 : "));

    }

    public static void informBallCountResult(){
        System.out.println("볼");

    }

    public static void informStrikeCountResult(){
        System.out.println("스트라이크");
    }

    public static void hint(int ball, int strike){
        if(ball ==0){
            System.out.println(strike + "스트라이크");
        }
        if(strike ==0){
            System.out.println(ball +"볼");
        }
        System.out.println(ball + '볼' + " " + strike + "스트라이크");
    }

    public static void informResultAnswer(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void askGameRestartOrFinish(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    }
}
