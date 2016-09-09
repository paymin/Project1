package id.sch.smktelkom_mlg.tugas01.xirpl1014.project1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText etEmail;
    Button bOk;
    TextView tvHasil, tvHasil2, tvHasil3;
    RadioGroup rgJumlah;
    Spinner spPaket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etEmail = (EditText) findViewById(R.id.editTextEmail);
        bOk = (Button) findViewById(R.id.buttonOk);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
        rgJumlah = (RadioGroup) findViewById(R.id.radioGroupJumlah);
        spPaket = (Spinner) findViewById(R.id.spinnerPaket);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
                doProcess2();
                doProcess3();
            }
        });

    }

    private void doProcess3() {
        StringBuilder builder = new StringBuilder();
        builder.append("Anda Memilih Paket ");
        builder.append(spPaket.getSelectedItem().toString());

        tvHasil3.setText(builder);
    }


    private void doProcess2() {
        String nama = etNama.getText().toString();
        String email = etEmail.getText().toString();
        tvHasil.setText("Hallo " + nama + " (" + email + ")");
    }

    private void doProcess() {

        String hasil = null;

        if (rgJumlah.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJumlah.getCheckedRadioButtonId());
            hasil = rb.getText().toString();

            if (rgJumlah.getCheckedRadioButtonId() == R.id.radioButtonG) {
                EditText Jumlah = (EditText) findViewById(R.id.editTextJumlah);
                hasil += "\nJumlah Anggota Grup : " + Jumlah.getText();
            }
        }

        if (hasil == null) {
            tvHasil2.setText("Belum memilih jumlah tiket");
        } else {
            tvHasil2.setText("Anda Akan Naik Gunung : " + hasil);
        }
    }

}
