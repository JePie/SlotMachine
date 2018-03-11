package com.example.jackhuang.slotmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Player
    private int playerAmount = 300;
    private TextView pBalance;

    //Player Bet
    private int bet = 0;
    private TextView playerBet;

    //Jackpot
    private int jackpot = 99999;
    private TextView jpTxt;

    //Slots
    private ImageView Slot1;
    private ImageView Slot2;
    private ImageView Slot3;

    //1,2,5,10,20,100 bet buttons
    private Button[] betButton = new Button[6];

    //handles if there are no more funds
    private boolean fundsAvailable = false;
    private TextView noFunds;

    private int play = 0;
    private int win = 0;
    private boolean isWin = false;
    private int setWin;
    private Button spinButton;



    static int DRAWABLE_ID[] =
    {

            R.drawable.ic_grapes,
            R.drawable.ic_watermeloin,
            R.drawable.ic_luckyseven
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pBalance = findViewById(R.id.playerAmount);
        pBalance.setText("Player Amount: " + playerAmount);
        jpTxt = findViewById(R.id.currentJackpot);
        jpTxt.setText("Jackpot: " + jackpot);

        Slot1 = findViewById(R.id.slot1);

        Slot2 = findViewById(R.id.slot2);

        Slot1 = findViewById(R.id.slot3);

        //Beginning of buttons
        Button quit = findViewById(R.id.QuitBtn);
        quit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                finish();
            }
        });



        Button reset = findViewById(R.id.Reset);
        reset.setOnClickListener(new View.OnClickListener()
                                 {

                                 }
        );
    }
}
