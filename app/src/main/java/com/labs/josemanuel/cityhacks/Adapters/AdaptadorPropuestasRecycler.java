package com.labs.josemanuel.cityhacks.Adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.labs.josemanuel.cityhacks.Model.PropuestasPOJOModel;
import com.labs.josemanuel.cityhacks.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by josem on 25/09/2016.
 */


public class AdaptadorPropuestasRecycler extends RecyclerView.Adapter<AdaptadorPropuestasRecycler.ViewHolder> {

    private List<PropuestasPOJOModel> elements;
    private Context context;
    private TypedArray drawerListIcons;

    /**
     * El constructor de nuestro a adaptador, recibe la lista de datos que corresponde a una lista de
     * objetos tipo PropuestasPOJOModel que nos representa la información de una tarjeta.
     */
    public AdaptadorPropuestasRecycler(List<PropuestasPOJOModel> elements, Context context, TypedArray drawerListIcons) {
        this.elements = elements;
        this.context = context;
        this.drawerListIcons = drawerListIcons;
    }

    public AdaptadorPropuestasRecycler(List<PropuestasPOJOModel> elements, Context context) {
        this.elements = elements;
        if (this.elements == null) {
            this.elements = new ArrayList<>();
        }
        this.context = context;
        drawerListIcons = context.getResources().obtainTypedArray(R.array.array_fotospropuestas);
    }

    /**
     * El método OnCreateViewHolder, es dónde vamos a inflar nuesto layout y vamos a crear el ViewHolder.
     */
    @Override
    public AdaptadorPropuestasRecycler.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // Inflamos la vista que correspode a la tarjeta.
        View rowCard = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_lista_propuestas, viewGroup, false);
        // Creamos el holder
        ViewHolder holder = new ViewHolder(rowCard);
        return holder;
    }

    /**
     * En el método OnBindViewHolder, lo que se hace es asignar los datos que va a tener
     * nuestra fila, por eso recibe también la posición para poder coger el elemento y
     * ponerle datos a la tarjeta.
     *
     * @param viewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(AdaptadorPropuestasRecycler.ViewHolder viewHolder, int i) {
        // Configuramos los datos del dataSet.
        // La imagen la traemos del string array y cogemos la posición
        PropuestasPOJOModel pojoModel = this.elements.get(i);
        int fotoId = this.drawerListIcons.getResourceId(pojoModel.getFoto(), 0);

        viewHolder.viewFoto.setImageResource(fotoId);
        viewHolder.viewTitle.setText(pojoModel.getTitulo());
        viewHolder.viewUbicacion.setText(pojoModel.getUbicacion());
        viewHolder.viewBody.setText(pojoModel.getBodycomment());
        viewHolder.viewFecha.setText(pojoModel.getFecha());
        viewHolder.viewEstado.setText(pojoModel.getStatus());
//      viewHolder.viewFlagState.setImageDrawable(drawerListIcons.getDrawable(i));

    }

    /**
     * El método getItemCount debe retornar el tamaño de la lista para que el activity sepa cuántos elementos debe mostrar.
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return elements.size();
    }


    /**
     * La clase interna ViewHolder es un contenedor de nuestra fila, es decir del layout donde creamos la fila.
     * En el constructor de esta clase se asocian los elementos de la vista, con objetos java.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // Referencias UI
        public TextView viewTitle;
        public TextView viewUbicacion;
        public TextView viewBody;
        public ImageView viewFoto;
        public TextView viewFecha;
        public TextView viewEstado;
        public ImageView viewFlagState;
        public FloatingActionButton viewFabFollow;

        public ViewHolder(View itemView) {
            super(itemView);

            viewTitle = (TextView) itemView.findViewById(R.id.titulo);
            viewUbicacion = (TextView) itemView.findViewById(R.id.ubicacion);
            viewBody = (TextView) itemView.findViewById(R.id.descripcion);
            viewFoto = (ImageView) itemView.findViewById(R.id.foto);
            viewFecha = (TextView) itemView.findViewById(R.id.fecha);
            viewEstado = (TextView) itemView.findViewById(R.id.categoria);
            viewFlagState = (ImageView) itemView.findViewById(R.id.status_flag);
            viewFabFollow = (FloatingActionButton) itemView.findViewById(R.id.btnFollow);


            itemView.setOnClickListener(this);
            // Boton Follow
            viewFabFollow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*Intent goMain = new Intent(contexto, MapsActivity.class);
                    contexto.startActivity(goMain);*/
                    //Toast.makeText(context, contexto.getResources().getString(R.string.addFavoritos), Toast.LENGTH_SHORT).show();
                }
            });
        }


        //POR IMPLEMENTAR. INTENT AL DETALLE DE LA PROPUESTA SELECCIONADA
        @Override
        public void onClick(View view) {
           /* Infrastructure.setPropuestaSeleccionada(obtenerPropuesta(getAdapterPosition()));
            Infrastructure.setComentarioSeleccionada(obtenerPropuesta(getAdapterPosition()).getCom());
            DetailActivity.launch(
                    (Activity) contexto, obtenerNid(getAdapterPosition()));*/
        }

       /* //Identificador de la propuesta
        private String obtenerNid(int posicion) {
            if (propuestas != null) {
                return propuestas[posicion].getNid();
            }
            return null;
        }

        private Propuesta obtenerPropuesta(int posicion) {
            if (propuestas != null) {
                return propuestas[posicion];
            }
            return null;
        }*/
    }


}
