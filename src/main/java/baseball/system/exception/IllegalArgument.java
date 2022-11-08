package baseball.system.exception;

public class IllegalArgument {
    public static void outOfRange(int start,int end){
        throw new IllegalArgumentException(String.format("입력이 지정된 범위를 벗어났습니다.(%d ~ %d 사이의 값들로 입력)",start,end));
    }

    public static void notNNumbers(int count){
        throw new IllegalArgumentException(String.format("%d개의 숫자가 아닙니다.",count));
    }

    public static void duplicateNumberExists(){
        throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
    }
}
