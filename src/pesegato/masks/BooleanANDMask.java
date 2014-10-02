package pesegato.masks;

import pesegato.HMProcessorMask;

public class BooleanANDMask implements HMProcessorMask{

    HMProcessorMask filters[];
    
    public BooleanANDMask(HMProcessorMask... filters){
        this.filters=filters;
    }
    
    public boolean mask(int row, int col) {
        for (HMProcessorMask filter:filters){
            if (!filter.mask(row,col))
                return false;
        }
        return true;
    }
    
}
