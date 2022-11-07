package baseball;

import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class process {
    private static final int cnt_nbr= 3;
    private static final int strike_nbr= 2;
    private static final int ball_nbr= 1;
    private static final String str_strike= "스트라이크";
    private static final String str_ball= "볼 ";
    private static final String str_nothing= "낫싱";
    private static final String exit_nbr= "2";
    private static final String three_strike= "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String str_exit= "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private int[] user;
    private int[] computer;

    private int strike = 0;
    private int ball = 0;
    private boolean exit = false;
    public process() {}
}