package pesegato;

public class BooleanNOTMask implements HMProcessorMask{

    HMProcessorMask filter;
    
    public BooleanNOTMask(HMProcessorMask filter){
        this.filter=filter;
    }
    
    public boolean mask(int row, int col) {
        return !filter.mask(row,col);
    }
    
}
