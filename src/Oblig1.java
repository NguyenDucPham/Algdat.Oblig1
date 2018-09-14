import java.sql.SQLOutput;

//////Nguyen Duc Pham, s315303///////////////

import java.util.*;
public class Oblig1 {

    public static int maks(int[] a){
        if(a.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen er tom");
        }

        for(int i = 0; i < a.length-1; i++) {
            if (a[i] > a[i + 1]) {
                int temp = a[i];
                a[i]= a[i + 1];
                a[i + 1] = temp;
            }
        }



        return a[a.length-1];

    }

    /* Det blir flest ombyttinger om høyest verdi ligger i den forste indeksen i arrayen,
    og minst ombyttinger om det ligger bakerst i arrayen.
    Denne maks metoden intererer over alle ledd i arrayet og sammenligner før den evt foreta en swap mellom tall
    hvis det første tallet er større. Denne metoden er ikke så hurtig sammenlignet med metoder som f.eks tre-metoden
    som vi har sett tidligere i forelesningen. I array med store tall vil tre-metoden være mye kjappere da den vil få
    mindre sammenligninger og mindre operasjoner.

    Gjennomsnittet for en array med lengde n vil være (n-1)/2.
    */

   public static int ombyttinger(int[] a){
        if(a.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen er tom");
        }
       int ant=0;
        for(int i = 0; i < a.length - 1; i++)
            if (a[i] >= a[i + 1]) {
                ant++;
            }



        return ant;

    }

//oppgave 2
    public static int antallUlikeSortert(int[] a){
       if (a.length<1) {
           throw new java.util.NoSuchElementException("A er tom");
       }
       int count=1;
       for (int i=0; i < a.length - 1; i++){
           if(a[i] > a[i+1]) {
               throw new java.lang.IllegalStateException("a er ikke sortert");
           }
           else if(a[i]< a[i+1]) {
                   count++;
           }

       }

        return count;
    }

//oppgave 3

    public static int antallUlikeUsortert(int[] a){

       if(a.length<1){
           throw new java.util.NoSuchElementException("A er tom");
       }

       int ant=1;
       for (int i=0; i< a.length -1; i++){
           int t = a[i];
           int count=1;
           int tempcnt=0;

            for (int j =i+1; j< a.length ;j++){
                if (t ==a[j]) {
                    tempcnt++;
                }

            }
           if (tempcnt<count){
               ant++;
           }
       }
       //System.out.println(ant);
      
       return ant;
    }
//oppgave 4
    public static void delsortering(int[] a){

       int mid=0;
       int right=a.length-1;

       while (mid < a.length && (a[mid] %2) !=0){
           mid++;
       }
       while (right>=0 && (a[right] % 2)== 0){
           right--;
       }

       while(true){
           if(mid<right){
               bytt(a,mid++,right--);
           }else{
               break;
           }
           while ((a[mid] %2) !=0){
               mid++;
           }
           while ((a[right] %2) == 0){
               right++;
           }
       }
       Arrays.sort(a,0, mid);
       Arrays.sort(a, mid, a.length-1);
    }
    public static void bytt(int[] a, int i, int j){
       int temp = a[i];
       a[i] = a[j];
       a[j]=temp;

    }
//oppgave 5
    public static void rotasjon(char[] a){

       if(a.length<2)
        return;

        char temp= a[a.length-1];
        for (int i=a.length-1; i>=1; i--) {
              a[i] = a[i-1];
        }
            a[0]=temp;


    }
//oppgave 6

    public static void rotasjon(char[] a, int k) {
        int temp=a.length;
        if(temp<2)
            return;

        if((k %= temp) < 0)
            k += temp;
        char[] n= Arrays.copyOfRange(a,temp-k,temp);
        for (int i = temp-1; i>=k ;i--)
            a[i]=a[i-k];
        System.arraycopy(n,0,a,0,k);

    }
//oppgave 7a
    public static String flett(String s, String t){

        char[] streng = new char[s.length() + t.length()];
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        int k=0;
        int l=0;
        int m=0;
        for (int i =0; i < Math.max(s.length(), t.length()); i++){
            if (s.length()>l){
                streng[k++]=a[l++];
            }
            if(m<t.length()){
                streng[k++]= b[m++];
            }
        }

        return String.valueOf(streng);
    }

//oppgave 7b
    public static String flett(String... s) {

        String b = "";
        int k = 0;
        int[] f = new int[s.length];
        for (String x : s) k += x.length();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < s.length; j++) {
                if (f[k] < s[j].length()) {
                    b += s[j].toCharArray()[f[j]];
                    f[j]++;
                }
            }

        }
        return b;
    }

    //oppgave 8
    // på denne oppgaven fikk jeg ikke til å skille indeks på tall med like verdier.

    public static int[] indekssortering(int[] a){
        if(a.length<1) {
            return a;
        }
        int[] indeks= new int[a.length];
        int[] temp= new int[a.length];
        System.arraycopy(a,0,temp,0, a.length);
        Arrays.sort(temp);

        for (int i=0; i<a.length ;i++){
           for(int j=0; j<a.length; j++){
               if(a[i]==temp[j]){
                   indeks[i]=j;

               }

           }
        }

        return indeks;
        }
    public static int[] tredjeMin(int[] a){
       int [] test= {1};
       return test;
    }

    public static boolean inneholdt(String a, String b){
       return true;
    }


}