package com.example.jackhuang.slotmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int money = 300;
    private boolean noMoney = false;
    private TextView moneyText;
    private TextView msgText;
    private TextView jackpot;
    private int bet;
    private TextView betText;
    private Button[] BetButton = new Button[6];

    private Button spinButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msgText = findViewById(R.id.msg);

        moneyText = findViewById(R.id.moneyText);
        moneyText.setText("player amount"+money);

        betText = findViewById(R.id.betText);
        betText.setText("Bet: " +bet);

        spinButton = findViewById(R.id.spin);
        spinButton.setEnabled(true);


    }
    void spin() {
        if (bet == 0)
            msgText.setText("Please place a bet");
        if (noMoney && money >= bet && bet > 0) {
        runSpin();
        }else if (bet>0){
            msgText.setText("you have no more money");
            spinButton.setEnabled(false);
        }
    }
    void runSpin(){


    }
}
