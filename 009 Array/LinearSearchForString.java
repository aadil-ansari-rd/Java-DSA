public class LinearSearchForString {
    public static int linearSearch(String[] fStrings, String key){
        for(int i=0; i<fStrings.length;i++){
            if(fStrings[i].equals(key)){
                return  i;
            }
        }
        return  -1;
    }
    public static void main(String[] args) {
        String[] fruits={"Apple", "Banana", "Orange", "Mango", "Pineapple", "Grapes", "Papaya", "Strawberry", "Blueberry", "Watermelon", "Kiwi", "Peach", "Cherry", "Pear", "Guava", "Litchi", "Pomegranate", "Coconut", "Plum", "Apricot"};
        String searchFruit = "Strawberry";
        int index = linearSearch(fruits, searchFruit);
        if(index==-1){
            System.out.println("Fruit not found");
        }else{
            System.out.println("Your fruit is at index : "+ index);
        }
    }
}
