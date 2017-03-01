package com.example.speak1_app;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends Activity implements OnInitListener{
	private Button spk;
	private EditText et;
	private TextToSpeech engine;
	private SeekBar seekSpeed,seekPitch;
	private float pitchRate,speedRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spk=(Button)findViewById(R.id.button1);
        et=(EditText)findViewById(R.id.editText1);
        seekPitch=(SeekBar)findViewById(R.id.seekBar1);
        seekSpeed=(SeekBar)findViewById(R.id.seekBar2);
        
        engine=new TextToSpeech(this, this);
        spk.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				speak();
			}

			private void speak() {
				// TODO Auto-generated method stub
				engine.setPitch(pitchRate);
				engine.setSpeechRate(speedRate);
				engine.speak(et.getText().toString(), TextToSpeech.QUEUE_FLUSH,null);
				
				Toast.makeText(getApplication(), "your voice is speaking", Toast.LENGTH_SHORT).show();
			}
		});
        seekPitch.setThumbOffset(5);
        seekPitch.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				// TODO Auto-generated method stub
				pitchRate=((float)arg1)/100f;
			}
		});
		seekSpeed.setThumbOffset(5);
		seekSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				// TODO Auto-generated method stub
				speedRate=((float)arg1)/100f;
			}
		});
			
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public void onInit(int arg0) {
		// TODO Auto-generated method stub
		if(arg0==TextToSpeech.SUCCESS){
			engine.setLanguage(Locale.UK);

	}
}
}
