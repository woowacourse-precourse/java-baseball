# 기능 목록

| # | 기능 이름 | 기능 구현 객체 |
|---|-----------|--------------|
| 1 | 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. | `Application`, `Randoms` |
| 2 | 컴퓨터는 플레이어에게 입력을 요구한다. | `AIPlayer` |
| 3 | 컴퓨터는 플레이어가 입력한 숫자에 대한 결과를 출력한다. | `Application` |
| 3-1 | 플레이어의 입력을 확인 | `Console` |
| 3-2 | 플레이어의 입력을 검증 | `GuessValidator` |
| 3-3 | 같은 수가 같은 자리에 있으면 스트라이크 | `BaseballGamePolicy` |
| 3-4 | 같은 수가 다른 자리에 있으면 볼 | `BaseballGamePolicy` |
| 3-5 | 같은 수가 전혀 없으면 낫싱 | `BaseballGamePolicy` |
| 3-6 | 결과를 플레이어에게 출력 | `BaseballGamePolicy` |
| 4 | 이 같은 과정을 반복 | `Application` |
| 5 | 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료 | `Application`, `BaseballGamePolicy` |
| 6 | 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다. | `Application` |
| 7 | 잘못된 값을 입력할 경우 IllegalArgumentException으로 종료 | `GuessValidator` |
