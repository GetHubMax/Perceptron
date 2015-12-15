import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Maxwell
 *
 */
public class Image {
	boolean label;
	int image[][];
	int width;
	int height;
	/**
	 * 
	 * @param label
	 * @param width
	 * @param height
	 * @param image
	 */
	public Image(boolean label, int width, int height, int image[][]){
		this.label=label;
		this.width=width;
		this.height=height;
		this.image = image;
	}
	
	@Override
	public String toString(){
		
		StringBuilder im = new StringBuilder();
		for(int x=0;x<width;x++ ){
			for(int y=0;y<height;y++){
				im.append(image[x][y]);
			}
			
		}
		
		
		return "Label :"+label +" Width :" + width+" Height :"+height+"Image Array: " +im+"";
		
	}
	/**
	 * 
	 * @param scan
	 * @return
	 */
	public static List<Image> listBuilder(Scanner scan){
		List<Image> out = new ArrayList<>();
		while(scan.hasNext()){
			String p1 = scan.next();
			if(!p1.equals("P1")){
				break;
			}
			String tmp = scan.next();
			boolean label = tmp.equals("#Yes");
			int width  = scan.nextInt();
			int height = scan.nextInt();
			int image[][] = new int[width][height]; 
			Scanner  iscan  =new Scanner(scan.next());
			iscan.useDelimiter("");
			
			for(int x=0;x<width;x++){
				for(int y=0;y<height ;y++){
					if(!iscan.hasNext()){
						iscan.close();
						iscan = new Scanner(scan.next());
						iscan.useDelimiter("");
					}
					if(iscan.hasNext("#%S")){
						iscan.skip("#%S");
					}
					
					
					int value = iscan.nextInt();		
					image[x][y] = (int)value;
				}			
		
			}	
			iscan.close();
			out.add(new Image(label, width, height,image));			
		}
		scan.close();
	return out;
	}
	
	/**
	 * 
	 * @param f
	 * @return
	 */
	public int value(Feature f){
		int sum=0;
		for(int i=0;i<Feature.d;i++){
			if(image[f.row[i]][f.col[i]] == (f.sgn[i]?1:0)){
			sum++;	
			}
		}
			return (sum>=3)?1:0;
		}
		
	
	
}
