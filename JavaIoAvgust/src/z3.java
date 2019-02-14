import java.io.*;
/*Да се напише Java програма која со користење на I/O стримови ќе ја прочита содржината на датотеката 
 * izvor.txt, а потоа нејзината содржина ќе ја испише превртена во празната датотека destinacija.txt.
 *  Читањето и запишувањето реализирајте го со баферирано читање и запишување
 * Напомена: Сами креирајте ги овие две датотеки и пополнете ја izvor.txt со произволна содржина.*/
public class z3 {

	public static void main(String[] args)throws IOException{
		File source = new File("C:\\Users\\Aleksandar\\Desktop\\java","prva.txt");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new FileWriter(source.getAbsolutePath(),true));
		
		System.out.println("vnesete sodrzina");
		
		out.write(in.readLine());
		in.close();
		out.close();
		
		File destination = new File("C:\\Users\\Aleksandar\\Desktop\\java","vtora.txt");
		
		BufferedReader input = null;
		BufferedWriter output = null;
		
		try {
			input = new BufferedReader(new FileReader(source.getAbsolutePath()));
			output = new BufferedWriter(new FileWriter(destination.getAbsolutePath()));
			
			String line = input.readLine();
			StringBuilder sb = new StringBuilder();
			
			while(line != null) {
				sb.append(line);
				line = input.readLine();
			}
			
			output.write(sb.reverse().toString());
			
			
		}finally{
			if(input != null)
				input.close();
			if(output != null)
				output.close();
		}
		
		

	}

}
