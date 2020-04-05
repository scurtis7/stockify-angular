package com.scurtis.stockify.config;

/**
 * Author: Steve Curtis
 * Date: Mar 10, 2020
 **/

public class AppConstants {

    // Alpha Vantage Base URL
    public static final String ALPHA_VANTAGE_BASE_URL = "https://www.alphavantage.co/query?";
    // Finnhub Base URL
    public static final String FINN_HUB_BASE_URL = "https://finnhub.io/api/v1";

    // Symbol
    public static final String SYMBOL = "&symbol=";

    // Functions
    public static final String FUNCTION_SYMBOL_SEARCH              = "function=SYMBOL_SEARCH";
    public static final String FUNCTION_GLOBAL_QUOTE               = "function=GLOBAL_QUOTE";
    public static final String FUNCTION_INTRADAY                   = "function=TIME_SERIES_INTRADAY";
    public static final String FUNCTION_DAILY                      = "function=TIME_SERIES_DAILY";
    public static final String FUNCTION_DAILY_ADJUSTED             = "function=TIME_SERIES_DAILY_ADJUSTED";
    public static final String FUNCTION_WEEKLY                     = "function=TIME_SERIES_WEEKLY";
    public static final String FUNCTION_WEEKLY_ADJUSTED            = "function=TIME_SERIES_WEEKLY_ADJUSTED";
    public static final String FUNCTION_MONTHLY                    = "function=TIME_SERIES_MONTHLY";
    public static final String FUNCTION_MONTHLY_ADJUSTED           = "function=TIME_SERIES_MONTHLY_ADJUSTED";
    public static final String FUNCTION_SIMPLE_MOVING_AVERAGE      = "function=SMA";
    public static final String FUNCTION_EXPONENTIAL_MOVING_AVERAGE = "function=EMA";
    public static final String FUNCTION_WEIGHTED_MOVING_AVERAGE    = "function=WMA";

    // Intervals
    public static final String INTERVAL_ONE_MINUTE     = "&interval=1min";
    public static final String INTERVAL_FIVE_MINUTE    = "&interval=5min";
    public static final String INTERVAL_FIFTEEN_MINUTE = "&interval=15min";
    public static final String INTERVAL_THIRTY_MINUTE  = "&interval=30min";
    public static final String INTERVAL_SIXTY_MINUTE   = "&interval=60min";
    public static final String INTERVAL_DAILY          = "&interval=daily";
    public static final String INTERVAL_WEEKLY         = "&interval=weekly";
    public static final String INTERVAL_MONTHLY        = "&interval=monthly";

    // Outputsize
    public static final String OUTPUTSIZE_COMPACT = "&outputsize=compact";
    public static final String OUTPUTSIZE_FULL    = "&outputsize=full";

    // Time Period (positive numbers 1 to 200?)
    public static final String TIME_PERIOD_DATA_POINTS = "&time_period=";

    // Series Type
    public static final String SERIES_TYPE_CLOSE = "&series_type=close";
    public static final String SERIES_TYPE_OPEN  = "&series_type=open";
    public static final String SERIES_TYPE_HIGH  = "&series_type=high";
    public static final String SERIES_TYPE_LOW   = "&series_type=low";

    private AppConstants() {
        // Empty to prevent instantiation
    }
}
