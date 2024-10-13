package br.edu.fateczl.professor;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.edu.fateczl.professor.model.ProfessorHorista;
import br.edu.fateczl.professor.model.ProfessorTitular;

/*
 *@author:<Gustavo de Paula>
 */
public class MainActivity extends AppCompatActivity {

    private TextView tvSaida;
    private RadioButton rbTitular, rbHorista;
    private Button btnCalc;
    private EditText etNome, etMatricula, etIdade, etAnosHoras, etSalarioValor;
    private RadioGroup rgTipo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvSaida = findViewById(R.id.tvSaida);
        rbTitular = findViewById(R.id.rbTitular);
        rbHorista = findViewById(R.id.rbHorista);
        rbHorista.setChecked(true);
        btnCalc = findViewById(R.id.btnCalc);
        etNome = findViewById(R.id.etNome);
        etMatricula = findViewById(R.id.etMatricula);
        etIdade = findViewById(R.id.etIdade);
        etAnosHoras = findViewById(R.id.etAnosHoras);
        etSalarioValor = findViewById(R.id.etSalarioValor);
        rgTipo = findViewById(R.id.rgTipo);

        rgTipo.setOnCheckedChangeListener((group, checkedId)-> {
            if (checkedId == R.id.rbTitular) {
                etAnosHoras.setHint(R.string.etAnos);
                etSalarioValor.setHint(R.string.salario);
            } else {
                etAnosHoras.setHint(R.string.etHorasAula);
                etSalarioValor.setHint(R.string.etValorHA);
            }
            etAnosHoras.setText("");
            etSalarioValor.setText("");
        });
        btnCalc.setOnClickListener(op -> calc());



    }
    private void calc(){
        if (rbTitular.isChecked()) {
            ProfessorTitular pt = new ProfessorTitular();
            pt.setNome(etNome.getText().toString());
            pt.setMatricula(etMatricula.getText().toString());
            pt.setIdade(Integer.parseInt(etIdade.getText().toString()));
            pt.setAnosInstituicao(Integer.parseInt(etAnosHoras.getText().toString()));
            pt.setSalario(Double.parseDouble(etSalarioValor.getText().toString()));
            tvSaida.setText(getString(R.string.saida)+ pt.calcSalario());
        } else {
            ProfessorHorista ph = new ProfessorHorista();
            ph.setNome(etNome.getText().toString());
            ph.setMatricula(etMatricula.getText().toString());
            ph.setIdade(Integer.parseInt(etIdade.getText().toString()));
            ph.setHorasAula(Integer.parseInt(etAnosHoras.getText().toString()));
            ph.setValorHoraAula(Double.parseDouble(etSalarioValor.getText().toString()));
            tvSaida.setText(getString(R.string.saida) + ph.calcSalario());
        }

    }
}