/**
 * Debugging Code - Part 1
 * 
 * @author Ginny Dang
 * @version July 6th, 2022
 */

public class Part1 {
   public void findAbc(String input){
       //System.out.println(input.length());
       int index = input.indexOf("abc");
       while (true){
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           System.out.println("index " + index);
           String found = input.substring(index+1, index+4);
           System.out.println(found);
           index = input.indexOf("abc",index+3);
           System.out.println("index after updating " + index);
       }
   }
    
   public void test() {
       //findAbc("abcd");
       //findAbc("abcdabc");
       //findAbc("woiehabchi");
       //findAbc("eusabce");
       //findAbc("aaaaabc");
       //findAbc("yabcyabc");
       //findAbc("abcbbbabcdddabc");
       findAbc("abcabcabcabca");
   }
}
