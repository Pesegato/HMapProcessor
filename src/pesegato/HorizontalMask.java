
package pesegato;

public class HorizontalMask implements HMProcessorMask{

    boolean westArea;
    int limit;
    public HorizontalMask(int limit, boolean westArea){
        this.limit=limit;
        this.westArea=westArea;
    }
    
    public boolean mask(int row, int col) {
        if (westArea)
            return col<limit;
        else
            return col>limit;
    }
    
}
