package com.example.androidstudio_day2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Creacion de array
    ArrayList<Question> questions = new ArrayList<>();

    private Button boton1;
    private Button boton2;
    private TextView textPregunta;
    private TextView texto_final;
    private int currentQuestionIndex = 0;
    private int score = 0;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillQuestionWhitData();
        updateQuestion();
        boton1 = findViewById(R.id.button1);
        boton2 = findViewById(R.id.button2);
        textPregunta = findViewById(R.id.text);
        texto_final = findViewById(R.id.final_text);


        //Asignar un listener al botón 1
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acciones que se ejecutan cuando se hace clic en el botón 1
                Toast.makeText(MainActivity.this, "¡Botón 1 pulsado!", Toast.LENGTH_SHORT).show();
            }
        });

        //Asignar un listener al botón 2
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acciones que se ejecutan cuando se hace clic en el botón 1
                Toast.makeText(MainActivity.this, "¡Botón 2 pulsado!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void fillQuestionWhitData(){
        questions.add(new Question("El número atómico del litio es 17",false,2));
        questions.add(new Question("La acrofobia es el miedo al ajo",true,1   ));
        questions.add(new Question("Marrakech es la capital de Marruecos",false,1));
        questions.add(new Question("Waterloo tiene el mayor número de andenes de metro de Londres",false,2));
        questions.add(new Question("M&M son las siglas de 'Mars y Moordale'",false,2));
        questions.add(new Question("Hay 219 episodios de 'Friends'",false,2));
        questions.add(new Question("El rugido de un león puede oírse hasta a ocho kilómetros de distancia.",true,3));
        questions.add(new Question("La batalla de Hastings tuvo lugar en 1066",true,2));
        questions.add(new Question("'Canis lupur' es el nombre científico del lobo",false,1));
        questions.add(new Question("El verdadero nombre de Madonna es Madonna",true,2));
    }

    public void updateQuestion(){
        Question myQuestion = questions.get(currentQuestionIndex);
        String questionTitle = myQuestion.getQuestionTitle();
        textPregunta.setText(questionTitle);
    }

    public void checkQuestion(boolean useranswer) {
        boolean endgame = false;
        while (endgame = false) {

            if (questions.get(currentQuestionIndex).answerIsTrue() == useranswer) {
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                score += questions.get(currentQuestionIndex).getPoints();
            } else {
                Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Sorry, the answer is 'correct' ", Toast.LENGTH_SHORT).show();
            }
            currentQuestionIndex++;
            if (currentQuestionIndex == questions.size()) {
                currentQuestionIndex = 0;
                endgame = true;
            }



            updateQuestion();
        }
        texto_final.setText("Enhorabuena! Has completado el juego con " + score + " puntos");
    }
}