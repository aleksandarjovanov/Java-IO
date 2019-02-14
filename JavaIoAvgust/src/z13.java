/*1ArrayDatabase
Потребно е да имплементирате специјален вид на база на податоци – ArrayDatabase. 
Елементите (редовите) во базата се елементи составени од id на редот – 2 бајти,
 вредност на редот – 128 бајти и статус на редот 1 бајт – T или F. Базата има две операции put и get.
 Датотеката на базата е db.bin и претставува бинарна датотека. Базата може да биде десетици гигабајти 
 во големина.

put методот прима 4 вредности: int rowNum, byte[] id, byte[] value, boolean status. 
Во овој метод вредностите id, value и status се запишуваат во датотека на базата на позиција rowNum. 
Доколку, на пример, базата имала само 10 податоци, а ние сакаме да запишеме 15ти, тогаш податоците 
од 11 до 14 се пополнуваат со нули.

get методот прима 1 вредност – int rowNum. Во овој метод се исчитува позицијата rowNum
од датотеката на базата и се печатат вредностите на овој ред. Доколку се наиде на ред кој е празен 
(составен само од нули), се печати Prazen element. Доколку се наиде на ред кој е поголем од големината 
на базата, се печати Nema takov element.*/
import java.io.*;
public class z13 {
	public static void put(File f, int rowNumber, byte [] id, byte [] value, boolean status)throws IOException{
		FileOutputStream out = null;
		
		try {
			out = new FileOutputStream(f,true);
			
			if(rowNumber * 15 >= f.length()) {
				int numberOfEmptyObj = ((rowNumber*15) - (int)f.length()) / 15;
				String zero="";
				for(int j = 0; j < 13; j++) {
					zero = zero + "0";
				}
			//	out.write("\r\n".getBytes());
				for(int j = 0; j < numberOfEmptyObj; j++) {
					out.write(zero.getBytes());
					out.write("\r\n".getBytes());
				}
				
				out.write(id);
				out.write(value);
				if(status) {
					out.write((byte)'T');
				}
				else {
					out.write((byte)'F');
				}
			}
			
		}finally {
			if(out != null)
				out.close();
		}
		
	}

	public static void main(String[] args)throws IOException {
		File from = new File("C:\\Users\\Aleksandar\\Desktop\\out\\destt.txt");
		
		int rowNumber = 5;
		byte [] id = {49,50};
		byte [] value = { 105, 106, 107, 108, 109, 110, 111, 112, 113, 114};
		boolean status = true;
		
		put(from,rowNumber,id,value,status);
		
	}

}
