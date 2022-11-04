package baseball;

import java.util.List;
import java.util.Objects;

public class Game {
    Input_Output IO = new Input_Output();
    static int Strike_count=0;
    static int Ball_count=0;
    public void Print()
    {


        IO.Computer_RandomNumber();
        System.out.println(IO.computer);
        IO.User_enter();
        BaseNumber_Check(IO.computer,IO.Scan);
        System.out.println(Strike_count + " 스트라이크 "+ Ball_count + "볼");

    }

    public static void BaseNumber_Check(List<Integer> computer,List<Integer> User)
    {
        for(int i=0; i<computer.size();i++)
        {
            if(Number_Check(computer.get(i),User.get(i)))
                Strike_count++;
            else
                Ball_Repeat(computer.get(i),User);


        }
    }

    public static boolean Ball_Repeat(int computer, List<Integer> User)//볼을 확인하기 위한 반복
    {
        for(int j =0; j<User.size();j++)
        {
            if(Number_Check(computer,User.get(j)))
                Ball_count++;
        }

        return false;
    }

    public static boolean Number_Check(int computer,int User)//같은 숫자가 맞는지 확인
    {
        if (Objects.equals(computer, User))
            return true;

        return false;
    }



}
