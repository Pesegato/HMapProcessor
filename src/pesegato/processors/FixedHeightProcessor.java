package pesegato.processors;

import pesegato.HeightmapProcessor;

public class FixedHeightProcessor {

    public static void fixedHeight(HeightmapProcessor hmp, float targetHeight) {
        for (int row = 0; row < hmp.size; row++) {
            for (int col = 0; col < hmp.size; col++) {
                hmp.setHM(row, col, targetHeight);
            }
        }
    }
}
