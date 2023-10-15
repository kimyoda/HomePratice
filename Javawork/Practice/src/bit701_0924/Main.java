package bit701_0924;

@FunctionalInterface
interface Myfunction {
	void run(); // public abstaract void run();
}

class Main {
	static void execute(Myfunction f) {//매개 변수의 타입이 MyFunction인 메서드
		f.run();

	}
	static Myfunction getMyfunction() { // 반환 타입이 MyFunction인 메서드
		Myfunction f = () -> System.out.println("f3.run()");
		return f;
	}
	public static void main(String[] args) {
		Myfunction f1 = () -> System.out.println("f1.run()");

		Myfunction f2 = new Myfunction() {
			public void run() {
				System.out.println("f2.run()");
			}


		};
		
		Myfunction f3 = getMyfunction();
		
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		
		execute(() -> System.out.println("run()"));
	}
}
