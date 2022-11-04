package baseball;

public class Strike {
    Computer computer = new Computer();

    public int compareCharacterLocationMatch() {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            if(InputNumber.number.charAt(i)
                    == computer.randomNumberListToString().charAt(i)){
                count++;
            }
        }
        return count;
    }
}
