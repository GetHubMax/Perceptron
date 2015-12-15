import java.util.Arrays;
import java.util.Random;


/**
 * 
 * @author Maxwell
 *
 */
public class Feature {
	public static final int d=4;
	public int row[];
	public int col[];
	public boolean sgn[];
	
	public Feature(Random r, int imageSize){
		row=new int[d];
		col= new int[d];
		sgn= new boolean[d];
		for(int i=0;i<d;i++){
			row[i] = r.nextInt(imageSize);
			col[i] = r.nextInt(imageSize);
			sgn[i] = r.nextBoolean();
		}
		
	}
	public Feature(int row[], int col[], boolean sgn[]){
		this.row=row;this.col=col; this.sgn=sgn; 
				
		
	}
	
	@Override
	public String toString(){
		return "row: "+Arrays.toString(row)+" col: "+Arrays.toString(col)+" Sign: "+Arrays.toString(sgn);
		
	}
	
}
