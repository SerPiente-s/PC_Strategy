public class PerformanceCoolingStrategy implements CoolingStrategy {
    @Override
    public int calculateFanSpeed(int cpuTemperature) {
        int fanSpeed = 40 + (cpuTemperature - 40) * 2;
        return Math.max(40, Math.min(100, fanSpeed));
    }
}
