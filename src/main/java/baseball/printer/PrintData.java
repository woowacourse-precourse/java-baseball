package baseball.printer;

import baseball.data.BaseballData;

public enum PrintData {
    GAME_START("숫자 야구 게임을 시작합니다."),
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱"),
    INPUT_STRING("숫자를 입력해주세요 : "),
    ALL_STRIKES(BaseballData.GAME_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART("게임을 새로 시작하려면 " + BaseballData.RESTART + ", 종료하려면 "
        + BaseballData.GAME_OVER + "를 입력하세요")
    ;

    private final String printResult;

    PrintData(String result){
        this.printResult= result;
    }

    public static final void printData(String label){
        for(PrintData printDataValue : PrintData.values()){
            if(printDataValue.toString().equals(label)) {
                System.out.print(printDataValue.printResult);
            }
        }
    }

    public static final void printLine(){
        System.out.println();
    }

    public static final void printSpace(){
        System.out.print(" ");
    }
}
