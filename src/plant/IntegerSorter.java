package plant;

import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.StdIn;

public class IntegerSorter {
	public static void main(String[] args){
		MaxPQ<Integer> pq = new MaxPQ<Integer>();

		while(StdIn.hasNextLine()){
			pq.insert(StdIn.readInt());
		}
		while(!pq.isEmpty()){
			System.out.println(pq.delMax());
		}
	}
}
