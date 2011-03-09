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

  private static boolean isPrime(int prime){
    for (int i = 2; i< prime/2+1 ; i++){
      if (prime%i == 0){
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

  void euler5(int div) {
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

  void euler6(int st) {
    long vk = 0;
    long kv = 0;
    for (int i =1 ; i<=st ; i++){
      vk += i*i;
      kv += i;
    }
    kv = kv*kv;

    System.out.println("razlika: "+(kv-vk)+"\n\n");
  }

  void euler7(int i) {
    int prime=2;
    int primeCount = 1;
    while (primeCount<i){
      prime++;
      while (!isPrime(prime)){prime++;}
      primeCount++;
    }

    System.out.println("prime: "+prime+"\n\n");
  }

  void euler8(String digits) {
      int maxdigits = 0;
      for (int i = 0; i<digits.length()-5; i++){
        int prev = Integer.parseInt(digits.substring(i, i+5));
        if (prev > maxdigits){
          maxdigits = prev;
        }
      }
      
      System.out.println("max: "+maxdigits+"\n\n");

  }

}
