## 기능 요구 사항

기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
    - 예) 상대방(컴퓨터)의 수가 425일 때
        - 123을 제시한 경우 : 1스트라이크
        - 456을 제시한 경우 : 1볼 1스트라이크
        - 789를 제시한 경우 : 낫싱
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한
  결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 구현 기능 목록
1. 앱의 메인화면 기능 구현(main)
2. Count 클래스에서 Strike + Ball 을 세는 기능 (getSameNum)
3. Count 클래스에서 Strike를 세는 기능 (countStrike)
4. Print 클래스에서 Hint를 출력하는 기능 구현(Hint)
5. Feat : 기본적으로 게임을 플레이하는 기능 구현 (playGame) strike가 3개가 될 때까지 게임 반복 
6. 게임 Restart를 선택할 수 있는 기능 구현 (EndSelect)
7. 게임 시작 기능 구현 (startGame)
8. Player 클래스 기능 구현, 체크하고 다시 플레이어의 숫자 배열 리스트 만들기 (NumList, CheckNum)
9. 컴퓨터의 숫자 리스트를 받아오는 기능 구현(NumList)
10. 첫 입력에서 세자리 수를 입력해야 하는 예외처리(CheckNotThreeLength)
11. 첫 입력에서 중복 입력을 제외하는 예외처리(CheckNotRedundant)
12. 첫 입력에서 숫자가 아닌 것을 제외하는 예외처리(CheckNotNumber)
13. 두번째 입력에서 1,2가 아닌 것을 제외하는 예외처리(CheckNotRestartNum)
14. Count 클래스만 객체로 표현 
15. 객체에 맞게 ballCount 기능을 구현하여 Strike와 Ball의 개수를 세었다. (ballCount)
16. 출력문을 그에 맞게 출력함수로 생성하였다. (StartMessage(),EndMessage(),RestartMessage();) / 메세지 클래스에 생성.

## 게임 진행 순서
startGame -> playGame
Computer.NumList 컴퓨터의 숫자 세자리를 가져온다.
Player.NumList 플레이어의 예측 숫자 세자리 입력 받는다.
Strike 개수 countStrike로 세고
Ball 개수 getSameNum - countStrike 해서 Ball 개수 세기
EndSelect 에서 게임을 재시작 할 것인지 입력받는다.