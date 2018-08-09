package com.example.ured3.obracunfiskal4;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ViewHolder> {



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvNaziv;
        private TextView tvCijena;
        private TextView tvPorez;
        private TextView tvPocstanje;
        private TextView tvDonos;
        private TextView tvUkupno;
        private TextView tvOstatak;
        private TextView tvProdano;
        private TextView tvIznos;

        public ViewHolder(View itemView) {
            super(itemView);

            tvNaziv = itemView.findViewById(R.id.tv_name);
            tvCijena = itemView.findViewById(R.id.tv_cijena);
            tvPorez = itemView.findViewById(R.id.tv_pdva);
            tvPocstanje = itemView.findViewById(R.id.tv_pocstanjee);
            tvDonos = itemView.findViewById(R.id.tv_donosaa);
            tvUkupno = itemView.findViewById(R.id.tv_ukupnoo);
            tvOstatak = itemView.findViewById(R.id.tv_ostatakk);
            tvProdano = itemView.findViewById(R.id.tv_prodanoo);
            tvIznos = itemView.findViewById(R.id.tv_Iznos);
            itemView.setOnClickListener(this);
        }

        private void bind(int position) {

            Artikli article = mArtikli.get(position);

            tvNaziv.setText(article.getNazivA());
            tvCijena.setText(String.format(Locale.getDefault(), "%.2f", article.getCijenaA()));
            tvPorez.setText(String.format(Locale.getDefault(), "%.2f", article.getPoreza()));
            tvPocstanje.setText(String.format(Locale.getDefault(),    "%.2f", article.getZalihaA()));
            tvDonos.setText(String.format(Locale.getDefault(),    "%.2f", article.getDonosA()));
            tvUkupno.setText(String.format(Locale.getDefault(),   "%.2f", article.getZalihaA() + article.getDonosA()));
            tvOstatak.setText(String.format(Locale.getDefault(),    "%.2f", article.getOstatakA()));
            tvProdano.setText(String.format(Locale.getDefault(),   "%.2f", article.getUkupnoA() - article.getOstatakA()));
            tvIznos.setText(String.format(Locale.getDefault(), "%.2f", article.getProdanoA() * article.getCijenaA()));

        }

        @Override
        public void onClick(View v) {
            mArticlesListener.onArticleClicked(mArtikli.get(getAdapterPosition()));
        }
    }

    private List<Artikli> mArtikli;
    private ArticlesListener mArticlesListener;

    public ArticlesAdapter(ArticlesListener mArticlesListener) {
        this.mArtikli = new ArrayList<>();
        this.mArticlesListener = mArticlesListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_articler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mArtikli.size();
    }

    public void replaceData(List<Artikli> artikli){
        this.mArtikli = artikli;
        notifyDataSetChanged();
    }

    public interface ArticlesListener {

        void onArticleClicked(Artikli artikl);

    }

}
