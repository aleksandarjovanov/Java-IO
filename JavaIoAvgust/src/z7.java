
/*Potrebno e rekurzivno da go izminete direktoriumot in. Dokolku pri listanjeto dojdete do datoteka so 
 * ekstenzija .bin potrebno e da gi napravite slednite raboti:
 * 
 * Dokolku goleminata na datotekata e pomala od 10KB, iskopirajte ja datotekata vo direktoriumot out.
 * Dokolku datotekata veke postoi vo direktoriumot out, togas ispisete na ekran "datotekata IME veke postoi".
 * 
 * Dokolku goleminata na datotekata e ednakava ili pogolema od 10KB, togas nejzinata sodrzina dodate ja na 
 * pocetok od datotekata big.bin vo out direktoriumot.
 * 
 * Dokolku direktoriumot in ne postoi, ispecatete poraka "in ne postoi" i zavrsete so rabota.
 * Direktoriumot out na pocetok na rabotata treba da bide prazen.
 * 
 * Imajte vo predvid deka .bin datotekite se binarni datoteki koi moze da bidat mnogu golemi. 
 * Baraniot kod napisete go vo metodata void work(String in_value, String out_value) pri sto navedenite 
 * in i out direktoriumi ke bidat vrednostite na stringovite in_value i out_value.*/
import java.io.*;
public class z7 {
	public static void copy(File in, File out)throws IOException {
		

		BufferedReader input = null;
		BufferedWriter output = null;
		
		try {
			input = new BufferedReader(new FileReader(in.getAbsolutePath()));
			output = new BufferedWriter(new FileWriter(out.getAbsolutePath(), true));
			
			String line;
			
			while((line = input.readLine()) != null) {
				output.write(line+"\r\n");
			}
			
		}finally {
			if(input != null) {
				input.close();
			}
			if(output != null) {
				output.close();
			}
		}
		
	}
	public static void work(File in, File out)throws IOException {
		File b = new File("C:\\Users\\Aleksandar\\Desktop\\out","big.txt");
		
		if(!b.exists())
			b.createNewFile();
		
		File [] files = in.listFiles();
		
		for(File f : files) {
			if(f.isFile() && f.getName().endsWith(".txt")) {
				//float size = (float)f.length() / 1024;
				float size = f.length();
				if(size < 10) {
					File newf = new File(out.getAbsolutePath(), f.getName());
					newf.createNewFile();
					copy(f,newf);
				}
				else {
					File tmp = new File(out.getAbsolutePath(),"tmp.txt");
					tmp.createNewFile();
					
					copy(b,tmp);
					b.delete();
					b.createNewFile();
					
					copy(f,b);
					copy(tmp,b);
					
					tmp.delete();
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
		
		if(!in.exists()) {
			System.out.println("ne posti");
			return;
		}
		
		deleteOut(out);
				
		work(in, out);
	}
	public static void deleteOut(File out) {
		
		File [] files = out.listFiles();
		for(File f : files) {
			if(f.isFile()) {
				f.delete();
			}
			else {
				deleteOut(f);
				f.delete();
			}
		}
	}
	
	

}
