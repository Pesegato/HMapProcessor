/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pesegato.processors;

import pesegato.HeightmapProcessor;

/**
 *
 */
public class ErodeProcessor {
    public void erodeTerrain(HeightmapProcessor hmp, float filter) {
        //erode left to right
        float v;
/* TODO
        for (int i = 0; i < hmp.size; i++) {
            v = heightData[i];
            for (int j = 1; j < hmp.size; j++) {
                heightData[i + j * hmp.size] = filter * v + (1 - filter) * heightData[i + j * size];
                v = heightData[i + j * hmp.size];
            }
        }

        //erode right to left
        for (int i = hmp.size - 1; i >= 0; i--) {
            v = heightData[i];
            for (int j = 0; j < hmp.size; j++) {
                heightData[i + j * hmp.size] = filter * v + (1 - filter) * heightData[i + j * size];
                v = heightData[i + j * hmp.size];
                //erodeBand(tempBuffer[size * i + size - 1], -1);
            }
        }

        //erode top to bottom
        for (int i = 0; i < hmp.size; i++) {
            v = heightData[i];
            for (int j = 0; j < hmp.size; j++) {
                heightData[i + j * hmp.size] = filter * v + (1 - filter) * heightData[i + j * size];
                v = heightData[i + j * hmp.size];
            }
        }

        //erode from bottom to top
        for (int i = hmp.size - 1; i >= 0; i--) {
            v = heightData[i];
            for (int j = 0; j < hmp.size; j++) {
                heightData[i + j * hmp.size] = filter * v + (1 - filter) * heightData[i + j * size];
                v = heightData[i + j * hmp.size];
            }
        }*/
    }

}
