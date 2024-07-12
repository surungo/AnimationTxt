

import java.util.Random;

public class App {
	public static int x=0;
	public static int y=0;
	public static void main(String[] args) {
		
		
		String linha[][] = {
				{"+","-","-","-","-","-","-","-","-","-","-","-","-","-","-","+"},
				{"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
				{"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
				{"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
				{"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
				{"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
				{"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
				{"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
				{"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
				{"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
				{"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
				{"|"," "," "," "," "," "," "," "," "," "," "," "," "," "," ","|"},
				{"+","-","-","-","-","-","-","-","-","-","-","-","-","-","-","+"}
		};
		
		x = linha.length;
		y = linha[0].length;
		int p[] = {5,5};
				
		linha=movePersonagem("S",p,0,linha);
		
		for(int i=0; i < 100; i++) {
			Random rand = new Random();
			int direction = rand.nextInt(4);
			linha[1][1]=String.valueOf(direction);
			linha[1][3]=String.valueOf(x).substring(0,1);
			linha[1][4]=String.valueOf(x).substring(1,2);
			linha[1][6]=String.valueOf(y).substring(0,1);
			linha[1][7]=String.valueOf(y).substring(1,2);
			linha=movePersonagem("S",p,direction,linha);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(String col[] : linha){
				String str = convertStringArrayToString(col,"");
				System.out.println(str);
			}
			
		}
	}
	private static String[][] movePersonagem(String objeto, int p[], int direction, String[][] linha) {
		int margem = 2;
		int top = 1;
		
		linha[p[0]][p[1]]=" ";
		switch (direction) {
		case 0:
			if(top+margem<=p[1])
				p[1]--;
			break;
		case 1:
			if(x-margem>=p[0])
				p[0]++;
			break;
		case 2:
			if(y-margem>=p[1])
				p[1]++;
			break;
		case 3:
			if(0+margem<=p[0])
				p[0]--;
			break;
		}
		linha[p[0]][p[1]]=objeto;
		return linha;
	}
	private static String convertStringArrayToString(String[] strArr, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (String str : strArr)
			sb.append(str).append(delimiter);
		return sb.substring(0, sb.length() );
	}
}
