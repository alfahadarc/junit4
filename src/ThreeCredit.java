public class ThreeCredit {

    public static String getGrade(double number){
        if(number >= 240 && number <= 400){
            //A 240 to 400
            return "A";

        }else if(number >= 210 && number <= 239){
            //B n 210 to 239
            return "B";

        }else if(number >= 180 && number <= 209){
            //C 180 to 209
            return "C";

        }else
            //less than 180
            return "F";
        }
    }

