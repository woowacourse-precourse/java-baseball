# 기능 구현 목록

1. generateNumber() - Randoms.pickNumberInRange를 이용해 랜덤으로 3자리 중복되지 않는 숫자를 생성하는 함수.
2. getInput() - 사용자로부터 input을 받아오는 함수. Console.readLine을 이용.
3. checkInput() - input이 요구하는 형태로 들어왔는지 검사하는 함수. 아닐 시 IllegalArgumentException을 생성.
4. countAnswer() - 받은 input과 생성된 answer을 비교해 ball, strike count를 리턴하는 함수.
5. playMathBaseball() - 위 함수들을 이용해 입력을 받고 이를 비교해 적절한 아웃풋을 생성하는 함수. 마찬가지로 적절하지 않을 시 IllegalArgumentException을 생성.
6. checkGameState() - 한 게임이 종료된 이후, 적절한 input이 들어오는지 검사하는 함수.