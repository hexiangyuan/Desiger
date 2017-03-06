package hexiangyuan.github.io.designer.module.home;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by 何祥源 on 2017/3/6.
 * Desc:
 */

public interface HomeContract {
    interface View {
        void showNetWorkError(boolean hasNetWork);

        void showProgress(boolean showProgress);

        void homeDataLoaded(ArrayList<Object> homeData);
    }

    interface Presenter {

    }
}
