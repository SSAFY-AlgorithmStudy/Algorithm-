import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> adjList;
    static int [] len;
    static int maxLen= Integer.MIN_VALUE;
    public int solution(int n, int[][] edge) {
        int answer = 0;
		adjList = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}
		len = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			len[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < edge.length; i++) {
			adjList.get(edge[i][0]).add(edge[i][1]);
			adjList.get(edge[i][1]).add(edge[i][0]);
		}
		len[1]=0;
		dfs(1, 0, n);
		
		for(int k: len) {
			maxLen = Math.max(maxLen, k);
		}
		int cnt=0;
		
		for(int k: len) {
			if(maxLen==k)cnt++;
		}
		answer = cnt;
		return answer;
    }
    static void dfs(int start ,int depth ,int cnt){
                
        if(cnt-1<depth){
            return;
        }
        ArrayList<Integer> tempList= adjList.get(start);
        
        for(int k: tempList){
            if(len[k]>depth+1){
                len[k]=depth+1;
                
                dfs(k,depth+1,cnt);
            }
        }
    }
}