# :chicken: Algorithm

---

### Study Flow

- Implementation
- BFS/DFS
- Back Tracking
- Greedy
- **_DP (LIS)_**
- Hash

---

### :wave: 문제 풀이

- Programmers

  - Lv.1
  - ~~기능 개발~~

- BOJ

  - ~~2564 경비원~~
  - ~~17478 재귀함수가뭔가요~~
  - ~~1244 스위치 켜고 끄기~~
  - ~~2563 색종이~~
  - ~~2567 색종이2~~
  - ~~15649-15666 N과M 시리즈 11문제~~
  - ~~2493 탑~~
  - ~~9663 N-Queen~~
  - ~~1074 Z~~
  - ~~10972 다음 순열~~
  - ~~10973 이전 순열~~
  - ~~10819 차이를 최대로~~
  - ~~1158 요세푸스 문제~~
  - ~~1260 DFS와BFS~~
  - ~~2178 미로 탐색~~
  - ~~2839 설탕 배달~~
  - ~~16926 배열돌리기1~~
  - ~~16927 배열돌리기2~~
  - ~~16935 배열돌리기3~~
  - ~~17406 배열돌리기4~~
  - ~~15900 나무탈출~~
  - ~~4963 섬의 개수~~
  - ~~18352 특정 거리의 도시 찾기~~
  - ~~14502 연구소~~
  - ~~2941 크로아티아 알파벳~~
  - ~~2961 도영이가 만든 맛있는 음식~~
  - ~~1182 부분수열의 합~~
  - ~~6603 로또~~
  - ~~3040 백설공주와 일곱 난장이~~
  - ~~11399 ATM~~
  - ~~11047 동전0~~
  - ~~2630 색종이~~
  - ~~15686 치킨배달~~
  - ~~18405 경쟁적 전염~~
  - ~~1992 쿼드트리~~
  - ~~1931 회의실 배정~~
  - ~~17135 캐슬디펜스~~
  - ~~18428 감시피하기~~
  - ~~2138 전구와 스위치~~
  - ~~16234 인구 이동~~
  - ~~1377 버블 소트~~
    <<<<<<< HEAD
  - ~~12865 평범한 배낭~~
  - ~~1463 1로 만들기~~
  - ~~1715 카드 정렬하기~~
  - ~~1715 카드정렬하기~~
  - ~~2933 미네랄~~
  - ~~2636 치즈~~
  - ~~17836 공주를 구해라!~~
  - ~~7576 토마토~~
  - ~~1759 암호 만들기~~
  - ~~16236 아기 상어~~
  - DP, LIS , MST 공부

- SW Expert

  - ~~1859 백만장자 프로젝트~~
  - ~~1984 중간 평균값 구하기~~
  - ~~1289 원재의 메모리 복구하기~~
  - ~~1208 Flatten~~
  - ~~1210 Ladder1~~
  - ~~1954 달팽이 숫자~~
  - ~~1873 상호의 배틀필드~~
  - ~~2805 농작물 수확하기~~
  - ~~11315 오목 판정~~
  - ~~11387 몬스터 사냥~~
  - ~~2001 파리 퇴치~~
  - ~~1218 괄호 짝짓기~~
  - ~~1225 암호생성기~~
  - ~~1861 정사각형 방~~
  - ~~3499 퍼펙트 셔플~~
  - ~~1223 계산기2~~
  - ~~5215 햄버거다이어트~~
  - ~~9229 한빈이와 Spot Mart~~
  - ~~1227 암호문1~~
  - ~~6808 규영이와 인영이의 카드게임~~
  - ~~1949 등산로 조성~~

- 정올
  - ~~1828 냉장고~~

---

### :book: 새롭게 익힌 사실

- 2021/01/28

  - Array to ArrayList
    ```jsx
    List < Integer > list = Arrays.asList(arr);
    ```
  - ArrayList to Array
    ```jsx
    ArrayList<Integer> list = new ArrayList<>();
    int[] arr = list.toArray();
    ```
  - List 거꾸로 뒤집기
    ```jsx
    Collections.reverse(list);
    ```
  - PriorityQueue

    - 정렬을 하는 기준인 Comparable Interface를 구현해야 함

      - CompareTo( ) : 우선순위 비교 메소드

        ```jsx
        public Class Corona implements Comparable<Corona>{
          @Override
          public int compareTo(Corona c) {

            return this.spreadSpeed - c.spreadSpeed;

          }
        }
        ```

      - Comparable Interface를 상속받은 다음에 compareTo 메소드를 오버라이딩 해야 함
      - offer() : 요소 추가
      - poll(): 맨 앞 요소를 뽑아서 반환 ( Queue에서는 제거 됨)
      - peek(): 맨 앞 요소를 반환 ( Queue에는 남아있음 )

  - Comparable<T>

    - Priority queue에 사용하는 비교 인터페이스
    - 클래스 내부에 compareTo() 함수를 구현한다

  - Comparator<T>

    - compare( ) 함수 구현

      ```jsx
      public int compare(int p1, int p2) {
        if (p1 > p2) {
          return 1; // 1은 뒤집음 (즉, 큰게 뒤로 (오름차순))
        } else if (p1 < p2) {
          return -1; // -1이면 그대로
        } else
          return 0;
      }
      ```

    - ArrayList 정렬하기 (feat. Anonymous Class)

      ```jsx
      Collections.sort( list, new Comparator<Integer>( ) {

        public int compare(int p1, int p2) {

        return p1 - p2; // 반대로 하면 내림차순

        }

      }
      ```

- 2021/01/29

  - String 객체 vs String 리터럴

    - String 객체
      ```jsx
      String str = new String("hello");
      ```
      - 객체로 생성하면 Heap 영역에 생성됨
    - String 리터럴
      ```jsx
      String str = "hello";
      ```
      - 리터럴로 생성하면 String Constance Pool 영역에 생성됨
      ```jsx
      String str2 = "hello";
      str == str3  // true
      ```
      - 문자열이 같은 String 리터럴은 서로 같다 ( 둘다 같은 pool을 참조함)

  - Collections

    - Set / List
      - add 로 추가
        - add(a) : 맨뒤에 추가
        - add(0,b) : 0번째에 추가후 나머지를 뒤로 밀음
        - set(0,c) : 0번째에 덮어쓰기
        - remove(인덱스), remove(객체) : 요소 제거
        - get(인덱스): i번째 요소 확인
    - Map
      - put(key,value) : 추가
      - get(key) : key에 해당하는 value 확인
      - remove(key) : key value 삭제

- 2021/01/31

  - char to int
    ```jsx
    Character.getNumericValue("1");
    ```

- 2021/02/02

  - 완전탐색

    - nPr (Permutation, 순열)
    - nCr (Combination, 조합)
    - 부분 집합

  - 순열 Permutation
    - 반복문을 통한 구현
    - 재귀를 통한 구현

  ```jsx
    int[] arr = { 1, 2, 3 }; // 3P3

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (arr[j] != arr[i]) {
          for (int k = 0; k < 3; k++) {
            if (arr[k] != arr[i] && arr[k] != arr[j])
              System.out.println(arr[i] + "-" + arr[j] + "-" + arr[k]);
          }
        }
      }
    }
  ```

  ```jsx
  static boolean[] isSelected = new boolean[5];
  static int[] numbers = new int[5];

  public static void perm(int cnt) {
    if (cnt == 5) {
      System.out.println(Arrays.toString(numbers));
      return;
    } else {
      for (int i = 0; i < 5; i++) {
        if (!isSelected[i]) { // 뽑히지 않았으면 뽑음
          numbers[cnt] = i; // 저장
          isSelected[i] = true; // 뽑았다고 표시
          perm(cnt + 1);
          isSelected[i] = false; // 끝나면 뽑았던 표시 제거
        }
      }
    }
  }
  ```

  - 조합 Combination

  ```jsx

  static int[] input = { 1, 2, 3, 4, 5 };
  static int[] numbers = new int[2]; // 5C2 이므로 2개만 저장

  public static void comb(int cnt, int start) {
    if (cnt == numbers.length) {
      System.out.println(Arrays.toString(numbers));
      return;
    } else {
      for (int i = start; i < 5; i++) {
        numbers[cnt] = input[i];
        comb(cnt + 1, i + 1);
      }
    }
  }
  ```

  - 중복 순열

  ```jsx
  public static void RepPerm(int cnt) {
      if (cnt == R) {
        System.out.println(Arrays.toString(output));
        return;
      } else {
        for (int i = 1; i <= N; i++) {
          output[cnt] = i;
          RepPerm(cnt + 1); // 중복을 허용하므로 visited[] 사용 x
        }
      }
    }
  ```

  - 중복 조합

  ```jsx
  public static void RepComb(int cnt, int start) {
      if (cnt == R) {
        System.out.println(Arrays.toString(output));
        return;
      } else {
        for (int i = start; i <= N; i++) {
          output[cnt] = i;
          RepComb(cnt + 1, i); // i+1 시작이 아니라 자기 자신부터 시작
        }
      }
    }
  ```

  - 부분 집합 (Subset, Powerset)

  ```jsx
  public static void SubSet(int cnt) {
      if (cnt == N) {
        for (int i = 0; i < N; i++) {
          if (isSelected[i])
            System.out.print(input[i] + " ");
        }
        System.out.println();
        tot++;
        return;
      } else {
        isSelected[cnt] = true;
        SubSet(cnt + 1);

        isSelected[cnt] = false;
        SubSet(cnt + 1);
      }
    }
  ```

  - Next Permutation

  ```jsx
  static boolean next_permutation(int size) {
      int i = size;
      while (i > 0 && p[i - 1] >= p[i])
        i--;

      if (i == 0) { // 이미 내림차순으로 모두 정렬이 되어있는 경우
        return false;
      } else {
        int j = size;
        while (p[i - 1] >= p[j]) // 피크 다음값보다 작은 바로 직전 값을 찾음
          j--;

        swap(i-1, j);

        int k = size;
        while (i < k) { // 피크 뒷부분을 정렬
          swap(i, k);
          i++;
          k--;
        }
        return true;
      }
    }
  ```

  - Prev Permutation

  ```jsx
  static boolean prev_permutation() {
  	int i = input.length - 1;

  	while (i > 0 && input[i - 1] <= input[i])
  		i--;

  	if (i == 0) {
  		return false;
  	} else {
  		int j = i - 1;
  		while (j + 1 < input.length && input[i - 1] >= input[j + 1])
  			j++;

  		swap(i - 1, j);

  		int k = input.length - 1;

  		while (i < k) {
  			swap(i, k);
  			i++;
  			k--;
  		}

  		return true;
  	}
  }
  ```

- 2021/02/04

  - StringBuilder에 관해서

    - BOJ15651를 풀다가 시간초과가 나길래 재귀 종료시마다 출력하지 않고 Strinbbuilder로 append 해두었다가 모두 완료될때 한번만 출력했더니 훨씬 빨랐음
    - StringBuilder sb = new StringBuilder() 를 Static으로 선언해놓고 최종 단계에서만 출력하기.

  - Set에 관해서

    - BOJ15663 N과M(9) 를 풀다가 중복 처리를 어떻게하지 ? 라는 생각에 중복을 허용하지않는 자료구조인 Set을 사용하고자 했다. 그런데 생각해보니 출력을 비내림 차순으로 정렬해야해서 TreeSet이 사전순 (Lexicographically) 으로 정렬한다는 생각에 TreeSet으로 구현했는데 오답이 나왔다. 생각해보니 사전순이 수열을 비내림차순으로 정렬해주지는 않는다. 따라서 중복을 허용하지 않으면서 삽입 순서대로 자료를 저장하는 LinkedHashSet을 사용해서 풀었다.

  - Stack

    - 선언
      ```jsx
      Stack<Object> S = new Stack<>();
      ```
    - push(Object o) : 요소를 Top에 추가
    - pop() : Top을 삭제
    - peek() : Top을 조회
    - isEmpty() : 스택이 비었는지를 true, false 로 return
    - search(Object o) : 요소가 스택의 몇번째에 있는지를 return

  - Queue
    - 선언
      ```jsx
      Queue<Object> Q = new LinkedList<>();
      ```
    - offer(Object o) : 요소를 enqueue
    - poll(): 요소를 삭제하고 그 요소를 return
    - peek(): 첫번째 요소를 조회
    - isEmpty(): 큐가 비었는지를 true, false 로 return

- 2021/02/05

  - 백트래킹 Back Tracking
    - DFS와 다른 점은 DFS는 모든 경우를 모두 탐색하지만 Back Tracking은 DFS에서 가지치기 (Pruning)을 더한것
    - 즉, 조건을 만족하지 않으면 break를 걸어서 불필요한 재귀 호출을 막는다.
    - N-Queen 문제
      - 처음에 2차원 배열을 생성하고 8방 탐색으로 놓을수 있는 지 없는지를 판별한 후에 놓을수 있는것들만 재귀로 해결하려 했는데 시간초과때문에 안풀림
      - 생각해보니 2차원 배열을 생각할 필요 없이 col 배열을 만들고 index가 c, col[i]가 r로 생각하면 풀수 있었음
      - 가로, 대각선을 판별하는 함수 ( 세로는 어차피 col배열을 for문 돌릴것이기 때문에 중복될 일이 없음)
        - 첫번째 행 (col[0]) 부터 현재행 직전 (col[cnt-1]) 까지 for문을 돌며 가로와 대각선을 검사한다.
      - 백트래킹 답게 판별함수를 통과하지 못한 놈들은 쳐내고 판별함수를 통과한 놈들에 대해서만 재귀를 호출한다.

- 2021/02/09

  - Tree 용어 정리

    - 노드의 차수 : 연결된 자식의 개수
    - 트리의 차수 : 노드의 차수 중 최대값
    - 높이 : 루트에서 노드까지 이르는 간선의 수
    - 이진트리 : 자식이 최대 2개인 트리
    - 포화 이진트리(Full Binary Tree) : 모든 레벨의 노드가 포화상태로 차있는 트리
      - 노드 번호가 같은 레벨에서 왼쪽에서 오른쪽으로 정해진 순서를 가짐
    - 완전 이진트리(Complete Binary Tree)
      - 루트 부터 노드를 채우는 방식은 포화 이진트리와 같지만 마지막 레벨은 꽉 차있지 않은 트리

  - DFS

    ```jsx
    DFS(v){
      v 방문 (visited[v] = true)
      for(v와 연결된 모든 노드 w){
        if(방문하지 않았으면)
          DFS(w);
      }

      return;
    }
    ```

  - BFS

    ```jsx
    BFS(){
      큐 생성
      루트 v를 큐에 삽입

      while(!Q.isEmpty()){
        t = 큐 첫번째 요소를 꺼냄
        t 방문 ( visited[t] = true )
        for( t와 연결된 모든 노드에 대해, 방문하지 않았으면) {
          Q에 그 노드를 삽입
          방문 표시
        }
      }
    }
    ```

  - 최단 거리

    - 최단 거리를 구할때는 BFS로 짜는 것이 유리하다.
    - BFS는 해당 노드에 도착하면 그 거리가 최단거리 이므로 바로 종료하면 된다.
    - 하지만 DFS는 모든 경우를 최단거리를 갱신하며 탐색해야 되므로 비효율적이다.

  - Character.isDigit(c)
    - 매개변수로 넘긴 char이 숫자인지 아닌지를 판별해 주는 함수
    ```jsx
    char a = 'a';
    char b = '9';
    Character.isDigit(a); // False
    Character.isDigit(b); // True
    ```
  - st.countTokens()

    - StringTokenizer의 토큰을 세어주는 함수

  - SWEA1233에 대해
    - 위 두개 함수를 알았으면 Tree의 가장 말단 노드(Token이 2개거나 3개인 노드) 만 숫자여야 하고 그 위 모든 노드(Token이 4개인 노드) 들은 연산자여야 함을 판별해서 쉽게 풀수있었다.
    - 나는 ArrayList로 Tree를 구현해서 일일이 중위 순회로 수식을 검사했다... ㅠ
