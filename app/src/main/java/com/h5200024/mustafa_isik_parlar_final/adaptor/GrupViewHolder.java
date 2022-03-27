package com.h5200024.mustafa_isik_parlar_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5200024.mustafa_isik_parlar_final.R;

public class GrupViewHolder extends RecyclerView.ViewHolder {
    ImageView imgGrupUyesi;
    TextView txtIsim;
    TextView txtViewRol;
    TextView txtViewYas;
    public GrupViewHolder(@NonNull View itemView) {

        super(itemView);
        imgGrupUyesi =itemView.findViewById(R.id.imgGrupUyesi);
        txtIsim =itemView.findViewById(R.id.textViewIsim);
        txtViewRol =itemView.findViewById(R.id.textViewRol);
        txtViewYas =itemView.findViewById(R.id.textViewYas);
    }
}
