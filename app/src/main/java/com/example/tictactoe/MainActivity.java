package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int activeplayer=0;
    boolean gameactive=true;
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    int[][] winpos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

        public void onClick(View view) {
            if(gameactive==true){
                ((ImageView)findViewById(R.id.imageView15)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView11)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView12)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView13)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView14)).setImageResource(0);
            }
        }




    public void Playertap(View view){
        ImageView img=(ImageView)view;
        int tappedimage=Integer.parseInt(img.getTag().toString());
        if(!gameactive){
            gamereset(view);
        }
        if(gamestate[tappedimage]==2 ){
            gamestate[tappedimage]=activeplayer;
            img.setTranslationY(-1000f);

            if(activeplayer==0 && gameactive==true){
                img.setImageResource(R.drawable.x);
                activeplayer=1;
                TextView status=findViewById(R.id.status);
                status.setText("2nd Player turn...");
            }
            else
            { if(gameactive==true)
                img.setImageResource(R.drawable.o);
                activeplayer=0;
                TextView status=findViewById(R.id.status);
                status.setText("1st Player turn...");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int[] winposition:winpos){
            if (gamestate[winposition[0] ]== gamestate[winposition[1]] &&
                    gamestate[winposition[1] ]== gamestate[winposition[2]] &&
                            gamestate[winposition[0]]!= 2) {
                            String winnerstr;
                            if(gamestate[winposition[0]]==0){
                                gameactive=false;
                                winnerstr="1st player has won!!!!!";
                                Toast.makeText(this, "Congratulations.....", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                gameactive=false;
                                winnerstr="2nd player has won!!!!!";
                                Toast.makeText(this, "Congratulations.....", Toast.LENGTH_SHORT).show();
                            }
                TextView status=findViewById(R.id.status);
                status.setText(winnerstr);

            }
        }

    }
public void gamereset(View view){
        gameactive=true;
        activeplayer=0;
        for(int i=0;i<gamestate.length;i++)
        {
            gamestate[i]=2;
        }


}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}