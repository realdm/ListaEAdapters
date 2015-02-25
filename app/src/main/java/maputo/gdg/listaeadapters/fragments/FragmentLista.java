package maputo.gdg.listaeadapters.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import maputo.gdg.listaeadapters.R;
import maputo.gdg.listaeadapters.activity.Segunda;
import maputo.gdg.listaeadapters.adapters.ListaAdapter;

/**
 * Created by Mac on 2/25/2015.
 */
public class FragmentLista extends Fragment {

    private ListView mLista;

    private ListaAdapter adapter;

    private String[] listaNomes=
            {
                    "Dario ICS",
                    "Paulo HoneyComb",
                    "Mariano Froyo",
                    "Martin Jelly Bean",
                    "Edson Kit",
                    "Marry Kat",
                    "Paula LoliPop",
                    "John Doe",
                    "Chuck Norris"

            };
    private static final String CHAVE_NOME="nome";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Desenhamos uma nova view utilizando o inflater e passando o ficheiro de layout
        View view = inflater.inflate(R.layout.lista_fragment_layout,container,false);

        //mapeamos a instancia do listview ao widget no xml pelo seu id
        //lembre-se que se fizer (ListView) findViewById nao ira funcionar pois este metodo pertence a uma view
        mLista = (ListView)view.findViewById(R.id.listView);

        //definir o adapter para a lista

        mLista.setAdapter(adapter);

        //definir o listener de clique a lista
        mLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //pega o item do adapter na posicao passada
                String nome = (String) parent.getItemAtPosition(position);

                //cria intent e passa argumentos

                Intent i = new Intent(getActivity(), Segunda.class);

                i.putExtra(CHAVE_NOME,nome);

                startActivity(i);

            }
        });

        //fazer o return da view

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ListaAdapter(getActivity().getApplicationContext());

        adapter.setData(listaNomes);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
