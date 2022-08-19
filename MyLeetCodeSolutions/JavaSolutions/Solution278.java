/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
//278. First Bad Version
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid = left + (right - left) / 2;
        if (isBadVersion(left))
            return left;
        while (left != mid) {
            if (isBadVersion(mid)) {
                right = mid;
                mid = left + (right - left) / 2;
            } else {
                left = mid;
                mid = left + (right - left) / 2;
            }
        }
        return right;
    }
}