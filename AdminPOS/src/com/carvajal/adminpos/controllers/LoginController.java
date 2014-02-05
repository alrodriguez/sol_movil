package com.carvajal.adminpos.controllers;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.carvajal.adminpos.R;
import com.carvajal.adminpos.models.User;
import com.carvajal.adminpos.views.activities.LoginActivity;

public class LoginController {
	
	private User user;
	
	/**
	 * A dummy authentication store containing known user names and passwords.
	 * TODO: remove after connecting to a real authentication system.
	 */
	private static final String[] DUMMY_CREDENTIALS = new String[] {
			"foo@example.com:hello", "bar@example.com:world" };
	
	/**
	 * The default email to populate the email field with.
	 */
	public static final String EXTRA_EMAIL = "com.example.android.authenticatordemo.extra.EMAIL";
	
	// Values for email and password at the time of the login attempt.
	private String mEmail;
	private String mPassword;
	
	/**
	 * Keep track of the login task to ensure we can cancel it if requested.
	 */
	private UserLoginTask mAuthTask = null;
		
	private LoginActivity activity;

	public LoginController(LoginActivity activity) {
		this.activity = activity;
		this.activity.addSignInListener(signInListener);
		
		// Set up the login form.
		mEmail = this.activity.getIntent().getStringExtra(EXTRA_EMAIL);
		this.activity.getmEmailView().setText(mEmail);
		
		user = new User();
	}
	

	private OnClickListener signInListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			attemptLogin();
		}
	};
	
	private OnEditorActionListener onEditorActionListener = new OnEditorActionListener() {
		@Override
		public boolean onEditorAction(TextView textView, int id,
				KeyEvent keyEvent) {
			if (id == R.id.login || id == EditorInfo.IME_NULL) {
				attemptLogin();
				return true;
			}
			return false;
		}
	};
	
	/**
	 * Attempts to sign in or register the account specified by the login form.
	 * If there are form errors (invalid email, missing fields, etc.), the
	 * errors are presented and no actual login attempt is made.
	 */
	public void attemptLogin() {
		if (mAuthTask != null) {
			return;
		}

		// Reset errors.
		this.activity.getmEmailView().setError(null);
		this.activity.getmPasswordView().setError(null);

		// Store values at the time of the login attempt.
		mEmail = this.activity.getmEmailView().getText().toString();
		mPassword = this.activity.getmPasswordView().getText().toString();

		boolean cancel = false;
		View focusView = null;

		// Check for a valid password.
		if (TextUtils.isEmpty(mPassword)) {
			this.activity.getmPasswordView().setError(this.activity.getString(R.string.error_field_required));
			focusView = this.activity.getmPasswordView();
			cancel = true;
		} else if (mPassword.length() < 4) {
			this.activity.getmPasswordView().setError(this.activity.getString(R.string.error_invalid_password));
			focusView = this.activity.getmPasswordView();
			cancel = true;
		}

		// Check for a valid email address.
		if (TextUtils.isEmpty(mEmail)) {
			this.activity.getmEmailView().setError(this.activity.getString(R.string.error_field_required));
			focusView = this.activity.getmEmailView();
			cancel = true;
		} else if (!mEmail.contains("@")) {
			this.activity.getmEmailView().setError(this.activity.getString(R.string.error_invalid_email));
			focusView = this.activity.getmEmailView();
			cancel = true;
		}

		if (cancel) {
			// There was an error; don't attempt login and focus the first
			// form field with an error.
			focusView.requestFocus();
		} else {
			// Show a progress spinner, and kick off a background task to
			// perform the user login attempt.
			this.activity.getmLoginStatusMessageView().setText(R.string.login_progress_signing_in);
			this.activity.showProgress(true);
			mAuthTask = new UserLoginTask();
			mAuthTask.execute((Void) null);
		}
	}
	
	/**
	 * Represents an asynchronous login/registration task used to authenticate
	 * the user.
	 */
	public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
		@Override
		protected Boolean doInBackground(Void... params) {
			// TODO: attempt authentication against a network service.

			try {
				// Simulate network access.
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				return false;
			}

			for (String credential : DUMMY_CREDENTIALS) {
				String[] pieces = credential.split(":");
				if (pieces[0].equals(mEmail)) {
					// Account exists, return true if the password matches.
					return pieces[1].equals(mPassword);
				}
			}

			// TODO: register the new account here.
			return true;
		}

		@Override
		protected void onPostExecute(final Boolean success) {
			mAuthTask = null;
			activity.showProgress(false);

			if (success) {
				//activity.finish();
			} else {
				activity.getmPasswordView()
						.setError(activity.getString(R.string.error_incorrect_password));
				activity.getmPasswordView().requestFocus();
			}
		}

		@Override
		protected void onCancelled() {
			mAuthTask = null;
			activity.showProgress(false);
		}
	}
	
	
}
