package com.example.mobile;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ActivityPrincipal extends AppCompatActivity {
    private EditText etRecipeName;
    private EditText etIngredients;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receitas);

        etRecipeName = findViewById(R.id.et_recipe_name);
        etIngredients = findViewById(R.id.et_ingredients);
        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recipeName = etRecipeName.getText().toString();
                String ingredients = etIngredients.getText().toString();

                if (!recipeName.isEmpty() && !ingredients.isEmpty()) {
                    new SendRecipeTask().execute(recipeName, ingredients);
                } else {
                    Toast.makeText(ActivityPrincipal.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private class SendRecipeTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            String recipeName = params[0];
            String ingredients = params[1];

            try {
                URL url = new URL("https://sua-api.com/receitas"); // Substitua pela URL da sua API
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                conn.setDoOutput(true);

                JSONObject recipeData = new JSONObject();
                recipeData.put("nome", recipeName);
                recipeData.put("ingredientes", ingredients);

                OutputStream os = conn.getOutputStream();
                os.write(recipeData.toString().getBytes("UTF-8"));
                os.close();

                int responseCode = conn.getResponseCode();
                return responseCode == HttpURLConnection.HTTP_OK;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (success) {
                Toast.makeText(ActivityPrincipal.this, "Receita enviada com sucesso!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ActivityPrincipal.this, "Erro ao enviar receita. Tente novamente.", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
