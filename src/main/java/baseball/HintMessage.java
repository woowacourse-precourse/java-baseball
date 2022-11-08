package baseball;

enum HintMessage {
    NOTHING("낫싱"),
    STRIKE("%s스트라이크"),
    BALL("%s볼"),
    STRIKE_AND_BALL("%s볼 %s스트라이크");

    private final String message;

    HintMessage(String message){
        this.message = message;
    }

    public String message(){
        return message;
    }
}
