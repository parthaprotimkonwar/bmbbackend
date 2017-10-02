package com.bookmybanner.application.exception;

/**
 * Application Error Handled constants.
 *
 * @author pkonwar
 */
public enum ErrorConstants {


    // Error Code Series : 4XX : Client Side Error (Frontend Error)
    NO_SUCH_USER_TYPE("BMB-401", "No such Usertype."),
    INVALID_LOGIN("BMB-402", "Invalid Username or Password."),
    INVALID_REQUEST_DATA("BMB-403", "Invalid Request Data"),
    INVALID_RESPONSE_FORMAT("BMB-404", "Invalid Response data"),
    DUPLICATE_EMAIL_ID("BMB-406", "Email Id already in use"),
    INVALID_TOKEN("BMB-407", "Token not valid"),
    MANDATORY_FIELDS_NOT_PRESENT("BMB-408", "Mandatory Fields Not Present"),
    VALIDATION_EXCEPTION("BMB-409", "Validation Exception"),
    NO_SUCH_RECORD("BMB-410", "No such record"),
    USER_ALREADY_EXIST("BMB-411", "User already exist"),

    BANNER_SEARCH_EXCEPTION("BMB-401", "Exception while searching banner"),
    BANNER_CREATE_EXCEPTION("BMB-402", "Exception while Banner creation"),
    BANNER_UPDATE_EXCEPTION("BMB-403", "Exception while Banner updation"),
    BANNER_DELETE_EXCEPTION("BMB-404", "Exception while Banner deletion"),

    //Error Code Series : 5XX : Server Side Error (Backend error)
    DATA_PERSISTANT_EXCEPTION("BMB-501", "Unable to Save data"),
    DATA_FETCH_EXCEPTION("BMB-502", "Unable to Fetch data"),
    DATA_REMOVAL_EXCEPTION("BMB-503", "Unable to Delete data"),
    CONTACT_SYSTEM_ADMINISTRATOR("BMB-500", "System Error. Contact system administrator"),

    //Error Code : 6XX : Integration error
    INTEGRATION_FETCH_RESPONSE_EXCEPTION("BMB-601", "Unable to fetch data from remote server");

    private String errorCode;
    private String errorMessage;

    private ErrorConstants(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "ErrorConstants{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
