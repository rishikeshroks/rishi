package com.hexaware.FTP107.integration.test;
import com.hexaware.FTP107.integration.test.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * enum constructor.
 */
public enum OrdersStatus {
    /**
     * Place_order.
     * delivered.
     * cancelled.
     */
    PLACE_ORDER, DELIVERED, CANCELLED;
}
