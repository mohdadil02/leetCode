public class FancyString {
    public static String makeFancyString(String s) {
         StringBuilder b = new StringBuilder();
         for(int i =0; i<s.length(); i++){
             b.append(s.charAt(i));
             if(i>=2 && s.charAt(i) == s.charAt(i-1) && s.charAt(i)==s.charAt(i-2)){
                 b.deleteCharAt(b.length() - 1);
             }
         }
         return b.toString();

    }
    public static void main(String[] args) {
        // Test case 1
        String s1 = "leeetcode";
        System.out.println("Fancy string for '" + s1 + "' is: " + makeFancyString(s1));

    }
}