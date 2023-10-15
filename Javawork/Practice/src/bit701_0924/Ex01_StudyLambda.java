package bit701_0924;


public class Ex01_StudyLambda {
	
	@FunctionalInterface
	interface Myfunction {
		void run(); // public abstaract void run();
	}

	class LambdaEx1 {
		static void execute(Myfunction f) {//매개 변수의 타입이 MyFunction인 메서드
			f.run();
			
			
		}

		static Myfunction getMyfunction() { // 반환 타입이 MyFunction인 메서드
			Myfunction f = () -> System.out.println("f3.run()");
			return f;
		}
	}
	
	

	public static void main(String[] args) {
		//람다식으로 MyFunction의 run()을 표현
		Myfunction f1 = () -> System.out.println("f1.run()");

		Myfunction f2 = new Myfunction() {
			public void run() {
				System.out.println("f2.run()");
			}


		};
		
		Myfunction f3 = LambdaEx1.getMyfunction();
		
		f1.run();
		f2.run();
		f3.run();
		
		LambdaEx1.execute(f1);
		
		LambdaEx1.execute(() -> System.out.println("run()"));


	}






}
