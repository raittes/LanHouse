/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemalanhouse.logic;

/**
 *
 * @author marcos
 */
public class Hora {
        private int h;
        private int m;

        public Hora(int h, int m) {
            this.h=h;
            this.m=m;
        }
        @Override
        public String toString(){
            return (h+":"+m);
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }

        public int getM() {
            return m;
        }

        public void setM(int m) {
            this.m = m;
        }
}
