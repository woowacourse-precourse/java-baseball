Feat: "입력 기능 구현"

BaseBall 게임의 랜덤 값을 맞추기 위해 입력 기능이 필요
입력 값은 숫자로만 이루어짐, 게임 진행 중인 경우 길이가 세자리라는 조건
종료 시 1과 2로만 이루어져야함
나머지 조건은 모두 오류로 발생 후 종료
입력 기능은 BaseBall 게임만의 기능이 아니라고 생각하기 때문에 Input 클래스 선언 
Input 클래스는 각 단계의 입력 값을 받는 메소드(playInput, endInput)와
입력 값이 조건을 구분하는 메소드(regexCheck,playInputCheck,endInputCheck)로 구성
