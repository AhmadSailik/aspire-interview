package aspire.interview;

public class Logic2 {
    public void countNumberAndSpaceAndString(String str){
        int letter=0;
        int number=0;
        int specialCharactersWithSpace=0;
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))){
                number++;
            }else if(Character.isLetter(str.charAt(i))){
                letter++;
            }else {
                specialCharactersWithSpace++;
            }
        }
        System.out.println("letter is: "+letter+" number is: "+number+" special characters with space is: "+specialCharactersWithSpace);
    }
}
