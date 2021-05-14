package code690;

import java.util.*;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Solution.java, v 0.1 2021-02-26 11:21 feigeswjtu.cyf Exp $$
 */
public class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();

        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        Employee employee = map.get(id);
        Deque<Employee> deques = new LinkedList<>();
        deques.push(employee);

        int importance = 0;

        while (!deques.isEmpty()){
            Employee pop = deques.pop();
            importance += pop.importance;
            if (pop.subordinates != null && pop.subordinates.size() > 0){
                for (Integer subordinate : pop.subordinates) {
                    deques.push(map.get(subordinate));
                }
            }
        }
        return importance;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
