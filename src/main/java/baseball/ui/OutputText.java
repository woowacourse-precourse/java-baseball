package baseball.ui;

import baseball.setting.CorrectEnum;
import baseball.setting.Setting;

public class OutputText {


    public static void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void endGame(){
        System.out.println(Setting.INPUT_NUMBER + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 "+Setting.START_GAME+", 종료하려면 "+Setting.END_GAME+"를 입력하세요.");
    }

    public static void inputNumber(){
        System.out.println("숫자를 입력해주세요 : ");
    }

    public static void strike(int count){
        System.out.println(String.valueOf(count)+CorrectEnum.STRIKE.valueOf());
    }

    public static void ball(int count){
        System.out.println(String.valueOf(count)+CorrectEnum.BALL.valueOf());
    }

    public static void strikeAndBall(int strike, int ball){
        System.out.println(String.valueOf(ball)+CorrectEnum.BALL.valueOf()+" "+String.valueOf(strike)+CorrectEnum.STRIKE.valueOf());
    }

    public static void nothing(){
        System.out.println(CorrectEnum.NOTHING.valueOf());
    }

}
