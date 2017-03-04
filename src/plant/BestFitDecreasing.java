package plant;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.StdIn;

public class BestFitDecreasing {
	public static void main(String[] args){
		RedBlackBST<Integer, Disk> tree = new RedBlackBST<Integer, Disk>();

		int diskNum = 0;
		int totalSpace = 0;
		Disk first = new Disk(diskNum);
		tree.put(first.getSpaceLeft(), first);

		while(StdIn.hasNextLine()){
			int file;
			Disk disk;

			try{
				file = StdIn.readInt();
			}
			catch(NoSuchElementException e){
				break;
			}

			if(tree.ceiling(file) != null){
				disk = tree.get(tree.ceiling(file));
				tree.delete(tree.ceiling(file));
			}
			else{
				disk = new Disk(++diskNum);
			}
			disk.add(file);
			tree.put(disk.getSpaceLeft(), disk);

			totalSpace += file;
		}

		System.out.println("file sizes sum = " + (double)totalSpace/1000000 + " GB");
		System.out.println("Disks used     = " + (diskNum+1));

		while(!tree.isEmpty()){
			System.out.println(tree.get(tree.max()).toString());
			tree.deleteMax();
		}
	}
}
