
package pesegato;

public class VerticalMask implements HMProcessorMask{

    int limit;
    public VerticalMask(int limit){
        this.limit=limit;
    }
    
    public boolean mask(int row, int col) {
        return col<limit;
    }
    
}
