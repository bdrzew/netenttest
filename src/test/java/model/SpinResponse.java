package model;

import lombok.Builder;

/**
 * Model which simulates response from spin.php
 */
@Builder
public class SpinResponse {
    @Builder.Default private String prizeId = "41";
    @Builder.Default private String payoutCredits = "7";
    @Builder.Default private String payoutWinnings = "7";
    @Builder.Default private String lastWin = "7";
    @Builder.Default private String success = "true";
    @Builder.Default private String credits = "8";
    @Builder.Default private String dayWinnings = "7";
    @Builder.Default private String lifetimeWinnings = "7";

    public String getWinJsonString() {
        return "{\"reels\":[\"1.0\",\"1.0\",\"1.0\"],\"prize\":{\"id\":\"" +
                prizeId + "\",\"payoutCredits\":" +
                payoutCredits + ",\"payoutWinnings\":" +
                payoutWinnings + "},\"lastWin\":" +
                lastWin + ",\"success\":" +
                success + ",\"credits\":" +
                credits + ",\"dayWinnings\":" +
                dayWinnings + ",\"lifetimeWinnings\":" +
                lifetimeWinnings + "}";
    }

    public String getLooseJsonString() {
        return "{\"reels\":[\"1.0\",\"1.0\",\"1.0\"],\"prize\":null,\"success\":" +
                success + ",\"credits\":" +
                credits + ",\"dayWinnings\":" +
                dayWinnings + ",\"lifetimeWinnings\":" +
                lifetimeWinnings + "}";
    }
}
