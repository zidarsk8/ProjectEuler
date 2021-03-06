
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

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
        if (isPal(""+(i*j)) && i*j>pal){
            pal = i*j;
        }
      }
    }
    System.out.println("pal: "+(pal)+"\n\n");
  }

  public void euler5(int div) {
    int small20 = 0;
    boolean devizable = false;//false;
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
    while (numOfDivisors(num)<numOfDev){
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

  public void euler14(int max){
    long maxnumber=0;
    long maxsprehod=0;
    long[] arr = new long[max];
    for (int i=max-1; i>0 ; i--){
      if (arr[i] == 0){
        long sprehod = 1;
        long temp = i;
        while (temp>1){
          sprehod++;
          if (temp<max){ arr[(int)temp]=1; }
          if (temp%2==0){
            temp = temp/2;
          }else{
            temp = 3*temp + 1;
          }
        }
        if (sprehod>maxsprehod){
          maxsprehod = sprehod;
          maxnumber = i;
        }
        //System.out.println("temp: "+temp+"   stevilo: "+i+"   pot: "+sprehod);
      }
    }
    System.out.println("stevilo: "+maxnumber+"   pot: "+maxsprehod);
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler15(int dimx, int dimy){
    System.out.println("fac: "+(factorialBigInt(dimx+dimy).divide( factorialBigInt(dimx).multiply( factorialBigInt(dimy) ) )).toString());
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler16(int power){
    BigInteger big = new BigInteger("2");
    big = big.pow(power);
    System.out.println("power sum: "+sumDigits(big.toString()));
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  

  public void euler17(int max){
    String[] ones =  {"", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten", 
      " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen"};
    String[] tens = {"", " ten", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety"};
    //  hundred
    String number = new String();
    
    for (int i=1; i<max ; i++){
      int k = i;
      number += (i>99 ? (ones[i/100]+" hundred"+(i%100==0? "":" and") ): "")+
                (i%100 >0 && i%100 <20 ? ones[i%100]: tens[(i%100)/10]+ones[i%10]);
      //System.out.println((i>99 ? (ones[i/100]+" hundred"+(i%100==0? "":" and") ): "")+(i%100 >0 && i%100 <20 ? ones[i%100]: tens[(i%100)/10]+ones[i%10]));
    }
    number+="one thousand";
    number = number.replace(" ", "");
    System.out.println("dolzina: "+number.length());
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  
  public void euler18(int[] arr){
    int[] arrlev = new int[arr.length+1];
    
    int i = 1;
    int lev = 1;
    while (i<arrlev.length){
      for (int j=0; j<lev ; j++){
        arrlev[i++] = lev;
      }
      lev++;
    }
    for (i=1; i<arr.length; i++){
      //we check if node has two parrents then we add the biggest parrent to current node value
      if (arrlev[i-arrlev[i+1]+1] == arrlev[i+1]-1 && arrlev[i-arrlev[i+1]+2] == arrlev[i+1]-1){
        arr[i] += arr[i-arrlev[i+1]]> arr[i-arrlev[i+1]+1] ? arr[i-arrlev[i+1]] : arr[i-arrlev[i+1]+1];
      }else{
        //else we just add the only parrent (ther is always at least one) to the current node value
        if (arrlev[i-arrlev[i+1]+1] == arrlev[i+1]-1){
          arr[i] += arr[i-arrlev[i+1]];
        }else{
          arr[i] += arr[i-arrlev[i+1]+1];
        }
      }
    }
    int max = 0;
    for (int j=0; j<arr.length; j++){
      if (arr[j]>max){
        max = arr[j];
      }
    }
    System.out.println("max 3 : "+max);
    
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler19(){
    int sum=0;
    for (int i=1901; i<=2000 ; i++){
      for(int j=1; j<=12; j++){
        if (dayOfWeek(i, j, 1)==1){
          sum++;
        }
      }
    }
    System.out.println("sum: "+sum);
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  
  
  public void euler20(int num){
//    BigInteger big = new BigInteger("1");
//    for(int i=1; i<=num;i++){
//      big = big.multiply(new BigInteger(""+i));
//    }
//    System.out.println(sumDigits(big.toString()));
    System.out.println(sumDigits(factorialBigInt(num).toString()));
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler21(int num){
    int[] arr = new int[++num];
    for (int i = 0; i < arr.length; i++) {
      arr[i]= sumOfAllDevisors(i);
      //System.out.println(i+" - "+arr[i]);
    }
    int sum = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i]<arr.length && i!= arr[i] && i == arr[arr[i]]){
       sum+=i;
      }
    }
    System.out.println(sum);
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler22(String[] names){
    Arrays.sort(names);
    long sum = 0;
    for (int i = 0; i < names.length; i++) {
      sum += numvalOfString(names[i])*(i+1);
    }
    System.out.println("sum: "+sum);
  }
  
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler23(int max){
    int sum = 0;
    int[] arr = new int[max];
    int abundantCount = 0;
    for (int i = 1; i < arr.length; i++) {
      arr[i] = sumOfAllDevisors(i);
      if (i<arr[i]){
        abundantCount++;
      }
    }
    int[] abundant = new int[abundantCount];
    abundantCount=0;
    for (int i = 0; i < arr.length; i++) {
      if (i<arr[i]){
        abundant[abundantCount++]= i;
      }
    }
    
    for (int i=1; i<max; i++){
      boolean isSum = false;
      for (int j = 0; j < abundant.length ; j++) {
        if (i-abundant[j]>=0 && i-abundant[j]<arr.length && i-abundant[j]<arr[i-abundant[j]]){
          isSum = true;
          //System.out.println("abundant sum: "+i+"      "+abundant[j]+" "+arr[abundant[j]]+"      +    "+(i-abundant[j])+" "+arr[(i-abundant[j])]);
          break;
        }
      }
      if (!isSum){
        sum+=i;
        //System.out.println("i: "+i);
      }
    }
    
    System.out.println("sum: "+sum);
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler24(int search){
    String[] arr = {"0","1","2","3","4","5","6","7","8","9"};
    String fin = new String();
    int tempPos =1;
    int pos=10;
    int curLetter= 0;
    while (tempPos!= search){
      curLetter = 0;
      while (search>=tempPos+factorialInt(pos-1)){
        curLetter++;
        tempPos+= factorialInt(pos-1);
      }
      fin += arr[curLetter];
      arr = removeElement(arr, curLetter);
      pos--;
    }
    for (int i = 0; i < arr.length; i++) {
      fin += arr[i]; 
    }
    System.out.println(fin);
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler25(int numOfDigits){
    BigInteger first = new BigInteger("1");
    BigInteger second = new BigInteger("1");
    long term = 2;
    while(second.toString().length()<numOfDigits){
      BigInteger temp = first.add(second);
      first = second;
      second = temp;
      term++;
    }
    System.out.println("term "+term);
  }
  

/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/

  public void euler26(int maxDevider){
    int devider= 1;
    int terms = 0;
    int maxTerms = 0;
    int num = 1;
    String result = "0.";
    LinkedList l = new LinkedList();
    for (int i=1; i<maxDevider; i++){
      l = new LinkedList();
      result="0.";
      num = 1;
      terms = 0;
      while (num !=0){
        while (num/i == 0){
          num*=10;
        }
        if (l.contains(num)){
          terms = l.size()-l.indexOf(num);
          if (terms>maxTerms){
            devider = i;
            maxTerms = terms;
            System.out.println("\ndevider :"+devider+"     result: "+result+"    terms: "+terms);
          }
          break;
        }
        l.add(num);
        result += (num/i);
        num = num%i;
      }
    }
    System.out.println("devider :"+devider+"    terms:"+maxTerms);
  }
  
  
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler27(int maxa, int maxb){
    
    int besta=0;
    int bestb=0;
    int con =0;
    int product =0;
    for (int a = 1-maxa; a < maxa ; a++){
      for (int b = 1-maxb; b < maxb ; b++){
        int n = 0;
        int tempcon = 0;
        while (isPrime1(n*n + a*n + b)){
          tempcon++;
          n++;
        }
        if (tempcon > con){
          besta=a;
          bestb=b;
          product = a*b;
          con = tempcon;
          System.out.println("product: "+product+"   con: "+tempcon+"     a: "+a+"  b: "+b);
        }
      }
    }
    System.out.println("product: "+product+"  a: "+besta+"  b: "+bestb);
            
  }
  

  
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler28(int square){
    int current = 1;
    int step = 0;
    int sum = 0;
    int count = 4;
    while (step<square){
      current+=step;
      sum +=current;
      if (count == 4){
        step+=2;
        count = 1;
      }else{
        count++;
      }
    }
    System.out.println("sum: "+sum);
  }
  
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler29(int maxa,int maxb){
    TreeSet set = new TreeSet();
    for (int a=2 ; a <= maxa ; a++){
      for (int b=2 ; b <= maxb ; b++){
        set.add(Math.pow(a, b));
      }
    }
    System.out.println("count: "+set.size());
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler30(int power){
    int sum =0;
    for (int i=2; i<determenMax30(power);i++){
      if (i==sumDigitPow(i, power)){
        sum+=i;
      }
    }
    System.out.println("sum: "+sum);
  }
  
  private int determenMax30(int power){
    int max = 1;
    int len = 1;
    while((""+(pow(9, power)*len)).length()>len){
      len = (""+(pow(9, power)*len)).length();
    }
    return (pow(9, power)*len);
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler31(int search){
    int diff=0;
    int[] arr = {200,100,50,20,10,5,2,1};
    //int[] arr = {1,2,5,10,20,50,100,200};
    for (int i = 0; i <=search/arr[0] ; i++) 
      for (int j = 0; j <=search/arr[1] ; j++)       
        for (int k = 0; k <=search/arr[2] ; k++)       
          for (int l = 0; l <=search/arr[3] ; l++)       
            for (int m = 0; m <=search/arr[4] ; m++)       
              for (int n = 0; n <=search/arr[5] ; n++)       
                for (int o = 0; o <=search/arr[6] ; o++)       
                  for (int p = 0; p <=search/arr[7] ; p++) 
                    if ( arr[0]*i + arr[1]*j + arr[2]*k + arr[3]*l + arr[4]*m + arr[5]*n + arr[6]*o + arr[7]*p == search)
                      diff++;
    System.out.println("diff: "+diff);
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler32(){
    int sum=0;
    TreeSet set = new TreeSet();
    for (int i=0; i<10000; i++){
      for (int j=0; j<10000; j++){
        int pro = i*j;
        if (hasAllDigits(""+i+j+pro)){
          set.add(pro);
        }
      }
    }
    while (!set.isEmpty()){
      sum += (int) set.pollFirst();
    }
    System.out.println(sum);
  }
  
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler33(){
    int denum = 1;
    int num = 1;
    for (int i=10 ; i<100 ; i++){
      for (int j=i+1 ; j<100 ; j++){
        for (int k=1; k<10;k++){
          int ii = Integer.parseInt(("0"+i).replace(""+k, ""));
          int jj = Integer.parseInt(("0"+j).replace(""+k, ""));
          if (ii!=0 && jj!=0 && i!=ii && j!=jj && ((double)i/j)== ((double)ii/jj)){
            System.out.println(i+"/"+j+"    "+ii+"/"+jj);
            System.out.println(((double)i/j));
            System.out.println(((double)ii/jj));
            System.out.println();
            num*=i;
            denum*=j;
          }
        }
      }    
    }

    System.out.println(num+" / "+denum);
  }

/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler34(){
    int allsum=0;
    for (int i=3; i<10000000 ; i++){ // sum(factorial([1:9])) = 409113
      int ii = i;
      int facsum = 0;
      while (ii>0){
        facsum += factorialInt(ii%10);
        ii/=10;
      }
      if (facsum == i){
        allsum+=i;
        System.out.println("factsum: "+i);
      }
    }
    System.out.println("factsum: "+allsum);
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler35(int max){
    int count =1;
    for (int i=3; i<max; i+=2){
      if (!containsMultipleOf2(""+i) && isPrime(i)){
        boolean isCirc = true;
        int pri = i;
        int numbers = ((int)( Math.log10(i))+1);
        int num = (int) Math.pow(10,numbers);
        
        
        for (int j=0;j<numbers;j++){
          pri = (pri*10)%num + pri*10/num;
          if (!isPrime1(pri)){
            isCirc= false;
          }
        }
        if (isCirc){
          count++;
          //System.out.println("count: "+i+"   "+num);
        }
      }
    }
    System.out.println("count: "+count);
  }
  
  private boolean containsMultipleOf2(String s){
    return (s.contains("2")||s.contains("4")||s.contains("6")||s.contains("8")||s.contains("0"));
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler36(int max){
    int sum =0;
    for (int i=1; i<max; i++){
      if (isPal(""+i) && isPal(Integer.toBinaryString(i))){
        sum+=i;
        System.out.println("i: "+i+"   bin:"+Integer.toBinaryString(i));
      }
    }
    System.out.println("sum: "+sum);
  }
  
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler37(){
    int sum=0;
    int count=0;
    int prime=9;
    while (count<11){
      if (isPrime1(++prime)){
        if (isTruncatablePrime(prime)){
          System.out.println("prime: "+prime);
          count++;
          sum+=prime;
        }
      }
    }
    System.out.println("sum: "+sum);
  }
  
  private boolean isTruncatablePrime(int prime){
    int prime1= prime;
    int digit=10;
    while ((prime1 /= 10)!=0){
      //System.out.println(prime1);
      if (!isPrime1(prime1)){
        return false;
      }
      digit *= 10;
    }
    
    digit /= 10;
    while ((prime = prime%digit)!=0){
      //System.out.println(prime);
      if (!isPrime1(prime)){
        return false;
      }
      digit /= 10;
    }
    
    return true;
  }
  
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler38(){
    for (int i=0; i<10000; i++){
      String s="";
      for (int j=1; j<11 && s.length()<9; j++){
        s+=i*j;
      }
      if (hasAllDigits(s)){
        System.out.println(s);
      }
    }
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler39(int perimeter){
    int maxSolutions = 0;
    int bestPar = 0;
    for (int i=3; i<=perimeter; i++){
      int solutions = 0;
      for(int a = 1; a<i; a++){
        for (int b = a; b+a<i ; b++){
          int c= i-a-b;
          if (c*c == a*a+b*b){
            solutions++;
          }
        }
      }
      if (solutions>maxSolutions){
        bestPar = i;
        maxSolutions = solutions;
        System.out.println("par: "+bestPar+"    sol: "+solutions);
      }
    }
  }
  
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler40(int last){
    String s = "";
    int product = 1;
    for (int n =1; n<=last ; n*=10){
      int digitPos = 1;
      int curPos = 0;
      int digit = 1;
      while (digitPos<=n){
        s= ""+digit;
        curPos=digitPos;
        while(digitPos < s.length()+curPos) {
          if (digitPos==n){
            product *= s.charAt(digitPos-curPos) & 0xf;
          }
          digitPos++;
        }
        digit++;
      }
    }
    System.out.println("pro: "+product);
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  // 987654321 would be the highest possible with numbers from 1 to 9
  // but all 9 digit numbers like that are devisible by 3
  public void euler41(){
    for (long i=87654321;i>5 ;i-=2){
      int len = ((int)Math.log10(i)+1);
      if(i<=(len+1)*((int)Math.pow(10, len-1))){
        if (hasAllDigits(""+i, 1, len)){
          System.out.println(""+i+"  "+len);
          if (isPrime1(i) ){
            break;
          }
        }
      }
    }
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  // 987654321 would be the highest possible with numbers from 1 to 9
  // but all 9 digit numbers like that are devisible by 3
  public void euler42(String[] arr){
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      int numval = numvalOfString(arr[i]);
      if (isTriangle(numval) || numval==1){
        count++;
        System.out.println(count+"   "+(isTriangle(numval))+"   "+numval+"   "+arr[i]);
      }
      
    }
    System.out.println("aaa  "+count);
  }
  
  
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler43(){
    long[] arr = {0,1,2,3,4,5,6,7,8,9};
    long[] div = {1,1,1,2,3,5,7,11,13,17};
    System.out.println(sumEuler43(arr,div, 0));
  }
  
  private long sumEuler43(long[] arr,long[] div, long number){
    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      long newnumber =number*10+arr[i];
      if ((newnumber%1000) % div[div.length-arr.length] == 0){
        long[] newarr = new long[arr.length-1];
        for (int j=0; j<arr.length ; j++){
          if (j!=i){
            newarr[j-(j<i?0:1)] = arr[j];
          }
        }
        sum += sumEuler43(newarr, div, newnumber);
      }
    }
    if (arr.length==0 && (number%1000) % div[div.length-1] == 0){
      System.out.println(number);
      return sum+number;
    }
    return sum;
  }
  
  
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
 
  public void euler44(){
    long[] arr = new long[1000000];
    arr[0] = 1;
    for (int i = 1; i < arr.length; i++) {
      arr[i] = getPentagonal(arr[i-1]+1); 
      //println(i+"   "+arr[i]);
    }
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j >=0 ; j--) {
        if (isPantegonal(arr[i]+arr[j])&&isPantegonal(arr[i]-arr[j])){
          println(i+"   "+arr[i]+"  "+arr[j]+"   D = "+(arr[i]-arr[j]));
          return;
        }
      }
    }
  }
  
  private boolean isPantegonal(long n){
    
    pentagonali = 1;
    return (n>0 && n == getPentagonal(n));
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

  public void euler46(){
    for (int i=3; ; i+=2){
      if (!isPrime1(i)){
        boolean isok = true;
        for (int j=3; j<i; j+=2){
          if (isPrime1(j)){
            double add = Math.sqrt((i-j)/2);
            if (Math.floor(add)==add){
              //System.out.println(i+"   "+j);
              isok = false;
              break;
            }
          }
        }
        if (isok){
          System.out.println(i);
          break;
        }
      }
    }
    
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler47(int dist){
    int found = 0;
    int i=1;
    TreeSet set = new TreeSet();
    while (true){
      i++;
      boolean iscon = true;
      for (int k=0; k<dist;k++){
        set = new TreeSet();
        int[] fac = factor(i+k);
        for (int j = 0; j < fac.length; j++) {
          if (fac[j] == 1 || !isPrime1(fac[j] )){
            continue;
          }
          //System.out.println(" "+i);
          set.add(fac[j]);
        }
        if (set.size()!=dist){
          iscon=false;
          break;
        }
      }
      if (iscon){
        System.out.println(i);
        break;
      }
    }
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

  
  public void euler49(){
    
    for (int i =1000; i<10000; i++){
      if(isPrime1(i)){
        //System.out.println("prime: "+i);
        for(int j=1; j<4000; j++){
          if (i+2*j<10000 && isPrime1(i+j) && isPrime1(i+2*j) && arePermutations(""+i,""+(i+j),""+(i+2*j))){
            System.out.println(""+i+""+(i+j)+""+(i+2*j));
          }
        }
      }
    }
  }
  
  private boolean arePermutations(String a,String b,String c){
    if ( b.indexOf(a.charAt(0))==-1 ||b.indexOf(a.charAt(1))==-1 ||
         b.indexOf(a.charAt(2))==-1 ||b.indexOf(a.charAt(3))==-1 ||
         c.indexOf(a.charAt(0))==-1 ||c.indexOf(a.charAt(1))==-1 ||
         c.indexOf(a.charAt(2))==-1 ||c.indexOf(a.charAt(3))==-1 ||
         b.replace(""+a.charAt(0), "").replace(""+a.charAt(1), "").replace(""+a.charAt(2), "").replace(""+a.charAt(3), "").length()>0 ||
         c.replace(""+a.charAt(0), "").replace(""+a.charAt(1), "").replace(""+a.charAt(2), "").replace(""+a.charAt(3), "").length()>0
            ){
      return false;
    }
    return true;
  }


/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  
  public void euler50(int to){
    int primecount = 0;
    int maxCon = 0;
    int maxConPrime = 0;
    boolean[] isPrime = new boolean[to];
    for (int i =2; i<to; i++){
      if(isPrime1(i)){
        primecount++;
        isPrime[i]=true;
      }
    }
    int[] primes = new int[primecount];
    primecount=0;
    for (int i =2; i<to; i++){
      if(isPrime1(i)){
        primes[primecount++] = i;
      }
    }
    
    for (int i = 0; i < primes.length; i++) {
      int con = 0;
      int sum = 0;
      for (int j = i; j < primes.length; j++) {
        sum += primes[j];
        if (sum>=isPrime.length || sum<0){
          break;
        }
        if (isPrime[sum]){
          if (maxCon<(j-i)){
            maxCon = j-i;
            maxConPrime = sum;
          }
          //System.out.println("i: "+i+"   "+isPrime[i]+"   "+primes[i]);
        }
      }
    }
    System.out.println("i: "+maxCon+"  "+maxConPrime);
    
  }
  

/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler52(){
    for (int i=10; ; i++){
      int cut = (int) Math.pow(10, (int)(Math.log(i)/Math.log(10)+1));
      int n1 = cut+i;
      int n2 = n1*2, n3 = n1*3, n4 = n1*4, n5 = n1*5, n6 = n1*6;
      String[] s= {""+n1,""+n2,""+n3,""+n4,""+n5};
      if (containSameChars(s)){
        println(i+" "+n1+"  "+n2+"  "+n3+"  "+n4+"  "+n5+"  "+n6);
        break;
      }
    }
  }
  
  public boolean containSameChars(String[] arr){
    for (int i = 1; i < arr.length; i++) {
      if (arr[i-1].length()!=arr[i].length()){
        return false;
      }
    }
    while(arr[0].length()>0){
      String c = ""+arr[0].charAt(0);
      for (int j = 0; j < arr.length; j++) {
        arr[j] = arr[j].replaceFirst(c, "");
      }
    }
    for (int j = 0; j < arr.length; j++) {
      if (arr[j].length() != 0){
        return false;
      }
    }
    
    return true;
  }
  
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler53(int maxn){
    BigInteger million = BigInteger.TEN.pow(6);
    int sum = 0;
    for (int n=1; n<=maxn ;n++){
      for (int r=1; r<=n ; r++){
        if (combinations(n, r).compareTo(million)==1){
          sum++;
        }
      }
    }
    
    System.out.println("sum: "+sum);
  }

  private BigInteger combinations(int n,int r){
    return factorialBigInt(n).divide(factorialBigInt(r).multiply(factorialBigInt(n-r)));
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  
  public void euler67(int[] arr){
      
    int[] arrlev = new int[arr.length+1];
    
    int i = 1;
    int lev = 1;
    while (i<arrlev.length){
      for (int j=0; j<lev ; j++){
        arrlev[i++] = lev;
      }
      lev++;
    }
    for (i=1; i<arr.length; i++){
      //we check if node has two parrents then we add the biggest parrent to current node value
      if (arrlev[i-arrlev[i+1]+1] == arrlev[i+1]-1 && arrlev[i-arrlev[i+1]+2] == arrlev[i+1]-1){
        arr[i] += arr[i-arrlev[i+1]]> arr[i-arrlev[i+1]+1] ? arr[i-arrlev[i+1]] : arr[i-arrlev[i+1]+1];
      }else{
        //else we just add the only parrent (ther is always at least one) to the current node value
        if (arrlev[i-arrlev[i+1]+1] == arrlev[i+1]-1){
          arr[i] += arr[i-arrlev[i+1]];
        }else{
          arr[i] += arr[i-arrlev[i+1]+1];
        }
      }
    }
    int max = 0;
    for (int j=0; j<arr.length; j++){
      if (arr[j]>max){
        max = arr[j];
      }
    }
    System.out.println("max 3 : "+max);
    
  }
  
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  
  public void euler69(int max){
    //Mathematica
    int nevi = 0;
    for (int i=2; i<=max; i++){
      if (i/EulerPhi(i)>nevi){
        nevi = i/EulerPhi(i);
        println(""+i);
      }
    }
  }
  
  private int EulerPhi(int i){
    //solved with mathematica: need to implement this later
    return i;
  }
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  
  public void euler76(int max){
    println(""+findSums(max, max-1));
  }
  
  public int findSums(int num, int maxSub){
    if (num==0){
      return 1;
    }
    int sum = 0;
    for (int i=maxSub;i>0;i--){
      if (num-i >=0){
        sum += findSums(num-i, i);
      }
    }
    return sum;
  }
  
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  
  public void euler81(int[][] arr){
    for (int i = 1; i < arr[0].length; i++) {
      arr[0][i] += arr[0][i-1];
    }
    for (int i = 1; i < arr.length; i++) {
      arr[i][0] += arr[i-1][0];
    }
    for (int i = 1; i < arr.length; i++) {
      for (int j = 1; j < arr.length; j++) {
        arr[i][j] += arr[i-1][j]<arr[i][j-1] ? arr[i-1][j] : arr[i][j-1];
      }
    }
    println(""+arr[arr.length-1][arr[arr.length-1].length-1]);
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  
  public void euler92(int below){
    int sum89 = 0;
    for (int i = 2; i < below; i++) {
      int cur = i;
      while(cur != 89 && cur != 1){
        cur = sumSquareOfDigits(cur);
      }
      if (cur==89){
        sum89++;
      }
    }
    println(""+sum89);
  }
  
  private int sumSquareOfDigits(int n){
    int sum =0;
    while (n>0){
      sum += (n%10)*(n%10);
      n /= 10;
    }
    return sum;
  }
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  
  public void euler97(){
    //solved with mathematica
    // Mod[28433*2^7830457+1,10000000000];
    println("8739992577");
  }
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  
  public void euler100(){
    // prime = num * 2^powerOfTwo + 1
    BigInteger n = new BigInteger("500000000000");
    BigInteger one = new BigInteger("1");
    BigInteger tvo = new BigInteger("2");
    BigInteger square = new BigInteger("1");
    BigInteger m = new BigInteger("1000000000000");
    BigInteger msquare = m.pow(2);
    while (square.compareTo(msquare)<0){
      n = n.add(one);
      square = (n.pow(2)).subtract(n).multiply(tvo);
      println(square.toString());
    }
    
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  
  public void euler102(int[][] arr){
    int inside= 0;
    for (int i = 0; i < arr.length; i++) {
      int[] p1 = {arr[i][0],arr[i][1]};
      int[] p2 = {arr[i][2],arr[i][3]};
      int[] p3 = {arr[i][4],arr[i][5]};
      //println("("+p1[0]+","+p1[1]+")   ("+p2[0]+","+p2[1]+")   ("+p3[0]+","+p3[1]+")");
      int[] p4 = {0,0};
      if (isInsideTriangle(p1, p2, p3, p4)){
        inside++;
      }
    }
    println(""+inside);
  }
  private boolean isInsideTriangle(int[] a,int[] b,int[] c,int[] point){
    if (sameSide(a, b, c, point) && sameSide(a, c, b, point) && sameSide(b, c, a, point)){
      return true;
    }
    return false;
  }
  /**
   * functions takes a vector with coordinates v1 and v2, and checks if point is on the same side of the vector as ref
   * @param v1
   * @param v2
   * @param ref
   * @param point
   * @return 
   */
  private boolean sameSide(int[] v1, int[] v2, int[] ref, int[] point){
    int[] vec = subVec(v1,v2);
    int[] vecref = subVec(v1,ref);
    int[] vecpoint = subVec(v1,point);
    long cross1 = crossProduct2d(vec, vecref);
    long cross2 = crossProduct2d(vec, vecpoint);
    cross1 = cross1/Math.abs(cross1);
    cross2 = cross2/Math.abs(cross2);
    return (cross1*cross2>=0);
  }
  
  private int[] subVec(int[] v1, int[] v2){
    if (v1.length != v2.length){
      println("vector lenght error");
      return null;
    }else{
      int[] vec = new int[v1.length];
      for (int i = 0; i < v2.length; i++) {
        vec[i] = v2[i]-v1[i];
      }
      return vec;
    }
  }
  
  /**
   * function returns cross product
   * @param vec1
   * @param vec2
   * @return 
   */
  private long crossProduct2d(int[] vec1, int[] vec2){
    return vec1[0]*vec2[1]-vec1[1]*vec2[0];
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  
  public void euler124(int max, int search){
    //int[][] arr= new int[max][2];
    CompareArray[] arr = new CompareArray[max];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new CompareArray();
      arr[i].setIndex(i+1);
      arr[i].setFacProduct(arrayProduct(factors(i+1)));
      //System.out.println(arr[i][0]+"  "+arr[i][1]);
    }
    Arrays.sort(arr);
//    for (int i = 0; i < arr.length; i++) {
//      System.out.printf("%7d %7d %7d\n",arr[i].getIndex(),arr[i].getFacProduct(),(i+1));
//    }
    System.out.printf("%7d %7d %7d\n",arr[search-1].getIndex(),arr[search-1].getFacProduct(),search);
  }
  
  class CompareArray implements Comparable<CompareArray> {
    private int index;
    private int facProduct;

    public int getFacProduct() {
      return facProduct;
    }

    public int getIndex() {
      return index;
    }

    public void setFacProduct(int facProduct) {
      this.facProduct = facProduct;
    }

    public void setIndex(int index) {
      this.index = index;
    }

    public int compareTo(CompareArray o) {
      return this.facProduct-o.getFacProduct();
    }
    
  }
  
  private int arrayProduct(int[] arr){
    int pro=1;
    for (int i = 0; i < arr.length; i++) {
      pro *= arr[i];
    }
    return pro;
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  
  public void euler125(long max){
    TreeSet set = new TreeSet();
    long palsum = 0;
    for (long i=1; i <= (long)Math.sqrt(max) ; i++){
      for (long j=i-1; j>0 ; j--){
        long squareSum=0;
        for (long k=j; k<=i; k++){
          squareSum += k*k;
        }
        if (squareSum>max){
          break;
        }
        if ( isPal(""+squareSum)){
          set.add(squareSum);
        }
      }
//      println(""+i);
    }
    while(set.size()>0) {
      palsum+= (long) set.pollFirst();
    }
    println(""+palsum);
  }
  
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  
  public void euler131(long max){
    TreeSet set = new TreeSet();
    long palsum = 0;
    for (long i=1; i <= (long)Math.sqrt(max) ; i++){
      for (long j=i-1; j>0 ; j--){
        long squareSum=0;
        for (long k=j; k<=i; k++){
          squareSum += k*k;
        }
        if (squareSum>max){
          break;
        }
        if ( isPal(""+squareSum)){
          set.add(squareSum);
        }
      }
//      println(""+i);
    }
    while(set.size()>0) {
      palsum+= (long) set.pollFirst();
    }
    println(""+palsum);
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  
  public void euler150(int height){
    int[][] arr = getRandomTable150(height);
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.printf("%8d",arr[i][j]);
      }
      println("");
    }
  }
  
  private int[][] getRandomTable150(int height){
    int[][] arr = new int[height][height];
    long t = 0;
    for (int i=0; i<height ; i++){
      for (int j=0; j<=i ; j++){
        t = (615949*t + 797807) % ((long)Math.pow(2, 20));
        arr[i][j] = (int)(t - ((long) Math.pow(2, 19)));
      }
    }
    
    return arr;
  }
  
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  
  public void euler152(int min,int max){
    int[] arr = new int[max-min+1];
    double[] arrd = new double[max-min+1];
    double[] arrdsums = new double[max-min+2];
    for (int  i = arr.length-1; i >=0 ; i--) {
      arr[i]= (i+min)*(i+min);
      arrd[i] = 1.0/arr[i];
      arrdsums[i] = arrdsums[i+1]+arrd[i];
    }
    
    printlnArray(arr, 7);
    printlnArray(arrd, 7);
    printlnArray(arrdsums, 7);
    println(""+countEuler152(arrdsums,arrd,0,0.0));
  }
  
  public int countEuler152(double[] sums, double[] arr, int index, double sum){
    if (Math.abs(sum-0.5)<0.00000000000001){
      println(""+sum);
    }
    if (sum>0.5){
      return 0;
    }else if (Math.abs(sum-0.5)<0.000000000000001){
      return 1;
    }else{
      int count = 0;
      for (int i=index; 
              i<arr.length && 
              sum+sums[i]>=0.5 && 
              (sum+arr[arr.length-1]<0.500000000000001)
              ; i++){
        count += countEuler152(sums, arr, i+1, sum+arr[i]);
      }
      return count;
    }
  }
  
  
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  
  public void euler165(){
    int counter = 0;
    int[][] lines = getRandomTable165(50);
    for (int i = 0; i < lines.length; i++) {
      //println(lines[i][0]+"  "+lines[i][1]+"  "+lines[i][2]+"  "+lines[i][3]);
    }
    for (int i = 0 ; i<lines.length ; i++){
      for (int j = i+1 ; j< lines.length ; j++){
//        if (lines[i][0] > lines[i][2]){ // we check if the second line lies left or right of the first line
//          if ((lines[i][0] < lines[j][0] && lines[i][0] < lines[j][2] ) || (lines[i][2] > lines[j][0] && lines[i][2] > lines[j][2] ) ){
//            //println("left or right :  ("+lines[i][0]+","+lines[i][1]+")("+lines[i][2]+","+lines[i][3]+")     ("+lines[j][0]+","+lines[j][1]+")("+lines[j][2]+","+lines[j][3]+")");
//            break;
//          }
//        }else{ // we check if the second line lies left or right of the first line
//          if ((lines[i][0] > lines[j][0] && lines[i][0] > lines[j][2] ) || (lines[i][2] < lines[j][0] && lines[i][2] < lines[j][2] ) ){
//            //println("left or right :  ("+lines[i][0]+","+lines[i][1]+")("+lines[i][2]+","+lines[i][3]+")     ("+lines[j][0]+","+lines[j][1]+")("+lines[j][2]+","+lines[j][3]+")");
//            break;
//          }
//        }
//        if (lines[i][1] > lines[i][3]){ // we check if the second line lies above or below of the first line
//          if ((lines[i][1] < lines[j][1] && lines[i][1] < lines[j][3] ) || (lines[i][3] > lines[j][1] && lines[i][3] > lines[j][3] ) ){
//            //println("below or abov :  ("+lines[i][0]+","+lines[i][1]+")("+lines[i][2]+","+lines[i][3]+")     ("+lines[j][0]+","+lines[j][1]+")("+lines[j][2]+","+lines[j][3]+")");
//            break;
//          }
//        }else{ // we check if the second line lies left or right of the first line
//          if ((lines[i][3] > lines[j][1] && lines[i][3] > lines[j][3] ) || (lines[i][1] < lines[j][1] && lines[i][1] < lines[j][3] ) ){
//            //println("below or abov :  ("+lines[i][0]+","+lines[i][1]+")("+lines[i][2]+","+lines[i][3]+")     ("+lines[j][0]+","+lines[j][1]+")("+lines[j][2]+","+lines[j][3]+")");
//            break;
//          }
//        }
        //println("lines may cro :  ("+lines[i][0]+","+lines[i][1]+")("+lines[i][2]+","+lines[i][3]+")     ("+lines[j][0]+","+lines[j][1]+")("+lines[j][2]+","+lines[j][3]+")");
        // vec from first point of line i to both points of line j
        int[] veci = {lines[i][2] - lines[i][0] , lines[i][3] - lines[i][1]};
        int[] veci1 = {lines[j][0] - lines[i][0] , lines[j][1] - lines[i][1]};
        int[] veci2 = {lines[j][2] - lines[i][0] , lines[j][3] - lines[i][1]};
        // vec from first point of line j to both points of line i
        int[] vecj = {lines[j][2] - lines[j][0] , lines[j][3] - lines[j][1]};
        int[] vecj1 = {lines[i][0] - lines[j][0] , lines[i][1] - lines[j][1]};
        int[] vecj2 = {lines[i][2] - lines[j][0] , lines[i][3] - lines[j][1]};
        
        if (crossProduct2d(veci, veci1)*crossProduct2d(veci, veci2)<0 && crossProduct2d(vecj, vecj1)*crossProduct2d(vecj, vecj2)<0 ){
          println("lines cross :  ("+lines[i][0]+","+lines[i][1]+")("+lines[i][2]+","+lines[i][3]+")     ("+lines[j][0]+","+lines[j][1]+")("+lines[j][2]+","+lines[j][3]+")");
          //println("lines CROSS !!!! ");
          counter++;
        }
      }
    }
    println(" "+counter);
  }
  
  private int[][] getRandomTable165(int numOfLines){
    int[][] arr = new int[numOfLines][4];
    long t = 290797L;
    for (int i=0; i<numOfLines ; i++){
      for (int j=0; j<4 ; j++){
        t = (t*t) % 50515093; 
        arr[i][j] = (int) (t % 500);
//        arr[i][j] = (int) (t % 10);
      }
    }
    return arr;
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  private int[] primeArray;

      //s.euler179(3100000); // 8 sek
      //s.euler179(4100000); // ne konca !!!!!
  public void euler179(int limit){
    primeArray = getPrimesTo(limit/10);
    println("primes  "+primeArray.length);
    
    TreeMap[] arr = new TreeMap[limit];
    
    int sum = 0;
    
    for (int i=2; i<limit-1; i++){
      if (i%100000==0){
        println(""+i);
      }
      int curPrime = 0;
      int sqrt = (int)Math.sqrt(i);
      while (i%primeArray[curPrime]!=0 && primeArray[curPrime]<= sqrt){
        curPrime++;
      }
      int primeLookup = primeArray[curPrime];
      if (primeLookup > sqrt){
        arr[i] = new TreeMap();
        arr[i].put(i, 1);
      }else{
        arr[i] = (TreeMap) arr[i/primeLookup].clone();
        if (arr[i].containsKey(primeLookup)){
          arr[i].put(primeLookup, (int) (arr[i].get(primeLookup))+1);
        }else{
          arr[i].put(primeLookup, 1);
        }
      }
    }
//    for (int i = 2; i < arr.length; i++) {
//      print(""+i+"   : ");
//      while(arr[i]!= null && !arr[i].isEmpty()){
//        Entry e = arr[i].pollFirstEntry();
//        print("  "+e.getKey()+"^"+e.getValue());
//      }
//      println("");
//    }
    println(""+sum);
  }
    
  public void euler179v2(int limit){
    primeArray = getPrimesTo(2 * (int) Math.sqrt(limit)); // 
    println("primes  "+primeArray.length);
    
    int[] arr = new int[limit];
    arr[0] = 4;
    arr[1] = 4;
    int sum = 0;
    
    for (int i=2; i<limit; i++){
      int curPrime = 0;
      int sqrt = (int)Math.sqrt(i);
      while (i%primeArray[curPrime]!=0 && primeArray[curPrime]<= sqrt){
        curPrime++;
      }
      if (primeArray[curPrime]<= sqrt){
        arr[i] = primeArray[curPrime];
      }else{
        arr[i] = i;
      }
    }
    int prevDivisors = 0;
    for (int i = 2; i < arr.length; i++) {
      int curi = i ;
      int power = 1;
      int curPrime = arr[i];
      int divisors = 1;
      while(curi>1){
        curi /= arr[curi];
        if(curPrime== arr[curi]){
          power++;
        }else{
          curPrime = arr[curi];
          divisors *= (power+1);
          power = 1;
        }
      }
      if (power>1){
        divisors *= (power+1);
      }
      if (prevDivisors == divisors){
        sum++;
      }
      prevDivisors = divisors;
    }   
    println(""+sum);
  }
  
  private int[] getPrimesTo(int to){
    int[] primes = new int[to];
    int primecount=1;
    int prime = 3;
    boolean isPrime= false;
    primes[0] = 2;
    while (prime<=to){
      primes[primecount++] = prime;
      prime+=2;
      isPrime=false;
      while(!isPrime){
        isPrime = true;
        for(int primeDevisor=0; primes[primeDevisor]<= (int)(Math.sqrt(prime)) && prime<=to; primeDevisor++){
          if (prime%primes[primeDevisor]==0){
            isPrime=false;
            prime+=2;
            break;
          }
        }
      }
    }
    int[] pr = new int[primecount];
    System.arraycopy(primes, 0, pr, 0, primecount);
    return pr;
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  
  
  public void euler303v3(int sum){
    BigInteger b3 = new BigInteger("1");
    BigInteger[] arr = new BigInteger[++sum];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new BigInteger("0");
    }
    for (int i=1; i<sum; i++){
      b3=new BigInteger("1");
      BigInteger current = new BigInteger(""+i);
      if (current.toString().replace("9", "").equals("")){ //if all are nines
        b3 = new BigInteger("99999999999999999999999999999999999999999999999");
        String solution = new String();
        for (int ii=0; ii<100; ii++){
          solution = "";
          for (int jj=0; jj<ii; jj++){
            solution+="1";
          }
          for (int jj=0; jj<100; jj++){
            solution+="2";
            if((new BigInteger(solution)).mod(current).equals(new BigInteger("0")) && (new BigInteger(solution)).compareTo(b3)==-1){
              b3 = (new BigInteger(solution));
            }
          }
        }
      }else{
        while (!b3.mod(current).equals(new BigInteger("0"))){
          b3=getNewInt10b3Big(b3);
        }
      }
      arr[i]=b3;
      System.out.println("int : "+i+"   multiple :"+arr[i].toString());
    }
    BigInteger sumdiv = new BigInteger("0");
    for(int i=1; i<arr.length; i++){
      sumdiv = sumdiv.add(arr[i].divide(new BigInteger(""+i)));
    }
    System.out.println(sumdiv.toString());
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler327(int c, int r){
    int[] rooms = new int[r+1];

    int currentRoom = 0;
    int currentCards = 0;
    boolean forward = true;
    int sum = 0;
    boolean leavemin = false;
    int lastRoom = rooms.length-c;
    
    while (currentRoom > 0 || fullRooms(rooms)<rooms.length-c){
      if (forward){
        if (currentRoom == 0){
          sum -= currentCards;
          currentCards = c-1;
          currentRoom++;
          sum += c;
          printArray(rooms,4);
        }
        if (currentCards+rooms[currentRoom]<=c || currentRoom==lastRoom){
          if (currentRoom==lastRoom){
            lastRoom--;
            leavemin = true;
          }
          forward = false;
        }else{
          while (currentCards<c && rooms[currentRoom]>0){
            currentCards++;
            rooms[currentRoom]--;
          }
          currentCards--;
          currentRoom++;
        }
      }else{
        rooms[currentRoom] += currentCards-1;
        currentCards = 0; 
        if (leavemin){
          while (currentCards<c && rooms[currentRoom]>1){
            currentCards++;
            rooms[currentRoom]--;
          }
          leavemin = false;
        }
        currentRoom--;
        forward = (currentRoom == 0);
      }
    }
    System.out.println("sum  "+sum);
  }
  private int fullRooms(int[] rooms){
    int sum = 0;
    for (int i = 0; i < rooms.length; i++) {
      sum += rooms[i]>0 ? 1:0;
    }
    return sum;
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  public void euler328(int len){
    len++;
    TreeSet ts = new TreeSet();
    int[] arr = new int[len];
    int[] arrprint = new int[len];
    int[] steps = new int[len];
    steps[1] = 0;
    steps[2] = 1;
    steps[3] = 1;
    arr[1] = 0;
    arr[2] = 1;
    arr[3] = 2;
    arrprint[1] = 1;
    arrprint[2] = 1;
    arrprint[3] = 2;
    
    System.out.println("el    1   kor    0   teža    0  : _ ");
    System.out.println("el    2   kor    1   teža    1  : *_ ");
    System.out.println("el    3   kor    1   teža    2  : _*_ ");
//    System.out.println("   2 :    1  : *_ ");
//    System.out.println("   3 :    2  : _*_ ");
    for (int i = 4; i < arr.length; i++) {
      arr[i] = Integer.MAX_VALUE;
      for (int j=1; j<=i; j++){
        if (Math.max(j+arr[j-1],j+arr[i-j]+j*steps[i-j])<=arr[i]){
          arr[i]=Math.max(arr[j-1]+j,j+arr[i-j]+j*steps[i-j]);
          if (arr[j-1] >= arr[i-j]+j*steps[i-j]){
            steps[i] = steps[j-1]+1;
          }else{
            steps[i] = steps[i-j]+1;
          }
        }
        //System.out.println("");
        //System.out.println("st el: "+i+"  del mesto: "+j+"  teza: "+(Math.max(j+arr[j-1],j+arr[i-j]+j*steps[i-j])));
      }
      System.out.printf("el %4d   kor %4d   teža %4d  : ",i,steps[i],arr[i]);
      for (int j=1; j<=i; j++){
        
        if (Math.max(arr[j-1]+j,j+arr[i-j]+j*steps[i-j])==arr[i]){
          ts.add(j);
          arrprint[i] = j;
          System.out.print("*");
        }else{
          System.out.print("_");   
        }
      }
      while (!ts.isEmpty()){
        System.out.print(" ,"+ts.pollFirst());
      }
      System.out.println();
      
    }
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    arr328place = new int[arr.length];
    for (int i = 0; i < arr328place.length; i++) {
      arr328place[i] = arr328place.length;
    }
    
      System.out.println();
    printSearchTree(arrprint, 1, arrprint.length-1, 1,0);
      System.out.println();
    printSearchTree2(arrprint, 1, arrprint.length-1, 1,0);
      System.out.println();
      System.out.println();
      
    for (int i = 1; i < arr328place.length/2; i++) {
      for (int j = 1; j < arr328place.length; j++) {
        if (arr328place[j] == i){
          System.out.printf("%2d", j-1);
        }else if (arr328place[j] < i){
          System.out.printf(" |");
        }else{
          System.out.printf("  ");
        }
      }
      System.out.println();
      for (int j = 1; j < arr328place.length; j++) {
        if (arr328place[j] == i){
          System.out.printf(" |", j);
        }else if (arr328place[j] < i){
          System.out.printf(" |");
        }else{
          System.out.printf("  ");
        }
      }
      System.out.println();
    }
  
      System.out.println();
    for (int i = 0; i < arr.length; i++) {
      System.out.printf(" %3d \n ",arr[i]);
    }
  }
  int[] arr328place;
  private void printSearchTree(int[] arr, int from, int to,int level, int place){
    if (from<to && to>0 && to<arr.length && from>0 && from<arr.length){
      printSearchTree(arr, 1, arr[to]-1, level+1, place);
      System.out.printf("%3d", level);
      printSearchTree(arr, 1, to-arr[to], level+1,arr[to] + place );
    }
  }
  private void printSearchTree2(int[] arr, int from, int to,int level, int place){
    if (from<to && to>0 && to<arr.length && from>0 && from<arr.length){
      printSearchTree2(arr, 1, arr[to]-1, level+1, place);
      System.out.printf("%3d", arr[to]+place+1);
      arr328place[arr[to]+place+1]= level;
      printSearchTree2(arr, 1, to-arr[to], level+1,arr[to] + place );
    }
  }
  
  private int search (int[] array, int from, int to){
    if (from < to-3){
      int pivot = from + 2*(to-from)/3;
      return Math.max(search(array, from, pivot-1), search(array, pivot+1, to))+array[pivot];
    }else{
      return array[from];
    }
  }
  
  private int search2(int from, int to, int add){
    if (to <4) {
      return add+to-1;
    }else{
      int minSum = Integer.MAX_VALUE;
      for (int i=from; i<=to ; i++){
        int levo = search2(from, i, add);
        int desno = search2(i, to, i+add);
        
      }
    }
    return 0;
  }    
  
  private int sumfromto(int from, int to){
    int sum =0;
    for (int i = from; i <= to; i++) {
      sum+=i;
    }
    return sum;
  }

  
  int[][] arrFromTo;
  int[] arrTo;
  int[] dividers;
  public void euler328v2(int len){
    dividers = new int[len+1];
    arrFromTo = new int[len+1][len+1];
    for (int i = 0; i < arrFromTo.length; i++) {
      for (int j = 0; j < arrFromTo[i].length; j++) {
        arrFromTo[i][j] = -1;
      }
    }
    int sum = 0;
    for (int i=1; i<= len ; i++){
      int costt = cost(1, i);
      System.out.println(i+" cost: "+costt);
      sum += costt;
    }
    System.out.println(sum);
  }
  
  private int cost(int from, int to){
    if (from >= to){
      return 0;
    }else if(from == to-1){
      return from;
    }else if(from == to-2){
      return from+1;
    }else if(arrFromTo[from][to] != -1){
      return arrFromTo[from][to];
    }else{
      int bestCost = Integer.MAX_VALUE;
      
      for (int i = (from+to)/2; i<=to; i++){
        int curCost = Math.max(cost(from, i-1), cost(i+1, to)) +i ;
        if (curCost < bestCost){
          bestCost = curCost;
          dividers[to-from] = i;
        }
      }
      
      arrFromTo[from][to]=bestCost;
      return bestCost;
    }
  }
  
  public void euler328v3(int len){
    
    dividers = new int[len+1];
    dividers[0] = 0;
    dividers[1] = 0;
    dividers[2] = 1;
    arrTo = new int[len+1];
    for (int i = 0; i < arrTo.length; i++) {
        arrTo[i] = -1;
    }
    int sum = 0;
    for (int i=1; i<= len ; i++){
      int costt = costv3(1, i);
      System.out.println(i+" cost: "+costt);
      sum += costt;
    }
    System.out.println(sum);
  }
  
  private int costv3(int from, int to){
    if (from >= to){
      return 0;
    }else if(from == to-1){
      return from;
    }else if(from == to-2){
      return from+1;
    }else if(from == 1 && arrTo[to] != -1){
      return arrTo[to];
    }else{
      int bestCost = Integer.MAX_VALUE;
      if (dividers[to-from]>0){
        bestCost = Math.max(costv3(from, from+dividers[to-from]-1), costv3(from+dividers[to-from]+1, to)) +from+ dividers[to-from] ;
      }else{
        for (int i = (from+to)/2; i<=to; i++){
          int curCost = Math.max(costv3(from, i-1), costv3(i+1, to)) +i ;
          if (curCost < bestCost){
            bestCost = curCost;
            dividers[to-from] = i;
          }
        }
      }
      if (from == 1){
        arrTo[to]=bestCost;
      }
      return bestCost;
    }
  }
  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  
/******************************************************************************/  
/******************************************************************************/  
/******************************************************************************/  

  
  public void primetest(long n){
    long t = System.nanoTime();
    for (long i = n-10000; i < n ; i++) {
      //System.out.println(i+"  "+isPrime1(i)+isPrimeLenstra(i));
      isPower(i);
    }
    System.out.println("power: "+(System.nanoTime()-t));
    t = System.nanoTime();
    for (long i = n-10000; i < n ; i++) {
      //System.out.println(i+"  "+isPrime1(i)+isPrimeLenstra(i));
      isPrime1(i);
    }
    System.out.println("prime: "+(System.nanoTime()-t));
//    for (int i = n-10000; i < n ; i++) {
//      if (isPrime1(i)){
//        System.out.println(i+"  ");
//      }
//    }
  }
  
  private boolean isPrimeLenstra(int p){
    if (isPower(p)){
      return false;
    }
    return false;
  }
  
  
  private boolean isPower(long n){
    long root = 2;
    double rootValue =0;
    do{
      rootValue = Math.pow(n, 1.0/root);
      if (Math.floor(rootValue)==rootValue){
        System.out.println(n+"  =  "+rootValue+"^"+root);
        return true;
      }
      root++;
    }while (rootValue>2);
    return false;
  }
  
  
  
  
  
  
  
  
  
  private boolean hasAllDigits(String s){
    return hasAllDigits(s, 1, 9);
  }

  
  private boolean hasAllDigits(String s,int from, int to){
    if (s.length()!=to+-from+1){
      return false;
    }
    for(int i=from; i<=to ; i++){
      if (s.indexOf(""+i)==-1){
        return false;
      }
    }
    return true;
  }

  
  
  private void printArray(int[] arr,int max){
    for (int i = 0; i < arr.length; i++) {
      System.out.printf("%"+max+"d  ",arr[i]);
    }
    System.out.println();
  }
  private void printlnArray(int[] arr,int max){
    for (int i = 0; i < arr.length; i++) {
      System.out.printf("%"+max+"d  \n",arr[i]);
    }
    System.out.println();
  }
  private void printlnArray(double[] arr,int max){
    for (int i = 0; i < arr.length; i++) {
      System.out.printf("%f \n",arr[i]);
    }
    System.out.println();
  }
  
  private void printArray(String[] arr,int max){
    for (int i = 0; i < arr.length; i++) {
      System.out.println(""+arr[i]);
    }
    System.out.println();
  }
  
  
  private String[] removeElement(String[] arr, int curLetter){
    String[] temp = new String[arr.length-1];
    for (int i = 0; i < arr.length; i++) {
      if (i == curLetter){
        continue;
      }
      if (i < curLetter){
        temp[i] = arr[i];
      }else{
        temp[i-1] = arr[i];
      }
    }
    return temp;
  }
    
  private int dayOfWeek(int year, int month, int day){
    Calendar xmas = new GregorianCalendar(year, month-1, day);
   return xmas.get(Calendar.DAY_OF_WEEK);    // 6=Friday
  }
  
  
  /**
   * 
   * function used to get base 3 numbers represented in base 10.
   * 
   * @param old base 3 number
   * @return next base 3 number
   */
  private long getNewInt10b3(long old){
    old++;
    int pos = (""+old).indexOf("3");
    while (pos != -1){
      pos = (""+old).length()-pos-1; //get the actual position of the overflow
      old += (long)(Math.pow(10, pos)*7);
      pos = (""+old).indexOf("3");
    }
    return old;
  }
  private BigInteger getNewInt10b3Big(BigInteger old){
    old = old.add(new BigInteger("1"));
    int pos = old.toString().indexOf("3");
    while (pos != -1){
      pos = (""+old).length()-pos-1; //get the actual position of the overflow
      old = old.add(new BigInteger(""+((long)(Math.pow(10, pos)*7))));
      pos = old.toString().indexOf("3");
    }
    return old;
  }
  
  
  
  private BigInteger factorialBigInt(int n){
    BigInteger fac = new BigInteger("1");
    for (int i=1; i<=n ;i++ ){
      fac = fac.multiply(new BigInteger(""+i));
    }
    return fac;
  }
  
  private int factorialInt(int n){
    int fac = 1;
    for (int i=1; i<=n ;i++ ){
      fac = fac*i;
    }
    return fac;
  }
  
  
  private int sumOfAllDevisors(int i){
    int sum=1;
    for (int j = 2; j < (int)Math.sqrt(i)+1 ; j++) {
      if (i%j == 0){
        sum += j + (i/j ==j ? 0: i/j);
      }
    }
    return sum;
  }
  
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
  
  private boolean isPrime(int prime){
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
  
  
  public boolean isPrime1(long n) {
    boolean prime = true;
		for (long i = 3; i <= Math.sqrt(n); i += 2)
			if (n % i == 0) {
				prime = false;
				break;
			}
		if (( n%2 !=0 && prime && n > 2) || n == 2) {
			return true;
		} else {
			return false;
		}
	}

  
  private boolean isPal(String niz){
    //String niz = ""+pal;
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
  private boolean isTriangle(long min){
    trianglei=1;
    return getTriangle(min-1)==min;
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
  /**
   * 
   * @param n
   * @return n-th pentagonal number
   */
  private long getPentagonaln(int n){
      return (n*(3*n-1)) / 2;
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
  private int numOfDivisorsBrute(int num){
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
  private int numOfDivisors(int number){
    int sum = 1;
    int factor = 0;
    int power = 1;

    while (number>1){
      if (number%primeArray[factor] == 0){
        number = number/primeArray[factor];
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
   * Function returns an array of all prime divisors of the given number.
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
  /**
   * Function returns an array of all prime divisors of the given number.
   * 
   * @param number 
   * @return integer array
   */
  private int[] factors(int number){
    TreeSet map = new TreeSet();
    map.add(1);
    if (number>1){
      int factor = 2;
      while (factor<=number || number != 1){
        if (number%factor == 0){
          number = number/factor;
          map.add(factor);
        }else{
          factor++;
        }
      }
    }
    int[] factorArray = new int[map.size()];
    for (int i = 0; i<factorArray.length; i++){
      factorArray[i] = (int) map.pollFirst();
    }
    return factorArray;
  }
  
  private int pow(int a,int b){
    return (int)(Math.pow(a, b));
  }
  private int sumDigitPow(int a,int b){
    int sum = 0;
    while(a>0){
      sum += pow((a%10), b);
      a = a/10;
    }
    return sum;
  }
  private long pow(long a,long b){
    return (long)(Math.pow(a, b));
  }
  
  private int numvalOfString(String s){
    int numval = 0;
    for(int j=0; j<s.length(); j++){
      numval += s.charAt(j)-64;
    }
    return numval;
  }
  
  private void println(String s){
    System.out.println(s);
  }

  private void print(String s){
    System.out.print(s);
  }
  
}
