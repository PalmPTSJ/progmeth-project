package logic;

public class ResourceManager {
	public static final int WOOD = 0, STONE = 1, IRON = 2, DIAMOND = 3, ARTIFACT = 4;
	public static final String[] name = { "Wood", "Stone", "Iron", "Diamond", "Alien Artifact" };

	// x artifacts = 1 target unit
	public static final int[] exchangeRate = { 1, 10, 100, 250 };

	public static ResourceManager instance;

	private int[] capacity = new int[] { 0, 0, 0, 0, 9999 };
	private int[] resource = new int[] { 0, 0, 0, 0, 0 };

	public int getCapacity(int index) {
		return capacity[index];
	}

	public int getResource(int index) {
		return resource[index];
	}

	public void addResource(int index, int amount) {
		resource[index] += amount;
		normalize(index);
	}

	public void addCapacity(int index, int amount) {
		capacity[index] += amount;
		normalize(index);
	}

	// check resource overflow
	private void normalize(int index) {
		if (resource[index] > capacity[index]) {
			resource[index] = capacity[index];
		}
	}
}
