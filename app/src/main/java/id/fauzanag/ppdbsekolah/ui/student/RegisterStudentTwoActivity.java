package id.fauzanag.ppdbsekolah.ui.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import id.fauzanag.ppdbsekolah.R;
import id.fauzanag.ppdbsekolah.helper.BaseApiService;
import id.fauzanag.ppdbsekolah.helper.RetrofitClient;
import id.fauzanag.ppdbsekolah.model.Data;
import id.fauzanag.ppdbsekolah.model.Region;
import id.fauzanag.ppdbsekolah.model.UniqueCode;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterStudentTwoActivity extends AppCompatActivity {

    private Spinner spinnerProv, spinnerKab, spinnerKec, spinnerKel;
    private Button btRegisterNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student_two);

        initView();
        loadUniqueCode();
        onClick();
    }

    private void initView() {
        spinnerProv = (Spinner) findViewById(R.id.spinProv);
        spinnerKab = (Spinner) findViewById(R.id.spinKab);
        spinnerKec = (Spinner) findViewById(R.id.spinKec);
        spinnerKel = (Spinner) findViewById(R.id.spinKel);
        btRegisterNext = (Button) findViewById(R.id.btn_RegisterTwo);
    }

    private void loadUniqueCode() {
        BaseApiService apiService = RetrofitClient.getClient().create(BaseApiService.class);
        Call<UniqueCode> call = apiService.getUniqueCode();

        call.enqueue(new Callback<UniqueCode>() {
            @Override
            public void onResponse(Call<UniqueCode> call, Response<UniqueCode> response) {
                String code = "MeP7c5ne" + response.body().getUniqueCode();
                loadProvinceList(code);
            }

            @Override
            public void onFailure(Call<UniqueCode> call, Throwable t) {

            }
        });

    }

    private void loadProvinceList(final String code) {
        BaseApiService apiService = RetrofitClient.getClient().create(BaseApiService.class);
        Call<Data> call =apiService.getProvinceList(code);

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {

                final List<Region> daftarProvinsi = response.body().getData();

                // masukkan daftar provinsi ke list string
                List<String> provs = new ArrayList<>();
                // isi data pertama dengan string 'Silakan Pilih!'
                provs.add(0, getString(R.string.txt_please_slct));
                for (int i = 0; i < daftarProvinsi.size(); i++) {
                    provs.add(daftarProvinsi.get(i).getName());
                }

                final ArrayAdapter<String> adapter = new ArrayAdapter<>(RegisterStudentTwoActivity.this,
                        android.R.layout.simple_spinner_item, provs);
                spinnerProv.setAdapter(adapter);

                spinnerProv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (!spinnerProv.getSelectedItem().toString().equals(getString(R.string.txt_please_slct))) {
                            long idProv = daftarProvinsi.get(position - 1).getId();
                            loadKabupatenList(code, idProv);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
    }

    public void loadKabupatenList(final String code, final long idProv) {
        spinnerKec.setAdapter(null);
        spinnerKel.setAdapter(null);
        BaseApiService apiService = RetrofitClient.getClient().create(BaseApiService.class);
        Call<Data> call = apiService.getKabupatenList(code, idProv);

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                final List<Region> daftarKabupaten = response.body().getData();

                // masukkan daftar kabupaten ke list string
                List<String> kabs = new ArrayList<>();
                // isi data pertama dengan string 'Silakan Pilih!'
                kabs.add(0, getString(R.string.txt_please_slct));
                for (int i = 0; i < daftarKabupaten.size(); i++) {
                    kabs.add(daftarKabupaten.get(i).getName());
                }

                // masukkan daftar kabupaten ke spinner
                final ArrayAdapter<String> adapter = new ArrayAdapter<>(RegisterStudentTwoActivity.this,
                        android.R.layout.simple_spinner_item, kabs);
                spinnerKab.setAdapter(adapter);

                spinnerKab.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (!spinnerKab.getSelectedItem().toString().equals(getString(R.string.txt_please_slct))) {
                            long idKab = daftarKabupaten.get(position - 1).getId();
                            loadKecamatanList(code, idKab);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
    }

    public void loadKecamatanList(final String code, long idKab) {
        spinnerKel.setAdapter(null);
        BaseApiService apiService = RetrofitClient.getClient().create(BaseApiService.class);
        Call<Data> call = apiService.getKecamatanList(code, idKab);

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                final List<Region> daftarKecamatan = response.body().getData();

                // masukkan daftar kecamatan ke list string
                List<String> kecs = new ArrayList<>();
                // isi data pertama dengan string 'Silakan Pilih!'
                kecs.add(0, getString(R.string.txt_please_slct));
                for (int i = 0; i < daftarKecamatan.size(); i++) {
                    kecs.add(daftarKecamatan.get(i).getName());
                }

                // masukkan daftar kecamatan ke spinner
                final ArrayAdapter<String> adapter = new ArrayAdapter<>(RegisterStudentTwoActivity.this,
                        android.R.layout.simple_spinner_item, kecs);
                spinnerKec.setAdapter(adapter);

                spinnerKec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (!spinnerKec.getSelectedItem().toString().equals(getString(R.string.txt_please_slct))) {
                            long idKec = daftarKecamatan.get(position - 1).getId();
                            loadKelurahanList(code, idKec);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
    }

    public void loadKelurahanList(final String code, final long idKec) {
        BaseApiService apiService = RetrofitClient.getClient().create(BaseApiService.class);
        Call<Data> call = apiService.getKelurahanList(code, idKec);

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                final List<Region> daftarKelurahan = response.body().getData();

                // masukkan daftar kelurahan ke list string
                List<String> kels = new ArrayList<>();
                // isi data pertama dengan string 'Silakan Pilih!'
                kels.add(0, getString(R.string.txt_please_slct));
                for (int i = 0; i < daftarKelurahan.size(); i++) {
                    kels.add(daftarKelurahan.get(i).getName());
                }

                // masukkan daftar kelurahan ke spinner
                final ArrayAdapter<String> adapter = new ArrayAdapter<>(RegisterStudentTwoActivity.this,
                        android.R.layout.simple_spinner_item, kels);
                spinnerKel.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
    }

    private void onClick() {
        btRegisterNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchToRegisterThree();
            }
        });
    }

    private void LaunchToRegisterThree() {
        Intent moveRegisterThree = new Intent(RegisterStudentTwoActivity.this, RegisterStudentThreeActivity.class);
        moveRegisterThree.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(moveRegisterThree);
    }
}
