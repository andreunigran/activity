package br.unigran.hello.fragmento;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.unigran.hello.R;
import br.unigran.hello.crud.DBHelper;
import br.unigran.hello.crud.ProdutoDB;
import br.unigran.hello.domain.Produto;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadastroProduto#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastroProduto extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button btn;
    EditText nome;
    DBHelper db;
    public CadastroProduto() {
        // Required empty public constructor
    }

    public void setDb(DBHelper db) {
        this.db = db;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CadastroProduto.
     */
    // TODO: Rename and change types and number of parameters
    public static CadastroProduto newInstance(String param1, String param2) {
        CadastroProduto fragment = new CadastroProduto();
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
        View view= inflater.inflate(R.layout.fragment_cadastro_produto, container, false);
        btn=view.findViewById(R.id.idSalvarProduto);
       nome= view.findViewById(R.id.idNomeProduto);
        db=new DBHelper(getActivity());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

        return view;
    }

    private void salvar() {
        Produto p = new Produto();
        p.setNome(nome.getText().toString());
        new ProdutoDB(db).insert(p);
        Toast.makeText(getContext(),"Salvo",Toast.LENGTH_SHORT).show();
    }
}