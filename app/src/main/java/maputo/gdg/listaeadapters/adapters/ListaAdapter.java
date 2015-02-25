package maputo.gdg.listaeadapters.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import maputo.gdg.listaeadapters.R;

/**
 * Created by Mac on 2/25/2015.
 */
public class ListaAdapter extends BaseAdapter {

    private Context mContext;

    private String[] listaNomes;


    public ListaAdapter(Context context)
    {
        mContext = context;
    }

    public void setData(String[] nomes)
    {
        listaNomes = nomes;
    }

    @Override
    public int getCount() {

        //fazemos o return do tamanho do nosso array de nomes
        return listaNomes.length;
    }

    @Override
    public Object getItem(int position) {

        //fazemos o return do nome em uma certa posicao da lista
        return listaNomes[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //define o layoutInflater para desenhar o layout de cada linha da lista
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        ViewHolder viewHolder = null;

        if(convertView==null)
        {
            //desenha a view da linha da lista passando o ficheiro de layout
            convertView = inflater.inflate(R.layout.linha_lista_layout,parent,false);

            viewHolder = new ViewHolder(convertView);

            //guardamos a referencia ao viewholder e nao temos de re-fazer o findViewById sempre
            convertView.setTag(viewHolder);
        }

        else
        {
            //pegamos o objecto do view holder
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //faz o set do nome ao textview directament do view holder
        viewHolder.textView.setText(listaNomes[position]);

        //faz return da view para a linha da posicao
        return convertView;

    }

    //View Holder

    public class ViewHolder
    {
        public TextView textView;

        public ViewHolder(View view)
        {
            textView = (TextView) view.findViewById(R.id.nome);
        }
    }
}
