package com.snatik.matches.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.snatik.matches.R;
import com.snatik.matches.common.Music;
import com.snatik.matches.utils.FontLoader;
import com.snatik.matches.utils.FontLoader.Font;

public class PopupSettingsView extends LinearLayout {

	private ImageView mSoundImage;
	private TextView mSoundText;

	public PopupSettingsView(Context context) {
		this(context, null);
	}

	public PopupSettingsView(final Context context, AttributeSet attrs) {
		super(context, attrs);
		setOrientation(LinearLayout.VERTICAL);
		setBackgroundResource(R.drawable.settings_popup);
		LayoutInflater.from(getContext()).inflate(R.layout.popup_settings_view, this, true);
		mSoundText = (TextView) findViewById(R.id.sound_off_text);
		TextView rateView = (TextView) findViewById(R.id.rate_text);
		FontLoader.setTypeface(context, new TextView[] { mSoundText, rateView }, Font.GROBOLD);
		mSoundImage = (ImageView) findViewById(R.id.sound_image);
		View soundOff = findViewById(R.id.sound_off);
		soundOff.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Music.OFF = !Music.OFF;
				setMusicButton();
			}
		});
		View rate = findViewById(R.id.rate);
		rate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "Rates are not available in demo app", Toast.LENGTH_LONG).show();
			}
		});
		setMusicButton();
	}

	private void setMusicButton() {
		if (Music.OFF) {
			mSoundText.setText("Sound OFF");
			mSoundImage.setImageResource(R.drawable.button_music_off);
		} else {
			mSoundText.setText("Sound ON");
			mSoundImage.setImageResource(R.drawable.button_music_on);
		}
	}
}
