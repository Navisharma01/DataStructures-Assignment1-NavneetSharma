package artifactVault;  

public class Main {
    public static void main(String[] args) {
        // Create an instance of ArtifactVault with a size of 5
        ArtifactVault vault = new ArtifactVault(5);

        // Create a few artifacts
        Artifact artifact1 = new Artifact("Ancient Vase", 200);
        Artifact artifact2 = new Artifact("Old Scroll", 300);
        Artifact artifact3 = new Artifact("Golden Statue", 150);
        Artifact artifact4 = new Artifact("Silver Necklace", 100);
        Artifact artifact5 = new Artifact("Bronze Coin", 50);

        // Add artifacts to the vault
        vault.addArtifact(artifact1);
        vault.addArtifact(artifact2);
        vault.addArtifact(artifact3);
        vault.addArtifact(artifact4);
        vault.addArtifact(artifact5);

        // Try to add another artifact beyond the limit
        Artifact artifact6 = new Artifact("Diamond Ring", 400);
        vault.addArtifact(artifact6);  // Should print "No more space in the vault!"

        // Test linear search
        System.out.println("Linear Search: ");
        Artifact foundArtifact = vault.linearSearch("Old Scroll");
        if (foundArtifact != null) {
            System.out.println("Found: " + foundArtifact.getName());
        } else {
            System.out.println("Artifact not found.");
        }

        // Test binary search
        System.out.println("\nBinary Search: ");
        Artifact foundBinary = vault.binarySearch("Ancient Vase");
        if (foundBinary != null) {
            System.out.println("Found: " + foundBinary.getName());
        } else {
            System.out.println("Artifact not found.");
        }

        // Test removing an artifact
        System.out.println("\nRemove Artifact: ");
        String removalResult = vault.removeArtifact("Golden Statue");
        System.out.println(removalResult);

        // Attempting to remove an artifact that's not in the vault
        System.out.println("\nRemove Artifact: ");
        removalResult = vault.removeArtifact("Nonexistent Artifact");
        System.out.println(removalResult);

        // Print all remaining artifacts in the vault
        System.out.println("\nArtifacts in Vault: ");
        for (Artifact artifact : vault.getArtifacts()) {
            if (artifact != null) {
                System.out.println(artifact.getName() + " - Age: " + artifact.getAge());
            }
        }
    }
}

class ArtifactVault {
    private Artifact[] artifacts;
    private int size;
    private int currentIndex;

    public ArtifactVault(int size) {
        this.size = size;
        this.artifacts = new Artifact[size];
        this.currentIndex = 0;
    }

    // Add an artifact to the vault
    public void addArtifact(Artifact artifact) {
        if (currentIndex < size) {
            artifacts[currentIndex] = artifact;
            currentIndex++;
        } else {
            System.out.println("No more space in the vault!");
        }
    }

    // Remove an artifact by its name
    public String removeArtifact(String artifactName) {
        for (int i = 0; i < artifacts.length; i++) {
            if (artifacts[i] != null && artifacts[i].getName().equals(artifactName)) {
                artifacts[i] = null;
                return artifactName + " removed.";
            }
        }
        return artifactName + " not found.";
    }

    // Linear search for an artifact by its name
    public Artifact linearSearch(String artifactName) {
        for (Artifact artifact : artifacts) {
            if (artifact != null && artifact.getName().equals(artifactName)) {
                return artifact;
            }
        }
        return null;
    }

    // Binary search for an artifact by its name (sorted by age)
    public Artifact binarySearch(String artifactName) {
        Artifact[] sortedArtifacts = new Artifact[currentIndex];
        System.arraycopy(artifacts, 0, sortedArtifacts, 0, currentIndex);

        // Sort the artifacts by age
        java.util.Arrays.sort(sortedArtifacts, (a1, a2) -> Integer.compare(a1.getAge(), a2.getAge()));

        int low = 0;
        int high = sortedArtifacts.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Artifact midArtifact = sortedArtifacts[mid];

            if (midArtifact.getName().equals(artifactName)) {
                return midArtifact;
            } else if (midArtifact.getName().compareTo(artifactName) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    // Get the list of all artifacts in the vault
    public Artifact[] getArtifacts() {
        return artifacts;
    }
}

// The Artifact class to represent individual artifacts
class Artifact {
    private String name;
    private int age;

    public Artifact(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
