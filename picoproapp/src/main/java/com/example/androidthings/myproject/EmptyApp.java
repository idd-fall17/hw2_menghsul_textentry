package com.example.androidthings.myproject;

import com.google.android.things.pio.Gpio;

/**
 * Minimal empty example - clone this and add your code.
 * Created by bjoern on 9/1/17.
 */

public class EmptyApp extends SimplePicoPro {
    int counter = 0;
    int count = 0;

    @Override
    public void setup() {
        pinMode(GPIO_128, Gpio.DIRECTION_IN);
        pinMode(GPIO_39, Gpio.DIRECTION_IN);
        pinMode(GPIO_37, Gpio.DIRECTION_IN);
        pinMode(GPIO_35, Gpio.DIRECTION_IN);
        pinMode(GPIO_34, Gpio.DIRECTION_IN);
        pinMode(GPIO_33, Gpio.DIRECTION_IN);
        pinMode(GPIO_32, Gpio.DIRECTION_IN);
        pinMode(GPIO_10, Gpio.DIRECTION_IN);
        pinMode(GPIO_172, Gpio.DIRECTION_IN);
        pinMode(GPIO_173, Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_128, Gpio.EDGE_BOTH);
        setEdgeTrigger(GPIO_39, Gpio.EDGE_BOTH);
        setEdgeTrigger(GPIO_37, Gpio.EDGE_BOTH);
        setEdgeTrigger(GPIO_35, Gpio.EDGE_BOTH);
        setEdgeTrigger(GPIO_34, Gpio.EDGE_BOTH);
        setEdgeTrigger(GPIO_33, Gpio.EDGE_BOTH);
        setEdgeTrigger(GPIO_32, Gpio.EDGE_BOTH);
        setEdgeTrigger(GPIO_10, Gpio.EDGE_BOTH);
        setEdgeTrigger(GPIO_172, Gpio.EDGE_BOTH);
        setEdgeTrigger(GPIO_173, Gpio.EDGE_BOTH);

    }

    @Override
    public void loop() {

    }

    @Override
    void digitalEdgeEvent(Gpio pin, boolean value) {
        println("digitalEdgeEvent"+pin+", "+value);
        // pins goes from LOW to HIGH
        // this is on button button release for pull-up resistors

        // pin 39 for A,B,C,D
        if (pin==GPIO_39 && value==LOW) {
            counter++;
            count = 1;
            if (counter > 4){
                counter = 1;
            }
        }
        // pin 37 for E,F,G
        if (pin==GPIO_37 && value==LOW) {
            counter++;
            count = 2;
            if (counter > 3){
                counter = 1;
            }
        }
        // pin 35 for H,I,J,K
        if (pin==GPIO_35 && value==LOW) {
            counter++;
            count = 3;
            if (counter > 4){
                counter = 1;
            }
        }
        // pin 34 for L,M,N,O
        if (pin==GPIO_34 && value==LOW) {
            counter++;
            count = 4;
            if (counter > 4){
                counter = 1;
            }
        }
        // pin 33 for P,Q,R,S
        if (pin==GPIO_33 && value==LOW) {
            counter++;
            count = 5;
            if (counter > 4){
                counter = 1;
            }
        }
        // pin 32 for T,U,V
        if (pin==GPIO_32 && value==LOW) {
            counter++;
            count = 6;
            if (counter > 3){
                counter = 1;
            }
        }
        // pin 10 for W,X,Y,Z
        if (pin==GPIO_10 && value==LOW) {
            counter++;
            count = 7;
            if (counter > 4){
                counter = 1;
            }
        }
        println(String.valueOf(counter));
        // print letter with confirm button pin 172
        if (counter == 1 && pin==GPIO_172 && value == LOW){
            if (count == 1){
                printCharacterToScreen('A');
            }else if (count == 2){
                printCharacterToScreen('E');
            }else if (count ==3){
                printCharacterToScreen('H');
            }else if (count ==4){
                printCharacterToScreen('L');
            }else if (count ==5){
                printCharacterToScreen('P');
            }else if (count ==6){
                printCharacterToScreen('T');
            }else if (count ==7){
                printCharacterToScreen('W');
            }
            counter = 0;
        } else if (counter == 2 && pin==GPIO_172 && value == LOW){
            if (count == 1){
                printCharacterToScreen('B');
            }else if (count == 2){
                printCharacterToScreen('F');
            }else if (count ==3){
                printCharacterToScreen('I');
            }else if (count ==4){
                printCharacterToScreen('M');
            }else if (count ==5){
                printCharacterToScreen('Q');
            }else if (count ==6){
                printCharacterToScreen('U');
            }else if (count ==7) {
                printCharacterToScreen('X');
            }
            counter = 0;
        } else if (counter == 3 && pin==GPIO_172 && value == LOW){
                if (count == 1){
                    printCharacterToScreen('C');
                }else if (count == 2){
                    printCharacterToScreen('G');
                }else if (count ==3){
                    printCharacterToScreen('J');
                }else if (count ==4){
                    printCharacterToScreen('N');
                }else if (count ==5){
                    printCharacterToScreen('R');
                }else if (count ==6){
                    printCharacterToScreen('V');
                }else if (count ==7){
                    printCharacterToScreen('Y');
            }
            counter = 0;
        }else if (counter == 4 && pin==GPIO_172 && value == HIGH) {
            if (count == 1) {
                printCharacterToScreen('D');
            } else if (count == 3) {
                printCharacterToScreen('K');
            } else if (count == 4) {
                printCharacterToScreen('O');
            } else if (count == 5) {
                printCharacterToScreen('S');
            } else if (count == 7) {
                printCharacterToScreen('Z');
            }
            count = 0;
        }
        //delete letter
        if (pin == GPIO_173 && value == HIGH){
            println("DELETE TRIGGER");
            deleteCharacterOnScreen();
        }
        //print space
        if (pin == GPIO_128 && value == LOW){
            printCharacterToScreen(' ');
        }

    }
}
