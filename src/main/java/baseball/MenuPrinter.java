package baseball;

public class MenuPrinter {
    public void printMenu(boolean correct){
        if(correct){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        }else{
            System.out.printf("숫자를 입력해주세요 : ");
        }
    }
}
