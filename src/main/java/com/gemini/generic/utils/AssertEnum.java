package com.gemini.generic.utils;

import org.apache.commons.lang3.StringUtils;

public enum AssertEnum {

    EQUALS {
        @Override
        public boolean doAssert(String value1, String value2) {
            return StringUtils.equals(value1, value2);
        }
    },
    NOT_EQUALS {
        @Override
        public boolean doAssert(String value1, String value2) {
            return !StringUtils.equals(value1, value2);
        }
    },
    CONTAINS {
        @Override
        public boolean doAssert(String value1, String value2) {
            return StringUtils.contains(value1, value2);
        }
    },
    NOT_CONTAINS {
        @Override
        public boolean doAssert(String value1, String value2) {
            return !StringUtils.contains(value1, value2);
        }
    };

    public abstract boolean doAssert(String value1, String value2);
}
