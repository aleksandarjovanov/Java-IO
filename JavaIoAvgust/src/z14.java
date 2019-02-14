import java.io.*;
/*Потребно е да направите апликација која пребарува Microsoft Office датотеки кои имаат read-write привилегии.
 *  За таа потреба имплементирајте метод findRW(String in, String out) кој ќе го изминува рекурзивно директориумот
 *   претставен преку “in”. Доколку наиде на .docx или .xlsx кои имаат read-write привилегии, тогаш треба да ги ископира 
 *   во “out”\brisenje, а доколку наиде на .xlsx или .docx кои имаат само read или само write привилегија, тогаш треба да 
 *   додаде линија во “out”\rw.txt од типот “Nema read-write datotekata filename, tuku ima privilegii”. На местото filename 
 *   ставете го името на датотеката и на местото на privilegii ставете ги привилегиите на датотеката во формат rwx или цртичка 
 *   ако ја нема соодветната привилегија (како во Unix). Внимавајте дека може да има многу вакви документи во “in”.
 */
public class z14 {
	public static void addLine(File f,File to)throws IOException {
		BufferedWriter out = null;
			
		try {
			out = new BufferedWriter(new FileWriter(to));
			String prev = "";
			if(f.canRead())
				prev = "r";
			else
				prev = "-";
			if(f.canWrite())
				prev += "w";
			else
				prev += "-";
			if(f.canExecute())
				prev += "x";
			else
				prev += "-";
			
			String line = "Nema read-write "+f.getName()+" tuku ima " + prev;
			out.write(line);
			
		}
		finally {
			if(out != null)
				out.close();
		}
			
	}
	public static void copy(File from,File to)throws IOException {
		if(!to.exists()) {
			to.mkdir();
		}
		File dest = new File(to,from.getName());
		
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			in = new BufferedReader(new FileReader(from));
			out = new BufferedWriter(new FileWriter(dest));
			
			String line;
			while((line = in.readLine()) != null) {
				out.write(line);
			}
			
		}finally {
			if(in != null)
				in.close();
			if(out != null)
				out.close();
		}
		
	}
	public static void findRW(File from, File to)throws IOException{
		
		File [] files = from.listFiles();
		for(File f : files) {
			if(f.isFile()) {
				if(f.getName().endsWith(".docx") || f.getName().endsWith(".xslx")) {
					if(f.canRead() && f.canWrite()) {
						copy(f,new File(to,"brisenje"));
					}
					if((f.canRead() && !f.canWrite()) || (!f.canRead() && f.canWrite())) {
						addLine(f,new File(to,"rw.txt"));
						
					}
				}
			}
			else {
				findRW(f,to);
			}
		}
	}
	
	public static void main(String[] args)throws IOException {
		File from = new File("C:\\Users\\Aleksandar\\Desktop\\java");
		File to = new File("C:\\Users\\Aleksandar\\Desktop\\out");
		
		findRW(from,to);
	}

}
