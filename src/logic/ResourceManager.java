package logic;

public class ResourceManager {
	public static final int WOOD=0,STONE=1,IRON=2,DIAMOND=3,ARTIFACT=4;
	public static final String[] name={"Wood","Stone","Iron","Diamond","Alien Artifact"};
	
	// x artifacts = 1 target unit
	public static final int[] exchangeRate={1,10,100,500};
	
	public static ResourceManager instance;
	
	private int[] capacity;
	private int[] resource;
	public ResourceManager(){
		capacity=new int[5];
		capacity[0]=capacity[1]=capacity[2]=capacity[3]= 100;
		capacity[4] = 9999;
		resource=new int[5];
		resource[0]=resource[1]=resource[2]=resource[3]=0;
		resource[4] = 100;
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
