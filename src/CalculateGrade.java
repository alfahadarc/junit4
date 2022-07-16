public class CalculateGrade {

    public static String calculateGrade(String number_str, String credit_str){
        double number;
        int credit;
        if(number_str.isEmpty() || credit_str.isEmpty()){
            throw new RuntimeException("input can not be empty");
        }
        try{
            //check for non number input
            number = Double.parseDouble(number_str);
            credit = Integer.parseInt(credit_str);
        }catch(NumberFormatException nfe){
            throw new RuntimeException("non-number input");
        }

        //negative check
        if(number < 0){
            throw new RuntimeException("negative number input is not accepted");
        }

        //fraction upgrade
        number =(int) Math.ceil(number);

        //out of bound
        if(number > 400) throw new RuntimeException("number must be less or equal 400");
        if(credit == 3){
            return ThreeCredit.getGrade(number);

        }else if(credit == 4){
            return FourCredit.getGrade(number);
        }else{
            //error
            throw new RuntimeException("Credit must be 3 or 4");
        }
    }


}
