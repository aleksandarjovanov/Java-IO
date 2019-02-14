import java.io.*;
import java.util.ArrayList;
import java.util.List;
/*Со користење на Java I/O да се имплементираат следните методи од класата ExamIO:

(10 поени)void copyLargeTxtFiles(String from, String to, long size)
Ги копира сите датотеки со екстензија .txt од именикот зададен преку from аргументот, во 
именикот зададен преку to аргументот, кои се поголеми од вредноста на size аргументот (во бајти). 
Доколку не постои именикот from да се испише "Ne postoi", a aко не постои именикот to, потребно е да се креира.

(10 поени)void serializeData(String destination, List<byte[]> data)
Низата од податоци зададени со data ја запишува во датотеката destination, без никакви делимитери 
(како континуиран тек од бајти). Сите елементи на листата data имаат иста должина (ист број бајти).

(Бонус 5 поени)byte[] deserializeDataAtPosition(String source, long position, long elementLength)
Го исчитува и враќа податокот на позицијата position од датотеката source, која содржи голем број податоци, 
сите со иста должина во бајти, без никаков делимитер. Секој од податоците има должина зададена со elementLength. 
При имплементацијата да не се чита содржината на целата датотека.*/
public class z9 {
	
	public static void copy(File from, File to)throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream(from);
			File copy = new File(to,from.getName());
			copy.createNewFile();
			out = new FileOutputStream(copy);
			
			int c = 0;
			while((c = in.read()) != -1) {
				out.write(c);
			}
		}finally{
			if(in != null)
				in.close();
			if(out != null)
				out.close();
		}
		
	}
	public static void deserializeDataAtPosition(File src, long position, long elementLength)throws IOException {
		RandomAccessFile rin = null;
		
		try{
			rin = new RandomAccessFile(src,"rw");
			
			rin.seek((position - 1) * elementLength);
			byte [] b = new byte[(int)elementLength];
			rin.read(b);
			
			for(int i = 0; i < elementLength; i++) {
				System.out.println((char)b[i]);
			}
			
		}finally {
			if(rin != null)
				rin.close();
		}
		
		
	}
	public static void copyLargeTxtFiles(File from, File to, long size)throws IOException {
		if(from.exists()) {
			if(!to.exists()) {
				to.mkdirs();
			}
			
			File [] files = from.listFiles();
			
				for(File f : files) {
					if(f.isFile()) {		
						if(f.getName().endsWith("txt") && f.length() > size) {
							copy(f,to);
						}
					}
					else {
						copyLargeTxtFiles(f, to, size);
					}
				}
		}
		else {
			System.out.println("ne postoi");
		}
	}

	public static void main(String[] args)throws IOException {
		File from = new File("C:\\Users\\Aleksandar\\Desktop\\java");
		File to= new File("C:\\Users\\Aleksandar\\Desktop\\out");
		long size = 10;
		//copyLargeTxtFiles(from,to,size);
		
		File dest = new File("C:\\Users\\Aleksandar\\Desktop\\out\\destt.txt");
		ArrayList<byte[]> data = new ArrayList<byte[]>();
		byte [] niza = {68,69,70,71}; 
		byte [] niza1 = {72,73,74,75}; 
		byte [] niza2 = {76,77,78,79}; 
		byte [] niza3 = {80,81,82,83}; 
		data.add(niza);
		data.add(niza1);
		data.add(niza2);
		data.add(niza3);
		//serializeData(dest,data);
		deserializeDataAtPosition(dest,3,4);
		
	}
	public static void serializeData(File dest, ArrayList<byte[]> data)throws IOException {
		
		FileOutputStream out = null;
		
		try {
			out = new FileOutputStream(dest,true);
			for(byte [] b : data) {
				out.write(b);
			}
		
		}
		finally {
			if(out != null)
				out.close();
		}
	}
}
