public class Main {
	public static void main(String[] args) {
		try{
		for(int x=0;x<1000;x++){
		
		T.clearScreen();
		for(int i=0;i<x;i++){
		System.out.print(" ");
		}
		System.out.println("∆");
		Thread.sleep(100);
		}
		}catch(Exception e){}
	}
}
class T{
  public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
   }
}
