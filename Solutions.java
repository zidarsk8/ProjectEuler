
import java.awt.List;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;
import javax.sound.midi.SysexMessage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author zidar
 */
public class Solutions {
  
  public void euler1(int n){
    long sum = 0;
    for (int i=0; i<n; i++){
      if (i%5 == 0 || i%3 ==0){
        sum += i;
      }
    }
    System.out.println(sum+"\n\n");
  }
  
  public void euler2(int n){
      int sum = 2;
      int[] fib = new int[100];
      fib[0]= 1;
      fib[1]= 2;
      for (int i=2; i<100; i++){
        fib[i]= fib[i-2]+fib[i-1];
        if (fib[i]<0) break;
        if (fib[i]%2 == 0 && fib[i] < n){
          sum+=fib[i];
        }
      }
      System.out.println(sum+"\n\n");
    
  }

  public void euler3(long num) {
    long i2 = 2;
    while (i2<=num || num != 1){
      if (num%i2 == 0){
        num = num/i2;
      }else{
        i2++;
      }
    }
    System.out.println(i2+"\n\n");
  }

  public void euler4(int digits) {      int pal = 0;
    for (int i=digits; i>0 ; i--){
      for (int j=digits; j>0 ; j--){
        if (isPal(i*j) && i*j>pal){
            pal = i*j;
        }
      }
    }
    System.out.println("pal: "+(pal)+"\n\n");
  }

  public void euler5(int div) {
    int small20 = 0;
    boolean devizable = true;//false;
    while (!devizable){
      small20++;
      devizable = true;
      for (int i = 1; i<=div ; i++){
        if (small20%i !=0){
          devizable = false;
        }
      }
    }
    System.out.println("dev 20: "+small20+"\n\n");
  }

  public void euler6(int st) {
    long vk = 0;
    long kv = 0;
    for (int i =1 ; i<=st ; i++){
      vk += i*i;
      kv += i;
    }
    kv = kv*kv;

    System.out.println("razlika: "+(kv-vk)+"\n\n");
  }

  public void euler7(int i) {
    int prime=2;
    int primeCount = 1;
    while (primeCount<i){
      prime++;
      while (!isPrime(prime)){prime++;}
      primeCount++;
    }

    System.out.println("prime: "+prime+"\n\n");
  }

  public void euler8(String digits) {
      int maxdigits = 0;
      for (int i = 0; i<digits.length()-4; i++){
        int prev = productDigits(Integer.parseInt(digits.substring(i, i+5)));
        //System.out.println(digits.substring(i, i+5)+" : "+prev);
        if (prev > maxdigits){
          maxdigits = prev;
        }
      }
      
      System.out.println("max: "+maxdigits+"\n\n");
  }

  public void euler9(int i) {
    for (int a=1; a<i;a++){
      for (int b=1; b<i;b++){
        for (int c=1; c<i;c++){
          if (a*a+b*b == c*c){
            if (a+b+c == 1000){
              System.out.println((a*b*c));
            }
          }
        }
      }
    }  
  }

  public void euler10(int max) {
    long sum =0;
    for (int i=2; i<max ;i++){
      if (isPrime(i)){
        //System.out.println(i);
        sum+=i;
      }
    }
    System.out.println("primesum "+sum);
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  
  public void euler11() {
    int[][] arr = {// <editor-fold defaultstate="collapsed" desc="array">
      {8,2,22,97,38,15,0,40,0,75,4,5,7,78,52,12,50,77,91,8},
      {49,49,99,40,17,81,18,57,60,87,17,40,98,43,69,48,04,56,62,00},
      {81,49,31,73,55,79,14,29,93,71,40,67,53,88,30,03,49,13,36,65},
      {52,70,95,23,04,60,11,42,69,24,68,56,01,32,56,71,37,02,36,91},
      {22,31,16,71,51,67,63,89,41,92,36,54,22,40,40,28,66,33,13,80},
      {24,47,32,60,99,03,45,02,44,75,33,53,78,36,84,20,35,17,12,50},
      {32,98,81,28,64,23,67,10,26,38,40,67,59,54,70,66,18,38,64,70},
      {67,26,20,68,2,62,12,20,95,63,94,39,63,8,40,91,66,49,94,21},
      {24,55,58,05,66,73,99,26,97,17,78,78,96,83,14,88,34,89,63,72},
      {21,36,23,9,75,0,76,44,20,45,35,14,0,61,33,97,34,31,33,95},
      {78,17,53,28,22,75,31,67,15,94,3,80,4,62,16,14,9,53,56,92},
      {16,39,05,42,96,35,31,47,55,58,88,24,00,17,54,24,36,29,85,57},
      {86,56,00,48,35,71,89,07,05,44,44,37,44,60,21,58,51,54,17,58},
      {19,80,81,68,05,94,47,69,28,73,92,13,86,52,17,77,04,89,55,40},
      {4,52,8,83,97,35,99,16,7,97,57,32,16,26,26,79,33,27,98,66},
      {88,36,68,87,57,62,20,72,03,46,33,67,46,55,12,32,63,93,53,69},
      {4,42,16,73,38,25,39,11,24,94,72,18,8,46,29,32,40,62,76,36},
      {20,69,36,41,72,30,23,88,34,62,99,69,82,67,59,85,74,04,36,16},
      {20,73,35,29,78,31,90,01,74,31,49,71,48,86,81,16,23,57,05,54},
      {01,70,54,71,83,51,54,69,16,92,33,48,61,43,52,01,89,19,67,48}
    /* </editor-fold> */};
    int[][] array = new int[arr.length+6][arr[0].length+6];
    for (int i = 0 ; i< arr.length; i++ ){
      System.arraycopy(arr[i], 0, array[i+3], 3, arr[i].length);
    }
    int sum = 0;
    for (int i = 3 ; i< array.length-3; i++ ){
      for (int j = 3; j < array.length-3; j++) {
        sum = arraySumMax(array,i,j)> sum ? arraySumMax(array,i,j) : sum;
      }
    }
    System.out.println("max array: "+sum);
  }
  
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler12(int numOfDev){
    int num = 1 ;
    int counter = 1;
    while (numOfDevisors(num)<numOfDev){
      counter++;
      num+=counter;
    }
    System.out.println(num);
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  
  public void euler13(String string) {
    String[] arr = string.split(" ");
    BigInteger sum = new BigInteger("0");
    for (int i=0; i<arr.length ; i++){
      sum = sum.add(new BigInteger(arr[i]));
    }
    System.out.println(sum.toString().substring(0, 10));
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  
  public void euler20(int num){
    BigInteger big = new BigInteger("1");
    for(int i=1; i<=num;i++){
      big = big.multiply(new BigInteger(""+i));
    }
    System.out.println(sumDigits(big.toString()));
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler45(int min){
    long minmax = min+1;
    long tri = 0;
    long pen = 1;
    long hex = 1;
    while (tri != pen || hex != pen || tri != hex){
      tri = getTriangle(minmax);
      pen = getPentagonal(minmax);
      hex = getHexagonal(minmax);
      minmax = getmax(tri, pen, hex);
    }
    
    System.out.println(""+trianglei+"  "+getTriangle(minmax));
    System.out.println(""+pentagonali+"  "+getPentagonal(minmax));
    System.out.println(""+hexagonali+"  "+getHexagonal(minmax));
    
  }
  
  
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler48(int pow){
    BigInteger big = new BigInteger("0");
    for (int i=1; i<=pow ; i++){
      big = big.add((new BigInteger(""+i)).pow(i));
    } 
    System.out.println(big.toString().substring(big.toString().length()-10));
  }

/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  
  
  
  
  
  
  
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  

  
  
  
  
  
  
  
  
  
  
  
  private int arraySumMax(int[][] arr,int x, int y){
    int sum = 0;
    int tmp;
    tmp = arr[x][y]*arr[x][y+1]*arr[x][y+2]*arr[x][y+3];
    sum = (sum<tmp? tmp: sum);
    tmp = arr[x][y]*arr[x][y-1]*arr[x][y-2]*arr[x][y-3];
    sum = (sum<tmp? tmp: sum);

    tmp = arr[x][y]*arr[x+1][y]*arr[x+2][y]*arr[x+3][y];
    sum = (sum<tmp? tmp: sum);
    tmp = arr[x][y]*arr[x-1][y]*arr[x-2][y]*arr[x-3][y];
    sum = (sum<tmp? tmp: sum);
    
    tmp = arr[x][y]*arr[x+1][y+1]*arr[x+2][y+2]*arr[x+3][y+3];
    sum = (sum<tmp? tmp: sum);
    tmp = arr[x][y]*arr[x-1][y-1]*arr[x-2][y-2]*arr[x-3][y-3];
    sum = (sum<tmp? tmp: sum);
    
    tmp = arr[x][y]*arr[x+1][y-1]*arr[x+2][y-2]*arr[x+3][y-3];
    sum = (sum<tmp? tmp: sum);
    tmp = arr[x][y]*arr[x-1][y+1]*arr[x-2][y+2]*arr[x-3][y+3];
    sum = (sum<tmp? tmp: sum);
    return sum;
  }
  
  private static boolean isPrime(int prime){
    if(prime%2 == 0 && prime>2){
      return false;
    }
    for (int i = 3; i< Math.sqrt(prime)+1 ; i+=2){
      if (prime%i == 0 && prime!=i){
        return false;
      }
    }
    return true;
  }

  private static boolean isPal(int pal){
    String niz = ""+pal;
    for(int i=0; i< niz.length()/2; i++){
      if(niz.charAt(i) != niz.charAt(niz.length()-1-i))
        return false;
    }
    return true;
  }
  
  private int sumDigits(String s){
    int sum = 0;
    for (int i=0; i<s.length(); i++){
      sum += s.charAt(i) & 0xf;
    }
    return sum;
  }
  
  private int productDigits(int num){
    int sum = 1;
    while (num>0){
      sum *= num%10;
      num = num/10;
    }
    return sum;
  }

  private long trianglei = 1;
  private long pentagonali = 1;
  private long hexagonali = 1;
  private long getmax(long a, long b, long c){
    if (a>=b && a>=c) return a;
    if (b>=a && b>=c) return b;
    if (c>=b && c>=a) return c;
    return -1;
  }
  private long getTriangle(long min){
    long n = 0;
    trianglei--;
    while(n<min){
      n= (trianglei*(trianglei+1)) / 2;
      trianglei++;
    }
    return n;
  }
  private long getPentagonal(long min){
    long n = 0;
    pentagonali--;
    while(n<min){
      n= (pentagonali*(3*pentagonali-1)) / 2;
      pentagonali++;
    }
    return n;
  }
  private long getHexagonal(long min){
    long n = 0;
    hexagonali--;
    while(n<min){
      n= (hexagonali*(2*hexagonali-1));
      hexagonali++;
    }
    return n;
  }

  /**
   * Function returns a number of all divisors with a brute force method.
   * 
   * @param number
   * @return number of divisors
   */
  private int numOfDevisorsBrute(int num){
    int sum = 0;
    for (int i=1; i<=num; i++){
      if (num%i==0){
        sum++;
      }
    }
    return sum;
  }
  
  /**
   * Function returns a number of all divisors using factorization.
   * 
   * @param number
   * @return number of divisors
   */
  private int numOfDevisors(int number){
    int sum = 1;
    int factor = 2;
    int power = 1;
    while (factor<=number || number != 1){
      if (number%factor == 0){
        number = number/factor;
        power++;
      }else{
        factor++;
        sum *=power;
        power = 1;
      }
    }
    sum *=power;
    power = 1;
    return sum;
  }
  
  /**
   * Function returns an array of all divisors of the given number.
   * 
   * @param number 
   * @return integer array
   */
  private int[] factor(int number){
    Stack stack = new Stack();
    int stackCounter = 1;
    stack.push(1);
    int factor = 2;
    while (factor<=number || number != 1){
      if (number%factor == 0){
        number = number/factor;
        stack.push(factor);
        stackCounter++;
      }else{
        factor++;
      }
    }
    int[] factorArray = new int[stackCounter];
    for (int i = 0; i<factorArray.length; i++){
      factorArray[i] = (int) stack.pop();
    }
    return factorArray;
  }
}
