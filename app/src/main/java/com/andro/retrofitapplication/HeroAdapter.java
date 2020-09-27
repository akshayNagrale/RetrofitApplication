package com.andro.retrofitapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {
    private List<hero> heroList = new ArrayList<>();
    private Context mContext;

    public HeroAdapter(List<hero> heroList, Context mContext) {
        this.heroList = heroList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public HeroAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_list,parent,false);
        return  new ViewHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull HeroAdapter.ViewHolder holder, int position) {
        hero hero = heroList.get(position);
        holder.tv_name.setText(hero.getName());
        holder.tv_realname.setText(hero.getRealname());
        holder.tv_team.setText(hero.getTeam());
        holder.tv_firstAppearence.setText(hero.getFirstappearance());
        holder.tv_createdBy.setText(hero.getCreatedby());
        holder.tv_publisher.setText(hero.getPublisher());
        holder.tv_imgUrl.setText(hero.getImageurl());
        holder.tv_bio.setText(hero.getBio());

        holder.tv_imgUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Its cliked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    public void setHeroList(List<hero> heroList) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_realname, tv_team, tv_firstAppearence, tv_createdBy, tv_publisher, tv_imgUrl,  tv_bio;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_realname = itemView.findViewById(R.id.tv_realname);
            tv_team = itemView.findViewById(R.id.tv_team);
            tv_firstAppearence = itemView.findViewById(R.id.tv_firstAppearence);
            tv_createdBy = itemView.findViewById(R.id.tv_createdBy);
            tv_publisher = itemView.findViewById(R.id.tv_publisher);
            tv_imgUrl = itemView.findViewById(R.id.tv_imgUrl);
            tv_bio = itemView.findViewById(R.id.tv_bio);

        }
    }
}