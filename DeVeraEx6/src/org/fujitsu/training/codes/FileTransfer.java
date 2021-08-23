package org.fujitsu.training.codes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.util.Arrays.sort;

public class FileTransfer {

	public void createBin() {
		File file = new File("./src/org/fujitsu/training/codes/data1.bin");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeUTF("1");
			dos.writeUTF("3");
			dos.writeUTF("5");
			dos.writeUTF("7");
			dos.writeUTF("9");
			dos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createBin2() {
		File file = new File("./src/org/fujitsu/training/codes/data2.bin");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeUTF("2");
			dos.writeUTF("4");
			dos.writeUTF("6");
			dos.writeUTF("8");
			dos.writeUTF("10");
			dos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createBin3(int[] array) {
		File file = new File("./src/org/fujitsu/training/codes/data3.bin");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos);
	
			for(int lookup : array) {
				dos.writeUTF(String.valueOf(lookup));
			}
			System.out.println("file data3.bin is created!");
			dos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void transfer() {
		int[] array = new int[10];
		byte counter1 = 5;
		byte counter2 = 5;
		File file = new File("./src/org/fujitsu/training/codes/data1.bin");
		File file2 = new File("./src/org/fujitsu/training/codes/data2.bin");
		try {
			FileInputStream fis = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fis);
			FileInputStream fis2 = new FileInputStream(file2);
			DataInputStream dis2 = new DataInputStream(fis2);
			
			int i = 0;
			while(counter1 > 0) {
				for(; i < 5; i++){
					array[i] = Integer.parseInt(dis.readUTF());
					counter1--;
				}
			}
			while(counter2 > 0) {
				for(; i < 10; i++){
					array[i] = Integer.parseInt(dis2.readUTF());
					counter2--;
				}
			}
			
			sort(array);
			FileTransfer ft = new FileTransfer();
			ft.createBin3(array);
			dis.close();
			dis2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
}

