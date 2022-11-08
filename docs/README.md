# 기능 추가 사항

## 게임 진행 순서

1. 게임 시작 문구 출력

2. camp.nextstep.edu.missionutils.Randoms 의 pickNumberInRange()를 활용해 컴퓨터(상대방)값 받기 

3. 숫자를 입력하세요 문구가 출력되면서, 나의 숫자 입력하기
   1. 나의 숫자 검증하기

4. 컴퓨터와 나의 숫자를 비교해 결과 출력하기 
   1. 3스트라이크라면, '게임 종료'문구 출력 후 선택하기
      1. 1번 입력시, 2번으로 가서 새 컴퓨터 값과 함께 새 게임 시작하기
      2. 2번 입력시, 게임 그대로 종료하기
   2. 3스트라이크 아니라면, 큰괄호 3번으로 이동해서 재입력 받기



## 기능

- startGame() - 게임을 처음 시작시키는 함수

- setComputerNum() - 컴퓨터의 숫자를 랜덤으로 뽑아서 저장하는 함수

- myNumber() - '숫자를 입력하세요'문구와 함께 나의 숫자를 입력하는 함수

   - validNumber() - IllegalArgumentException 이용한 내 숫자 검증 (validLength(길이 검증),validDuplication(숫자 중복 검증),validNotnumber(숫자 외 문자 입력 검증))
   - toInteger() - readline()으로 받은 String형태의 내 입력값을 Integer 리스트로 변환

- StrikeOrBall()- 입력된 숫자를 판단하여 strike,ball을 출력하는 함수
   - isStrike() - 스트라이크 수를 계산하는 함수
   - isBall() - 볼 수를 계산하는 함수

- moreGame()- 한 게임 종료 후, 더 할것인지 결정하는 함수




