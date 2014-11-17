package com.sierracircuit.android.alarmclock;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.util.Log;
import java.util.Calendar;

public class MainActivity extends Activity {

    final   int WHITE_TEXT = 0xffffffff;
    final   int RED_TEXT   = 0xffff2222;
    final   int MAX_RING_COUNT = 20;

    static  int i = 0;
    static  int j = 0;

    static  int m0;
    static  int m1;
    static  int m2;
    static  int m3;
    static  int ok;

    static  int alarmOff;
    static  int alarmOn;
    static  int alarmSnd1;
    static  int alarmSnd2;
    static  int alarmSnd3;
    static  int alarmSnd4;
    static  int morning;
    static  int wakeUp;
    static  int theTimeIs;

    static  int clockMin = 0;
    static  int clockHrs = 12;
    static  int clockPM  = 0;

    static  int alarmMin = 0;
    static  int alarmHrs = 12;
    static  int alarmPM  = 0;

    static  int alarmSet  = 0;
    static  int alarmRing = 0;
    static  int ringCount = 0;

    private Button hrsUpButton;
    private Button minUpButton;
    private Button hrsDownButton;
    private Button minDownButton;
    private Button sayTimeButton;
    private Button setAlarmButton;

    private TextView clockValue;
    private TextView alarmValue;

    private Handler customHandler = new Handler();

    private SoundPool soundclip;


    // Say the alarm time using audio sound clips
    public void sayAlarmVal(int hour, int minute, int pm) {
        if (alarmSet == 1) {
            soundclip.play(alarmOn,1,1,0,0,1);
            wait1(5);
            loadTimeAudio(hour, minute, pm);
        } else {
            soundclip.play(alarmOff,1,1,0,0,1);
        }
    }


    // Say the time using audio sound clips
    public void loadTimeAudio(int hour, int minute, int pm) {

        int tens;

        ok = 0;
        j  = 0;

        // Log.d("debugHour", Integer.toString(hour));
        // Log.d("debugMinute", Integer.toString(minute));
        // Log.d("debugPM", Integer.toString(minute));

        switch(hour) {
            case 1:
                m0=soundclip.load(this,R.raw.one,1);
                break;
            case 2:
                m0=soundclip.load(this,R.raw.two,1);
                break;
            case 3:
                m0=soundclip.load(this,R.raw.three,1);
                break;
            case 4:
                m0=soundclip.load(this,R.raw.four,1);
                break;
            case 5:
                m0=soundclip.load(this,R.raw.five,1);
                break;
            case 6:
                m0=soundclip.load(this,R.raw.six,1);
                break;
            case 7:
                m0=soundclip.load(this,R.raw.seven,1);
                break;
            case 8:
                m0=soundclip.load(this,R.raw.eight,1);
                break;
            case 9:
                m0=soundclip.load(this,R.raw.nine,1);
                break;
            case 10:
                m0=soundclip.load(this,R.raw.ten,1);
                break;
            case 11:
                m0=soundclip.load(this,R.raw.eleven,1);
                break;
            case 12:
                m0=soundclip.load(this,R.raw.twelve,1);
                break;
            default:
                m0=soundclip.load(this,R.raw.errormsg,1);
        }
        i = 3;
        tens = 0;

        if (minute >= 50) {
            m1=soundclip.load(this,R.raw.fifty,1);
            tens = 50;
        } else if (minute >= 40) {
            m1=soundclip.load(this,R.raw.forty,1);
            tens = 40;
        } else if (minute >= 30) {
            m1=soundclip.load(this,R.raw.thirty,1);
            tens = 30;
        } else if (minute >= 20) {
            m1=soundclip.load(this,R.raw.twenty,1);
            tens = 20;
        } else if (minute >= 10) {
            // the teens are a special case
            tens = 10;
        } else {
            m1=soundclip.load(this,R.raw.oh,1);
        }

        if ((tens >= 20) || (tens == 0)) {
            i = 4;

            if (tens >= 20) {minute -= tens;}

            switch(minute) {
                case 0:
                    if (tens == 0) {ok = 1;}  // on the hour
                    i = 3;                    // on ten-minute
                    break;
                case 1:
                    m2=soundclip.load(this,R.raw.one,1);
                    break;
                case 2:
                    m2=soundclip.load(this,R.raw.two,1);
                    break;
                case 3:
                    m2=soundclip.load(this,R.raw.three,1);
                    break;
                case 4:
                    m2=soundclip.load(this,R.raw.four,1);
                    break;
                case 5:
                    m2=soundclip.load(this,R.raw.five,1);
                    break;
                case 6:
                    m2=soundclip.load(this,R.raw.six,1);
                    break;
                case 7:
                    m2=soundclip.load(this,R.raw.seven,1);
                    break;
                case 8:
                    m2=soundclip.load(this,R.raw.eight,1);
                    break;
                case 9:
                    m2=soundclip.load(this,R.raw.nine,1);
                    break;
                default:
                    m2=soundclip.load(this,R.raw.errormsg,1);
            }
        }

        if (tens == 10) {
            minute -= tens;

            switch(minute) {
                case 0:
                    m1=soundclip.load(this,R.raw.ten,1);
                    break;
                case 1:
                    m1=soundclip.load(this,R.raw.eleven,1);
                    break;
                case 2:
                    m1=soundclip.load(this,R.raw.twelve,1);
                    break;
                case 3:
                    m1=soundclip.load(this,R.raw.thirteen,1);
                    break;
                case 4:
                    m1=soundclip.load(this,R.raw.fourteen,1);
                    break;
                case 5:
                    m1=soundclip.load(this,R.raw.fifteen,1);
                    break;
                case 6:
                    m1=soundclip.load(this,R.raw.sixteen,1);
                    break;
                case 7:
                    m1=soundclip.load(this,R.raw.seventeen,1);
                    break;
                case 8:
                    m1=soundclip.load(this,R.raw.eighteen,1);
                    break;
                case 9:
                    m1=soundclip.load(this,R.raw.nineteen,1);
                    break;
                default:
                    m1=soundclip.load(this,R.raw.errormsg,1);
            }
        }

        if (pm == 1) {
            m3=soundclip.load(this,R.raw.pm,1);
            // Log.d("pm_debug", Integer.toString(pm));
        } else {
            m3=soundclip.load(this,R.raw.am,1);
            // Log.d("am_debug", Integer.toString(pm));
        }

        // Log.d("i_debug", Integer.toString(i));
        // Log.d("j_debug", Integer.toString(j));
    }


    // Update the displayed time value
    public void setTimeValue(TextView tt, int hrs, int min, int pm) {
        if (pm == 1) {
            tt.setText("" + hrs + ":" + String.format("%02d", min) + " pm");
        } else {
            tt.setText("" + hrs + ":" + String.format("%02d", min) + " am");
        }
    }


    public void wait1(int x) {
        try { Thread.sleep(250 * x); }
        catch (InterruptedException ex) {}
    }


    public void playClockTime() {
        soundclip.play(m0,1,1,0,0,1);
        if (ok == 0){
            wait1(4);
            soundclip.play(m1,1,1,0,0,1);
        }
        if (i == 4){
            wait1(2);
            soundclip.play(m2,1,1,0,0,1);
        }
        wait1(4);
        soundclip.play(m3,1,1,0,0,1);
    }


    public void playAlarm() {

        switch(ringCount) {
            case 0:
                soundclip.play(morning,1,1,0,0,1);
                wait1(6);
                soundclip.play(wakeUp,1,1,0,0,1);
                wait1(12);
                break;
            case 1:
                soundclip.play(alarmSnd1,1,1,0,0,1);
                wait1(12);
                break;
            case 2:
                soundclip.play(alarmSnd1,1,1,0,0,1);
                wait1(12);
                break;
            case 3:
                soundclip.play(wakeUp,1,1,0,0,1);
                wait1(12);
                break;
            case 4:
                soundclip.play(alarmSnd2,1,1,0,0,1);
                wait1(12);
                break;
            case 5:
                soundclip.play(alarmSnd3,1,1,0,0,1);
                wait1(12);
                break;
            case 6:
                soundclip.play(wakeUp,1,1,0,0,1);
                wait1(12);
                break;
            default:
                soundclip.play(alarmSnd4,1,1,0,0,1);
                wait1(12);
        }

        alarmRing = 1;
        ringCount += 1;

        if (ringCount > MAX_RING_COUNT) {
            soundclip.play(wakeUp,1,1,0,0,1);  // one last try
            alarmSet  = 0;
            alarmRing = 0;
            ringCount = 0;
            alarmValue.setTextColor(WHITE_TEXT);
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        soundclip = new SoundPool(1,AudioManager.STREAM_MUSIC,0);
        soundclip.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                j += 1;
                if (i == j) {
                    playClockTime();
                }
                // Log.d("xi_debug", Integer.toString(i));
                // Log.d("xj_debug", Integer.toString(j));
            }
        });

        alarmOff  = soundclip.load(this,R.raw.alarmoff,1);
        alarmOn   = soundclip.load(this,R.raw.alarmset,1);
        alarmSnd1 = soundclip.load(this,R.raw.alarm1,1);
        alarmSnd2 = soundclip.load(this,R.raw.alarm2,1);
        alarmSnd3 = soundclip.load(this,R.raw.alarm3,1);
        alarmSnd4 = soundclip.load(this,R.raw.alarm4,1);
        wakeUp    = soundclip.load(this,R.raw.wakeup,1);
        morning   = soundclip.load(this,R.raw.morning,1);
        theTimeIs = soundclip.load(this,R.raw.thetimeis,1);

        clockValue = (TextView) findViewById(R.id.clockValue);
        alarmValue = (TextView) findViewById(R.id.alarmValue);

        hrsUpButton    = (Button) findViewById(R.id.hrsUpButton);
        hrsDownButton  = (Button) findViewById(R.id.hrsDownButton);
        minUpButton    = (Button) findViewById(R.id.minUpButton);
        minDownButton  = (Button) findViewById(R.id.minDownButton);
        sayTimeButton  = (Button) findViewById(R.id.sayTimeButton);
        setAlarmButton = (Button) findViewById(R.id.setAlarmButton);

        hrsUpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                alarmHrs += 1;
                if (alarmHrs > 12) {
                    alarmHrs = 1;
                }
                if (alarmHrs == 12) {
                    if (alarmPM == 1) {alarmPM = 0;}
                    else {alarmPM = 1;}
                }
                setTimeValue(alarmValue, alarmHrs, alarmMin, alarmPM);
            }
        });


        hrsDownButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                alarmHrs -= 1;
                if (alarmHrs < 1) {
                    alarmHrs = 12;
                }
                if (alarmHrs == 11) {
                    if (alarmPM == 1) {alarmPM = 0;}
                    else {alarmPM = 1;}
                }
                setTimeValue(alarmValue, alarmHrs, alarmMin, alarmPM);
            }
        });


        minUpButton.setOnClickListener(new View.OnClickListener() {        
            public void onClick(View view) {
                alarmMin += 1;
                if (alarmMin > 59) {
                    alarmMin = 0;
                }
                setTimeValue(alarmValue, alarmHrs, alarmMin, alarmPM);
            }
        });


        minDownButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                alarmMin -= 1;
                if (alarmMin < 0) {
                    alarmMin = 59;
                }
                setTimeValue(alarmValue, alarmHrs, alarmMin, alarmPM);
            }
        });


        sayTimeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                soundclip.play(theTimeIs,1,1,0,0,1);
                wait1(4);
                loadTimeAudio(clockHrs, clockMin, clockPM);
            }
        });


        sayTimeButton.setOnLongClickListener(new View.OnLongClickListener() { 
        @Override
            public boolean onLongClick(View view) {
                soundclip.play(theTimeIs,1,1,0,0,1);
                wait1(4);
                loadTimeAudio(clockHrs, clockMin, clockPM);
                return true;
            }
        });


        setAlarmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (alarmSet == 1) {
                    alarmSet  = 0;
                    alarmRing = 0;
                    ringCount = 0;
                    alarmValue.setTextColor(WHITE_TEXT);
                } else {
                    alarmSet  = 1;
                    ringCount = 0;
                    alarmValue.setTextColor(RED_TEXT);
                }
                sayAlarmVal(alarmHrs, alarmMin, alarmPM);
            }
        });


        setAlarmButton.setOnLongClickListener(new View.OnLongClickListener() { 
        @Override
            public boolean onLongClick(View view) {
                if (alarmSet == 1) {
                    sayAlarmVal(alarmHrs, alarmMin, alarmPM);
                } else {
                    soundclip.play(alarmOff,1,1,0,0,1);
                }
                return true;
            }
        });

        updateTimerThread.run();
    }


    private Runnable updateTimerThread = new Runnable() {
    
        public void run() {

            Calendar mytime = Calendar.getInstance();

            clockHrs = mytime.get(Calendar.HOUR);
            clockMin = mytime.get(Calendar.MINUTE);
            clockPM  = mytime.get(Calendar.AM_PM);

            if (clockHrs == 0) {clockHrs  = 12;}  // Hack !!

            if (((alarmSet == 1) &&
                 (clockPM  == alarmPM)   &&
                 (clockHrs == alarmHrs)  &&
                 (clockMin == alarmMin)) ||
                 (alarmRing == 1)) {
                Log.d("playAlarm_debug", Integer.toString(alarmRing));
                playAlarm();
            }
  
            // Log.d("clockHrs", Integer.toString(clockHrs));
            // Log.d("clockMin", Integer.toString(clockMin));

            setTimeValue(clockValue, clockHrs, clockMin, clockPM);
            setTimeValue(alarmValue, alarmHrs, alarmMin, alarmPM);

            if (alarmSet == 1) {
                alarmValue.setTextColor(RED_TEXT);
            } else {
                alarmValue.setTextColor(WHITE_TEXT);
            }

            customHandler.postDelayed(this, 1000);
        }
    };

}
