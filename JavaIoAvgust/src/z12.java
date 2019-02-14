import java.io.*;
import java.util.ArrayList;
import java.util.List;
/*Една датотека е составена од следниот тип на податоци:

| 4 | 2 6 5 8 | 3 | 7 4 4 | 4 | 5 7 4 1 | 2 | 3 7 |
На секој податок му претходи еден бајт кој кажува колкава е должината во бајти на податокот.
Во дадениот пример имаме еден бајт со вредност 4, па имаме податок од 4 бајти (2658), потоа имаме 
еден бајт со вредност 3, па имаме податок од 3 бајти (744), па имаме еден бајт со вредност 4 па 
следи податокот од 4 бајти (5741) и на крај имаме еден бајт со вредност 2 и податок од 2 бајти (37).

Реалниот изглед на наведената пример датотека е:
42658374445741237

Имплементирајте метод private List<byte[]> read(String input) кој ќе ја исчита датотеката претставена 
со аргументот input според наведениот формат и ќе врати листа од податоци (листа од низи од бајти). 

Во наведениот пример, листата би изгледала
[[2658], [744], [5741], [37]]
*/
public class z12 {
	private static ArrayList<byte []> read(File f)throws IOException {
		ArrayList<byte []> list = new ArrayList<>();
		
		FileInputStream in = null;
		try {
			in = new FileInputStream(f);
			
			int c = 0;
			while((c = in.read()) != -1) {
				char tmp = (char)c;
				c = Character.getNumericValue(tmp);
				byte [] b = new byte[c];
				
				in.read(b);
				list.add(b);
			}
			
		}finally {
			if(in != null)
				in.close();
		}
		
		return list;
	}

	public static void main(String[] args)throws IOException {
		File from = new File("C:\\Users\\Aleksandar\\Desktop\\out\\destt.txt");
		
		ArrayList<byte []> list = new ArrayList<>();
		
		list = read(from);
		
		for(byte [] b : list) {
			System.out.print("[");
			for(byte p : b) {
				System.out.print((char)p+" ");
			}
			System.out.println("]");
		}
		
	}

}
