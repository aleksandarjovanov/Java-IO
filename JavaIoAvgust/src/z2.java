import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.*;

/* Да се напише Java програма која со користење на I/O стримови ќе ја прочита 
 * содржината на датотеката izvor.txt, а потоа нејзината содржина ќе ја испише
 *  превртена во празната датотека destinacija.txt. Читањето и запишувањето 
 *  реализирајте го со стримови кои работат бајт по бајт.
 *  Напомена: Сами креирајте ги овие две датотеки и пополнете ја izvor.txt со 
 *  произволна содржина.*/
public class z2 {

	public static void main(String[] args)throws IOException {
		File source = new File("C:\\Users\\Aleksandar\\Desktop\\java\\vtora.txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new FileWriter(source.getAbsolutePath(),true));
		
		System.out.println("vnesete sodrzina ");
		
		out.write(in.readLine());
		in.close();
		out.close();
		
		
		File destination = new File("C:\\Users\\Aleksandar\\Desktop\\out\\pro.txt");
		FileInputStream fr = null;
		RandomAccessFile fw = null;
		
		try {
			fw = new RandomAccessFile(destination.getAbsolutePath(),"rw");
			fr = new FileInputStream(source.getAbsolutePath());
			
			long position = source.length() - 1;
			int c;
			
			while((c = fr.read()) != -1) {
				
				fw.seek(position);
				fw.write(c);
				position --;
			}
			
			
		}finally{
			if(fw != null) {
				fw.close();
			}
			if(fr != null) {
				fr.close();
			}
		}
		
		
		
		
		
		
		
		
	}

}
