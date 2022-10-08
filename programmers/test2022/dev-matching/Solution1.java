import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public String solution(String[] registered_list, String new_id) {
        Set<String> userSet = new HashSet<>(Arrays.asList(registered_list));

        String strOnly = new_id.replaceAll("[0-9]", "");
        while(userSet.contains(new_id)) {
            String numberOnly = new_id.replaceAll("[^0-9]", "");
            if(numberOnly.equals("")) {
                new_id += "1";
                continue;
            }

            int numberOnlyBy = Integer.parseInt(numberOnly) + 1;
            new_id = strOnly + Integer.toString(numberOnlyBy);
        }
        return new_id;
    }
}
