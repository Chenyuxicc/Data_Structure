package com.chen.test.cache;

import sun.misc.LRUCache;

/**
 * @author chenyuxi
 * @since 19-10-8:下午4:09
 */
public class LruTest {
    private final LRUCache lruCache = new LRUCache(10) {
        @Override
        protected Object create(Object o) {
            return null;
        }

        @Override
        protected boolean hasName(Object o, Object o2) {
            return false;
        }
    };
}
