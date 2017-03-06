package hexiangyuan.github.io.designer.module.home;

import java.util.List;

/**
 * Created by 何祥源 on 2017/3/6.
 * Desc:
 */

public interface IGrideAdapter<T> {

    int getSpanSize(int position);

    void clearData();

    void refresh(List<T> data);

    void loadMore(List<T> data);

    void initData(List<T> data);

    void startLoadMore();

    void endLoadMore();

}
