### 기능 목록
1. 컴퓨터의 수를 랜덤으로 정하는 기능 
- 1부터 9사이의 수 중 무작위로 뽑는 함수 : int getRandomNumber()
- 수를 computer 리스트에 추가하는 함수 : void addComputerNumber()
2. 사용자의 수를 입력받아 적합성 판단
- Console.readLine()
- 입력한 String의 요소를 int로 바꾸는 기능 : int charToInt()
- 숫자의 개수가 3이 아닌지 판단하는 기능 : void checkNumberLength()
- 1~9가 아닌 문자가 있는지 판단하는 기능 : void checkAdequateNumber()
- 입력한 숫자를 리스트에 추가하는 기능 : void addUserNumber()
- 같은 수가 있는지 판단하는 기능 : boolean checkOverlap()
3. 컴퓨터 수와 사용자 수를 비교하는 기능
- ball 개수 세는 기능 : int countBall()
- strike 개수 세는 기능 : int countStrike()
- 볼카운트 출력하는 함수 : in printCount()
- 게임 재시작/종료 정하는 기능 : int restartOrExit()