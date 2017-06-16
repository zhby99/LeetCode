/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        int left = 0;
        int right = 0;
        boolean overlapping = false;
        boolean used = false;
        for(Interval interval : intervals){
            if (interval.end < newInterval.start || interval.start > newInterval.end){
                if(interval.start > newInterval.end && !used){
                    res.add(newInterval);
                    used = true;
                }
                if(overlapping){
                    res.add(new Interval(left, right));
                    overlapping = false;
                }
                res.add(interval);
            } else if(interval.end >= newInterval.start && !overlapping){
                used = true;
                left = Math.min(interval.start, newInterval.start);
                right = Math.max(interval.end, newInterval.end);
                overlapping = true;
            } else if(overlapping){
                if(interval.end > newInterval.end && interval.start <= newInterval.end){
                    right = interval.end;
                    res.add(new Interval(left, right));
                    overlapping = false;
                }
            }
        }
        if(overlapping){
           res.add(new Interval(left, right));
        }
        if(!used){
           res.add(newInterval);
        }
        return res;
    }
}
