package dongzhong.looplist;

import android.support.annotation.NonNull;

import java.util.Iterator;
import java.util.List;

/**
 * Created by dongzhong on 2017/11/29.
 */

/**
 * 包装列表，提供循环遍历的功能
 * @param <T>
 */
public class LoopList<T> {
    private List<T> list;
    private Iterator<T> iterator;
    private int index = 0;

    /**
     * 构造函数
     * @param list 需要包装的列表，不能为空
     */
    public LoopList(@NonNull List<T> list) {
        this.list = list;
        iterator = list.iterator();
        index = 0;
    }

    /**
     * 遍历函数，使用时无需判断hasNext()
     * 当遍历到列表末尾时，自动循环到列表起始位置
     * @return 返回列表项
     */
    public T next() {
        if (list.size() <= 0) {
            return null;
        }
        if (iterator == null) {
            iterator = list.iterator();
            index = 0;
        }
        if (iterator.hasNext()) {
            index++;
            return iterator.next();
        }
        else {
            index = 0;
            iterator = list.iterator();
            index++;
            return iterator.next();
        }
    }

    /**
     * 获取当前列表索引位置
     * @return 索引位置
     */
    public int getIndex() {
        return index;
    }
}

