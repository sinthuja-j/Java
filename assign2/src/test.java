import java.io.*; 
import java.util.Arrays; 

public class test {
	public static void main(String[] args) throws Exception {
    int j = 0, k = 0; 
    Integer i = null;
    int[] A = new int[10];
    try {
    for (j = 0; j <= 10; j = j+1) {
    A[j] = k;
    k = k+1;
    }
    k = k + i.intValue();
    }
    catch (ArrayIndexOutOfBoundsException e) {System.out.println("Error");}
    catch (NullPointerException e) {k = 1;}
    catch (Exception e) {k = 2;}
    j = k;
	System.out.print(j);
}
	
}