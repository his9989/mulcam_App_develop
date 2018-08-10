## Android Developer site
* https://developer.android.com/ 참고

* 이클립스에서 .class로 바꿔서 실행했는데 <br>
  안드로이드 스튜디오는 JVM을 사용하지 못해서 .dex로 바꿔서 실행

## 안드로이드 스튜디오 다운로드
* 필요한 것 
  - 안드로이드 스튜디오
  - Java JDK 8.0(스튜디오에 포함)
  - 안드로이드 SDK (build tools, android sdk version(1~28))
      + sdk 버전은 보통 15버전을 사용한다. 너무 낮은건 구리고, 높은건 배포가 제한적이다.
  - 애뮬레이터

* sdk 버전 역사
  - 4.0 (kitkat) : NFC, BLE, Pay기능 추가
  - 5.0 : 32bit->64bit 변화, 디자인 지침서 추가
  - 6.0 : 64bit 안정화, 
  - 7.0 (Nougat), 8.0 (Oreo) 등 버전 업그레이드
  - 9.0 : 2018/08/08 최신 버전 업로드.

* 설치 방법
  - exe 프로그램 다운로드
1. https://developer.android.com/studio/ 접속, 가운데의 "DOWNLOAD ANDROID STUDIO" 버튼 클릭. -> exe프로그램 다운로드

  - exe 프로그램 실행
2. 설치 프로그램 실행 -> next 2번 누르고, 설치 위치를 "C:\Android\Android Studio" 으로 바꿔준 뒤 next -> install 누르고 설치 진행
3. Android Stuio를 실행하면 "Complete Installation"이 뜬다. "Do not import settings"하고 OK 한다.
4. wizard는 그냥 cnacel하고 꺼버린다. (여기서 설정하면 나중에 골때려진다. 밑에서 직접 설치할 것 임)

  - SDK 다운로드
5. "Welcome to Android Studio"라는 exe 프로그램이 실행되면, 우측 하단의 configure를 누른다. -> SDK Manager를 클릭
6. Android SDK Location 의 우측에 <Edit> 클릭
7. Android SDK Location 의 우측의 <...> 클릭
8. SDK 설치 위치를 "C:\Android\Android_sdk"로 바꿔준다. (Android_sdk 폴더는 직접 만들어준다.)
9. next-install 해주면 sdk를 우리가 설정한 폴더에 설치해준다.
10. 설치 완료되면 finish 클릭
11. Android API 28, Android 8.1(Oreo), Android 7.1.1(Nougat), Android 4.4(KitKat), Intel x86 Emulator Accelerator (HAXM installer) 5개 선택하고 계속 Next Click~~

  - 직접 실행해보기
12. Start a new Android Project 클릭해서 환경 설정하고 시작하면 최초 시작할 때 필요 데이터를 또 설치한다. 기다리기~

  - 애뮬레이터 설치
13. 우측 위에 AVD Manager 클릭 (애뮬레이터 생성)
14. create virtual device 클릭
15. 3.2HVGA 선택 (3.2인치, 작은 화면) - next 클릭
16. Oreo 8.1의 Download(파란색) 클릭

  - 안드로이드 환경 구축
17. C:\Android\Android Studio\bin 폴더에 들어가서 studio64 실행. (바로가기 만들어서 배경에 두기)
18. 처음 안드로이드 스튜디오를 오픈할 때, 기본 데이터 등을 다운로드해서 시간이 오래 걸림. 3일 정도 사용하면 빨라진다.

  - 애뮬레이터 실행
19. 우측 위에 AVD Manager 클릭 (애뮬레이터 실행)
20. 위의 13~16에서 선택한 3.2HVGA, Oreo8.1 선택해서 finish하면 애뮬레이터 설정됨.
21. 여기서 세모 모양 실행 버튼 누르면 애뮬레이터 켜짐
        (웬만하면 폰 쓰자)
        

## Java IO
1. 용어
  * stream : 입출력 데이터의 흐름
  * source : 입력 데이터의 시작
  * sink : 데이터가 처리되어 출력되는 끝
  * node: source, sink를 합쳐 이르는 말
  
  * Source Stream
    - Byte Stream : InputStream, FileInputStream
    - Character Stream : Reader, FileReader
  * Sink Stream
    - Byte Stream : OutStream, FileOutputStream
    - Character Stream : Writer, FileWriter
    
2. Processing Stream (decorater code)
  자동차 구입 시 옵션 붙이듯, 파일 입출력에 기능을 하나 씩 추가하는 것.
  
  * Buffering, Filtering, Converting, Object Serialization, Data Conversion, Counting, Peeking ahead, Printing
    - Byte가 읽는 속도가 빠르므로, ByteStream으로 읽고, Converting을 이용해서 CharacterStream으로 변환하면 코드가 빨라진다.
    - Buffering stream을 이용하면 속도를 빠르게 할 수 있다.
 
 **3개의 stream을 따로 만드는 경우. fos, bos, dos를 모두 close해주어야한다.**
 
<code>
  
    FileOutputStream fos = new FileOutputStream("TestFile.txt");
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    DataOutputStream dos = new DataOutputStream(bos);

</code>

**3개의 stream을 한번에 만드는 경우. dos만 close해주면 된다.**

<code>

    DataOutputStream dos = 
      new DataOutputStream(
       new BufferedOutputStream(
         new FileOutputStream("TestFile.txt")));
                     
</code>
 
 ex) 실전 예제
 
<code>

  package edu.jaen.java.io;
  import java.io.*;
  class FileRead {
     public static void main(String arg[]) throws Exception{
         File f=new File("Data.txt");
         FileReader fr = new FileReader(f);

         //node Stream 위에 Processing Stream을 2번 사용한것.
         BufferedReader br = 
             new BufferedReader(							// buffer에 넣어서 속도를 빠르게
                 new InputStreamReader(					// byte를 Character로 변환
                     new FileInputStream(f)));		// byte Source 코드

         // 텍스트를 입력할 파일
         File fw = new File("write.txt");

         //node Stream 위에 Processing Stream을 2번 사용한것.
         BufferedWriter bw = 
             new BufferedWriter(							  // buffer에 넣어서 속도 빠르게
                 new OutputStreamWriter(				// byte를 Character로 변환
                     new FileOutputStream(fw)));	// byte Sink 코드

           String ch;
           while((ch=br.readLine()) != null ) {
               System.out.println(ch);         
               bw.write(ch+"\n");
           }
           br.close();   
           bw.flush();
           bw.close();
     }
  }

<code>

##Thread
* 1개의 프로세스가 n개의 작업을 수행하는것. <br>
  즉, thread를 3개 만들면 stack이 3개 만들어진다. <br>
  객체는 heap에 만들어지며, 3개의 stack이 heap 1개를 공유한다. <br>

* priority는 max, normal, min이 있다. 원래는 min->normal->max 순으로 동작시켜서 순서를 정할 수 있을 것 같지만, 거의 랜덤으로 나타난다.

* runable 영역에 있는 Thread만이 running영역에 갈 수 있다.

* 명령어
  - stop 명령어를 통해 runable 영역에 있는 Thread를 멈출 수 있다. <br>
  - sleep 명령을 통해, runable 영역에 있는 Thread를 잠시 block 영역에 보내서 잠시만 멈춰둘 수 있다. <br>
                    running 영역에 있는 Thread의 경우, 실행 완료 후, runable 영역에 돌아오면 block로 보낸다. <br>
                    sleep(3ms)면 3ms간 block에 보내라는 의미다. <br>
  - suspend 명령어를 통해, resume(재호출) 명령어를 받을 때 까지, block 영역에 보관된다.
  
* 안드로이드는 기본적으로 14개의 thread가 돈다. Thread 없이는 할 수 없다. Thread 사용 방법은 외워야된다.
  - 점프 투 자바 예제 풀면서 연습해라.
