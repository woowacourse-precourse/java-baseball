package baseball.domain.score;

public class Result {
  private final Integer strikeCount;
  private final Integer ballCount;

  public Result(Integer strikeCount, Integer ballCount){
    this.strikeCount = strikeCount;
    this.ballCount = ballCount;
  }

  private boolean isNothing(){
    return this.strikeCount == 0 && this.ballCount == 0;
  }

  private boolean isBall(){
    return this.ballCount > 0;
  }

  private boolean isStrike(){
    return this.strikeCount > 0;
  }

  public String getResults() {
    if (isNothing()) {
      return "낫싱";
    }

    StringBuilder stringBuilder = new StringBuilder();

    if (isBall()) {
      stringBuilder.append(this.ballCount).append("볼 ");
    }

    if (isStrike()) {
      stringBuilder.append(this.strikeCount).append("스트라이크");
    }

    return stringBuilder.toString().stripTrailing();
  }

}
