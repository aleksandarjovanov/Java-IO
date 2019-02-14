/*Потребно е да имплементирате метод private void work(String in, String out) кој ќе го прави следното:

рекурзивно го листа директориумот претставен преку in
доколку секој излистан директориум има над 5 датотеки во него, избришете ги датотеките
доколку секој излистан директориум има под 5 датотеки во него, преместете ги во директориумот 
претставен преку out

Внимавајте на следните работи:

доколку директориумот претставен преку in не постои, излезете од методот со пораката "prazno" на екран
доколку директориумот претставен преку out не постои, потребно е да го креирате
доколку директориумот претставен преку out постои, потребно е да ја избришете неговата содржина
претпоставете дека нема директориуми во неговата содржина*/
import java.io.*;
public class z6 {
	public static int countFiles(File in) {
		int numFiles = 0;
		
		File [] files = in.listFiles();
		for(File f : files) {
			if(f.isFile()) {
				numFiles++;
			}
		}
		
		return numFiles;
	}
	public static void work(File in, File out) {
		
		int numFiles = countFiles(in);
		
			File [] files = in.listFiles();
			for(File f : files) {
				if(f.isFile()) {
					if(numFiles > 5) {
						f.delete();
					}
					else {
						f.renameTo(new File(out.getAbsolutePath() +"\\"+ f.getName()));
					}
				}
				else {
					work(f,out);
				}
			}
		
	}
	
	public static void main(String[] args)throws IOException {
		File in = new File("C:\\Users\\Aleksandar\\Desktop\\java");
		File out = new File("C:\\Users\\Aleksandar\\Desktop\\out");
		
		if(out.exists()) {
			File [] files = out.listFiles();
			for(File f : files) {
				f.delete();
			}
		}
		else {
			out.mkdirs();
		}
		
		if(in.exists()) {
			work(in, out);
		}
		else {
			System.out.println("prazno");
		}
		
	}
}
