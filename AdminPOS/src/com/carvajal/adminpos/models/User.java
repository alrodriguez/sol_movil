package com.carvajal.adminpos.models;

import android.provider.BaseColumns;

import com.carvajal.adminpos.utils.Constants;

public class User {
	
	private String username;
	private String password;
	private String name;
	
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * METADATA
	 * 
	 * Labels for the entity properties.
	 * In case no label is found the property name is used instead
	 */
	
	 /* Inner class that defines the entity contents */
    public static abstract class UserEntry implements BaseColumns {
        public static final String TABLE_NAME               = "User";
        public static final String COLUMN_NAME_USER_NAME    = "username";
        public static final String COLUMN_NAME_PASSWORK     = "password";
        public static final String COLUMN_NAME_NAME         = "name";
        
        /* Sync */
        public static final String COLUMN_NAME_URI        = "uri";
        public static final String COLUMN_NAME_TEMP_ID    = "tempId";
        public static final String COLUMN_NAME_IS_DELETED = "isDeleted";
        public static final String COLUMN_NAME_IS_DIRTY   = "isDirty";
    }
    
    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + UserEntry.TABLE_NAME + " (" +
            UserEntry.COLUMN_NAME_USER_NAME    + Constants.VARCHAR_TYPE_PRIMARY_KEY  + Constants.COMMA_SEP +
            UserEntry.COLUMN_NAME_PASSWORK     + Constants.INTEGER_TYPE              + Constants.COMMA_SEP +
            UserEntry.COLUMN_NAME_NAME         + Constants.INTEGER_TYPE              + Constants.COMMA_SEP +
            
            /* Sync */
            UserEntry.COLUMN_NAME_URI        + Constants.VARCHAR_TYPE                 + Constants.COMMA_SEP +
            UserEntry.COLUMN_NAME_TEMP_ID    + Constants.GUID_TYPE                    + Constants.COMMA_SEP +
            UserEntry.COLUMN_NAME_IS_DELETED + Constants.INTEGER_TYPE + " DEFAULT 0"  + Constants.COMMA_SEP +
            UserEntry.COLUMN_NAME_IS_DIRTY   + Constants.INTEGER_TYPE + " DEFAULT 0"  +
            " );";

	public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME+" ;";
	

	

}
