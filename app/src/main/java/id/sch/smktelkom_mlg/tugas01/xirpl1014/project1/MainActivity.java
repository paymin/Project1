package id.sch.smktelkom_mlg.tugas01.xirpl1014.project1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText etNama, etEmail, etJumlah;
    Button bOk;
    TextView tvHasil, tvHasil2, tvHasil3, tvHasil4;
    RadioGroup rgJumlah;
    Spinner spPaket;
    CheckBox cbT, cbN, cbP;
    RadioButton rbS, rbB, rbG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etEmail = (EditText) findViewById(R.id.editTextEmail);
        etJumlah = (EditText) findViewById(R.id.editTextJumlah);
        bOk = (Button) findViewById(R.id.buttonOk);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
        tvHasil4 = (TextView) findViewById(R.id.textViewHasil4);
        rgJumlah = (RadioGroup) findViewById(R.id.radioGroupJumlah);
        spPaket = (Spinner) findViewById(R.id.spinnerPaket);
        rbS = (RadioButton) findViewById(R.id.radioButtonS);
        rbB = (RadioButton) findViewById(R.id.radioButtonB);
        rbG = (RadioButton) findViewById(R.id.radioButtonG);
        cbN = (CheckBox) findViewById(R.id.checkBoxN);
        cbT = (CheckBox) findViewById(R.id.checkBoxT);
        cbP = (CheckBox) findViewById(R.id.checkBoxP);

        rgJumlah.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioButtonG) {
                    findViewById(R.id.jumlah).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.jumlah).setVisibility(View.GONE);
                }
            }
        });



        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
                doProcess2();
                doProcess3();
                doProcess4();
            }
        });
    }

    private void doProcess4() {
        String hasil = "Perlengkapan yang anda perlukan :\n";
        int startlen = hasil.length();
        if (cbP.isChecked()) hasil += cbP.getText() + "\n";
        if (cbN.isChecked()) hasil += cbN.getText() + "\n";
        if (cbT.isChecked()) hasil += cbT.getText() + "\n";

        if (hasil.length() == startlen) hasil += " (Tidak memerlukan pinjaman perlengkapan) ";

        tvHasil4.setText(hasil);
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
        tvHasil.setText("Hallo " + nama + "asal dari" + email);
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
