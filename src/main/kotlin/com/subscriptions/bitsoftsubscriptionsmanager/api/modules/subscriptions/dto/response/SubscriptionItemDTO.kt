package com.subscriptions.bitsoftsubscriptionsmanager.api.modules.subscriptions.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class SubscriptionItemDTO (
    val id: Int,

    var userId : Int,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val startDate : LocalDate,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val endDate : LocalDate,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val nextBillingDate : LocalDate,

    val isActive : Boolean,

    val serviceId: Int,
    val serviceType: String
)