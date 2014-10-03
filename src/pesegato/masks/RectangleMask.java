
package pesegato.masks;

import pesegato.HMProcessorMask;

public class RectangleMask implements HMProcessorMask{

    int row1,col1,row2,col2;
    public RectangleMask(int row1, int col1, int row2, int col2){
        this.row1=row1;
        this.col1=col1;
        this.row2=row2;
        this.col2=col2;
    }
    
    public boolean mask(int row, int col) {
        if (row<row1)
            return false;
        if (row>row2)
            return false;
        if (col<col1)
            return false;
        if (col>col2)
            return false;
        return true;
    }
}
