## 용어
1. compile : .java를 .class로 변환
2. build : compile + 기타 resource file 등 모두 합친다.
3. View : 아래와 같은 코드는 event 처리 메소드, v는 사건이 발생한 대상이다.

<code>

    public void sub(View v){}
    
</code>


<hr/>

## 단축기, 버그 수정 등
1. Ctrl+O : 부모가 overriding할 수 있는 목록이 팝업창에 출력된다. 참고하기 좋을 듯 <br>
2. 현재(18.08.16)안드로이드 스튜디오는 버그로 인해, 애뮬레이터에서 화면 미리 보기가 안된다. <br>
   **해결 방안** <br>
   Gradle Scripts -> build.gradle -> dependencies에서 2번째 줄 코드를 아래와 같이 수정한다. <br>
   그 다음, 상단에 나오는 Sync now 를 클릭하면 필요한 data를 다운로드하고 환경을 설정한다. <br>
   
<code>
   
      implementation 'com.android.support:appcompat-v7:28.0.0-alpha1'

</code>

3. Ctrl+Q : 코드에 대한 설명
4. Ctrl+D : 커서가 있는 코드를 줄 복사
5. Ctrl+좌클릭 : XML파일의 디자인 탭에서 어떤 UI를 text로 편집하고 싶은 경우

<hr/>

## 액티비티의 수명주기.
* 실행, 일시 중지, 중지는 엑티비티의 상태.
* 각 메소드에 의해 상태가 변환된다.

1. 실행
    * 처음 실행할 때 : onCreate(), onStart(), onResume()
    * 실행 후 일시정지할 때 : onPause()

2. 일시 중지
    * 실행상태로 돌아갈 때 : onResume()
    * 중지할 때 : onStop()
    
3. 중지
    * 다시 실행할 때 : onRestart(), onStart(), onResume()
    * 소멸시킬 때 : onDestroy()
    
* Android는 Thread가 여러개이므로, 여러개의 엑티비티 상태가 동시에 존재할 수 있다. <br>
  즉, 어플리케이션 다운로드하면서, 전화를 함면서, 게임을 할 수 있다.

<hr/>

## 안드로이드 코드의 구성
1. AndroidManifest : 프로젝트의 환경. main Activity를 어떤 Activity로 할 지 결정한다. intent filter에 대한 설명은 뒤에서 한다.

<code>

    <intent-filter>
      <action android:name="android.intent.action.MAIN" />
      <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
            
</code>

2. java 디렉토리 : 맨 위에 있는 건 Activity 목록을 알려준다. 밑의 2개는 test 용도.

3. res-layout : Activity의 UI xml 파일을 보여준다. 디자인을 할 수 있다.

4. res-values : colors, strings, styles 정보 등을 자주 사용할 때, 변수처럼 저장한다

5. gradle : build하는데 도움을 주는 tool. 

## 수업내용

### 1. layout
1. LinearLayout
      * 가로 세로로 정렬하는 제일 간단한 방법
      * XML에서 **android:orientation="vertical"** 와 같은 코드를 추가해주어야한다.


2. ConstraintLayout
   * 각 UI들에 대해 제약조건을 셋팅해주면 UI 배치할 수 있다. <br> 
   * 제약조건이란, 각 UI 및 layout과의 관계를 의미한다. <br>
   * **사용 방법** <br>
      - activity_main.xml의 Design tap을 열어둔다. <br>
      - palette에서 button 등 을 마음대로 가져다 둔다. <br>
      - 상단 탭 중에서 "Infer Constraints"를 클릭하면 각 UI들의 제약조건이 자동으로 입력된다. <br>
        일단 제약조건이 정해지면 수정하기 어렵다. 그럴때는, <br>
        "Infer Constraints" 왼쪽의 "Clear all Constraints"를 클릭하면 모든 제약조건이 지워진다. 이 때 디자인 수정하기 편하다. <br>
      - UI를 선택하면 우측에 Attributes가 나타난다. 여기서 UI의 text, onClick Event 등을 코드없이 편집할 수 있다. <br>
   * UI의 ID를 바꾸면, R.id의 값도 동기화되야한다. 보통은, ID 바꿀 때 동기화를 할 수 있지만, <br>
     이와 관련된 에러가 발생되는 경우, 최상단 우측의 "Sync Project with Gradle Files"를 클릭하면 모든 UI 이름 바뀐게 없는지 확인한다. <br>

### 2. intent
1. intent란? : Activity 간의 전환을 위해 사용되는 시스템이 사용하는 메시지(신호). <br>
               즉, Activity간을 이동하거나 하는데 사용된다. <br>
            
<code>
   
        Intent i = new Intent(this, SubActivity.class);
        startActivity(i);
        
</code>

   * this에서 SubActivity.class로 넘어가는 intent i를 만들었다. startActivity(i)를 통해, Activity 간의 이동을 실행한다.
   * SubActivity.class에서 this로 돌아올때는, SubActivity.class에서 finish() 명령어를 사용한다.

2. intent에 값 지정하기 : 
   * intent는 Activity간의 연결을 위한 메세지 뿐 아니라, data를 저장할 수 도 있다. 아래 코드는 intent를 이용하여 data를 주고받는 방법
   * intent i로 intent를 만든 뒤, putExtra로 값을 넣고, startActivity(i)로 화면 전환 하고, getIntent로 값을 뺄 수 있다.
   * 데이터는 dic처럼 [key, data]를 갖는다.
   * ID, PW 정보 등을 전달할 때 사용될 수 있다.
   
   * A, B Activity가 intent로 연결되어 있고, B가 다음과 같이 i에 data를 저장할 수 있다.
<code>
      
      i.putExtra("code", "droid");
      i.putExtra("count", 999);
        
</code>

   * A에서는 다음과 같이 B에서 저장한 data를 사용할 수 있다.
   
<code>
   
        Intent i = getIntent(); // intent 받기
        String code = i.getStringExtra("code");
        int count = i.getIntExtra("count", 0);
        
</code>

3. Intent의 종류
   * Intent()
   * Intent(Intent o)
      - 명시적 Intent
   * Intent(String action, [.Uri uri])
      - 암시적 Intent
      - Intent 사용 시 어떤 action을 할 것인지, 혹시 데이터가 필요하면 어떤 데이터([.Uri uri])를 사용할지에 대한 기능
      - []는 있으면 쓰고, 없어도 에러가 뜨지 않을 때 사용
   * Intent(Context packageContext, Class<?> cls)
   * Intent(String action, Uri uri, Context packageContext, Class<?> cls)

4. Intent Filter
   * Intent가 발생하면, Intent를 처리할 Filter가 존재한다.
   * 즉, Intent가 발생하면, 그 Intent를 처리할 수 있는 Intent Filter가 처리되고, Intent Filter를 갖고 있는 Activity가 수행된다.
