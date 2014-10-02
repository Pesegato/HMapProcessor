/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pesegato.processors;

import pesegato.HeightmapProcessor;

/**
 *
 */
public class SmoothProcessor {
    public static void smooth(HeightmapProcessor hmp, float np, int radius) {
        if (np < 0 || np > 1) {
            return;
        }
        if (radius == 0)
            radius = 1;
        
        for (int x = 0; x < hmp.size; x++) {
            for (int y = 0; y < hmp.size; y++) {
                int neighNumber = 0;
                float neighAverage = 0;
                for (int rx = -radius; rx <= radius; rx++) {
                    for (int ry = -radius; ry <= radius; ry++) {
                        if (x+rx < 0 || x+rx >= hmp.size) {
                        continue;
                        }
                        if (y+ry < 0 || y+ry >= hmp.size) {
                            continue;
                        }
                        neighNumber++;
                        neighAverage += hmp.getHM((y+ry), (x+rx));//heightData[(x+rx) + (y+ry) * hmp.size];
                    }
                }

                neighAverage /= neighNumber;
                float cp = 1 - np;
                hmp.setHM(y, x, neighAverage * np + hmp.getHM(y, x) * cp);
                //heightData[x + y * hmp.size] = neighAverage * np + heightData[x + y * hmp.size] * cp;
            }
        }
    }

}
