class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String,Integer> mpp=new HashMap<>();
        for(int i=0;i<paths.size();i++){
            mpp.put(paths.get(i).get(0),1);
        }
        for(int i=0;i<paths.size();i++){
            if(mpp.get(paths.get(i).get(1)) == null)
                return paths.get(i).get(1);
        }
        return "";
    }
}