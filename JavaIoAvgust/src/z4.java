import java.io.*;
/*Да се напише Java програма која прима два аргументи: локација на текстуална датотека и збор.
 * Програмата треба да испечати колку пати се сретнува зборот проследен како втор аргумент,
 * во текстуалната датотека проследена како прв аргумент.*/
public class z4 {
	public static void countWord(String path, String word) throws IOException {
		BufferedReader in = null;
		int br = 0;
		try {
			in = new BufferedReader(new FileReader(path));

			String line;
			while ((line = in.readLine()) != null) {
				String[] words = line.split(" ");
				for (String s : words) {
					if (s.equals(word)) {
						br++;
					}
				}
			}
		} finally {
			if (in != null)
				in.close();
		}
		System.out.println(br);
	}

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		File f = new File("C:\\Users\\Aleksandar\\Desktop\\java","prva.txt");
		
		String word = br.readLine();
		
		countWord(f.getAbsolutePath(),word);

	}

}
