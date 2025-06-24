public class RemoveDuplicate{
    public static void removeDuplicates(String str , int i , StringBuilder newStr , boolean[] map){
        if(i == str.length()){
            System.out.println(newStr);
            return;
        }
        if(map[str.charAt(i) - 'a']){ //Duplicate
            removeDuplicates(str, i+1, newStr, map);
        }else{
            map[str.charAt(i)-'a']=true;
            removeDuplicates(str, i+1, newStr.append(str.charAt(i)),map);

        }
    }
    public static void main(String[] args){
        removeDuplicates("apnacollege", 0, new StringBuilder(""),new boolean[26]);
    }
}