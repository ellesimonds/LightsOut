package com.example.lightsout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final int GRID_SIZE = 3;
    private GridLayout grid;
    private boolean cellState[][];


    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button current = (Button) v;
            for (int i = 0; i < grid.getChildCount(); i++) {
                Button gridButton = (Button) grid.getChildAt(i);

                if (gridButton == current) {
                    int row = i / GRID_SIZE;
                    int col = i % GRID_SIZE;

                    if (cellState[row][col] == true) {
                        cellState[row][col] = false;

                    } else {
                        cellState[row][col] = true;
                    }
                }
            }
        }
    };
// method to  count lights
    public void countLights; {
        // Button current = (Button) ;
        for (int i = 0; i < grid.getChildCount(); i++) {
            Button gridButton = (Button) grid.getChildAt(i);
    }

    View.OnClickListener reorganizeButtons = new View.OnClickListener() {

        @Override
        public void onClick(View view) {

        }
    }

        ;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            cellState = new boolean[][]{{true, true, true}, {true, true, true}, {true, true, true}};

            setContentView(R.layout.activity_main);
            grid = findViewById(R.id.light_grid);

            randomize();

            recolor();

           // git config user.email "elle.simonds@bruins.belmont.edu"
        }

        public void recolor() {
            for (int i = 0; i < grid.getChildCount(); i++) {
                Button gridButton = (Button) grid.getChildAt(i);

                // Find the button's row and col
                int row = i / GRID_SIZE;
                int col = i % GRID_SIZE;

                if (cellState[row][col] == true) {
                    gridButton.setBackgroundColor(getColor(R.color.teal));
                } else {
                    gridButton.setBackgroundColor(getColor(R.color.yellow));
                }
            }
        }

        public void randomize() {
            Random random = new Random();
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    cellState[i][j] = random.nextBoolean();
                }
            }
        }


    };
