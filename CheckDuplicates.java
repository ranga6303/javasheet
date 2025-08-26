import java.util.*;

public class CheckDuplicates {
    public static void main(String[] args) {
        String[] rolls = {
            "P5","1","N2","1","M6","1","N1","1","N0","1","L8","1","P6","1","O8","1",
            "N5","1","M8","1","L2","1","O7","1","L0","1","M1","1","L7","1","K0","1",
            "L3","1","L5","1","P7","1","O5","1","O1","1","Q2","1","M2","1","M4","1",
            "P0","1","K4","1","N4","1","M5","1","O6","1","K1","1","L4","1","N8","1",
            "P1","1","K7","1","K5","1","N6","1","J9","1","K9","1","O0","1","P2","1",
            "L9","1","J7","1","Q1","1","K6","1","O3","1","P9","1","P3","1","O2","1",
            "O9","1","K3","1","M7","1","L6","1","M9","1","M3","1","K8","1","L1","1",
            "N7","1","N3","1","O4","1","P8","1","K2","1","P4","1","N9","1","J8","1",
            "Q0","1","M0"
        };

        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        // The list contains roll numbers and '1's after each. Let's filter only roll numbers.
        for (int i = 0; i < rolls.length; i += 2) {
            String roll = rolls[i];
            if (!seen.add(roll)) {
                duplicates.add(roll);
            }
        }

        if (duplicates.isEmpty()) {
            System.out.println("No duplicates found.");
        } else {
            System.out.println("Duplicates found:");
            for (String d : duplicates) {
                System.out.println(d);
            }
        }
    }
}
