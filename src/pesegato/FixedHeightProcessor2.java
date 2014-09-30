
package pesegato;

public class FixedHeightProcessor2 {
    public static void fixedHeightNorth(HeightmapProcessor hmp, float targetHeight, float maxStep){
        for (int col=0;col<hmp.size;col++)
            hmp.setHM(0,col,targetHeight);
        
        for (int row=0;row<hmp.size-1;row++)
            for (int col=0;col<hmp.size;col++){
                if (hmp.getHM(row, col)-hmp.getHM(row+1, col)>maxStep)
                    hmp.setHM(row+1, col, hmp.getHM(row, col)-maxStep);
                if (hmp.getHM(row+1, col)-hmp.getHM(row, col)>maxStep)
                    hmp.setHM(row+1, col, hmp.getHM(row, col)+maxStep);
            }
    }    
    public static void fixedHeightWest(HeightmapProcessor hmp, float targetHeight, float maxStep){
        for (int row=0;row<hmp.size;row++)
            hmp.setHM(row,0,targetHeight);
        
        for (int col=0;col<hmp.size-1;col++)
            for (int row=0;row<hmp.size;row++){
                if (hmp.getHM(row, col)-hmp.getHM(row, col+1)>maxStep)
                    hmp.setHM(row, col+1, hmp.getHM(row, col)-maxStep);
                if (hmp.getHM(row, col+1)-hmp.getHM(row, col)>maxStep)
                    hmp.setHM(row, col+1, hmp.getHM(row, col)+maxStep);
            }
    }    
    public static void fixedHeightSouth(HeightmapProcessor hmp, float targetHeight, float maxStep){
        for (int col=0;col<hmp.size;col++)
            hmp.setHM(hmp.size-1,col,targetHeight);
        
        for (int row=hmp.size-1;row>0;row--)
            for (int col=0;col<hmp.size;col++){
                if (hmp.getHM(row, col)-hmp.getHM(row-1, col)>maxStep)
                    hmp.setHM(row-1, col, hmp.getHM(row, col)-maxStep);
                if (hmp.getHM(row-1, col)-hmp.getHM(row, col)>maxStep)
                    hmp.setHM(row-1, col, hmp.getHM(row, col)+maxStep);
            }
    }    
    public static void fixedHeightEast(HeightmapProcessor hmp, float targetHeight, float maxStep){
        for (int row=0;row<hmp.size;row++)
            hmp.setHM(row,hmp.size-1,targetHeight);
        
        for (int col=hmp.size-1;col>0;col--)
            for (int row=0;row<hmp.size;row++){
                if (hmp.getHM(row, col)-hmp.getHM(row, col-1)>maxStep)
                    hmp.setHM(row, col-1, hmp.getHM(row, col)-maxStep);
                if (hmp.getHM(row, col-1)-hmp.getHM(row, col)>maxStep)
                    hmp.setHM(row, col-1, hmp.getHM(row, col)+maxStep);
            }
    }    
}
