package pesegato.processors;

import pesegato.HeightmapProcessor;

public class ClampVerticalHeightProcessor {

    public static void towardSouth(HeightmapProcessor hmp, float maxStep) {
        for (int row = 0; row < hmp.size - 1; row++) {
            for (int col = 0; col < hmp.size; col++) {
                if (hmp.getHM(row, col) - hmp.getHM(row + 1, col) > maxStep) {
                    hmp.setHM(row + 1, col, hmp.getHM(row, col) - maxStep);
                }
                if (hmp.getHM(row + 1, col) - hmp.getHM(row, col) > maxStep) {
                    hmp.setHM(row + 1, col, hmp.getHM(row, col) + maxStep);
                }
            }
        }
    }

    public static void towardNorth(HeightmapProcessor hmp, float maxStep) {
        for (int row = hmp.size - 1; row > 0; row--) {
            for (int col = 0; col < hmp.size; col++) {
                if (hmp.getHM(row, col) - hmp.getHM(row - 1, col) > maxStep) {
                    hmp.setHM(row - 1, col, hmp.getHM(row, col) - maxStep);
                }
                if (hmp.getHM(row - 1, col) - hmp.getHM(row, col) > maxStep) {
                    hmp.setHM(row - 1, col, hmp.getHM(row, col) + maxStep);
                }
            }
        }
    }

    public static void towardEast(HeightmapProcessor hmp, float maxStep) {
        for (int col = 0; col < hmp.size - 1; col++) {
            for (int row = 0; row < hmp.size; row++) {
                if (hmp.getHM(row, col) - hmp.getHM(row, col + 1) > maxStep) {
                    hmp.setHM(row, col + 1, hmp.getHM(row, col) - maxStep);
                }
                if (hmp.getHM(row, col + 1) - hmp.getHM(row, col) > maxStep) {
                    hmp.setHM(row, col + 1, hmp.getHM(row, col) + maxStep);
                }
            }
        }
    }
    public static void towardWest(HeightmapProcessor hmp, float maxStep) {
        for (int col=hmp.size-1;col>0;col--)
            for (int row=0;row<hmp.size;row++){
                if (hmp.getHM(row, col)-hmp.getHM(row, col-1)>maxStep)
                    hmp.setHM(row, col-1, hmp.getHM(row, col)-maxStep);
                if (hmp.getHM(row, col-1)-hmp.getHM(row, col)>maxStep)
                    hmp.setHM(row, col-1, hmp.getHM(row, col)+maxStep);
            }
    }
}
