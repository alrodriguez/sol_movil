package com.carvajal.adminpos.views.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.carvajal.adminpos.R;
import com.carvajal.adminpos.controllers.LoginController;
import com.carvajal.adminpos.models.User;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends Activity {
	// UI references.
	private EditText mEmailView;
	private EditText mPasswordView;
	private View mLoginFormView;
	private View mLoginStatusView;
	private TextView mLoginStatusMessageView;
	private Button signInButton;
	
	private LoginController loginController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		mEmailView = (EditText) findViewById(R.id.email);
		mPasswordView = (EditText) findViewById(R.id.password);

		mLoginFormView = findViewById(R.id.login_form);
		mLoginStatusView = findViewById(R.id.login_status);
		mLoginStatusMessageView = (TextView) findViewById(R.id.login_status_message);

		signInButton = (Button) findViewById(R.id.sign_in_button);
		
		loginController = new LoginController(this);
		
	}
	
	public void addSignInListener(OnClickListener onClickListener) {
		signInButton.setOnClickListener(onClickListener);
	}
	
	public void addOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
		mPasswordView.setOnEditorActionListener(onEditorActionListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	

	/**
	 * Shows the progress UI and hides the login form.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	public void showProgress(final boolean show) {
		// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
		// for very easy animations. If available, use these APIs to fade-in
		// the progress spinner.
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			int shortAnimTime = getResources().getInteger(
					android.R.integer.config_shortAnimTime);

			mLoginStatusView.setVisibility(View.VISIBLE);
			mLoginStatusView.animate().setDuration(shortAnimTime)
					.alpha(show ? 1 : 0)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginStatusView.setVisibility(show ? View.VISIBLE
									: View.GONE);
						}
					});

			mLoginFormView.setVisibility(View.VISIBLE);
			mLoginFormView.animate().setDuration(shortAnimTime)
					.alpha(show ? 0 : 1)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginFormView.setVisibility(show ? View.GONE
									: View.VISIBLE);
						}
					});
		} else {
			// The ViewPropertyAnimator APIs are not available, so simply show
			// and hide the relevant UI components.
			mLoginStatusView.setVisibility(show ? View.VISIBLE : View.GONE);
			mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
		}
	}
	
	

	public EditText getmEmailView() {
		return mEmailView;
	}

	public void setmEmailView(EditText mEmailView) {
		this.mEmailView = mEmailView;
	}

	public EditText getmPasswordView() {
		return mPasswordView;
	}

	public void setmPasswordView(EditText mPasswordView) {
		this.mPasswordView = mPasswordView;
	}

	public View getmLoginFormView() {
		return mLoginFormView;
	}

	public void setmLoginFormView(View mLoginFormView) {
		this.mLoginFormView = mLoginFormView;
	}

	public View getmLoginStatusView() {
		return mLoginStatusView;
	}

	public void setmLoginStatusView(View mLoginStatusView) {
		this.mLoginStatusView = mLoginStatusView;
	}

	public TextView getmLoginStatusMessageView() {
		return mLoginStatusMessageView;
	}

	public void setmLoginStatusMessageView(TextView mLoginStatusMessageView) {
		this.mLoginStatusMessageView = mLoginStatusMessageView;
	}

	public Button getSignInButton() {
		return signInButton;
	}

	public void setSignInButton(Button signInButton) {
		this.signInButton = signInButton;
	}

}
