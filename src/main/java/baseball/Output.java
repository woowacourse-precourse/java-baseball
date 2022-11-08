package baseball;

public class Output {
    public Output() {

    }

    public Boolean result(int strikeCount, int ballCount) {
        if(strikeCount==3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if(strikeCount==0 && ballCount==0) {
            System.out.println("낫싱");
        } else if(strikeCount!=0 && ballCount!=0){
            System.out.println(ballCount+"볼 "+strikeCount+"스트라이크");
        } else if(strikeCount==0) {
            System.out.println(ballCount+"볼");
        } else if(ballCount==0) {
            System.out.println(strikeCount+"스트라이크");
        }
        return false;
    }
}
