package kr.or.ddit.homework;


public enum Sachick {
	PLUS("+"),MINUS("-"),MULTIPLY("*"),DIVIDE("/");
	
	private Sachick(String sachick) {
		this.sachick = sachick;
	}

	private String sachick;
	public String getSachickName() {
		return sachick;
	}
	
	public static int add(int a, int b) {
		int res=0;
		res=(a+b);
		return res;
	}
	public static int min(int a, int b) {
		int res=0;
		res=(a-b);
		return res;
	}
	public static int mul(int a, int b) {
		int res=0;
		res=(a*b);
		return res;
	}
	public static double div(int a, int b) {
		double res=0;
		res=((double)a/b);
		return res;
	}
	
	public static Sachick findSachick(String operator) {
		Sachick finded = PLUS;
		for(Sachick single : values()) {
			if(operator.contains(single.name())) {
				System.out.println("싱글 네임"+single.name());
				finded = single;
				break;
			}
		}
		return finded;
	}
	
	public static String findSachickName(String operator) {
		return findSachick(operator).getSachickName();
	}
}
