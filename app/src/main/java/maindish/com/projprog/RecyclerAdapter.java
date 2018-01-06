package maindish.com.projprog;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Dunya on 05/01/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    private ArrayList<Inici>listaMenu;
    private OnclickRecycler listener;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adaptador,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Inici menu=listaMenu.get(position);
        holder.bind(menu,listener);
    }

    @Override
    public int getItemCount() {
        return listaMenu.size();
    }

    public interface OnclickRecycler{
        void OnclickItemRecycler(Inici menu);
    }
    public RecyclerAdapter(ArrayList<Inici>listaMenu,OnclickRecycler listener){
        this.listaMenu=listaMenu;
        this.listener=listener;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.imagen);
        }
        public void bind(final Inici menu, final OnclickRecycler listener){
            Glide.with(imageView.getContext()).load(menu.getIdImagen()).into(imageView);
            itemView.setOnClickListener(new View.OnClickListener(){
                public  void onClick(View v){
                    listener.OnclickItemRecycler(menu);
                }
        });
    }}
}
