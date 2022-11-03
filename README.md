### 구현기능 목록
1부터 9까지 서로 다른 수로 이루어진 3자기의 수를 맞추는 게임이다.

#### 컴퓨터
* 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
* 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
#### 플레이어
* 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력한다.
* 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생 시킨 후 애플리케이션은 종료되어야 한다.
* 컴퓨터가 생각하는 서로다른 3개의 숫자를 모두 맞히면 게임이 종료된다.

#### 힌트
* 같은 수가 같은 자리에 있으면 스트라이크이다.
* 다른 자리에 있으면 볼이다.
* 같은 수가 전혀 없다면 낫싱이다.
* 위의 힌트들을 이용하여 상대방의 수를 맞춘다.

#### 입력
* 서로 다른 3자리의 수
* 게임이 끝난 경우 재시작/종료를 구분하는 1과 2중 하나의 수

#### 출력
* 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시


----
### 프로그래밍 요구사항
- [ ] JDK 11 버전에서 실행 가능해야 한다
- [ ] 프로그램 실행의 시작점은 Application의 main()
- [ ] Java 코드 컨벤션 가이드를 준수한다.
- [ ] 프로그램 종료 시 System.exit()를 호출하지 않는다.
- [ ] 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다.
- [ ] indent(인덴트, 들여쓰기) depth를 2까지만 허용한다.

### 라이브러리
* `camp.nextstep.edu.missionutils`에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
