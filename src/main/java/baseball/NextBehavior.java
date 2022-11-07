package baseball;

public class NextBehavior {
    Integer decision;
    public NextBehavior(String decision) throws IllegalArgumentException {
        this.decision = Integer.parseInt(decision);
        if(this.decision != 1 && this.decision != 2){
            throw new IllegalArgumentException("1과 2중의 하나의 값만 입력해야합니다.");
        }
    }
}
