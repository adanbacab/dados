package com.example.eadadel.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DadosDeadOfWinterFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DadosDeadOfWinterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DadosDeadOfWinterFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private final int DOW = 1;

    private Button buttonlanzarDadoDOW;

    private ImageView imageViewDadoRiesgo;
    private TextView textViewresultadoDadoRiesgo;

    private final int caras = 12;

    public DadosDeadOfWinterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DadosDeadOfWinterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DadosDeadOfWinterFragment newInstance(String param1, String param2) {
        DadosDeadOfWinterFragment fragment = new DadosDeadOfWinterFragment();
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
        View view = inflater.inflate(R.layout.fragment_dados_dead_of_winter, container, false);
        buttonlanzarDadoDOW = view.findViewById(R.id.buttonlanzarDadoDOW);
        imageViewDadoRiesgo = view.findViewById(R.id.imageViewDadoRiesgo);
        textViewresultadoDadoRiesgo = view.findViewById(R.id.textViewresultadoDadoRiesgo);

        buttonlanzarDadoDOW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "Dados Lanzados", Toast.LENGTH_SHORT).show();

                final Dado dado = new Dado(caras);
                asignarImagen(imageViewDadoRiesgo,dado.getResultadoNumerico());
                textViewresultadoDadoRiesgo.setText(Integer.toString(dado.getResultadoNumerico()));

                //imageButtonDadoRiesgo.setBackground();
                //imageButtonDadoRiesgo = dado.getDado();

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


    private void asignarImagen(ImageView imageViewResultado,int resultadoNumerico){
        switch (resultadoNumerico){
            case 1://DIENTE
                imageViewResultado.setBackground(getContext().getDrawable(R.drawable.diente));
                break;
            case 4: //CONGELACION
            case 8: //CONGELACION
                imageViewResultado.setBackground(getContext().getDrawable(R.drawable.congelacion));
                break;
            case 6: //HERIDA
            case 10: //HERIDA
                imageViewResultado.setBackground(getContext().getDrawable(R.drawable.herida));
                break;
            case 2: //FRACASO
            case 3: //FRACASO
            case 5: //FRACASO
            case 7: //FRACASO
            case 9: //FRACASO
            case 11: //FRACASO
            case 12: //FRACASO
                imageViewResultado.setBackground(getContext().getDrawable(R.drawable.fracaso));
                break;
        }
    }
}
