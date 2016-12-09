package logic;

public class ResourceManager {
	public static final int WOOD=0,IRON=1,DIAMOND=2,ARTIFACT=3;
	public static final String[] name={"Wood","Iron","Diamond","Alien Artifact"};
	
	public static ResourceManager instance;
	
	private int[] capacity;
	private int[] resource;
	public ResourceManager(){
		capacity=new int[4];
		capacity[0]=capacity[1]=capacity[2]=capacity[3]=10;
		resource=new int[4];
		resource[0]=resource[1]=resource[2]=resource[3]=10;
	}
	public int getCapacity(int index){
		return capacity[index];
	}
	public int getResource(int index){
		return resource[index];
	}
	public void addResource(int index,int amount){
		resource[index]+=amount;
		normalize(index);
	}
	public void addCapacity(int index,int amount){
		capacity[index]+=amount;
		normalize(index);
	}
	private void normalize(int index){
		if(resource[index]>capacity[index]){
			resource[index]=capacity[index];
		}
	}
}
