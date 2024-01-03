import java.util.*;
import java.text.*;

public class Main {
	public static void main(String[] args) {
		String[][] tela = T.getTela();
		try{
		  for(int t=0;t<60;t++){
		    tela=T.setItem(tela,T.getTime(),1,1);
		    T.prt(tela);
		    Thread.sleep(100);
		  }
		  
		}catch(Exception e){
		}
	
		
	}
}
class T{
  public static String[][] setItem(String[][] pTela, String pItem,int y, int x){
    String[] aItem=pItem.split("");
    int isize=aItem.length;
    int count=0;
    for(int i=x;i<isize+1;i++){
      pTela[y][i]=aItem[count];
      count++;
      
    }
    return pTela;
  }
  
  public static void prt(String[][] pTela){
    T.clearScreen();
    String linha="";
    for(int y=0;y<pTela.length;y++){
      linha="";
      for(int x=0;x<pTela[y].length;x++){
        linha+=pTela[y][x];
      }
      System.out.println(linha);
      
    }
  }
  
  public static String[][] getTela(){
    int y =16;
    int x =32;
    String[][] tela=new String[y][x];
    for(int l=0;l<y;l++){
      if(l==0||l==2||l==y-1){
        tela[l]=T.getLinha1(x);
      }else{
         tela[l]=T.getLinha2(x);
      }
    }
  
    return tela;
  }
  public static String[] getLinha1(int x){
    String[] linha = new String[x];
    
    for(int i=0;i<x;i++){
      if(i==0||i==x-1){
        linha[i]="+";
      }else{
        linha[i]="-";
      }
    }
    return linha;
  }
  
  public static String[] getLinha2(int x){
     String[] linha = new String[x];
    
    for(int i=0;i<x;i++){
      if(i==0||i==x-1){
        linha[i]="|";
      }else{
        linha[i]=" ";
      }
    }
    return linha;
  }
  
  
  public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
   }
   
   public static void printanimacao(){
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
   public static String getTime(){
     Date dNow = new Date( );
      SimpleDateFormat ft = 
      new SimpleDateFormat ("hh:mm:ss");//("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

      return ft.format(dNow);
   }
}
