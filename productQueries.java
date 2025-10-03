class Solution {
    public int[] productQueries(int n, int[][] queries) {
        String bin = Integer.toBinaryString(n);
        List<Long> p = new ArrayList<>();
        for(int i=bin.length()-1;i>=0;i--)
        {
            long x = 0L;
            if(bin.charAt(i)=='1')
            {
                x = (long)Math.pow(2,bin.length()-i-1);
                p.add(x);
            } 
        }
        int len = p.size();
        long pre[][] = new long[len][len];
        long mod = (long)1e9+7;
        for(int i=0;i<len;i++)
        {
            pre[i][i] = p.get(i) % mod;
            for(int j=i+1;j<len;j++)
            {
                pre[i][j] = ((pre[i][j-1] % mod) * (p.get(j) % mod)) % mod ;
            }
        }
        int ans[] = new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            ans[i] = (int)pre[queries[i][0]][queries[i][1]];
        }
        return ans;
    }
}
