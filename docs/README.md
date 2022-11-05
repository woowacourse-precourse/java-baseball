                            숫자야구 기능 목록
1.PickRandomNumber() </br>
-->Console api 를 이용해서 List에 랜덤난수 3개저장</br>

2.InputNumber() </br>
--> Console 로 입력값을 string 으로만 받을수있기때문에 String으로 받은
문자열을 int[] 안에 넣어준다.</br>

3.Strike3()</br>
--> Strike가 3번이면 정답이기때문에 종료하고 한번더할지,아니면 종료할지
선택창을 뛰워준다.</br>

4.CheckResult()</br>
-->Ball 갯수 랑Strike 갯수 를 HashMap 으로 받아서 논리연산자에따라 뛰워준다.

5.BallStrike()</br>
-->ball이랑Strike갯수를 받아서 HashMap으로 리턴해준다.</br>

6.Ball()</br>
-->Ball값을 계산해서 반환</br>

7.Strike()</br>
-->Strike값을 계산해서 반환</br>

8.Restart()</br>
-->다시시작하면 PickRandomNumber()메소드를 호출하여 변수에 넣어준다.</br>

9.GoAndStop()</br>
-->입력값이 세자리면 int[] 담아서 리턴하고 3자리가 아니면 IllegalArgumentException 을
발생시킨다.