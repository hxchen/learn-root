package com.a3fun.learn.java.nesting;


import java.util.HashMap;
import java.util.Map;

/**
 * @author haixiangchen
 */
public class RolePropSource {

    private Map<ICalcProp.Type, Map<Integer, Double>> propContainer;


    public void add(ICalcProp.Type calcType, int propId, double val) {
        if (propContainer == null) {
            propContainer = new HashMap<>();
        }

        Map<Integer, Double> doubleMap = propContainer.computeIfAbsent(calcType, k -> new HashMap<>());
        doubleMap.compute(propId, (k, v) -> v == null ? val : v + val);
    }

    public Map<ICalcProp.Type, Double> getPropsById(int propId){
        Map<ICalcProp.Type, Double> ret = new HashMap<>();
        propContainer.forEach((k, v) -> v.forEach((pId, doubleValue) ->{
            if (pId == propId){
                ret.put(k, doubleValue);
            }
        }));
        return ret;
    }

    public static void main(String[] args) {
        RolePropSource rolePropSource = new RolePropSource();
        rolePropSource.add(ICalcProp.RoleType.BASE, 1001, 0.1);
        rolePropSource.add(ICalcProp.RoleType.BASE, 1002, 0.1);
        rolePropSource.add(ICalcProp.RoleType.CITY, 1001, 0.1);
        rolePropSource.add(ICalcProp.RoleType.VIP, 1001, 0.1);

        Map<ICalcProp.Type, Double> ret = rolePropSource.getPropsById(1002);
        ret.forEach((k, v) -> System.out.println("k = " + k +", v = " +v));

    }
}
