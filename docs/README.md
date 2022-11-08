#기능 목록
Application.java 
1. Game객체를 만들어 게임 반복하는 함수를 실행
Game.java
1.Computer객체를 만들어 무작위의 컴퓨터의 3자리 수를 만들고 게임이 끝날떄 까지 반복하는 메소드
2.각 게임마다 숫자를 입력받고 User객체를 만들어 유저에게 숫자를 받아 볼,스트라이크를 계산하고 결과를 나타내주는 메소드
Computer.java
1.무작위의 세자리 수를 IntegerList로 만들어 this.integerList로 설정해주는 메소드
User.java
1.String을 각자리마다 숫자로 만들어 integerList로 반환해주는 메소드
2. 첫자리가 0인지, 세자리수가 아닌지, 각자리가 '0'~'9'인지 확인해주고 아니면 IllegalArgumentException()에러를 날려주는 메소드
3. 1,2함수를 같이 실행해 intergetList를 반환해주는 메소드
4. 유저에게 string을 입력받고 3번 함수의 반환값을 this.integerList로 만들어주는 메소드
Result.java
5. List<Integer>을 두개 받아 각 인덱스의 숫자가 같으면 strike++,다르지만 혹시 다른 자리에 포함된다면 ball++을 해주는 메소드