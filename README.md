# Assignment 5 — Strategy Pattern

**Topic:** PC Cooling Simulator  


## Description

A PC has three interchangeable cooling algorithms: Silent, Balanced, and Performance. The user selects a mode and enters a CPU temperature. The program calculates a simulated fan-speed percentage and allows switching cooling strategies at runtime.

## Strategy Pattern Components

| Component | Implementation |
|---|---|
| Strategy interface | `CoolingStrategy` — `calculateFanSpeed(int cpuTemperature)` |
| Concrete strategy 1 | `SilentCoolingStrategy` — low-noise fan-speed calculation |
| Concrete strategy 2 | `BalancedCoolingStrategy` — moderate fan-speed calculation |
| Concrete strategy 3 | `PerformanceCoolingStrategy` — stronger cooling calculation |
| Context | `PCCoolingSystem` — stores a `CoolingStrategy` and delegates the calculation |
| Client | `Main` — chooses, assigns, and switches strategies during program execution |

## Run

Open the `src` folder as the source directory in IntelliJ IDEA and run `Main.java`.

Alternatively, run from the project root:

```bash
javac -d out src/*.java
java -cp out Main
```

## Example

```text
PC Cooling Simulator

Choose a cooling mode:
1. Silent
2. Balanced
3. Performance
0. Exit
Your choice: 1
Enter CPU temperature (0-100 C): 65
CPU temperature: 65 C
Fan speed: 32%

Choose a cooling mode:
1. Silent
2. Balanced
3. Performance
0. Exit
Your choice: 2
Enter CPU temperature (0-100 C): 65
CPU temperature: 65 C
Fan speed: 62%

Choose a cooling mode:
1. Silent
2. Balanced
3. Performance
0. Exit
Your choice: 3
Enter CPU temperature (0-100 C): 65
CPU temperature: 65 C
Fan speed: 90%
```

## Clean Code Principles

1. **Single Responsibility Principle:** Each concrete strategy only calculates fan speed using its own algorithm. The context only delegates execution.
2. **Polymorphism instead of conditional logic:** `PCCoolingSystem` calls `coolingStrategy.calculateFanSpeed()` with no `if` or `switch` to identify the strategy.
3. **Meaningful names:** Names such as `BalancedCoolingStrategy`, `setCoolingStrategy`, and `calculateFanSpeed` describe their purpose clearly.
4. **Open/Closed Principle:** A new cooling algorithm can be implemented as another `CoolingStrategy` without changing the interface, existing algorithms, or `PCCoolingSystem`. The client only needs to register it as an available choice.
5. **Dependency Inversion Principle:** `PCCoolingSystem` depends on the `CoolingStrategy` interface instead of specific cooling-mode classes.
6. **Encapsulation:** Every fan-speed formula is contained in its own class. The context never needs to know the formula.

## Defense Notes

**What is the Strategy pattern?** A behavioral design pattern that allows interchangeable algorithms to be selected at runtime.

**Which class is the Context?** `PCCoolingSystem`.

**Where is runtime switching implemented?** `Main` calls `pc.setCoolingStrategy(selectedStrategy)` after the user selects a cooling mode.

**Why use an interface?** Every strategy follows the same method contract, so the context can use any implementation.

**How do you add a fourth mode?** Create another class implementing `CoolingStrategy`, then register it in `Main`. No changes to the existing strategies or context are required.

**Why are there no strategy-type conditions inside the Context?** The selected object executes the appropriate calculation through polymorphism.

**Note:** The program simulates fan-speed calculations; it does not control physical PC hardware.
