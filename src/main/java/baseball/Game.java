package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    int[] number = new int[3];
    Game(){
        int currentRandomNumber;
        int currentNumberIndex =0;

        for(int i=0; i<3; i++){
            number[i] = Integer.parseInt(i+"");
        }
        while(currentNumberIndex<3){
            currentRandomNumber = this.getRandomNumber();
            for(int num:number){
                if(num==currentRandomNumber){
                    number[currentNumberIndex] = currentRandomNumber;
                }
            }
        }
    }

    private int getRandomNumber() {
        return pickNumberInRange(1,9);
    }
}
