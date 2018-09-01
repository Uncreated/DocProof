package com.uncreated.docproof.ui.fragments.documents.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.uncreated.docproof.R;
import com.uncreated.docproof.model.documents.entities.Document;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

class DocumentsAdapter extends RecyclerView.Adapter<DocumentsAdapter.DocumentViewHolder> {

    private OnItemClickListener onItemClickListener;

    private List<Document> documents = new ArrayList<>();

    public DocumentsAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DocumentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.document_list_item, parent, false);

        return new DocumentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DocumentViewHolder holder, int position) {
        Document document = documents.get(position);
        holder.tvInfo.setText("Size:" + document.getPages().size());
        holder.layout.setOnClickListener(v -> onItemClickListener.onItemClick(position));
    }

    @Override
    public int getItemCount() {
        return documents.size();
    }

    interface OnItemClickListener {
        void onItemClick(int index);
    }

    class DocumentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.container)
        LinearLayout layout;

        @BindView(R.id.iv_thumbnail)
        ImageView ivThumbnail;

        @BindView(R.id.tv_info)
        TextView tvInfo;

        DocumentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
