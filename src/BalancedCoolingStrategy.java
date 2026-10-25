public class BalancedCoolingStrategy implements CoolingStrategy {
    @Override
    public int calculateFanSpeed(int cpuTemperature) {
        int fanSpeed = 25 + (cpuTemperature - 40) * 3 / 2;
        return Math.max(25, Math.min(100, fanSpeed));
    }
}
