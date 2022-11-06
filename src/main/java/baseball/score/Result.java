package baseball.score;

public class Result {

  public String getResults(Integer strikeCount, Integer ballCount) {
    if (isNothing(strikeCount, ballCount)) {
      return "낫싱";
    }

    StringBuilder stringBuilder = new StringBuilder();

    if (isBall(ballCount)) {
      stringBuilder.append(ballCount).append("볼 ");
    }

    if (isStrike(strikeCount)) {
      stringBuilder.append(strikeCount).append("스트라이크");
    }

    return stringBuilder.toString().stripTrailing();
  }

  public boolean isNothing(Integer strikeCount, Integer ballCount){
    return strikeCount == 0 && ballCount == 0;
  }

  public boolean isBall(Integer ballCount){
    return ballCount > 0;
  }

  public boolean isStrike(Integer strikeCount){
    return strikeCount > 0;
  }

}
