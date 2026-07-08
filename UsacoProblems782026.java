import java.util.HashSet;
import java.util.Set;

public class UsacoProblems782026 {


    //USACO problem
    //https://cses.fi/problemset/task/1621
    public static int distinctNumbers(int[] nums){
        Set<Integer> numbers = new HashSet<>();

        for (int num : nums){
            numbers.add(num);
        }

        return numbers.size();
    }

}
