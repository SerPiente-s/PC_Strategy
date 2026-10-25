import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, CoolingStrategy> strategies = new LinkedHashMap<>();
        strategies.put("1", new SilentCoolingStrategy());
        strategies.put("2", new BalancedCoolingStrategy());
        strategies.put("3", new PerformanceCoolingStrategy());

        PCCoolingSystem pc = new PCCoolingSystem(strategies.get("1"));
        Scanner scanner = new Scanner(System.in);

        System.out.println("PC Cooling Simulator");

        while (true) {
            System.out.println("\nChoose a cooling mode:");
            System.out.println("1. Silent");
            System.out.println("2. Balanced");
            System.out.println("3. Performance");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");

            String choice = scanner.nextLine().trim();
            if (choice.equals("0")) {
                System.out.println("Goodbye!");
                break;
            }

            CoolingStrategy selectedStrategy = strategies.get(choice);
            if (selectedStrategy == null) {
                System.out.println("Invalid mode. Try again.");
                continue;
            }

            int temperature = readTemperature(scanner);
            pc.setCoolingStrategy(selectedStrategy);
            int fanSpeed = pc.getFanSpeed(temperature);

            System.out.println("CPU temperature: " + temperature + " C");
            System.out.println("Fan speed: " + fanSpeed + "%");
        }
    }

    private static int readTemperature(Scanner scanner) {
        while (true) {
            System.out.print("Enter CPU temperature (0-100 C): ");
            try {
                int temperature = Integer.parseInt(scanner.nextLine().trim());
                if (temperature >= 0 && temperature <= 100) {
                    return temperature;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Enter a whole number from 0 to 100.");
        }
    }
}
