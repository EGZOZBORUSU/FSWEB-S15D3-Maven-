package org.example;

import org.example.entity.Employee;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();
        
        employees.add(new Employee(1, "Eren", "Ozkan"));
        employees.add(new Employee(1, "Eren", "Ozkan"));
        employees.add(new Employee(2, "Ahmet", "Yilmaz"));
        employees.add(new Employee(3, "Zeynep", "Kaya"));
        employees.add(new Employee(3, "Zeynep", "Kaya"));
        employees.add(new Employee(4, "Ali", "Veli"));

        System.out.println("Tekrar Edenler: " + findDuplicates(employees));
        System.out.println("Eşsiz (Unique) Harita: " + findUniques(employees));
        System.out.println("Sadece Tek Kaydı Olanlar: " + removeDuplicates(employees));
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        List<Employee> duplicates = new LinkedList<>();
        Map<Integer, Employee> seenMap = new HashMap<>();
        
        for (Employee emp : list) {
            if (emp != null) {
                if (seenMap.containsKey(emp.getId())) {
                    if (!duplicates.contains(emp)) {
                        duplicates.add(emp);
                    }
                } else {
                    seenMap.put(emp.getId(), emp);
                }
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> uniqueMap = new HashMap<>();
        for (Employee emp : list) {
            if (emp != null && !uniqueMap.containsKey(emp.getId())) {
                uniqueMap.put(emp.getId(), emp);
            }
        }
        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        List<Employee> singles = new LinkedList<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Employee emp : list) {
            if (emp != null) {
                countMap.put(emp.getId(), countMap.getOrDefault(emp.getId(), 0) + 1);
            }
        }

        for (Employee emp : list) {
            if (emp != null && countMap.get(emp.getId()) == 1) {
                singles.add(emp);
            }
        }
        return singles;
    }
}
