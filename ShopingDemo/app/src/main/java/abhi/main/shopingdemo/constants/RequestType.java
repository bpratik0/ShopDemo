package abhi.main.shopingdemo.constants;

/**
 * Request types
 */
public enum RequestType {
    REGISTER_USER,
    FORGOT_PASSWORD,
    FORGOT_PASSWORD_AUTH,
    LOGIN_USER,
    RESEND_OTP,
    CONFIRM_OTP,
    GET_TAX_SUMMARY,
    GET_KEY,
    TAX_DETAIL,
    TAX_SEARCH,
    LOG_OUT,
    STATIC_REQ,
    DYNAMIC_REQ,
    VALIDATE_VPA,
    MAKE_PAYMENT,
    PAYMENT_STATUS,
    SIGN_UP_CONFIRM_OTP,
    SIGN_UP_RESEND_OTP,
    PAYMENT_STATUS_MANUAL,

    GET_USER_INFO,
    UPDATE_USER_INFO,
    GET_PRODUCT_DETAILS,
    GET_ADS_DETAILS,
    GET_DELIVERY_DETAILS,
    GET_CART_PRODUCT_LIST,
    REMOVE_PRODUCT_FROM_LIST,
    EDIT_PRODUCT_FROM_LIST,
    GET_PRODUCT_LIST,
    GET_SUB_CATEGORY_LIST,
    GET_ADS_LIST,
    GET_HISTORY_PRODUCT_LIST,
    GET_HISTORY_PRODUCT_DETAILS,
    ADD_PRODUCT_TO_CART,
    GET_NOTIFICATION_LIST,
    PLACE_ORDER,
    GET_CATEGORY_LIST,
    NO_CONNECTION_FOUND
}