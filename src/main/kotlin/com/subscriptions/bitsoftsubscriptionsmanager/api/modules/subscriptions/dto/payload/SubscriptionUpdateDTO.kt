package com.subscriptions.bitsoftsubscriptionsmanager.api.modules.subscriptions.dto.payload

import jakarta.validation.constraints.*
import java.time.LocalDate

data class SubscriptionUpdateDTO (
    @field:NotNull(message = "userId is required")
    val userId : Int,

    @field:NotNull(message = "startDate is required")
    @field:FutureOrPresent(message = "startDate must be in the present or future")
    val startDate : LocalDate,

    @field:NotNull(message = "endDate is required")
    @field:FutureOrPresent(message = "endDate must be in the present or future")
    val endDate : LocalDate,

    @field:NotNull(message = "nextBillingDate is required")
    @field:Future(message = "nextBillingDate must be in the future")
    val nextBillingDate : LocalDate,

    @field:NotNull(message = "isActive is required")
    val isActive : Boolean,

    @field:NotNull(message = "serviceId is required")
    val serviceId: Int,

    @field:NotBlank(message = "serviceType is required")
    val serviceType: String
)