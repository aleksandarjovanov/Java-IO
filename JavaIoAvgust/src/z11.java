/* Napisete gi slednite metodi koi rabotat so binarnata datoteka api.dat. 
 * Ovaa datoteka sodrzi tipovi na podatoci so fiksna golemina od 2bajti. 
 * Se pretpostavuva deka datoteka moze da bide mnogu golema (merena vo GB).
 * Vlez/izlez operaciite da se implementiraat so pomos na Stream-ovi.
 * 
 * Metod: byte[] read(long i)
 * Opis: Ovoj metod go cita i-tiot objekt od navedenata datoteka i go vrakja kako niza od bajti. 
 * Dokolku i-tiot objekt ne postoi vo datotekata, se vrakja null. Dokolku datotekata ne posti se frla isklucok 
 * od tipot DatabaseNotFound.
 *  
 * Metod: void write(long i, byte[] obj)
 * Opis: Ovoj metod go zapisuva i-tiot objekt vo navedenata datoteka. Dokolku pozicijata na objektot sto 
 * treba da se zapise e ponapred od goleminata na datotekata (na primer datotekata ima 3 objekt, a nie sakame 
 * da go zapiseme 5-tiot), togas od posledniot objekt vo datotekata od i-tiot zapisuvame prazni ogjekti.
 * Prazen objekt e sostaven od 2 nuli. Dokolku datotekata ne postoi, taa se kreira.
 *  */
import java.io.*;
public class z11 {
	public static void write(File f,long i, byte[] obj)throws IOException {
		if(!f.exists()) {
			f.createNewFile();
		}
		
		FileOutputStream out = null;
		try {
			
			if(f.length() <= i*2) {
				out = new FileOutputStream(f,true);
				String zero = "00";
				byte [] emptyObj = zero.getBytes();
				int numberOfEmptyObj = (int)(((i*2) - f.length()) / 2);
				
				for(int j =0; j < numberOfEmptyObj; j++) {
					out.write(emptyObj);
				}
				out.write(obj);
			}
			
		}finally {
			if(out != null)
				out.close();
		}
				
	}
	public static byte [] read(File from,long i)throws IOException {
		FileInputStream in = null;
		
		byte [] b = new byte [2];
		
		try {
			in = new FileInputStream(from);
			
			if(i*2 > from.length()) {
				System.out.println("isklucok");
				return null;
			}
			else {
				in.skip((i-1)*2);
				in.read(b);
				return b;
			}
		}finally {
			if(in != null) {
				in.close();
			}
		}
	}

	public static void main(String[] args)throws IOException {
		File from = new File("C:\\Users\\Aleksandar\\Desktop\\out\\destt.txt");
		
		byte [] array = {68,69}; 
		
		write(from,5,array);
		
/*		if(from.exists()) {
			long i = 3;
			byte [] b = read(from,i);
			
			for(int j = 0; j < b.length; j++) {
				System.out.print((char)b[j]);
			}
			
		}else {
			System.out.println("ne postoi");
		}*/
	}

}
