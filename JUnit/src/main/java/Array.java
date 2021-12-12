import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Array {

	public List<Integer> getSubarray(ArrayList<Integer> in){
		List<Integer> out = new ArrayList<>();

		for(int i = in.size(); i > 0; i--){
			if(in.get(i-1) != 4){
				out.add(in.get(i-1));
			}
			else {
				break;
			}
		}
		if(out.size() == in.size()){
			throw new RuntimeException();
		}else{
			Collections.reverse(out);
		}
		return out;
	}

	public boolean checkArray(ArrayList<Integer> in){

		return false;
	}
}
