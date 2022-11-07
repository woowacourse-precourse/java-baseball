package baseball.view;

public class OutputView {
    public static void resultView(int strike, int ball){
        if(ball>0){
            System.out.printf("%d볼 ",ball);
        }
        if(strike>0){
            System.out.printf("%d스트라이크",strike);
        }
        if(ball==0 & strike ==0){
            System.out.print("낫싱");
        }
        System.out.println();
    }
    public static void threeStrike(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
