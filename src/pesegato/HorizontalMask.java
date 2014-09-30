
package pesegato;


public class HorizontalMask implements HMProcessorMask{

    int limit;
    public HorizontalMask(int limit){
        this.limit=limit;
    }
    
    public boolean mask(int row, int col) {
        return row<limit;
    }
    
}
