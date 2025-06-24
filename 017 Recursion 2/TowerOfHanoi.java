public class TowerOfHanoi {
    public static void towerOfHanoi(int n, char source , char helper , char destination){
        if(n==1){
            System.out.println( "Move Disk 1 from " + source + " to " + destination);
            return;
        }
        towerOfHanoi(n-1, source, destination, helper);
        System.out.println("Move Disk " + n + " from " + source + " to " + destination);
        towerOfHanoi(n-1,  helper,source, destination);
    }
    public static void main(String[] args) {
        towerOfHanoi(3, 'a', 'b', 'c');
    }
}
