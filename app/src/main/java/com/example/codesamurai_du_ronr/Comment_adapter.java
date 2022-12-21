package com.example.codesamurai_du_ronr;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codesamurai_du_ronr.databinding.CommentSampleBinding;
import com.github.marlonlom.utilities.timeago.TimeAgo;

import java.util.ArrayList;

public class Comment_adapter extends RecyclerView.Adapter<Comment_adapter.viewHolder>  {
    Context context;
    ArrayList<Comment> list;

    public Comment_adapter(Context context, ArrayList<Comment> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.comment_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Comment comment=list.get(position);
        String time= TimeAgo.using(comment.getCommentedAt());
        holder.binding.projectName.setText(Html.fromHtml("<b>"+comment.getCommentedby()+"</b >"+"    "+comment.getCommentText()));
        holder.binding.time.setText(time);
        //comment.getCommentText();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        CommentSampleBinding binding;
        public viewHolder(@NonNull View itemView) {

            super(itemView);
            binding = CommentSampleBinding.bind(itemView);

        }
    }
}
