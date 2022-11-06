package baseball.score;

public class Result {
  private final Integer strikeCount;
  private final Integer ballCount;

  private Result(Integer strikeCount, Integer ballCount){
    this.strikeCount = strikeCount;
    this.ballCount = ballCount;
  }

  public boolean isNothing(){
    return this.strikeCount == 0 && this.ballCount == 0;
  }

  public boolean isBall(){
    return this.ballCount > 0;
  }

  public boolean isStrike(){
    return this.strikeCount > 0;
  }

  public String getResults(Integer strikeCount, Integer ballCount) {
    if (isNothing()) {
      return "낫싱";
    }

    StringBuilder stringBuilder = new StringBuilder();

    if (isBall()) {
      stringBuilder.append(ballCount).append("볼 ");
    }

    if (isStrike()) {
      stringBuilder.append(strikeCount).append("스트라이크");
    }

    return stringBuilder.toString().stripTrailing();
  }
}
