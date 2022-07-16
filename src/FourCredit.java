public class FourCredit {

    public static String getGrade(double number){
        if(number >= 320 && number <= 400){
            //A 320-400,
            return "A";

        }else if(number >= 280 && number <= 319){
            //B n 280-319
            return "B";

        }else if(number >= 240 && number <= 279){
            //C 240-279
            return "C";

        }else{
            //less than 240
            return "F";
        }
    }
}
