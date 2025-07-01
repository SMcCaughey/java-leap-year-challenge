import java.util.ArrayList;

public class LeapYear {

    public Boolean calculate(Integer year){
        if(year < 1){return false;}
        if(year % 400 == 0){
            return true;
        }else if (year % 100 == 0){
            return false;
        } else {
            return year % 4 == 0;
        }
    }

    public ArrayList<Integer> leapYearsBetween(Integer start, Integer end){
        ArrayList<Integer> leapYears = new ArrayList<Integer>();
        Integer currentYear = start;
        while(currentYear <= end){
            if(calculate(currentYear)){
                leapYears.add(currentYear);
            }
           currentYear++;
        }
        return leapYears;
    }

    public Integer closestLeapYearTo(Integer year){
        for(Integer i = 1; i <= 3; i++) {
            if (calculate(year)) {
                return year;
            } else if (calculate(year + i)) {
                return year + i;
            } else if (calculate(year - i)){
                return year - i;
            }
        }
        return -1;
    }

    public static void main (String[] args){
        LeapYear test = new LeapYear();

        Integer count = 0;
        while(count <= 12){
            System.out.printf("Is %d a leap year: %s%n",count, test.calculate(count));
            count++;
        }
        System.out.println(test.leapYearsBetween(1990,2010).toString());
        System.out.println(test.closestLeapYearTo(2002));

    }
}
