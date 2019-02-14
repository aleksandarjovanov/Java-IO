import java.io.*;
/*Некој систем за е-учење генерира извештаи за оценки на студенти по предмети во 
 * CSV (Comma Separated Values) формат. Да се напише Java програма, која на екран ќе го отпечати 
 * просекот на секој студент од датотеката rezultati.csv (види слика), како и просечната оценка што 
 * ја имаат студентите по секој од предметите наведени во првата редица. Програмата треба да работи 
 * за произволен број на редици.
 * Бонус: За подобра читливост на извештајот, прочитаната rezultati.csv датотека трансформирајте ја 
 * во TSV (Tab Separated Values) формат и снимете ја како rezultati.tsv.*/
public class z5 {
	public static double avrgByStudent(String line) {
		String [] array = line.split("\\,");
		double avrg = 0;
		int sum = 0;
		sum = Integer.parseInt(array[1]) + Integer.parseInt(array[2]) + Integer.parseInt(array[3]);
		avrg = sum/ 3.0;
		
		return avrg;
	}
	public static void avrgBySubject(String path)throws IOException {
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new FileReader(path));
			
			String line;
			int sumAOK = 0, sumKRS = 0, sumNRS = 0, br = 0;
			
			in.readLine();
			
			while((line = in.readLine()) != null) {
				String [] array = line.split("\\,");
				br++;
				sumAOK += Integer.parseInt(array[3]);
				sumNRS += Integer.parseInt(array[2]);
				sumKRS += Integer.parseInt(array[1]);
			}
			
			double prosekKrs = sumKRS/(1.0 * br);
			double prosekNrs = sumNRS/(1.0 * br);
			double prosekAok = sumAOK/(1.0 * br);
			
			System.out.println("Prosecnata ocenka na studentite po predmetot KRS e: "+prosekKrs);
			System.out.println("Prosecnata ocenka na studentite po predmetot NRS e: "+prosekNrs);
			System.out.println("Prosecnata ocenka na studentite po predmetot AOK e: "+prosekAok);
			
			
		}finally {
			if(in != null)
				in.close();
		}
		
		
	}

	public static void main(String[] args)throws IOException {
		File f =  new File("C:\\Users\\Aleksandar\\Desktop\\java","prva.txt");
		
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new FileReader(f.getAbsolutePath()));
			
			in.readLine();
			
			String line;
			while((line = in.readLine()) != null) {
				double avrg = avrgByStudent(line);
				System.out.println("Prosekot za studentot "+line.split("\\,")[0]+" e: "+ avrg);
			}
			
			avrgBySubject(f.getAbsolutePath());
			
		}finally {
			if(in != null)
				in.close();
		}
		
	}

}
