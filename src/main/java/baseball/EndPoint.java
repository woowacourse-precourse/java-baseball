package baseball;

public enum EndPoint {
    RE_START("1"),End("2");
    public final String flag;

    EndPoint(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }
}
