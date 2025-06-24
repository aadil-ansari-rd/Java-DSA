public class ShortestPath {
    public static float shortestPath(String str){
        int x=0,y=0;
        int n= str.length();
        str=str.toLowerCase();
        for(int i=0;i<n;i++){
            char ch = str.charAt(i);
            if(ch=='e'){
                x++;
            }else if(ch=='w'){
                x--;
            }else if(ch=='n'){
                y++;
            }else{
                y--;
            }
        }

        int x2 = x*x;
        int y2 = y*y;
        int x2plusY2 = x2+y2;
        float path = (float) Math.sqrt(x2plusY2);
        return path;
    }
    public static void main(String[] args){
        String path = "ns";
        System.out.println(shortestPath(path));
    }
}
