package com.labs.josemanuel.cityhacks.Ui;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.labs.josemanuel.cityhacks.Adapters.AdaptadorPropuestasRecycler;
import com.labs.josemanuel.cityhacks.Model.PropuestasPOJOModel;
import com.labs.josemanuel.cityhacks.R;
import com.labs.josemanuel.cityhacks.Utils.PropuestasUtils;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

/**
 * Fragmento principal que contiene la lista de las metas
 */
public class MainFragment extends Fragment {


    private ProgressBar spinner;
    protected SwipeRefreshLayout mSwipeRefreshLayout;


    private TextView emptyFeedTextView;

    /*
    Etiqueta de depuracion
     */
    private static final String TAG = MainFragment.class.getSimpleName();

    /*
    Instancia global del recycler view
     */
    private RecyclerView recicladorlista;

    /*
    instancia global del administrador
     */
    private RecyclerView.LayoutManager lManager;





    public MainFragment() {

    }


    // onCreateView -----------------------------------------------------
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.content_main, container, false);

       // recicladorlista = (RecyclerView) v.findViewById(R.id.reciclador);


        // Usar un administrador para LinearLayout
        //lManager = new LinearLayoutManager(getActivity());
        //recicladorlista.setLayoutManager(lManager);


       // List<PropuestasPOJOModel> propuestaslList =
       //    PropuestasUtils.getDataSet(MainFragment.this.getContext());

      //  AdaptadorPropuestasRecycler adapter =
      //      new AdaptadorPropuestasRecycler(propuestaslList, MainFragment.this.getContext());

      //  recicladorlista.setAdapter(adapter);
       // recicladorlista.setHasFixedSize(true);



        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.reciclador);
        List<PropuestasPOJOModel> propuestaslList =
                PropuestasUtils.getDataSet(getContext());
        AdaptadorPropuestasRecycler adapter =
                new AdaptadorPropuestasRecycler(propuestaslList, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        // LinearLayout para que se mueste en fila y no en grilla
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());











        // Obtener instancia del FAB
        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar actividad de inserción
               /* getActivity().startActivityForResult(
                        new Intent(getActivity(), InsertActivity.class), 3);*/
            }
        });

        emptyFeedTextView = (TextView) v.findViewById(R.id.empty_view);



        // oculta el progressBar
        spinner = (ProgressBar) v.findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);
        mSwipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.SwipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(mOnRefreshListener);


        return v;


    } // fin onCreateView




    // añadido
    @Override
    public void onResume() {
        super.onResume();
      //  cargarAdaptador();
    }



    // Listener de SwipeRefresh con cambio de color durante el progreso
    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
          //  loadProposalFeed();
            Toast.makeText(getContext(), "Refrescando...", Toast.LENGTH_SHORT).show();
            mSwipeRefreshLayout.setColorSchemeResources(

                    R.color.colorPrimary,
                    R.color.btn_Twitter_normal,
                    R.color.movilityColor,
                    R.color.colorAccent

            );

        }

    };


}
