package mtj.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BlogAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    private List<Blog> mBlogList;

    public BlogAdapter(List<Blog> mBlogList) {
        this.mBlogList = mBlogList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (mBlogList != null && mBlogList.size() > 0) {
            return mBlogList.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends BaseViewHolder {
        ImageView ivThumbnail;
        TextView tvTitle;
        TextView tvDescription;
        TextView tvLink;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.ivThumbnail);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvLink = itemView.findViewById(R.id.tvLink);

        }

        @Override
        protected void clear() {
            ivThumbnail.setImageDrawable(null);
            tvTitle.setText("");
            tvLink.setText("");
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);
            final Blog mBlog = mBlogList.get(position);
            if (mBlog.getThumbnail() != null) {
                Glide.with(itemView.getContext())
                        .load(mBlog.getThumbnail())
                        .into(ivThumbnail);
            }
            if (mBlog.getTitle() != null) {
                tvTitle.setText(mBlog.getTitle());
            }
            if (mBlog.getDescription() != null) {
                tvDescription.setText(mBlog.getDescription());
            }
            if (mBlog.getLink() != null) {
                tvLink.setText(mBlog.getLink());
            }
            tvLink.setOnClickListener(v -> {
                if (mBlog.getLink() != null) {
                    try {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse(mBlog.getLink()));
                        itemView.getContext().startActivity(intent);
                    } catch (Exception e) {
                        Log.e("TAG", "onClick: Image url is not correct");
                    }
                }
            });

        }
    }
}
