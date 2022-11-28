# Domain
## User
  - [] 게임이 끝난 경우 재시작/종료를 구분하는 1과 2중 하나의 수 입력 

## RandomNumber
  - [x] 1~9 사이의 서로 다른 수로 이루어진 숫자 Randoms를 이용하여 값 추출

## RandomNumbers
  - [] RandomNumber를 이용하여 3자리 수 생성하는 기능

## Computer
  - [] RandomNubers를 생성하는 기능

# Controller
## GAME
  - [] 같은 자리에 위치한 수가 일치한 경우: 스트라이크
  - [] 다른 자리에 동일한 수가 위치한 경우: 볼
  - [] 입력된 수가 하나도 없는 경우: 낫싱

# EXCEPTION
  - [x] USER가 서로 다른 3자리의 수를 입력하지 않은 경우
  - [x] 중복되는 숫자를 입력한 경우
  - [x] RandomNumber가 중복되는 수를 생성한 경우
  - [] 게임이 끝난 경우 재시작/종료를 구분하는 숫자를 잘못 입력한 경우

# View
## InputView
  - [x] User가 숫자를 입력하는 기능
## OutputView
  - [x] 시작 메세지
  - [x] 입력 메세지
  - [] 오류 메세지
  - [] 결과 출력 메세지	