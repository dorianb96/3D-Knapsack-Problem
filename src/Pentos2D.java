import java.util.ArrayList;
import java.util.Arrays;

public class Pentos2D {
    public Pentos2D() {
        double[][] P1Pento = {
                {4.01, 4.01},
                {4.01, 4.01},
                {4.01, 0}};
        double[][] P2Pento = {
                {4.02, 4.02},
                {4.02, 4.02},
                {0, 4.02}};
        double[][] P3Pento = {
                {4.03, 0},
                {4.03, 4.03},
                {4.03, 4.03}};
        double[][] P4Pento = {
                {0, 4.04},
                {4.04, 4.04},
                {4.04, 4.04}};
        double[][] P5Pento = {
                {4.05, 4.05, 0},
                {4.05, 4.05, 4.05}};
        double[][] P6Pento = {
                {4.06, 4.06, 4.06},
                {4.06, 4.06, 0}};
        double[][] P7Pento = {
                {4.07, 4.07, 4.07},
                {0, 4.07, 4.07}};
        double[][] P8Pento = {
                {0, 4.08, 4.08},
                {4.08, 4.08, 4.08}};
        double[][] T1Pento = {
                {0,0,5.01},
                {5.01, 5.01, 5.01},
                {0, 0, 5.01}};
        double[][] T2Pento = {
                {5.02,0,0},
                {5.02, 5.02, 5.02},
                {5.02,0, 0}};
        double[][] T3Pento = {
                {5.02, 5.02,5.02},
                {0, 5.02, 0},
                {0, 5.02,0}};
        double[][] T4Pento = {
                {0,5.02, 0},
                {0, 5.02, 0},
                {5.02, 5.02, 5.02}};
        double[][] L1Pento = {
                {0, 0,0 , 3.01},
                {3.01, 3.01, 3.01, 3.01}};
        double[][] L2Pento = {
                {3.02, 0, 0,0 },
                {3.02, 3.02, 3.02, 3.02}};
        double[][] L3Pento = {
                {3.03, 3.03, 3.03, 3.03},
                {3.03, 0, 0, 0}};
        double[][] L4Pento = {
                {3.04, 3.04, 3.04, 3.04},
                {0, 0, 0, 3.04}};
        double[][] L5Pento = {
                {3.05,3.05},
                {3.05,0},
                {3.05,0},
                {3.05,0}};
        double[][] L6Pento = {
                {3.06,0},
                {3.06,0},
                {3.06,0},
                {3.06,3.06}};
        double[][] L7Pento = {
                {3.07,3.07},
                {0,3.07},
                {0,3.07},
                {0,3.07}};
        double[][] L8Pento = {
                {0,3.08},
                {0,3.08},
                {0,3.08},
                {3.08,3.08}};

        this.pents = new ArrayList<double[][]>(20);
        pents.add(P1Pento);        pents.add(P2Pento);        pents.add(P3Pento);        pents.add(P4Pento);
        pents.add(P5Pento);        pents.add(P6Pento);        pents.add(P7Pento);        pents.add(P8Pento);
        pents.add(T1Pento);        pents.add(T2Pento);        pents.add(T3Pento);        pents.add(T4Pento);
        pents.add(L1Pento);        pents.add(L2Pento);        pents.add(L3Pento);        pents.add(L4Pento);
        pents.add(L5Pento);        pents.add(L6Pento);        pents.add(L7Pento);        pents.add(L8Pento);
        /*
        for (double[][] item : pents){
            for (int i = 0; i < item.length; i++){
                for (int j = 0; j < item[i].length; j++) {
                    System.out.print(item[i][j] + "  " );
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }  */
    }

    public ArrayList<double[][]> getPentos(){
        return this.pents;
    }
    public ArrayList<double[][]> getGreedyPents(){
        greedyPents = greedySort(pents);
        return this.greedyPents;
    }
    public ArrayList<double[][]> greedySort(ArrayList<double[][]> pents){
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 1; i < pents.size(); i++) {
                double[][] item1 = pents.get(i - 1);
                double[][] item2 = pents.get(i);
                if (getMaxValue(item1) < getMaxValue(item2)) {
                    pents.set(i - 1, item2);
                    pents.set(i, item1);
                    flag = true;
                }
            }
        }
        return pents;
    }
    public static int getMaxValue(double[][] pento){
        for (int i = 0; i< pento.length; i++ ){
            for (int j = 0; j < pento[i].length; j++){
                if (pento[i][j] != 0){
                    return ((int)pento[i][j]);
                }
            }
        }
        return 0;
    }
    ArrayList<double[][]> pents;
    ArrayList<double[][]> greedyPents;

}
