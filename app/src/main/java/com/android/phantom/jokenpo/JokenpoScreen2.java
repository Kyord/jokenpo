package com.android.phantom.jokenpo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class JokenpoScreen2 extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "intent_message";
    private Button btn_stone;
    private Button btn_paper;
    private Button btn_scissor;

    private ImageView img_player;
    private ImageView img_bot;

    private TextView tv_player;
    private TextView tv_bot;
    private TextView tv_jkp_name;

    private int playerPoints = 0;
    private int botPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jokenpo_screen2);

        btn_stone = (Button) findViewById(R.id.btn_stone);
        btn_paper = (Button) findViewById(R.id.btn_paper);
        btn_scissor = (Button) findViewById(R.id.btn_scissor);

        img_player = (ImageView) findViewById(R.id.img_player);
        img_bot = (ImageView) findViewById(R.id.img_bot);

        tv_player = (TextView) findViewById(R.id.tv_player);
        tv_bot = (TextView) findViewById(R.id.tv_bot);

        tv_jkp_name = (TextView) findViewById(R.id.tv_jkp_name);
        tv_jkp_name.setText(getIntent().getStringExtra(this.EXTRA_MESSAGE));

        btn_stone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winnerChoice(playerTurn(1), botTurn());
            }
        });

        btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winnerChoice(playerTurn(2), botTurn());
            }
        });

        btn_scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winnerChoice(playerTurn(3), botTurn());
            }
        });
    }

    private int botTurn() {
        int botChoice = (int) (Math.random() * 3) + 1;

        if(botChoice == 1)
            img_bot.setImageResource(R.drawable.stone);
        else if(botChoice == 2)
            img_bot.setImageResource(R.drawable.paper);
        else if(botChoice == 3)
            img_bot.setImageResource(R.drawable.scissors);

        return botChoice;
    };

    private int playerTurn(int choice) {
        if(choice == 1)
            img_player.setImageResource(R.drawable.stone);
        else if(choice == 2)
            img_player.setImageResource(R.drawable.paper);
        else if(choice == 3)
            img_player.setImageResource(R.drawable.scissors);

        return choice;
    }

    private void playerWin() {
        tv_player.setText(String.valueOf(playerPoints++));
        Toast.makeText(getBaseContext(), "Player WON", Toast.LENGTH_SHORT).show();
    }

    private void playerLost() {
        tv_bot.setText(String.valueOf(botPoints++));
        Toast.makeText(getBaseContext(), "Computer WON", Toast.LENGTH_SHORT).show();
    }

    private void winnerChoice(int player, int bot) {
        if(player == bot) {
            Toast.makeText(getBaseContext(), "DRAW", Toast.LENGTH_SHORT).show();
        }

        //Pedra
        if(player == 1 && bot == 2) {//Pedra x Papel
            playerLost();
        } else if(player == 1 && bot == 3) {//Pedra x Tesoura
            playerWin();
        }

        //Papel
        if(player == 2 && bot == 1) {//Papel x Pedra
            playerWin();
        } else if(player == 2 && bot == 3) {//Papel x Tesoura
            playerLost();
        }

        //Tesoura
        if(player == 3 && bot == 1) {//Tesoura x Pedra
            playerLost();
        } else if(player == 3 && bot == 2) {//Tesoura x Papel
            playerWin();
        }
    }
}
