class Solution {
    public class Pair{
        String node;
        double weight;
        public Pair(String s,double w){
            this.node=s;
            this.weight=w;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        int n=equations.size();
        Map<String,List<Pair>> g=new HashMap<>();

        for(int i=0;i<n;i++){
            List<String> eq=equations.get(i);
            String u=eq.get(0), v=eq.get(1);
            double w=values[i];
            g.putIfAbsent(u,new ArrayList<>());
            g.putIfAbsent(v,new ArrayList<>());
            g.get(u).add(new Pair(v,w));
            g.get(v).add(new Pair(u,1/w));
        }

        int m=queries.size();
        double[] ans=new double[m];
        Arrays.fill(ans,-1.0);

        for(int i=0;i<m;i++){
            List<String> q=queries.get(i);
            String u=q.get(0), v=q.get(1);
            
            if(!g.containsKey(u) || !g.containsKey(v)) continue;
            if(u.equals(v)) { ans[i]=1.0; continue; }

            Queue<Pair> dq=new LinkedList<>();
            Set<String> set=new HashSet<>();
            set.add(u);
            dq.add(new Pair(u,1.0));

            while(!dq.isEmpty()){
                Pair cur=dq.poll();
                if(cur.node.equals(v)) {
                    ans[i]=cur.weight;
                    break;
                }
                for(Pair neigh: g.get(cur.node)){
                    if(set.contains(neigh.node)) continue;
                    set.add(neigh.node);
                    dq.add(new Pair(neigh.node, cur.weight*neigh.weight));
                }
            }
        }
        return ans;
    }
}