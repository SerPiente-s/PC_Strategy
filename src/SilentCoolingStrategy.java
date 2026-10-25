public class SilentCoolingStrategy implements CoolingStrategy {
    @Override
    public int calculateFanSpeed(int cpuTemperature) {
        int fanSpeed = 20 + (cpuTemperature - 40) / 2;
        return Math.max(20, Math.min(100, fanSpeed));
    }
}
