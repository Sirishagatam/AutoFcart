package Demo.Demo;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Monthtry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<String> allMonths = Arrays.asList("JANUARY", "FEBRAURY", "MARCH", "APRIL", "MAY", "JUNE", 
                "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER");

		String targetMonth="MARCH";
		
		Month currentmonth=LocalDate.now().getMonth();
		
		String currentmonthstr=currentmonth.name();
		
		int i=allMonths.indexOf(currentmonthstr);
		
		System.out.println("Current month is:"+currentmonth+" Current month index is:"+i);
		
        while (true) {
            System.out.println("Currently at: " + allMonths.get(i));

            // Check if we have reached the target month
            if (allMonths.get(i).equals(targetMonth)) {
                System.out.println("Reached the target month: " + targetMonth);
                break;
            }

            // Move to the next month (simulate circular traversal)
            i = (i + 1) % allMonths.size();  // Use modulo operator to wrap around the list
        }


	}

}
