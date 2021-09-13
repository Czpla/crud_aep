package com.czpla.crud;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateContatoOnClickListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {

        final Context context = view.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View formElementsView = inflater.inflate(R.layout.contato_form, null, false);

        final EditText editTextContatoNome = (EditText) formElementsView.findViewById(R.id.editTextContatoNome);
        final EditText editTextContatoEmail = (EditText) formElementsView.findViewById(R.id.editTextTextContatoEmail);

        new AlertDialog.Builder(context)
                .setView(formElementsView)
                .setTitle("Criar contato")
                .setPositiveButton("Incluir",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                // Regra para incluir contato
                                String contatoNome = editTextContatoNome.getText().toString();
                                String contatoEmail = editTextContatoEmail.getText().toString();

                                Contato contato = new Contato();
                                contato.setNome(contatoNome);
                                contato.setEmail(contatoEmail);

                                boolean criadoComSucesso = new ContatoController(context).create(contato);

                                if(criadoComSucesso) {
                                    Toast.makeText(context, "Contato incluido com sucesso!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(context, "Erro ao criar contato", Toast.LENGTH_SHORT).show();
                                }

                                dialogInterface.cancel();
                            }
                        }).show();
    }
}
