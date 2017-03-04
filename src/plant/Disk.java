package plant;

import java.util.ArrayList;

public class Disk implements Comparable<Disk>{
	private int spaceLeft;
	private ArrayList<Integer> file;
	private int id;

	public Disk(int id){
		this.id = id;
		spaceLeft = 1000000;
		file = new ArrayList<Integer>();
	}

	@Override
	public int compareTo(Disk that) {
		return Integer.compare(this.spaceLeft, that.spaceLeft);
	}


	public void add(int iFile){
		file.add(iFile);
		spaceLeft -= iFile;
	}

	public int getSpaceLeft(){
		return spaceLeft;
	}

	public int getID(){
		return id;
	}

	@Override
	public String toString(){
		String out = "	";
		out = out.concat(Integer.toString(id) + "  ");
		out = out.concat(Integer.toString(spaceLeft) + ":  ");
		for(int i : file){
			 out = out.concat(Integer.toString(i) + " ");
		}
		return out;
	}
}
