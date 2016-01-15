package part2b;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pento3D {
    public Pento3D() {
        initialize();
    }

    public void initialize() {
        /*
        since there are only 3 types of pents,
        we can easily add them in a "greedy" fashion
         */
        greedyPents3D.add(T1);    greedyPents3D.add(T2);   greedyPents3D.add(T3);   greedyPents3D.add(T4);
        greedyPents3D.add(T5);    greedyPents3D.add(T6);   greedyPents3D.add(T7);   greedyPents3D.add(T8);
        greedyPents3D.add(T9);    greedyPents3D.add(T10);  greedyPents3D.add(T11);  greedyPents3D.add(T12);

        greedyPents3D.add(P1);    greedyPents3D.add(P2);   greedyPents3D.add(P3);   greedyPents3D.add(P4);
        greedyPents3D.add(P5);    greedyPents3D.add(P6);   greedyPents3D.add(P7);   greedyPents3D.add(P8);
        greedyPents3D.add(P9);    greedyPents3D.add(P10);  greedyPents3D.add(P11);  greedyPents3D.add(P12);
        greedyPents3D.add(P13);   greedyPents3D.add(P14);  greedyPents3D.add(P15);  greedyPents3D.add(P16);
        greedyPents3D.add(P17);   greedyPents3D.add(P18);  greedyPents3D.add(P19);  greedyPents3D.add(P20);
        greedyPents3D.add(P21);   greedyPents3D.add(P22);  greedyPents3D.add(P23);  greedyPents3D.add(P24);

        greedyPents3D.add(L1);    greedyPents3D.add(L2);   greedyPents3D.add(L3);   greedyPents3D.add(L4);
        greedyPents3D.add(L5);    greedyPents3D.add(L6);   greedyPents3D.add(L7);   greedyPents3D.add(L8);
        greedyPents3D.add(L9);    greedyPents3D.add(L10);  greedyPents3D.add(L11);  greedyPents3D.add(L12);
        greedyPents3D.add(L13);   greedyPents3D.add(L14);  greedyPents3D.add(L15);  greedyPents3D.add(L16);
        greedyPents3D.add(L17);   greedyPents3D.add(L18);  greedyPents3D.add(L19);  greedyPents3D.add(L20);
        greedyPents3D.add(L21);   greedyPents3D.add(L22);  greedyPents3D.add(L23);  greedyPents3D.add(L24);


    }

    public void printPent(double[][][] pent) {
        for (int i = 0; i < pent.length; i++){
            for (int j = 0; j < pent[0].length; j++){
                for (int k = 0; k < pent[0][0].length; k++) {
                    System.out.print(pent[i][j][k]);
                }
            }
        }
    }

    public ArrayList<double[][][]> getGreedyPents3D(){
        return this.greedyPents3D;
    }

    private ArrayList<double[][][]> greedyPents3D = new ArrayList<>(65);
    //
    private double[][][] T1 = {
            {{5.01},{5.01},{5.01}},
            {{0},{5.01},{0}},
            {{0},{5.01},{0}}
    };
    private double[][][] T2 = {
            {{5.02,5.02,5.02}},
            {{0,5.02,0}},
            {{0,5.02,0}}
    };
    private double[][][] T3 = {
            {{0},{0},{5.03}},
            {{5.03},{5.03},{5.03}},
            {{0},{0},{5.03}}
    };
    private double[][][] T4 = {
            {{0,5.04,0}, {0,5.04,0},{5.04,5.04,5.04}}
    };
    private double[][][] T5 = {
            {{0},{5.05},{0}},
            {{0},{5.05},{0}},
            {{5.05},{5.05},{5.05}}
    };
    private double[][][] T6 = {
            {{0,5.06,0}},
            {{0,5.06,0}},
            {{5.06,5.06,5.06}}
    };
    private double[][][] T7 = {
            {{5.07},{0},{0}},
            {{5.07},{5.07},{5.07}},
            {{5.07},{0},{0}}
    };
    private double[][][] T8 = {
            {{5.08,5.08,5.08}, {0,5.08,0},{0,5.08,0}}
    };
    private double[][][] T9 = {
            {{0,0,5.09}},
            {{5.09,5.09,5.09}},
            {{0,0,5.09}}
    };
    private double[][][] T10 = {
            {{0,0,5.10},{5.10,5.10,5.10},{0,0,5.10}}
    };
    private double[][][] T11 = {
            {{5.11,0,0}},
            {{5.11,5.11,5.11}},
            {{5.11,0,0}}
    };
    private double[][][] T12 = {
            {{5.12,0,0},{5.12,5.12,5.12},{5.12,0,0}}
    };
    // upper position, clock time at 12 (L1 to L4)
    private double[][][] L1 = {
            {{3.01},{3.01}},
            {{3.01},{0}},
            {{3.01},{0}},
            {{3.01},{0}}
    };
    private double[][][] L2 = {
            {{3.02},{3.02}},
            {{0},{3.02}},
            {{0},{3.02}},
            {{0},{3.02}}
    };
    private double[][][] L3 = {
            {{3.03,3.03}},
            {{3.03,0}},
            {{3.03,0}},
            {{3.03,0}}
    };
    private double[][][] L4 = {
            {{3.04,3.04}},
            {{0,3.04}},
            {{0,3.04}},
            {{0,3.04}}
    };
    // right position at 3'o clock
    // x-1d
    private double[][][] L5 = {
            {{3.05,0},{3.05,0},{3.05,0},{3.05,3.05}}
    };
    private double[][][] L6 = {
            {{0,3.06},{0,3.06},{0,3.06},{3.06,3.06}}
    };
    // z - 1d
    private double[][][] L7 = {
            {{0},{0},{0},{3.07}},
            {{3.07},{3.07},{3.07},{3.07}}
    };
    private double[][][] L8 = {
            {{3.08},{3.08},{3.08},{3.08}},
            {{0},{0},{0},{3.08}}
    };
    // down position at 6'o clock, L9 - L12
    private double[][][] L9 = {
            {{3.09},{0}},
            {{3.09},{0}},
            {{3.09},{0}},
            {{3.09},{3.09}}
    };
    private double[][][] L10 = {
            {{0},{3.10}},
            {{0},{3.10}},
            {{0},{3.10}},
            {{3.10},{3.10}}
    };
    private double[][][] L11 = {
            {{3.11,0}},
            {{3.11,0}},
            {{3.11,0}},
            {{3.11,3.11}}
    };
    private double[][][] L12 = {
            {{0,3.12}},
            {{0,3.12}},
            {{0,3.12}},
            {{3.12,3.12}}
    };
    // left position at 9'o clock
    // x-1d
    private double[][][] L13 = {
            {{3.13,3.13},{3.13,0},{3.13,0},{3.13,0}}
    };
    private double[][][] L14 = {
            {{3.14,3.14},{0,3.14},{0,3.14},{0,3.14}}
    };
    // z - 1d
    private double[][][] L15 = {
            {{3.15},{0},{0},{0}},
            {{3.15},{3.15},{3.15},{3.15}}
    };
    private double[][][] L16 = {
            {{3.16},{3.16},{3.16},{3.16}},
            {{3.16},{0},{0},{0}}
    };
    // these are 3D pents, which are perpendicular to the clock rotations
    // goes to the north
    private double[][][] L17 = {
            {{0,0,0,3.17}},
            {{3.17,3.17,3.17,3.17}}
    };
    private double[][][] L18 = {
            {{3.18,3.18,3.18,3.18}},
            {{0,0,0,3.18}}
    };
    private double[][][] L19 = {
            {{3.19,3.19,3.19,3.19},{0,0,0,3.19}}
    };
    private double[][][] L20 = {
            {{0,0,0,3.20},{3.20,3.20,3.20,3.20}}
    };
    // goes to the south
    private double[][][] L21 = {
            {{3.21,0,0,0}},
            {{3.21,3.21,3.21,3.21}}
    };
    private double[][][] L22 = {
            {{3.22,3.22,3.22,3.22}},
            {{3.22,0,0,0}}
    };
    private double[][][] L23 = {
            {{3.23,3.23,3.23,3.23},{3.23,0,0,0}}
    };
    private double[][][] L24 = {
            {{3.24,0,0,0},{3.24,3.24,3.24,3.24}}
    };

    // P SHAPE
    // upper position, clock time at 12 (L1 to L4)
    private double[][][] P1 = {
            {{4.01},{4.01}},
            {{4.01},{4.01}},
            {{4.01},{0}}
    };
    private double[][][] P2 = {
            {{4.02},{4.02}},
            {{4.02},{4.02}},
            {{0},{4.02}}
    };
    private double[][][] P3 = {
            {{4.03,4.03}},
            {{4.03,4.03}},
            {{4.03,0}}
    };
    private double[][][] P4 = {
            {{4.04,4.04}},
            {{4.04,4.04}},
            {{0,4.04}}
    };
    // right position at 3'o clock
    // x-1d
    private double[][][] P5 = {
            {{4.05,0},{4.05,4.05},{4.05,4.05}}
    };
    private double[][][] P6 = {
            {{0,4.06},{4.06,4.06},{4.06,4.06}}
    };
    // z - 1d
    private double[][][] P7 = {
            {{0},{4.07},{4.07}},
            {{4.07},{4.07},{4.07}}
    };
    private double[][][] P8 = {
            {{4.08},{4.08},{4.08}},
            {{0},{4.08},{4.08}}
    };
    // down position at 6'o clock, L9 - L12
    private double[][][] P9 = {
            {{4.09},{0}},
            {{4.09},{4.09}},
            {{4.09},{4.09}}
    };
    private double[][][] P10 = {
            {{0},{4.10}},
            {{4.10},{4.10}},
            {{4.10},{4.10}}
    };
    private double[][][] P11 = {
            {{4.11,0}},
            {{4.11,4.11}},
            {{4.11,4.11}}
    };
    private double[][][] P12 = {
            {{0,4.12}},
            {{4.12,4.12}},
            {{4.12,4.12}}
    };
    // left position at 9'o clock
    // x-1d
    private double[][][] P13 = {
            {{4.13,4.13},{4.13,4.13},{4.13,0}}
    };
    private double[][][] P14 = {
            {{4.14,4.14},{4.14,4.14},{0,4.14}}
    };
    // z - 1d
    private double[][][] P15 = {
            {{4.15},{4.15},{0}},
            {{4.15},{4.15},{4.15}}
    };
    private double[][][] P16 = {
            {{4.16},{4.16},{4.16}},
            {{4.16},{4.16},{0}}
    };
    // these are 3D pents, which are perpendicular to the clock rotations
    // goes to the north
    private double[][][] P17 = {
            {{0,4.17,4.17}},
            {{4.17,4.17,4.17}}
    };
    private double[][][] P18 = {
            {{4.18,4.18,4.18}},
            {{0,4.18,4.18}}
    };
    private double[][][] P19 = {
            {{4.19,4.19,4.19},{0,4.19,4.19}}
    };
    private double[][][] P20 = {
            {{0,4.20,4.20},{4.20,4.20,4.20}}
    };
    // goes to the south
    private double[][][] P21 = {
            {{4.21,4.21,0}},
            {{4.21,4.21,4.21}}
    };
    private double[][][] P22 = {
            {{4.22,4.22,4.22}},
            {{4.22,4.22,0}}
    };
    private double[][][] P23 = {
            {{4.23,4.23,4.23},{4.23,4.23,0}}
    };
    private double[][][] P24 = {
            {{4.24,4.24,0},{4.24,4.24,4.24}}
    };



}
