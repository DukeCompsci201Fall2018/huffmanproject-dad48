import java.io.*;

public class HuffMainCompress {
	public static void main(String[] args) {
		
		System.out.println("Huffman Compress Main");
		String[] fileIn = {"h1.txt"};
		String[] fileOut = {"h1.txt.hf"};
		
		File inf = FileSelector.selectFile(fileIn);
		File outf = FileSelector.saveFile(fileOut);
		if (inf == null || outf == null) {
			System.err.println("input or output file cancelled");
			return;
		}
		BitInputStream bis = new BitInputStream(inf);
		BitOutputStream bos = new BitOutputStream(outf);
		HuffProcessor hp = new HuffProcessor();
		hp.compress(bis, bos);
		System.out.printf("compress from %s to %s\n", 
		                   inf.getName(),outf.getName());
		System.out.printf("file: %d bits to %d bits\n",inf.length()*8,outf.length()*8);
		System.out.printf("read %d bits, wrote %d bits\n", 
				           bis.bitsRead(),bos.bitsWritten());
		long diff = bis.bitsRead() - bos.bitsWritten();
		System.out.printf("bits saved = %d\n",diff);
	}
}