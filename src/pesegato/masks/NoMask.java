/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pesegato.masks;

import pesegato.HMProcessorMask;

/**
 *
 */
public class NoMask implements HMProcessorMask {

    public NoMask(){}
    
    @Override
    public boolean mask(int row, int col) {
        return true;
    }
}
