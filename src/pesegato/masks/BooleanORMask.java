package pesegato.masks;

import pesegato.HMProcessorMask;

public class BooleanORMask implements HMProcessorMask{

    HMProcessorMask filters[];
    
    public BooleanORMask(HMProcessorMask... filters){
        this.filters=filters;
    }
    
    public boolean mask(int row, int col) {
        for (HMProcessorMask filter:filters){
            if (filter.mask(row,col))
                return true;
        }
        return false;
    }
    
}
