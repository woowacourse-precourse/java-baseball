package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Computer {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    private static final List<Integer> computer = new ArrayList<>();

    public void selectUniqueNumbers(){

        computer.clear();

        while (computer.size() < Application.LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputer(){
        return Collections.unmodifiableList(computer);
    }

    //    @Override
//    public String toString() {
//        Iterator<Integer> it = computer.iterator();
//
//        String s = "";
//        while(it.hasNext()){
//            s += it.next() + ", ";
//        }
//        return s;
//    }

}
