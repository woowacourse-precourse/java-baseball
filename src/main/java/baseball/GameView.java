package baseball;

public class GameView {

    public void printStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInput(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printHint(Integer ball, Integer strike){
        if (strike == 0 && ball == 0){
            System.out.print("낫싱\n");
            return;
        }
        if (ball > 0){
            System.out.printf("%d볼 ", ball);
        }
        if (strike > 0){
            System.out.printf("%d스트라이크",strike);
        }
        System.out.print("\n");
    }

    public void printRestart(){
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. \n");
    }
}
