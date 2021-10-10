import java.io.*;
import java.util.*;

class PROGRAMMERS_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] stud = new int[n+1];
        for(int i = 0; i < lost.length; ++i)
            stud[lost[i]]--;
        for(int i = 0; i < reserve.length; ++i)
            stud[reserve[i]]++;
        
        for(int i = 1; i <= n; ++i) {
            // 만약 안 가져온 학생이 있다면
            if(stud[i] == -1) {
                if(stud[i-1] == 1) {
                    stud[i] = stud[i-1] = 0;
                }
                else if(i+1 <= n && stud[i+1] == 1) {
                    stud[i] = stud[i+1] = 0;
                }
            }
        }
        String str = "apple";
        str.
        int cnt = 0;
        for(int i = 1; i <= n; ++i) {
            if(stud[i] < 0) {
                ++cnt;
            }
        }
        
        return n - cnt;
    }
}