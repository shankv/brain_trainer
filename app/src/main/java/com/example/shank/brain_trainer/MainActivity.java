package com.example.shank.brain_trainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    Button startbutton,button,button1,button2,button3;
    ArrayList<Integer> answer =new ArrayList<>();
    int locofcorrect;
    int score=0;
    TextView resulttextView ,textView;
    TextView pointtextview;
    int noofques =0;
    TextView timertextview,palytextview;
    RelativeLayout relative;

    public void play(View view)
    {
        score=0;
        noofques=0;
        timertextview.setText("30s");
        pointtextview.setText("0/0");
        resulttextView.setText("");
        palytextview.setVisibility(View.INVISIBLE);
        gerate();
        new CountDownTimer(30100,1000)
        {

            @Override
            public void onTick(long l) {
                timertextview.setText(String.valueOf(l/1000)+"s");

            }

            @Override
            public void onFinish() {
                timertextview.setText("0s");
                resulttextView.setText("your score"+Integer.toString(score) + "/"+Integer.toString(noofques));
                palytextview.setVisibility(View.VISIBLE);
            }
        }.start();

    }
    public void gerate()
    {

        Random random =new Random();
        int a=random.nextInt(21);
        int b= random.nextInt(21);

        textView.setText(Integer.toString(a) + "+" + Integer.toString(b));

        locofcorrect = random.nextInt(4);
        answer.clear();

        int incorrectans;
        for(int i=0;i<4;i++)
        {
            if(i==locofcorrect)
            {
                answer.add(a+b);

            }
            else
            {
                incorrectans=(random.nextInt(41));
                while(incorrectans==a+b)
                {
                    incorrectans=(random.nextInt(41));
                }
                answer.add(incorrectans);
            }
        }

        button.setText(Integer.toString(answer.get(0)));
        button1.setText(Integer.toString(answer.get(1)));
        button2.setText(Integer.toString(answer.get(2)));
        button3.setText(Integer.toString(answer.get(3)));


    }
    public void start(View view)
    {
      startbutton.setVisibility(View.INVISIBLE);
      relative.setVisibility(View.VISIBLE);

    }

    public void chooseans(View view)
    {
       if(view.getTag().toString().equals(Integer.toString(locofcorrect))){
           score++;
            resulttextView.setText("correct");}
            else
        {
            resulttextView.setText("wrong");
        }

         noofques++;
        pointtextview.setText(Integer.toString(score) + "/"+Integer.toString(noofques));
        gerate();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
                startbutton=findViewById(R.id.button);
         textView=findViewById(R.id.ques);
         button=findViewById(R.id.button0);
         button1=findViewById(R.id.button1);
         button2=findViewById(R.id.button2);
         button3=findViewById(R.id.button3);
        resulttextView =findViewById(R.id.correctans);
        timertextview = findViewById(R.id.sec);
        palytextview =findViewById(R.id.playagain);
        pointtextview =findViewById(R.id.score);
        relative =findViewById(R.id.xxxx);
        play(findViewById(R.id.playagain));
    }
}
