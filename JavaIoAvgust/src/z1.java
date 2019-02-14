import java.io.File;

/*Да се напише Java програма која ќе прикаже колкава е просечната големина на
 *датотеките со екстензија .txt во именик зададен како аргумент на командна линија.
Напомена: Користете ја File класата за пристап до содржината на именикот.*/
public class z1 {

	public static void main(String[] args) {
		File f = new File("C:\\Users\\Aleksandar\\Desktop\\java");			
		
		if(!f.exists()) {
			f.mkdirs();
		}
		else {
			int zbir = 0;
			float avrg = 0;
			int br = 0;
			File [] files = f.listFiles();
			
			for(File file : files) {
				if(file.isFile()) {
					if(file.getName().endsWith(".txt")) {
						zbir += file.length();
						br ++;
					}
				}
			}
			avrg = (float)zbir / br;
			System.out.println(avrg);
		}
		
	}

}
