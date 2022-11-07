package baseball.print;

import baseball.game.Score;

public class Print {
    // 게임 상태에 대한 문구 
    public static void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void inputMsg(){
        System.out.print("숫자를 입력해주세요 : ");
    }
    public static void replay() {System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");}
    public static void correct() {System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");}
    public static void quit() {System.out.println("게임을 완전히 종료합니다.");}

    // 점수 관련 출력
    public static void nothing(){
        System.out.println("낫싱");
    }
    public static void calculateScore(Integer ball, Integer strike){
        StringBuilder score = new StringBuilder();
        if (ball > 0)
            score.append(ball).append("볼 ");
        if (strike > 0)
            score.append(strike).append("스트라이크 ");
        System.out.println(score);
    }

    public static void score(Score score){
        if(score.ifNothing()) {
            Print.nothing();
            return;
        }
        Print.calculateScore(score.ball(), score.strike());
    }
}
