public class SubSetString {
 public static void SubSet(String str , String ans , int i) {
    // base 
    if(i==str.length())
    {
      if(ans.length()==0)
      {
        System.out.println("null");
      }
      else{
        System.out.println(ans);
      }

      return ;
    }

    // recurssion 
    // decison is yes 
    SubSet(str, ans+str.charAt(i), i+1);

    // decison is no
    SubSet(str, ans, i+1);
 }
  public static void main(String[] args) {
   String str = "abc";
   SubSet(str, "", 0);
  }
}
