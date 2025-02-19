package com.subscriptions.bitsoftsubscriptionsmanager.api.modules.subscriptions.repositories

import com.subscriptions.bitsoftsubscriptionsmanager.api.modules.subscriptions.dto.payload.SubscriptionCreateDTO
import com.subscriptions.bitsoftsubscriptionsmanager.api.modules.subscriptions.dto.payload.SubscriptionUpdateDTO
import com.subscriptions.bitsoftsubscriptionsmanager.api.modules.subscriptions.dto.response.SubscriptionItemDTO
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDate

class SubscriptionsRepository {

    var subscriptions = mutableListOf(
        SubscriptionItemDTO(
            1,
            1,
            LocalDate.of(2024, 1, 1),
            LocalDate.of(2024, 12, 31),
            LocalDate.of(2024, 1, 1),
            true,
            1,
            "Service 1"
        ),
        SubscriptionItemDTO(
            2,
            1,
            LocalDate.of(2024, 1, 1),
            LocalDate.of(2024, 12, 31),
            LocalDate.of(2024, 1, 1),
            true,
            2,
            "Service 2"
        )
    )

    fun getAllSubscriptions(): List<SubscriptionItemDTO> {
        return subscriptions

    }

    fun getSubscription(id: Int): SubscriptionItemDTO? {
        return subscriptions.find { it.id == id }
    }

    fun createSubscription(subscription: SubscriptionCreateDTO): SubscriptionItemDTO {
        subscriptions.add(
            SubscriptionItemDTO(
                subscriptions.size + 1,
                subscription.userId,
                subscription.startDate,
                subscription.endDate,
                subscription.nextBillingDate,
                subscription.isActive,
                subscription.serviceId,
                subscription.serviceType
            )
        )
        return subscriptions.last()
    }

    fun updateSubscription(id: Int, subscription: SubscriptionUpdateDTO): SubscriptionItemDTO? {
        var subscriptionToUpdate = subscriptions.find { it.id == id }
        if (subscriptionToUpdate == null) {
            return null
        }

        subscriptionToUpdate = SubscriptionItemDTO(
            id,
            subscription.userId,
            subscription.startDate,
            subscription.endDate,
            subscription.nextBillingDate,
            subscription.isActive,
            subscription.serviceId,
            subscription.serviceType
        )

        subscriptions = subscriptions.map {
            if (it.id == id) {
                subscriptionToUpdate
            } else {
                it
            }
        }.toMutableList()

        return subscriptionToUpdate
    }

    fun deleteSubscription(id: Int): Int {
        val subscriptionToDelete = subscriptions.find { it.id == id }
        if (subscriptionToDelete == null) {
            return 0
        }
        subscriptions = subscriptions.filter { it.id != id }.toMutableList()
        return 1
    }
}