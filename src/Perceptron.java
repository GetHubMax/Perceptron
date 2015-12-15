
import java.util.List;
import java.util.Random;



/**
 * 
 * @author Maxwell
 *
 */
public class Perceptron {
	public int[] wieght;
	Feature features[];
	public Perceptron(Feature features[], Random random){
		wieght = new int[features.length];
		this.features =features;
		wieght[0] = -1;
		for(int i=1;i<wieght.length;i++){
			wieght[i]=random.nextInt(1);
		}
		
	}
/**	
 * 
 * @param images
 * @param values
 */
	public void train(List<Image> images, int values[][]){
			int max = 100000; 
			int succes = 0;
			int n=0;
			long start_time = System.currentTimeMillis();
			long TWO_MINUTES = 120000; 
			mainLoop :while(succes <= images.size() && n<max && System.currentTimeMillis()-start_time <TWO_MINUTES){
			succes =0;
				System.out.print("Cyle "+n+" Wrong at Indexs: ");
				n++;
				for(int i=0;i<images.size();i++){
					int sum=1;
					for(int f=0;f<features.length;f++){
						sum+=wieght[f]*images.get(i).value(features[f]);
						
					}
					boolean label = (sum>0);
					boolean  isRight = label== images.get(i).label ;
				
			//		System.out.println("Index: "+i+" Label: "+label+" isRight :" +isRight+"");
				
					if(isRight){
						succes++;
						if(succes>= images.size()){
							System.out.println("All correct");
							break mainLoop;
						}
						continue; 
					}
				
					if(!isRight && label && n<max-images.size()){
						for(int f=1;f<features.length;f++){
							wieght[f] -= values[i][f];	
						}	
					System.out.print(" "+i);
				//	i=0;
				//	succes=0;
					
				}
				if(!isRight && ! label && n<max-images.size()){
					for(int f=1;f<features.length;f++){
						wieght[f] += values[i][f];
					
					
					}	
					System.out.print(" "+i);
				//	i=0;
				//	succes=0;
				}
				
				}
			System.out.println("");
			}
		
		System.out.println("Number of correct entries: "+succes);
		System.out.println("Features");
		for(int i=0; i<100;i++){
			System.out.print(i+" Weight :"+ wieght[i]);
			System.out.print(" "+features[i].toString());
			
			System.out.println("");
		}
		
		System.out.println("Number of cycles: "+n);
		
		
	}
	
	
	
	
	
}
