package baseball;

public class Result {
    private Integer strikeCnt;
    private Integer ballCnt;

    public Result(Integer strikeCnt, Integer ballCnt) {
        if (strikeCnt < 0 || strikeCnt > 3 || ballCnt < 0 || ballCnt > 3) {
            throw new IllegalStateException("strike와 ball은 3개까지만 가능합니다");
        }
        if (strikeCnt + ballCnt > 3) {
            throw new IllegalStateException("strike와 ball을 합친 숫자가 자릿수보다 클 수는 없습니다");
        }
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }

    public Integer getStrikeCnt() {
        return strikeCnt;
    }

    public Integer getBallCnt() {
        return ballCnt;
    }

    public Boolean isThreeStrike() {
        return strikeCnt == 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(strikeCnt, result.strikeCnt) && Objects.equals(ballCnt, result.ballCnt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCnt, ballCnt);
    }
}
