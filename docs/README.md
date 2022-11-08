# 기능 목록 - 숫자 야구

## 1. 랜덤 숫자 생성
generateNumber()함수를 통해 BaseballGame안의 number값을 생성합니다. (camp.nextstep.edu.missionutils에서 제공하는 Randoms API를 사용합니다)
## 2. 3스트라이크가 될 때까지 게임 진행
반복문 안에서 3스트라이크(threeStrike값이 true)가 되기 전까지 사용자의 입력을 계속 받습니다.
### 2-1. 사용자 입력 받기
Console API의 Console.readLine()을 이용하여 사용자의 입력을 받습니다.
### 2-2. 예외 처리
사용자 입력이 '서로 다른' '1~9 사이의 숫자' '세 자리'인지 확인한 후, 예외가 발생한 경우 IllegalArgumentException을 발생시킵니다.
### 2-3. 스트라이크, 볼 갯수 계산
사용자 입력이 BaseballGame의 number값과 얼마나 일치하는지 판별하여 strikeCount과 ballCount를 계산합니다.
### 2-4. 결과 출력
계산한 strikeCount과 ballCount 값을 바탕으로 결과를 출력합니다. 
## 3. 게임을 종료한 후 게임을 다시 시작할건지 종료할건지 선택하는 부분
3스트라이크인 경우 게임을 다시 시작할건지 완전 종료할건지 물어보고, 사용자 입력의 예외 처리를 진행합니다.
그 후, gameRestart값에 따라 새로운 BaseballGame을 생성 여부를 main함수의 반복문에서 결정합니다.