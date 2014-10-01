
package pesegato;


public class VerticalMask implements HMProcessorMask{

    boolean northArea;
    int limit;
    public VerticalMask(int limit, boolean northArea){
        this.limit=limit;
        this.northArea=northArea;
    }
    
    public boolean mask(int row, int col) {
        if (northArea)
            return row<limit;
        else
            return row>limit;
    }
    
}
