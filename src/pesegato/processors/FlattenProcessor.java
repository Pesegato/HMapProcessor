/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pesegato.processors;

/**
 *
 */
public class FlattenProcessor {
   /*TODO!
     public void flatten(byte flattening) {
        // If flattening is one we can skip the calculations
        // since it wouldn't change anything. (e.g. 2 power 1 = 2)
        if (flattening <= 1) {
            return;
        }

        float[] minmax = findMinMaxHeights();

        normalizeTerrain(1f);

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                float flat = 1.0f;
                float original = heightData[x + y * size];

                // Flatten as many times as desired;
                for (int i = 0; i < flattening; i++) {
                    flat *= original;
                }
                heightData[x + y * size] = flat;
            }
        }

        // re-normalize back to its oraginal height range
        float height = minmax[1] - minmax[0];
        normalizeTerrain(height);
    }
    public float[] findMinMaxHeights() {
        float[] minmax = new float[2];

        float currentMin, currentMax;
        currentMin = heightData[0];
        currentMax = heightData[0];

        for (int i = 0; i < heightData.length; i++) {
            if (heightData[i] > currentMax) {
                currentMax = heightData[i];
            } else if (heightData[i] < currentMin) {
                currentMin = heightData[i];
            }
        }
        minmax[0] = currentMin;
        minmax[1] = currentMax;
        return minmax;
    }
    public void normalizeTerrain(float value) {
        float currentMin, currentMax;
        float height;

        currentMin = heightData[0];
        currentMax = heightData[0];

        //find the min/max values of the height fTemptemptempBuffer
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (heightData[i + j * size] > currentMax) {
                    currentMax = heightData[i + j * size];
                } else if (heightData[i + j * size] < currentMin) {
                    currentMin = heightData[i + j * size];
                }
            }
        }

        //find the range of the altitude
        if (currentMax <= currentMin) {
            return;
        }

        height = currentMax - currentMin;

        //scale the values to a range of 0-255
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                heightData[i + j * size] = ((heightData[i + j * size] - currentMin) / height) * value;
            }
        }
    }*/
}
