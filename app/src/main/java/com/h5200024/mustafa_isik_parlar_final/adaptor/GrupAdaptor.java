package com.h5200024.mustafa_isik_parlar_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5200024.mustafa_isik_parlar_final.util.GlideUtil;
import com.h5200024.mustafa_isik_parlar_final.model.Grup;
import com.h5200024.mustafa_isik_parlar_final.R;

import java.util.List;

public class GrupAdaptor extends RecyclerView.Adapter<GrupViewHolder> {

    List<Grup> grupUyeleri;
    Context context;
    OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void onItemClick(Grup tiklananGrup);
    }


    public GrupAdaptor(List<Grup> grupUyeleri, Context context, OnItemClickListener onItemClickListener) {
        this.grupUyeleri = grupUyeleri;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }
    @NonNull
    @Override
    public GrupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_grupuyesi,parent,false);

        GrupViewHolder grupViewHolder =new GrupViewHolder(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(grupUyeleri.get(grupViewHolder.getAdapterPosition()));
            }
        });

        return grupViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull GrupViewHolder viewHolder, int position) {
        viewHolder.txtViewRol.setText(grupUyeleri.get(position).getRol());
        viewHolder.txtIsim.setText(grupUyeleri.get(position).getAdiSoyadi());
        viewHolder.txtViewYas.setText(grupUyeleri.get(position).getYas());

        GlideUtil.resmiIndiripGoster(context,grupUyeleri.get(position).getResimURL(),viewHolder.imgGrupUyesi);
    }
    @Override
    public int getItemCount() {
        return grupUyeleri.size();
    }
}
