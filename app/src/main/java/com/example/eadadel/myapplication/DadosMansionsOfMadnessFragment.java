package com.example.eadadel.myapplication;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DadosMansionsOfMadnessFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DadosMansionsOfMadnessFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DadosMansionsOfMadnessFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private final int MOM = 2;
    private final int carasDado = 8;

    private OnFragmentInteractionListener mListener;

    private Button buttonQuitarDado;
    private Button buttonLanzarDado;
    private Button buttonAgregarDado;

    ConstraintLayout constraintLayoutTiradasNumero;

    private TextView textViewNumeroDados;
    private TextView textViewResultadoFallos;
    private TextView textViewResultadoPistas;
    private TextView textViewResultadoExitos;

    private GridView gridViewTiradas;
    private AdaptadorGrid adaptador;

    List<Dado> listaDados;

    private int numeroDeDados = 1;

    private final int EXITO = 1;
    private final int PISTA = 0;
    private final int FRACASO = -1;

    private int cantidadExitos = 0;
    private int cantidadPistas = 0;
    private int cantidadFracasos = 0;


    public DadosMansionsOfMadnessFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DadosMansionsOfMadnessFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DadosMansionsOfMadnessFragment newInstance(String param1, String param2) {
        DadosMansionsOfMadnessFragment fragment = new DadosMansionsOfMadnessFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dados_mansions_of_madness,container,false);

        gridViewTiradas = view.findViewById(R.id.gridViewTiradas);

        buttonQuitarDado = view.findViewById(R.id.buttonQuitarDado);
        buttonLanzarDado = view.findViewById(R.id.buttonLanzarDado);
        buttonAgregarDado = view.findViewById(R.id.buttonAgregarDado);
        textViewNumeroDados = view.findViewById(R.id.textViewNumeroDados);
        //linearLayoutTiradas = findViewById(R.id.linearLayoutTiradas);
        constraintLayoutTiradasNumero = view.findViewById(R.id.constraintLayoutTiradasNumero);

        textViewResultadoExitos = view.findViewById(R.id.textViewResultadoExitos);
        textViewResultadoPistas = view.findViewById(R.id.textViewResultadoPistas);
        textViewResultadoFallos = view.findViewById(R.id.textViewResultadoFallos);

        listaDados = new ArrayList<>();

        buttonQuitarDado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quitarDados();
                actualizarNumeroDados();
            }
        });
        buttonAgregarDado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarDados();
                actualizarNumeroDados();
            }
        });


        buttonLanzarDado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Dados Lanzados", Toast.LENGTH_SHORT).show();
                limpiarLayout();
                for (int i=0; i < numeroDeDados; i++){
                    //final Dado dado = new Dado(getContext(),MOM );
                    final Dado dado = new Dado(carasDado);

                    //linearLayoutTiradas.addView(dado.getDado());
                    TextView textviewDigitoTirada = new TextView(view.getContext());
                    textviewDigitoTirada.setText(String.valueOf(dado.getResultadoNumerico()));
                    textviewDigitoTirada.setLayoutParams(
                            new LinearLayout.LayoutParams(
                                    LinearLayout.LayoutParams.WRAP_CONTENT,
                                    LinearLayout.LayoutParams.MATCH_PARENT
                            )
                    );
                    constraintLayoutTiradasNumero.addView(textviewDigitoTirada);
                    //constraintLayoutTiradasNumero.addView(dado.getTextViewResultadoNumerico());
                    listaDados.add(dado);
                }
                actualizarResultados();
            }
        });

        adaptador = new AdaptadorGrid(getContext(),listaDados);
        gridViewTiradas.setAdapter(adaptador);
        adaptador.notifyDataSetChanged();

        gridViewTiradas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Dado Relanzado", Toast.LENGTH_SHORT).show();
                Dado dado = (Dado) adaptador.getItem(position);
                dado.lanzarDado();
                actualizarResultados();
                adaptador.notifyDataSetChanged();
            }
        });



        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void agregarDados() {
        numeroDeDados++;
    }

    private void quitarDados() {
        if (numeroDeDados <=1){
            return;
        }else{
            numeroDeDados--;
            return;
        }
    }

    private void actualizarNumeroDados() {
        if (numeroDeDados == 1){
            textViewNumeroDados.setText(numeroDeDados + " dado");
        }else{
            textViewNumeroDados.setText(numeroDeDados + " dados");
        }
    }

    private void limpiarLayout() {
        //gridViewTiradas.removeAllViews();
        cantidadFracasos= cantidadExitos = cantidadPistas = 0;
        constraintLayoutTiradasNumero.removeAllViews();
        listaDados.clear();
        adaptador.notifyDataSetChanged();
    }


    private void actualizarResultados() {
        cantidadExitos = cantidadPistas = cantidadFracasos = 0;

        for (Dado dado :listaDados) {
            switch (Valores.obtenerEFP(dado.getResultadoNumerico())){
                case Valores.EXITO:
                    cantidadExitos ++;
                    break;
                case Valores.PISTA:
                    cantidadPistas++;
                    break;
                case Valores.FRACASO:
                    cantidadFracasos++;
                    break;
            }
            /*switch (dado.getResultadoEPF()){
                case EXITO:
                    cantidadExitos ++;
                    break;
                case PISTA:
                    cantidadPistas++;
                    break;
                case FRACASO:
                    cantidadFracasos++;
                    break;
            }*/
        }
        textViewResultadoExitos.setText(cantidadExitos + "");
        textViewResultadoPistas.setText(cantidadPistas + "");
        textViewResultadoFallos.setText(cantidadFracasos + "");
    }




}
