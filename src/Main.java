
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

import java.util.Scanner;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author Maxwell
 *
 */
public class Main {

	public static int SEED = 1232468441; 
	public static void main(String arg[]){		
		

		System.out.println("Starting program...");
				
		File file;
		boolean isOutPut= false;
		try{
			if(arg.length<1){
				throw new Error("No File Passed");
			}
			if(arg.length>1 && arg[1] != null){
				System.setOut(new PrintStream(new File(arg[1])));
				isOutPut= true;
			}
		
			file = new File(arg[0]);
			Scanner scan = new Scanner(file);
			Random random = new Random(SEED);
			List<Image> images = Image.listBuilder(scan);
			System.out.println("Number of images :"+ images.size());
			//System.out.print(li.get(0).toString());
			scan.close();
			int values[][]=  new int[images.size()][100];
			Feature features[]  = new Feature[100];
			
			for(int i=0;i<100;i++){
				features[i] = new Feature(random, 10);
			}
			for(int i=0;i< images.size();i++){
				values[i][0] = 1;
				for(int v=1;v<100;v++){
					values[i][v]  = images.get(i).value(features[v]); 
				}
			}
			
			Perceptron per = new Perceptron(features, random);
			per.train(images, values);
			
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		if(isOutPut){
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));		
		}
		
		
		System.out.println("...End of program");
	}
	
	









}
