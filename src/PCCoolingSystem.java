import java.util.Objects;

public class PCCoolingSystem {
    private CoolingStrategy coolingStrategy;

    public PCCoolingSystem(CoolingStrategy coolingStrategy) {
        setCoolingStrategy(coolingStrategy);
    }

    public void setCoolingStrategy(CoolingStrategy coolingStrategy) {
        this.coolingStrategy = Objects.requireNonNull(coolingStrategy);
    }

    public int getFanSpeed(int cpuTemperature) {
        return coolingStrategy.calculateFanSpeed(cpuTemperature);
    }
}
