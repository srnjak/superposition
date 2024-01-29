# Quantum State Swapping Simulation

## Overview

This Java-based simulation explores the quantum mechanics phenomenon where the state of particles changes upon measurement. It specifically focuses on the effects of measuring and swapping the position and momentum of particles, illustrating how quantum measurements influence particle states.

## Experiment Description

The experiment simulated in this project investigates the impact of measurements on quantum states, with a focus on position and momentum:

1. **Measuring Position:** Particles are initially measured for position, establishing a defined state.

2. **Measuring Momentum:** Subsequently, particles are measured for momentum. This step demonstrates the quantum effect where measuring one property influences another.

3. **Re-measuring Position:** The final measurement of position shows a deviation from the initial state, highlighting the non-passive nature of quantum measurement.

The simulation demonstrates that quantum measurements actively alter the system's state, challenging classical notions of independent properties.

## Test Scenarios and Results

The simulation includes two key test scenarios:

- **Accept High:** After measuring momentum, only particles with "high" momentum are accepted for the next measurement. This scenario reflects the selective measurement process.

- **Accept High and Low:** Both "high" and "low" momentum particles are combined and accepted for the third measurement. This scenario provides insights into how different states, when combined, influence the overall system.

## Sample Test Results

Here are some results from various swap strategies, with each strategy described based on its implementation:

### Sequential
- Description: Applies a predictable, ordered pattern of swaps, closely aligning with expected quantum mechanics results.
   - Accept high: 50.0%, 25.0%, 12.5%
   - Accept high and low: 50.0%, 50.0%, 50.0%

### Random
- Description: Implements a random selection of swaps, introducing unpredictability and simulating chaotic quantum conditions.
   - Accept high: 50.0%, 25.0%, 12.5%
   - Accept high and low: 50.0%, 50.0%, 25.0%

### No Swaps
- Description: Maintains the original states of particles without any swaps, serving as a control scenario.
   - Accept high: 50.0%, 25.0%, 25.0%
   - Accept high and low: 50.0%, 50.0%, 50.0%

### Swap Momentum
- Description: Swaps only the momentum property, leaving position unchanged, to observe the isolated effects on momentum.
   - Accept high: 50.0%, 25.0%, 25.0%
   - Accept high and low: 50.0%, 50.0%, 50.0%

### Swap Position
- Description: Swaps only the position property of particles, examining the effects of changing position while keeping momentum constant.
   - Accept high: 50.0%, 25.0%, 25.0%
   - Accept high and low: 50.0%, 50.0%, 50.0%

### Swap Position and Momentum
- Description: Simultaneously swaps both position and momentum properties, representing a comprehensive state change.
   - Accept high: 50.0%, 25.0%, 25.0%
   - Accept high and low: 50.0%, 50.0%, 50.0%

### Advanced Sequence
- Description: Utilizes a complex, predefined sequence of swaps, simulating intricate patterns of state changes.
   - Accept high: 50.0%, 25.0%, 12.5%
   - Accept high and low: 50.0%, 50.0%, 50.0%

### First Half No Swap, Second Half Swap Momentum
- Description: Applies no swaps to the first half of particles and momentum swaps to the second half, contrasting different strategies.
   - Accept high: 50.0%, 25.0%, 25.0%
   - Accept high and low: 50.0%, 50.0%, 50.0%

### First Half Sequence, Second Half Random
- Description: Combines a sequential swap strategy for the first half and random swaps for the second half, testing mixed methodologies.
   - Accept high: 50.0%, 25.0%, 12.5%
   - Accept high and low: 50.0%, 50.0%, 50.0%

### First Half Random, Second Half Sequence
- Description: Random swaps are applied to the first half and sequential swaps to the second half, blending randomness with order.
   - Accept high: 50.0%, 25.0%, 12.5%
   - Accept high and low: 50.0%, 50.0%, 25.0%

These results demonstrate how different strategies for measuring and swapping particle states influence the outcomes.

## Running the Simulation

### Prerequisites

- Java JDK 17
- Maven (for dependency management and running the tests)

### Steps to Run

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/srnjak/superposition
   cd superposition
   ```

2. **Run the Tests:**
   ```bash
   mvn test
   ```

The test outcomes will highlight how different measurement and state swapping strategies influence particle states.

## Additional Notes

- The project simulates the Quantum Eraser concept, emphasizing how measurements influence quantum states.
- It provides a platform to explore the complex nature of quantum measurements and the interdependence of quantum properties.
- Future enhancements could involve simulating Quantum Entanglement, exploring diverse measurement strategies, incorporating probabilistic outcomes, and developing visualization tools.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
