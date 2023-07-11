package top.moyel.mayo.utils;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjUtil;

import java.util.List;

/**
 * @author moyel
 */
public class GenericTypeUtil {
    public static <E> boolean equalsAny(E target, List<E> values) {
        if (CollectionUtil.isEmpty(values)) {
            return false;
        }

        for (E value : values) {
            if (ObjUtil.equals(target, value)) {
                return true;
            }
        }

        return false;
    }
}
