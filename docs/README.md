## 구현할 기능 목록

1. 컴퓨터가 1에서 9까지 서로 다른 임의의 수 3개를 선택할 수 있도록 함: Computer 클래스 생성자
2. 사용자가 서로 다른 3자리의 수를 입력할 수 있도록 함: User 클래스 setInputForAnswer 함수
3. 사용자의 입력이 서로 다른 3자리의 수인지 확인할 수 있도록 함: User 클래스 checkInputForAnswer 함수
4. 컴퓨터의 정답과 사용자의 인풋을 비교해 낫싱인지 확인함: Computer 클래스 isNothing 함수
5. 숫자와 자릿수가 주어졌을 때 해당 숫자가 정답의 같은 자릿수에 있는지 확인함: Computer 클래스 isStrike 함수
6. 숫자와 자릿수가 주어졌을 때 해당 숫자가 정답의 다른 자릿수에 있는지 확인함: Computer 클래스 isBall 함수
7. 컴퓨터의 정답과 사용자의 인풋을 비교해 스트라이크의 수를 반환함: Computer 클래스 getStrikeCount 함수
8. 컴퓨터의 정답과 사용자의 인풋을 비교해 볼의 수를 반환함: Computer 클래스 getBallCount 함수
9. 컴퓨터의 정답과 사용자의 인풋을 비교해 나온 힌트들을 문자열로 리턴함: Computer 클래스 getResult 함수
10. 컴퓨터의 정답과 사용자의 인풋이 동일한지 확인하여 게임 종료 여부를 리턴함: Computer 클래스 isGameOver 함수
11. 사용자가 1 또는 2의 옵션을 입력할 수 있도록 함: User 클래스 setInputForOption 함수
12. 사용자가 입력한 옵션이 1, 2 중에 하나인지 확인할 수 있도록 함: User 클래스 checkInputForOption 함수
13. 사용자가 정답을 정확히 맞힐 때까지 입력을 받고 그에 따른 결과가 출력될 수 있도록 함: Application 클래스 baseBall 함수
14. 사용자가 잘못된 값을 입력하거나 종료 옵션을 주지 않는 이상 숫자 야구 게임이 계속될 수 있도록 함: Application 클래스 main 함수