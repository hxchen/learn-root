package com.a3fun.learn.java.nesting;

/**
 * @author haixiangchen
 */
public interface ICalcProp {
    /**
     * 处理类型 该类中内部枚举
     *
     * @return 处理类型
     */
    ICalcProp.Type getType();

    /**
     * 计算对应类型的属性
     */
    void calcProps();

    interface Type {
        /**
         * 枚举的size
         *
         * @return 枚举的size
         */
        int length();

        /**
         * 缓存枚举数组
         *
         * @return 缓存枚举数组
         */
        ICalcProp.Type[] fastValues();

    }

    enum RoleType implements Type {

        BASE,

        CITY,

        VIP,

        ;

        private static final RoleType[] VALUES = values();

        @Override
        public int length() {
            return VALUES.length;
        }

        @Override
        public RoleType[] fastValues() {
            return VALUES;
        }

    }

    /**
     * 英雄
     */
    enum HeroType implements Type {
        /**
         * 拥有
         */
        HERO_OWN,
        /**
         * 驻扎
         */
        HERO_STATION,

        ;

        private static final HeroType[] VALUES = values();

        @Override
        public int length() {
            return VALUES.length;
        }

        @Override
        public HeroType[] fastValues() {
            return VALUES;
        }

    }
}
