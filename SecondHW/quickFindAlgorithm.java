package org.moskalev.AaDS.HW.SecondHW;

public class quickFindAlgorithm {
    private int[] id;
    public quickFindAlgorithm(int n){
        id = new int[n];
        for (int i = 0; i < n; i++){
            id[i] = i;
        }
    }
    public boolean conected (int p, int q){
        return id[p] == id[q];
    }
    public void union (int p, int q){
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if(id[i] == pid){
                id[i] = qid;
            }
            
        }
    }
}
