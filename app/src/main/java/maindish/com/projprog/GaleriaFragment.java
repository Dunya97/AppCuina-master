package maindish.com.projprog;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GaleriaFragment extends Activity{
    View view;
    TextView titulo;
    TextView descripcion;
    RecyclerView recyclerViewgaleria;
    ImageView imagen;
    ArrayList<Inici> listaMenu;
    RecyclerAdapter adapter;

    //@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_galeria);
        //view = inflater.inflate(R.layout.fragment_galeria, container, true);
        titulo = (TextView) findViewById(R.id.titulo);
        imagen = (ImageView) findViewById(R.id.imagen);
        descripcion = (TextView) findViewById(R.id.descripcion);
        recyclerViewgaleria = (RecyclerView) findViewById(R.id.galeria);

        /*imagen.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                getDialog().dismiss();
            }
        });*/
        recyclerViewgaleria.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        listaMenu = new Inici().listaMenu();
        adapter = new RecyclerAdapter(listaMenu, new RecyclerAdapter.OnclickRecycler() {
            @Override
            public void OnclickItemRecycler(Inici menu) {
                Glide.with(getBaseContext()).load(menu.getIdImagen()).into(imagen);
                titulo.setText(menu.getTitulo());
                descripcion.setText(menu.getDescripcion());
            }
        });
        recyclerViewgaleria.setAdapter(adapter);
    }

}
