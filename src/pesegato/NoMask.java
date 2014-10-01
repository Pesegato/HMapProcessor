/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pesegato;

/**
 *
 */
class NoMask implements HMProcessorMask {

    public boolean mask(int row, int col) {
        return true;
    }
}
