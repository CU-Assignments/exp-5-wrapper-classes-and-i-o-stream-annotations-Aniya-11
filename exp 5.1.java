import java.util.ArrayList;
import java.util.Scanner;

public class IntegerSumCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        
        System.out.println("Enter integers (one per line). Enter a non-integer to stop:");
        
        
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            try {
                
                Integer num = Integer.parseInt(input);
                numbers.add(num); 
            } catch (NumberFormatException e) {
               
                break;
            }
        }
        
        
        int sum = 0;
        for (Integer num : numbers) {
            sum += num; 
        }
        
        System.out.println("Sum of the integers: " + sum);
        scanner.close();
    }
}
