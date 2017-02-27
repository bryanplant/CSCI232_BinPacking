package plant;

import edu.princeton.cs.algs4.StdIn;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.MaxPQ;

public class WorstFit {
	public static void main(String[] args){
		MaxPQ<Disk> pq = new MaxPQ<Disk>();
		int diskNum = 0;

		pq.insert(new Disk(0));

		while(StdIn.hasNextLine()){
			int file;

			try{
				file = StdIn.readInt();
			}catch(NoSuchElementException e){
				break;
			}
			if(pq.max().getSpaceLeft() - file < 0){
				pq.insert(new Disk(++diskNum));
			}
			pq.max().add(file);
		}

		while(!pq.isEmpty()){
			System.out.println(pq.delMax().toString());
		}
	}
}