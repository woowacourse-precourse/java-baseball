package custom.service.vo;

public enum ReTry {
    YES("1"),
    NO("0");

    private final String name;

    ReTry(String name) {
        this.name = name;
    }

    static ReTry nameOf(String name) throws IllegalArgumentException {
        for (ReTry reTry : ReTry.values()) {
            if (reTry.getName().equals(name)) {
                return reTry;
            }
        }
        throw new IllegalArgumentException("1 또는 2만 입력 가능합니다");
    }

    public String getName() {
        return name;
    }
}
