package baseball.ui;

import baseball.setting.CorrectEnum;
import baseball.setting.Setting;

public class OutputText {

    private final Setting setting;

    public OutputText(Setting setting){
        this.setting = setting;
    }


    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void endGame(){
        System.out.println(setting.INPUT_NUMBER + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 "+setting.START_GAME+", 종료하려면 "+setting.END_GAME+"를 입력하세요.");
    }

    public void inputNumber(){
        System.out.println("숫자를 입력해주세요 : ");
    }

    public void strike(int count){
        System.out.println(String.valueOf(count)+CorrectEnum.STRIKE.valueOf());
    }

    public void ball(int count){
        System.out.println(String.valueOf(count)+CorrectEnum.BALL.valueOf());
    }

    public void strikeAndBall(int strike, int ball){
        System.out.println(String.valueOf(ball)+CorrectEnum.BALL.valueOf()+" "+String.valueOf(strike)+CorrectEnum.STRIKE.valueOf());
    }

    public void nothing(){
        System.out.println(CorrectEnum.NOTHING.valueOf());
    }

}
