package baseball.play;

import baseball.number.ComputerNumber;
import baseball.number.UserNumber;
import camp.nextstep.edu.missionutils.Console;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.Arrays;
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
        computerNumberList = computerNumber.generateNumber();

        System.out.print(INPUT_MESSAGE);
        userNumberList = userNumber.inputUserNumber();
        
        getResult(userNumberList,computerNumberList);

    }
    public void getResult(List<Integer> userNumberList, List<Integer> computerNumberList){
        int strike = checkStrike(userNumberList,computerNumberList);
        int ball = checkBall(userNumberList,computerNumberList);
        String option = "";
        if(strike!=0 && ball==0) {
            System.out.println(strike+STRIKE_MESSAGE);
        }
        if(strike==3){
            System.out.println(WIN_MESSAGE);
            System.out.println(OPTION_MESSAGE);
            restart();
        }
        if(strike==0 && ball!=0){
            System.out.println(ball+BALL_MESSAGE);
        }
        if(strike==0 && ball ==0){
            System.out.println(NOTHING_MESSAGE);
        }

    }

    public int checkStrike(List<Integer> userNumberList, List<Integer> computerNumberList){
        int strike = 0;
        for(int i=0; i<3; i++){
            if(userNumberList.get(i).equals(computerNumberList.get(i))){
                strike++;
            }
        }
        return strike;
    }

    public int checkBall(List<Integer> userNumberList, List<Integer> computerNumberList){
        int ball = 0;
        for(int i=0; i<3; i++){
            if(userNumberList.contains(computerNumberList.get(i)) && !(userNumberList.get(i).equals(computerNumberList.get(i)))){
                ball++;
            }
        }
        return ball;
    }

    public void restart() {
        String option = Console.readLine();
        if (Integer.parseInt(option) == 1) {
            playBaseball();
        }
    }
}
