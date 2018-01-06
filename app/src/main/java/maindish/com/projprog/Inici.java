package maindish.com.projprog;


import java.util.ArrayList;

/**
 * Created by Dunya on 05/01/2018.
 */

public class Inici {
    private int idImagen;
    private String titulo;
    private String descripcion;
    public Inici() {
        this.idImagen = 0;
        this.titulo = "";
        this.descripcion = "";
    }
    public Inici(int idImagen, String titulo, String descripcion) {
        this.idImagen = idImagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }


    public int getIdImagen() {
        return idImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public ArrayList<Inici>listaMenu(){
        Inici menu;
        ArrayList<Inici> lista = new ArrayList<Inici>();
        Integer[]idImagenes=new Integer[]{R.drawable.r1,R.drawable.r2,R.drawable.r3,R.drawable.r4,R.drawable.r5,R.drawable.r6};
        String[]titulos=new String[]{"Musaka vegetal gratinada","Espirales de Nutella","Alcachofas en escabeche con aroma de tomillo","Tortitas"
                +" americanas rellenas de chocolate","Pan de Jamón","Bocaditos de almendra"};
        String[]descripciones=new String[]{"4 per. 75 min. 390 cal.\n" +
                "\n" + "Ingredientes"+
                "\n" +
                "4 berenjenas\n" +
                "1 cebolla\n" +
                "5 tomates\n" +
                "Unas hojas de albahaca\n" +
                "Aceite de oliva y sal\n" +
                "Orégano\n" +
                "40 g de harina\n" +
                "Mantequilla\n" +
                "400 ml de leche","Ingredientes para 30 galletas\n" +
                "\n" +
                "230 gramos de mantequilla a temperatura ambiente.\n" +
                "1 clara de huevo\n" +
                "2 cucharadas de esencia de vainilla.\n" +
                "230 gramos de azúcar glass\n" +
                "400 gramos de harina\n" +
                "50 gramos de Maizena\n" +
                "1 cucharadita de sal.","4 per. 40 min.\n" +
                "\n" + "Ingredientes"+
                "8 alcachofas\n" +
                "1 cebolla roja\n" +
                "1 limón\n" +
                "½ pimiento rojo\n" +
                "Sal\n" +
                "2 zanahorias\n" +
                "Pimienta\n" +
                "3 cucharadas de vinagre de Jerez\n" +
                "2 dientes de ajo\n" +
                "4 cucharadas de aceite de oliva\n" +
                "Tomillo fresco","Ingredientes:(para 8-10 unidades)\n" +
                "\n" +
                "\n" +
                "Para las tortitas:\n" +
                "\n" +
                "200 gr. de harina\n" +
                "250 ml. leche entera\n" +
                "2 huevos M\n" +
                "1 cucharada de azúcar\n" +
                "1 1/4 cucharadita de levadura química (polvos de hornear)\n" +
                "3 cucharadas de aceite de girasol","Ingredientes\n" +
                "3/4 taza de leche evaporada baja en grasa NESTLÉ CARNATION Evaporated Lowfat 2% Milk\n" +
                "1/4 taza (1/2 barra) de mantequilla\n" +
                "2 cucharadas de azúcar granulada\n" +
                "1 cucharadita de MAGGI Caldo Sabor a Pollo\n" +
                "1/4 taza de agua tibia (110° F)\n" +
                "1 paquete (7 gramos) de levadura activa seca\n" +
                "3 tazas de harina para todo uso\n" +
                "2 huevos grandes, batido, uso dividido\n" +
                "1/2 libra de jamón en rebanadas\n" +
                "1/2 taza de pasas\n" +
                "3/4 taza de aceitunas enteras rellenas de pimiento","Ingredientes:)\n"+"170 gr. de almendra cruda molida\n" +
                "150 gr. de azúcar\n" +
                "2 huevos\n" +
                "1 yema de huevo\n" +
                "la ralladura de 1 limón\n" +
                "el zumo de medio limón\n" +
                "1 cucharada de mantequilla."};
        for(int i = 0; i<idImagenes.length;i++){
            menu = new Inici(idImagenes[i],titulos[i],descripciones[i]);
            lista.add(menu);
        }
        return lista;
    }
}