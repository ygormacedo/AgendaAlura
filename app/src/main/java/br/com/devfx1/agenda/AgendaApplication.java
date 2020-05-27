package br.com.devfx1.agenda;

import android.app.Application;

import br.com.devfx1.agenda.dao.AlunoDAO;
import br.com.devfx1.agenda.model.Aluno;

public class AgendaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        createAlunosTest();

    }

    private void createAlunosTest() {
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Alex", "1122223333", "alex@alura.com.br"));
        dao.salva(new Aluno("Fran", "1122223333", "fran@gmail.com"));
    }
}
