/*Потребно е да ја имплементирате функцијата manage(String in, String out) која врши организација на 
 *текстуалните датотеки (*.dat) од именикот in според нивните привилегии на следниот начин:

доколку датотеката има привилегии за запишување тогаш таа треба да се премести во out именикот. 
При преместувањето, во конзола испечатете pomestuvam и апсолутното име на датотеката која се копира.

доколку датотеката нема привилегии за запишување тогаш нејзината содржина додадете ја на крај од датотеката 
writable-content.txt во resources именикот. При додавањето, во конзола испечатете dopisuvam и апсолутното име 
на датотеката. Сметајте дека овие датотеки може да бидат многу поголеми од физичката меморија на компјутерот.

доколку датотеката е скриена (hidden), тогаш избришете ја од in именикот, и во конзола испечатете zbunet sum и 
апсолутното име на датотеката.
Доколку in именикот не постои, испечатете на екран ne postoi.

Доколку out именикот веќе постои, избришете ја неговата содржина. Претпоставете дека во out именикот има само датотеки.*/
import java.io.*;
public class z8 {
	public static void delete(File in) {
		File [] files = in.listFiles();
		
		for(File f : files) {
			f.delete();
		}
	}

	public static void main(String[] args)throws IOException {            /// NE E TESTIRANA AMA RESENIETO E TOA!
		File in = new File("C:\\Users\\Aleksandar\\Desktop\\java");
		File out = new File("C:\\Users\\Aleksandar\\Desktop\\out");
		File rec = new File("C:\\Users\\Aleksandar\\Desktop\\test.txt");
		
		if(in.exists()) {
			if(out.exists()) 
				delete(out);
			else
				out.mkdir();
			
			
			File [] files = in.listFiles();
			
			for(File f : files) {
				
				if(f.isFile() && f.getName().endsWith("txt") && f.canWrite()) {
					f.renameTo(new File(out, f.getName()));
					System.out.println("pomestuvam");
				}
				else if(!f.isDirectory()){
					FileInputStream fin = null;
					FileOutputStream fout = null;
					
					try {
						fin = new FileInputStream(in);
						fout = new FileOutputStream(rec);
						
						int c = 0;
						
						while((c = fin.read()) != -1) {
							fout.write(c);
						}
						System.out.println("dopisuvam"+" "+f.getAbsolutePath());
						
					}finally {
						if(fin != null)
							fin.close();
						if(fout != null)
							fout.close();
					}
				}
				if(f.isHidden()) {
					f.delete();
					System.out.println("zbunet sum"+" "+f.getAbsolutePath());
				}
				
			}
			
		}
		else {
			System.out.println("ne postoi");
		}
	}

}
