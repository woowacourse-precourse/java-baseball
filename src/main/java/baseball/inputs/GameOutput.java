package baseball.inputs;

public class GameOutput {
    public void printWhenStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printPlayingCount(int strikeCount, int ballCount) throws IllegalArgumentException{

        if(!(0 <= strikeCount && strikeCount <= 3) || !(0 <= ballCount && ballCount <= 3)){
            throw new IllegalArgumentException("strikeCount 나 ballCount 숫자가 0보다 작거나, 3보다 큽니다.");
        }

        boolean isStrikeExists = (strikeCount > 0);
        boolean isBallExists = (ballCount > 0);

        boolean isNothing = !(isStrikeExists || isBallExists);
        boolean onlyHaveBalls = (isBallExists && !isStrikeExists);
        boolean onlyHaveStrikes = isStrikeExists && !isBallExists;

        if(isNothing){
            System.out.print("낫싱\n");
        }else if(onlyHaveBalls){
            System.out.printf("%d볼\n",ballCount);
        }else if(onlyHaveStrikes){
            System.out.printf("%d스트라이크\n",strikeCount);
        }else{
            System.out.printf("%d볼 %d스트라이크\n",ballCount,strikeCount);
        }
    }

    public void printWhenUserWin(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
