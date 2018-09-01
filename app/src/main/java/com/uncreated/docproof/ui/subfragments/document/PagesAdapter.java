package com.uncreated.docproof.ui.subfragments.document;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uncreated.docproof.R;
import com.uncreated.docproof.model.documents.entities.Page;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PagesAdapter extends RecyclerView.Adapter<PagesAdapter.PagesViewHolder> {

    private List<Page> pages = new ArrayList<>();

    public PagesAdapter() {
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.page_list_item, parent, false);

        return new PagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PagesViewHolder holder, int position) {
        holder.textViewInfo.setText("Page: " + position);
    }

    @Override
    public int getItemCount() {
        return pages.size();
    }

    class PagesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_page_info)
        TextView textViewInfo;

        PagesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
