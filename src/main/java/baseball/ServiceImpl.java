
package baseball;


public class ServiceImpl implements Service {

    public ServiceImpl() {
    }
    @Override
    public void readyGame() {
        int strike = 0;
        char[] number = // 숫자생성;

        while(strike != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            char[] input = //입력
            int[] count = baseBall(number,input);
            strike = count[0];
        }
    }
    @Override
    public int[] baseBall(char[] number, char[] input) {
        int[] count = new int[]{0, 0};

        for(int i = 0; i < 3; ++i) {
            // 스트라이크 볼 처리
        }

        return count;
    }
}
