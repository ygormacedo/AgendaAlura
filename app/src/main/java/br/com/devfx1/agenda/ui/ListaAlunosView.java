package br.com.devfx1.agenda.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import br.com.devfx1.agenda.dao.AlunoDAO;
import br.com.devfx1.agenda.model.Aluno;
import br.com.devfx1.agenda.ui.adapter.ListAlunosAdapter;

public class ListaAlunosView {

    private final ListAlunosAdapter adapter;
    private AlunoDAO dao;
    private final Context context;

    public ListaAlunosView(Context context) {
        this.context = context;
        this.adapter = new ListAlunosAdapter(this.context);
        this.dao = new AlunoDAO();
    }

    public void createDialog(final MenuItem item) {
        new AlertDialog
                .Builder(context)
                .setTitle("Removendo aluno")
                .setMessage("Tem certeza que quer remover aluno?")
                .setPositiveButton("Sim", (dialog, which) -> {
                    AdapterView.AdapterContextMenuInfo menuInfo =
                            (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    Object alunoEscolhido = adapter.getItem(menuInfo.position);
                    remove((Aluno) alunoEscolhido);
                })
                .setNegativeButton("Não", null)
                .show();
    }

    public void atualizaAlunos() {
        adapter.atualiza(dao.todos());
    }

    private void remove(Aluno aluno) {
        dao.remove(aluno);
        adapter.remove(aluno);
    }

    public void configuraAdapter(ListView listaDeAlunos) {

        listaDeAlunos.setAdapter(adapter);
    }


}
