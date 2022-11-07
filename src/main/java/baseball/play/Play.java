package baseball.play;

import baseball.number.ComputerNumber;
import baseball.number.UserNumber;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.List;

public class Play {
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String BALL_MESSAGE = "볼";
    public static final String NOTHING_MESSAGE = "낫싱";
    public static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String OPTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private List<Integer> computerNumberList;
    private ComputerNumber computerNumber;
    public UserNumber userNumber;
    private List<Integer> userNumberList;

    public Play(){
        computerNumber = new ComputerNumber();
        computerNumberList = new ArrayList<>();

        userNumber = new UserNumber();
        userNumberList = new ArrayList<>();
    }
    public void playBaseball(){
        System.out.println(START_MESSAGE);
        computerNumber.generateNumber();
        System.out.print(INPUT_MESSAGE);
        userNumberList = userNumber.inputUserNumber();




    }
}
