package baseball;

public class PrintWindow {

    public void startPrint() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void playerTurnPrint(){
        System.out.println("숫자를 입력해주세요 :");
    }
    public void resultNothingPrint(){
        System.out.println("낫싱");
    }
    public void threeStrikePrint(){
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public void gameResult(int ball, int strike){
        if (ball != 0 && strike !=0){
            System.out.printf("%d볼 %d스트라이크", ball, strike);
        }
        if (ball !=0){
            System.out.printf("%d볼", ball);
        }
        System.out.printf("%d스크라이크", strike);
    }
}
