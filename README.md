<h1>talking-alarm-clock</h1>

This is a (very simple) Android talking-alarm-clock application that was written as a homework assignment for introductory Android programming class.
It is a first attempt at java and Android.

<h2>App Usage</h2>
There are 4 buttons to adjust the alarm time: hours+, hours-, minutes+ and minutes-
The fifth button will say the current time (single press and press-and-hold have the same effect)
For the sixth button, a single-press will turn on/off the alarm and press-and-hold will say the alarm time.
The app uses AP/PM time and there is no 24-hour time option (there are no configuration menus).

<h2>Sound Files</h2>
The app uses pre-recorded .wav (or .mp3) sound files, so it is possible to cutomize the clock with your own voice and sound effects. Here is the list of required sound files (these files live in the res/raw sub-directory)

```
-- file name --   -- content --

 alarm1           alarm option #1 (digital alarm)
 alarm2           alarm option #2 (arcade thump)
 alarm3           alarm option #3 (arcade laser)
 alarm3           alarm option #4 (really annoying alarm)

 alarmoff.wav     "the alarm is off"
 alarmset.wav     "the alarm is set to"
 oh.wav           "oh"
 one.wav          "1"
 two.wav          "2"
 three.wav        "3"
 four.wav         "4"
 five.wav         "5"
 six.wav          "6"
 seven.wav        "7"
 eight.wav        "8"
 nine.wav         "9"
 ten.wav          "10"
 eleven.wav       "11"
 twelve.wav       "12"
 thirteen.wav     "13"
 fourteen.wav     "14"
 fifteen.wav      "15"
 sixteen.wav      "16"
 seventeen.wav    "17"
 eighteen.wav     "18"
 nineteen.wav     "19"
 twenty.wav       "20"
 thirty.wav       "30"
 forty.wav        "40"
 fifty.wav        "50"
 am.wav           "A M"
 pm.wav           "P M"
 morning.wav      "good morning"
 thetimeis.wav    "the time is"
 wakeup.wav       "time to wakeup"
```
