package baseball.model;

enum ResultList {
    Ball("볼"),
    STRIKE("스트라이크"),
    NOTTING("낫싱");

    final private String result;

    ResultList(String result) {
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }
}

public class ResultModel {

}
