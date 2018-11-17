package Map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserRoleCount {

    public Map<String, Integer> getUserRoleCount(Map<String, List<String>> userRoles) {
        Map<String, Integer> roleCountMap = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : userRoles.entrySet()) {
            List<String> userList = entry.getValue();

            for (String user : userList) {
                if (roleCountMap.containsKey(user)) {
                    int count = roleCountMap.get(user);
                    count++;
                    roleCountMap.put(user, count);
                } else {
                    roleCountMap.put(user, 1);
                }
            }
        }
        return roleCountMap;
    }

    public Map<String, Long> getUserRoleCountWithJava8(Map<String, List<String>> userRoles){
         return  userRoles.entrySet().stream().map(Map.Entry::getValue).flatMap(user -> user.stream()).collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()
                ));
    }
}
