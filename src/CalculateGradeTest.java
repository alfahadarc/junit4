import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculateGradeTest {

//    @Test
//    @DisplayName("Extra")
//    public void extra_test(){
//        System.out.println(CalculateGrade.calculateGrade("-1", "3"));
//    }

    @Test
    @DisplayName("non number input test")
    public void non_number_input_test() {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            CalculateGrade.calculateGrade("er", "3");
        });
        if(exception == null) fail();
        else assertEquals("non-number input",exception.getMessage());
    }
    //case for credit and both
    @Test
    @DisplayName("non number input test")
    public void non_number_input_credit_test() {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            CalculateGrade.calculateGrade("200", "er");
        });
        if(exception == null) fail();
        else assertEquals("non-number input",exception.getMessage());
    }

    @Test
    @DisplayName("non number input test")
    public void non_number_input_both_test() {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            CalculateGrade.calculateGrade("er", "rt");
        });
        if(exception == null) fail();
        else assertEquals("non-number input",exception.getMessage());
    }

    //credit test
    @DisplayName("credit test only 3 and 4 accepted")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "5", "6"})
    public void credit_input_test(String credit) {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            CalculateGrade.calculateGrade("200", credit);
        });
        if(exception == null) fail();
        else assertEquals("Credit must be 3 or 4",exception.getMessage());
    }

    //negative number test
    @DisplayName("negative number test")
    @ParameterizedTest
    @ValueSource(strings = {"-0.05", "-0.5", "-200", "-350", "-400"})
    public void negative_number_test(String number){
      Exception exception =  Assertions.assertThrows(RuntimeException.class, () -> {
            CalculateGrade.calculateGrade(number, "3");
        });
        if(exception == null) fail();
        else assertEquals("negative number input is not accepted",exception.getMessage());
    }

    //null input check
    @Test
    @DisplayName("null input test")
    public void null_input_check(){
      Exception exception =  Assertions.assertThrows(RuntimeException.class, ()->{
            CalculateGrade.calculateGrade("", "3");
        });
      if(exception == null) fail();
      else assertEquals("input can not be empty", exception.getMessage());
    }

    //number > 400 check
    @DisplayName("out of bound test(number <= 400)")
    @ParameterizedTest
    @ValueSource(strings = {"400.01", "500", "10000"})
    public void out_of_bound_input_check(String number){
      Exception exception =  Assertions.assertThrows(RuntimeException.class, ()->{
            CalculateGrade.calculateGrade(number, "3");
        });
        if(exception == null) fail();
        else assertEquals("number must be less or equal 400",exception.getMessage());
    }


    //grade test

    @DisplayName("grade A for 3 credit")
    @ParameterizedTest
    @ValueSource(strings = {"240", "245", "300", "350", "400"})
    public void grade_A_3_credit_test(String number) {
        assertEquals("A", CalculateGrade.calculateGrade(number, "3"));
    }


    @DisplayName("grade B for 3 credit")
    @ParameterizedTest
    @ValueSource(strings = {"210", "220", "230", "239"})
    public void grade_B_3_credit_test(String number) {
        assertEquals("B", CalculateGrade.calculateGrade(number, "3"));
    }


    @DisplayName("grade C for 3 credit")
    @ParameterizedTest
    @ValueSource(strings = {"180", "190", "200", "209"})
    public void grade_C_3_credit_test(String number) {
        assertEquals("C", CalculateGrade.calculateGrade(number, "3"));
    }


    @DisplayName("grade F for 3 credit")
    @ParameterizedTest
    @ValueSource(strings = {"0", "100", "150", "179"})
    public void grade_F_3_credit_test(String number) {
        assertEquals("F", CalculateGrade.calculateGrade(number, "3"));
    }

    //4 credit

    @DisplayName("grade A for 4 credit")
    @ParameterizedTest
    @ValueSource(strings = {"320", "340", "350", "355", "400"})
    public void grade_A_4_credit_test(String number) {
        assertEquals("A", CalculateGrade.calculateGrade(number, "4"));
    }


    @DisplayName("grade B for 4 credit")
    @ParameterizedTest
    @ValueSource(strings = {"280", "290", "300", "319"})
    public void grade_B_4_credit_test(String number) {
        assertEquals("B", CalculateGrade.calculateGrade(number, "4"));
    }


    @DisplayName("grade C for 4 credit")
    @ParameterizedTest
    @ValueSource(strings = {"240", "250", "260", "279"})
    public void grade_C_4_credit_test(String number) {
        assertEquals("C", CalculateGrade.calculateGrade(number, "4"));
    }


    @DisplayName("grade F for 4 credit")
    @ParameterizedTest
    @ValueSource(strings = {"0", "100", "150", "239"})
    public void grade_F_4_credit_test(String number) {
        assertEquals("F", CalculateGrade.calculateGrade(number, "4"));
    }


    //fractional test
    //grade test

    @DisplayName("fractional grade A for 3 credit")
    @ParameterizedTest
    @ValueSource(strings = {"239.1", "239.5", "300.5","399.2"})
    public void fractional_grade_A_3_credit_test(String number) {
        assertEquals("A", CalculateGrade.calculateGrade(number, "3"));
    }


    @DisplayName("fraction grade B for 3 credit")
    @ParameterizedTest
    @ValueSource(strings = {"209.1", "209.5", "230.3", "238.01"})
    public void fraction_grade_B_3_credit_test(String number) {
        assertEquals("B", CalculateGrade.calculateGrade(number, "3"));
    }


    @DisplayName("fractional grade C for 3 credit")
    @ParameterizedTest
    @ValueSource(strings = {"179.2", "190.3", "200.02", "208.5"})
    public void fractional_grade_C_3_credit_test(String number) {
        assertEquals("C", CalculateGrade.calculateGrade(number, "3"));
    }


    @DisplayName("fractional grade F for 3 credit")
    @ParameterizedTest
    @ValueSource(strings = {"0.001","0.1", "100.2", "150.3", "178.3"})
    public void fractional_grade_F_3_credit_test(String number) {
        assertEquals("F", CalculateGrade.calculateGrade(number, "3"));
    }

    //4 credit
    @DisplayName("fractional grade A for 4 credit")
    @ParameterizedTest
    @ValueSource(strings = {"319.2", "340.2", "319.02", "355", "399.05"})
    public void fractional_grade_A_4_credit_test(String number) {
        assertEquals("A", CalculateGrade.calculateGrade(number, "4"));
    }


    @DisplayName("fractional grade B for 4 credit")
    @ParameterizedTest
    @ValueSource(strings = {"279.02", "279.5", "300.2", "318.5"})
    public void fractional_grade_B_4_credit_test(String number) {
        assertEquals("B", CalculateGrade.calculateGrade(number, "4"));
    }


    @DisplayName("fractional grade C for 4 credit")
    @ParameterizedTest
    @ValueSource(strings = {"239.2", "239.5", "260.5", "278.5"})
    public void fractional_grade_C_4_credit_test(String number) {
        assertEquals("C", CalculateGrade.calculateGrade(number, "4"));
    }


    @DisplayName("fractional grade F for 4 credit")
    @ParameterizedTest
    @ValueSource(strings = {"0.001","0.1", "100.2", "150.3", "238.5"})
    public void fractional_grade_F_4_credit_test(String number) {
        assertEquals("F", CalculateGrade.calculateGrade(number, "4"));
    }



}