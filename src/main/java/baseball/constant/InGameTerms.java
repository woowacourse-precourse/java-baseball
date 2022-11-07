package baseball.constant;

public enum InGameTerms {
  BALL("볼"),
  STRIKE("스트라이크"),
  NOTHING("낫싱");

  private String term;

  InGameTerms(String term) {
    this.term = term;
  }

  public String getTerm() {
    return term;
  }
}
