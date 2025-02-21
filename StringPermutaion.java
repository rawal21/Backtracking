public class StringPermutaion{

  public static void findPermution(String str , String ans)
  {
    if(str.length()==0)
    {
      System.out.println(ans);
      return ;
    }

    // base case 
    for(int i = 0 ; i < str.length() ; i++)
    {
      char curr = str.charAt(i); 
    String newstr= str.substring(0, i)+str.substring(i+1); 
     findPermution(newstr, ans+curr);

    }
  
  }
  public static void main(String[] args) {
    String str = "abc";
    findPermution(str, "");
  }
}