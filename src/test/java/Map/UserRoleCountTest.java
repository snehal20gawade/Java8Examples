package Map;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class UserRoleCountTest {
    private UserRoleCount userRoleCount;
    private Map<String, List<String>> rolesAndUserMap;

    @Before
    public void setUp() throws Exception {
        userRoleCount = new UserRoleCount();
        rolesAndUserMap = setRoleUserMap();
    }

    @Test
    public void getUserRoleCount() {
        Map<String, Integer> roleCount = userRoleCount.getUserRoleCount(rolesAndUserMap);
        assertThat(roleCount.get("Devidas"), equalTo(3));
        assertThat(roleCount.get("Anaya"), equalTo(2));

    }

    @Test
    public void getUserRoleCountWithJava8() {
        Map<String, Long> roleCount = userRoleCount.getUserRoleCountWithJava8(rolesAndUserMap);
        assertThat(roleCount.get("Devidas"), equalTo(new Long(3)));
        assertThat(roleCount.get("Anaya"), equalTo(new Long(2)));

    }

    private Map<String, List<String>> setRoleUserMap() {
        Map<String, List<String>> rolesAndUsers = new HashMap<>();
        List<String> userlist = new ArrayList<>();
        userlist.add("Snehal");
        userlist.add("Devidas");
        List<String> userlist2 = new ArrayList<>();
        userlist2.add("Snehal");
        userlist2.add("Anaya");
        List<String> userlist3 = new ArrayList<>();
        userlist3.add("Devidas");
        userlist3.add("Anaya");
        List<String> userlist4 = new ArrayList<>();
        userlist4.add("Devidas");
        rolesAndUsers.put("Admin", userlist);
        rolesAndUsers.put("SuperAdmin", userlist2);
        rolesAndUsers.put("ReadOnly", userlist3);
        rolesAndUsers.put("ReadWrite", userlist4);
        return rolesAndUsers;
    }
}