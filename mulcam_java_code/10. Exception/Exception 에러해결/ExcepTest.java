package edu.jaen.java.excep;
public class ExcepTest{
	public static void main(String[] args) {
		ExcepTest et= new ExcepTest();
		et.pr();
		System.out.println("main End..이건 꼭 수행해야 하는데...");
	}

	void pr(){
		int i = 0;
		String greetings[] = {"Good Bye",
							  "Hi~",
							  "안녕히~"};
		try{
			while (i < 4) {
				System.out.println(greetings[i]);
				i++;
			}
		}catch(Exception e){
			System.out.println("Error :"+e);
		}
		System.out.println("Method End.."+i);
	}
}
