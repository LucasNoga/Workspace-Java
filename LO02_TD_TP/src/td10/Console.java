package td10;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Console {

	public Console(){}

	public void afficher (String message){

	}
	public void test(){
		//Nous déclarons nos objets en dehors du bloc try/catch
		BufferedInputStream bis;
		BufferedOutputStream bos;
		try {
			bos = new BufferedOutputStream(
					new FileOutputStream(
							new File("./src/td10/test.txt")));

			//Nous allons écrire chaque type primitif
			bos.write(23);
			bos.write(100);
			bos.write(12);
			bos.write(100);
			bos.write(10);
			bos.write(16);
			bos.close();
			//On récupère maintenant les données !
			bis = new BufferedInputStream(
					new FileInputStream(
							new File("./src/td10/test.txt")));

			System.out.println(bis.read());
			System.out.println(bis.read());
			System.out.println(bis.read());
			System.out.println(bis.read());
			System.out.println(bis.read());
			System.out.println(bis.read());
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}       
	}

	public int lireInt(){
		File file = new File("./src/td10/test.txt");
		DataOutputStream dos = null; 
		DataInputStream dis = null;

		try {
			dos = new DataOutputStream( new BufferedOutputStream(new FileOutputStream(file)));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			dos.writeInt(58);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			dis = new DataInputStream(
					new BufferedInputStream(
							new FileInputStream(file)));

		}catch(Exception e){}
		try {
			System.out.println(" l'entier est " +dis.readInt());
		} catch (IOException e) {}



		return 0;	
	}

	public String lireChaine(){
		return null;
	}

	public void echo(){
		//while(){

		//}
	}

	public static void main(String[] args){
		Console cons = new Console();
		cons.test();


	}

}
