package br.com.devfx1.agenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.devfx1.agenda.R;
import br.com.devfx1.agenda.model.Aluno;

public class ListAlunosAdapter extends BaseAdapter {
    private final List<Aluno> alunos = new ArrayList<>();
    private final Context context;

    public ListAlunosAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        View createView = createViewInflate(viewGroup);
        Aluno alunoDevolvido = alunos.get(position);
        vinculaView(createView, alunoDevolvido);
        return createView;
    }

    private void vinculaView(View view, Aluno alunoView) {
        TextView name = view.findViewById(R.id.item_aluno);
        name.setText(alunoView.getNome());
        TextView telephone = view.findViewById(R.id.item_telephone);
        telephone.setText(alunoView.getTelefone());
    }

    private View createViewInflate(ViewGroup viewGroup) {
        return LayoutInflater.from(context)
                .inflate(R.layout.item_aluno, viewGroup, false);
    }

    public void atualiza(List<Aluno> alunos){
        this.alunos.clear();
        this.alunos.addAll(alunos);
        notifyDataSetChanged();
    }

    public void remove(Aluno aluno) {
        alunos.remove(aluno);
        notifyDataSetChanged();
    }
}
