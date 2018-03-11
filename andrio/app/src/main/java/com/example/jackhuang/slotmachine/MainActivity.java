package com.example.jackhuang.slotmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Player
    private int playerAmount = 300;
    private TextView pBalance;

    //Player Bet
    private int bet = 1;
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

    private TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pBalance = findViewById(R.id.playerAmount);
        pBalance.setText("Player Amount: " + playerAmount);

        jpTxt = findViewById(R.id.currentJackpot);
        jpTxt.setText("Jackpot: " + jackpot);

        msg = findViewById(R.id.msg);

        Slot1 = findViewById(R.id.slot1);

        Slot2 = findViewById(R.id.slot2);

        Slot3 = findViewById(R.id.slot3);

        //Beginning of buttons
        Button quit = findViewById(R.id.QuitBtn);
        quit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                ifcanspin();
            }
        });



        Button reset = findViewById(R.id.Reset);
        reset.setOnClickListener(new View.OnClickListener()
                                 {
                                     public void onClick(View v){
                                         bet = 0;
                                         playerBet.setText("Bet: " +bet);
                                         msg.setText("");
                                         spinButton.setEnabled(true);
                                     }
                                 });

    }
    public void ifcanspin(){
        if(bet == 0)
        msg.setText("you have to place a bet");
        if(fundsAvailable && playerAmount >= bet && bet>0){
            runSpin();
        }
        else if (bet>0){
            msg.setText("No more Money");

        }
    }
    public void runSpin(){
        int chance1 = new Random().nextInt(3);
        int chance2 = new Random().nextInt(3);
        int chance3 = new Random().nextInt(3);

        Slot1.setImageResource(DRAWABLE_ID[chance1]);
        Slot2.setImageResource(DRAWABLE_ID[chance2]);
        Slot3.setImageResource(DRAWABLE_ID[chance3]);

        if(chance1+chance2+chance3==0) {
            msg.setText("YOU WON THE JACKPOT");
            playerAmount +=jackpot;
        }
        if(chance1==chance2&&chance2==chance3){
            msg.setText("You Win");
            isWin = true;
        }else{
            isWin=false;
        }
        //set must win condition to increase the rate of win
        if(play >= setWin && win < 5)
        {
            Slot1.setImageResource(DRAWABLE_ID[chance1]);
            Slot2.setImageResource(DRAWABLE_ID[chance1]);
            Slot3.setImageResource(DRAWABLE_ID[chance1]);
            msg.setText("You Won!");
            isWin = true;
            play = 0;
            setWin = new Random().nextInt(setWin)+5;

            //when getting the diamond in line
            if (chance1 == 0) {
                playerAmount += jackpot;
                msg.setText("You Won the Jackpot!!!");
            }
        }

        if(isWin){
            win++;
            if(win >= 5) win = 0;
            playerAmount += bet;
            pBalance.setText(""+playerAmount);
        }else{
            playerAmount -= bet;
            if(playerAmount < 0) playerAmount = 0;
            pBalance.setText(""+playerAmount);
            msg.setText("You Lost!");
        }

        if(playerAmount ==0){
            bet = 0;
            playerBet.setText("" + bet);
        }

    }

}
