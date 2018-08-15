package edu.jaen.java.inheritance;

public class MemberMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Member m = new Member();
		//VipMember v = new VipMember();
		Member m = new Member();
		Member m2 = new Member("한인수", 25, "his9989");
		
		VipMember v = new VipMember("한인수", 25, "his9989", "drum");
		System.out.println(v.toString());
		
		VVIP vv = new VVIP("한인수", 25, "his9989", "drum", 10000);
		System.out.println(vv.toString());
	}
}