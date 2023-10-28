import java.util.*;
import java.time.LocalDate;

public class AgeCalculator extends Exception {
    private String errorText;

    public AgeCalculator(String errorText) {
        this.errorText = errorText;
    }

    @Override
    public String getMessage() {
        return "MyException: Exception type: " + errorText;
    }

    public static void main(String[] args) {
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        Scanner input = new Scanner(System.in);
        int yearOfBirth = 1;
        boolean continueCycle = true;
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        int currentDay = currentDate.getDayOfMonth();
        int currentYear = currentDate.getYear();
        int monthOfBirth = 1;
        int dayOfBirth = 1;

		System.out.println("Current Date(YYYY-MM-DD): " + currentYear +"-"+ currentMonth +"-"+ currentDay);
        
		do {
            try {
                System.out.print("Input the year of birth (YYYY)");
                yearOfBirth = input.nextInt();
                if (yearOfBirth > currentYear) {
                    throw new AgeCalculator("Value must be before the current year");
                } else {
                    if ((yearOfBirth % 4 == 0 && yearOfBirth % 100 != 0) || yearOfBirth % 400 == 0) {
                        daysInMonth[1] = 29;
                    }
                    continueCycle = false;
                }
            } catch (InputMismatchException ex) {
                System.out.println("The value must be an integer");
                input.nextLine();
            } catch (AgeCalculator ex) {
                System.out.println(ex.getMessage());
            }
        } while (continueCycle);

        continueCycle = true;

        do {
            try {
                System.out.print("Input the month of birth (MM)");
                monthOfBirth = input.nextInt();
                if (monthOfBirth > 12 || monthOfBirth <= 0) {
                    throw new AgeCalculator("Value must be between 1 and 12");
                } else if (monthOfBirth > currentMonth && yearOfBirth == currentYear) {
                    throw new AgeCalculator("Value can't be above the current month while the year of birth is the same as the current year");
                } else {
                    continueCycle = false;
                }
            } catch (InputMismatchException ex) {
                System.out.println("The value must be an integer");
                input.nextLine();
            } catch (AgeCalculator ex) {
                System.out.println(ex.getMessage());
            }
        } while (continueCycle);

        continueCycle = true;
        int maximumDaysInMonth = daysInMonth[monthOfBirth - 1];

        do {
            try {
                System.out.print("Input the day of birth (DD)");
                dayOfBirth = input.nextInt();
                if (dayOfBirth > maximumDaysInMonth || dayOfBirth <= 0) {
                    throw new AgeCalculator("Value must be between a valid day between 0 and " + maximumDaysInMonth);
                } else if (monthOfBirth == currentMonth && yearOfBirth == currentYear && dayOfBirth > currentDay) {
                    throw new AgeCalculator("Value can't be above the current day while the year and month of birth is the same as the current year and month");
                } else {
                    continueCycle = false;
                }
            } catch (InputMismatchException ex) {
                System.out.println("The value must be an integer");
                input.nextLine();
            } catch (AgeCalculator ex) {
                System.out.println(ex.getMessage());
            }
        } while (continueCycle);

        int ageInYears = currentYear - yearOfBirth;
        int ageInMonths = currentMonth - monthOfBirth;
        int ageInDays = currentDay - dayOfBirth;

        if (ageInDays < 0) {
            ageInMonths--;
            ageInDays += maximumDaysInMonth;
        }

        if (ageInMonths < 0) {
            ageInYears--;
            ageInMonths += 12;
        }

        if (monthOfBirth == currentMonth && yearOfBirth == currentYear && dayOfBirth == currentDay) {
            System.out.println("Congratulations, you were born today!");
            input.close();
            return;
        }

        System.out.println("Days: " + ageInDays + "\nMonth: " + ageInMonths + "\nYear:" + ageInYears);
        input.close();
    }
}
