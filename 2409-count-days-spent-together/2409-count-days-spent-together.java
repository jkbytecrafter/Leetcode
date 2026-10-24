class Solution {
    int []days = {31,28,31,30,31,30,31,31,30,31,30,31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int start = Math.max(countDays(arriveAlice),countDays(arriveBob));
        int end = Math.min(countDays(leaveAlice),countDays(leaveBob));
        return Math.max(0,end-start+1);
    }
    public int countDays(String date) {
        String []temp = date.split("-");
        int month = Integer.parseInt(temp[0]);
        int day = Integer.parseInt(temp[1]);
        int dayCount = 0;
        for(int i=0;i<month-1;i++) {
            dayCount += days[i];
        }
        return dayCount+day;
    }
}