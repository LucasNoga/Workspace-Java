package td5_lo02;
public class Singleton{

	private volatile static Singleton instance;	//instance de singleton

	private Singleton(){

	}
	public static synchronized Singleton getInstance(){
		if (instance == null){
			synchronized (Singleton.class){
				if (instance == null) 
					instance = new Singleton();
			}
		}
		return instance;
	}

	public static void main(String[] arg){
		//Singleton s1 = new Singleton();
		getInstance();
		System.out.println(instance);
		//Singleton s2 = new Singleton();
		System.out.println(instance);
		getInstance();
		System.out.println(instance);
		System.out.println(instance);

	}
}