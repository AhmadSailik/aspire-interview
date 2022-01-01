package aspire.interview;

public class Logic1 {
    public void startWithAEIOU(String[]arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].startsWith("A")||arr[i].startsWith("E")||arr[i].startsWith("I")||arr[i].startsWith("O")||arr[i].startsWith("U")){
                System.out.println(arr[i]);
            }
        }
    }

    public void nameLongerThanFive(String[]arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length()>5){
                System.out.println(arr[i]);
            }
        }
    }
}
