package baseball.ui;

public class OutputText {

    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void endGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void inputNumber(){
        System.out.println("숫자를 입력해주세요 : ");
    }

    public void warnNumber(){
        System.out.println("잘못된 숫자를 입력했습니다.");
    }

}
