package hexiangyuan.github.io.designer.module.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hexiangyuan.github.io.designer.data.TGrid;

/**
 * Created by 何祥源 on 2017/3/6.
 * Desc:
 */

public class GrideAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements IGrideAdapter<TGrid> {
    private static final int TYPE_GRIDE_ONE = 0;
    private static final int TYPE_GRIDE_TWO = 1;
    private static final int TYPE_GRIDE_PROGRESS = -1;
    private final int span;
    private boolean showLoadingMore = false;

    private List<TGrid> data = new ArrayList<>();

    public GrideAdapter(int span) {
        this.span = span;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_GRIDE_ONE:
                return new TypeOneViewHolder(View.inflate(parent.getContext(), 0, null));
            case TYPE_GRIDE_TWO:
                return new TypeTwoViewHolder(View.inflate(parent.getContext(), 0, null));
            case TYPE_GRIDE_PROGRESS:
                return new ProgressViewHolder(View.inflate(parent.getContext(), 0, null));
        }
        return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TYPE_GRIDE_ONE:
                bindTypeOne((TypeOneViewHolder) holder, position);
                break;

            case TYPE_GRIDE_TWO:
                bindTypeTwo((TypeTwoViewHolder) holder, position);
                break;
            case TYPE_GRIDE_PROGRESS:
                bindTypeProgress((ProgressViewHolder) holder, position);
                break;
        }

    }

    private void bindTypeOne(TypeOneViewHolder holder, int position) {
    }

    private void bindTypeTwo(TypeTwoViewHolder holder, int position) {
    }

    private void bindTypeProgress(ProgressViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return data.size() + (showLoadingMore ? 1 : 0);
    }

    @Override
    public int getSpanSize(int position) {
        switch (getItemViewType(position)) {
            case TYPE_GRIDE_PROGRESS:
            case TYPE_GRIDE_ONE:
                return span;
            default:
                return 1;
        }
    }

    @Override
    public void clearData() {
        this.data.clear();
    }

    @Override
    public void refresh(List<TGrid> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public void loadMore(List<TGrid> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public void initData(List<TGrid> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public void startLoadMore() {
        if (showLoadingMore) return;
        showLoadingMore = true;
        notifyItemInserted(getProgressPosition());
    }

    @Override
    public void endLoadMore() {
        if (showLoadingMore) return;
        int pos = getProgressPosition();
        showLoadingMore = false;
        notifyItemRemoved(pos);
    }

    private int getProgressPosition() {
        if (data == null || data.size() == 0)
            return RecyclerView.NO_POSITION;
        return showLoadingMore ? getItemCount() - 1 : RecyclerView.NO_POSITION;
    }

    private static class TypeOneViewHolder extends RecyclerView.ViewHolder {

        public TypeOneViewHolder(View itemView) {
            super(itemView);
        }
    }

    private static class TypeTwoViewHolder extends RecyclerView.ViewHolder {
        public TypeTwoViewHolder(View itemView) {
            super(itemView);
        }
    }

    private static class ProgressViewHolder extends RecyclerView.ViewHolder {
        public ProgressViewHolder(View itemView) {
            super(itemView);
        }
    }
}

