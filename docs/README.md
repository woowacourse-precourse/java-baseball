######숫자야구게임######

> 첫번째, random숫자를 리턴하는 AnswerNumber 기능
숫자 야구 게임에서 우선 랜덤으로 세자리의 숫자를 컴퓨터가 반환하게끔 하는 기능이다.
세가지의 숫자가 겹칠 경우 다시 반복하여 세가지의 숫자가 겹치지 않게끔 1~9 사이의 숫자 중 하나를 반환한다.
숫자들은 각각 randoms.pickNumberInRange()로 생성되어
ArrayList<Integer> list에 담긴다.


> 두번째, 사용자가 입력한 숫자를 반환하는 PlayerNumber 기능
player가 세가지 숫자의 답을 유추해낼 숫자를 반환하는 기능이다.
일단, 사용자가 입력한 숫자를 String으로 받은 후에 이를 char배열로 변환하여 다시 int로 변환한다.
그 다음에 ArrayList<Integer> playerIntNumList에 담아서 반환한다. 


> 세번째, 사용자가 입력한 숫자가 제대로 되었는지를 확인하는 CheckPlayerNum 기능
1. 사용자가 입력한 세자리의 숫자의 길이가 3인지를 체크한다.
3이하이거나 이상일 경우 IllegalArgumentException 예외를 던지고 게임이 종료된다.
2. 사용자가 입력한 세자리의 숫자 중 중복된 숫자가 있으면 마찬가지로 IllegalArgumentException을 던지고 게임이 종료된다.
이렇게 사용자가 입력한 숫자가 잘 입력되어있는지를 확인하는 기능이다.


> 네번째, 사용자가 입력한 숫자와 컴퓨터가 생성한 숫자를 비교하는 Compare 기능
1. 사용자가 입력한 숫자와 컴퓨터가 생성한 숫자를 비교하여 몇 번 비교했는지를 반환하는 메소드 getMatchResult를 통해 총 비교 숫자를 반환한다.
2. strikeCount로 사용자 숫자와 컴퓨터 숫자를 비교해 두 숫자 중 같은 숫자의 수를 strike에 담아 반환한다.


> 다섯번째, 결과를 반환하는 Output 기능
Compare 기능에서 생성된 strike와 총 비교횟수인 total의 값을 얻어서 이 두 개를 빼면 ball의 값을 알아낼 수 있다.
ball 값을 알아낸 후에, total이 0면 "낫싱",
strike가 0면 ball의 값을 반환,
ball값이 0면 strike의 값을 반환,
그 외에 ball값과 strike값을 반환한다.



> 여섯번째, 게임을 다시 시작할지 말지 결정하는 TryAgain 기능
세가지 숫자를 다 맞춰 게임이 종료된 후에, 게임을 새로 시작할지 말지를 묻는 기능이다.
1을 받으면 boolean값으로 true를 반환하여 다시 시작,
2를 받으면 boolean값으로 false를 반환하여 게임이 종료된다.



> 마지막, 게임을 실행하는 Application 기능
컴퓨터와 사용자의 세가지 숫자를 받은 후에 사용자의 세가지 숫자가 CheckPlayerNum 테스트를 통과하면 3스트라이크가 될때까지 계속해서 숫자를 입력받는다. 
3스트라이크가 되면 게임을 다시 시작할지 말지를 결정하는 TryAgain기능으로 마무리된다. 

