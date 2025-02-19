package com.subscriptions.bitsoftsubscriptionsmanager.api.modules.subscriptions.services

import com.subscriptions.bitsoftsubscriptionsmanager.api.modules.subscriptions.dto.response.SubscriptionItemDTO
import com.subscriptions.bitsoftsubscriptionsmanager.api.modules.subscriptions.dto.payload.SubscriptionCreateDTO
import com.subscriptions.bitsoftsubscriptionsmanager.api.modules.subscriptions.dto.payload.SubscriptionUpdateDTO
import com.subscriptions.bitsoftsubscriptionsmanager.api.modules.subscriptions.repositories.SubscriptionsRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class SubscriptionsServices {

    var subscriptionsRepository = SubscriptionsRepository()

    fun getSubscriptions(): List<SubscriptionItemDTO> {
        return subscriptionsRepository.getAllSubscriptions();
    }

    fun getSubscription(id: Int): ResponseEntity<SubscriptionItemDTO> {
        val subscription = subscriptionsRepository.getSubscription(id)
            ?: return ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        return ResponseEntity.ok(subscription)
    }

    fun createSubscription(subscription: SubscriptionCreateDTO): ResponseEntity<SubscriptionItemDTO> {

        if (subscription.userId == 409){
            return ResponseEntity.status(HttpStatus.CONFLICT).build()
        }

        if (subscription.userId == 401){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }

        if (subscription.userId == 403){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build()
        }

        return ResponseEntity(
            subscriptionsRepository.createSubscription(subscription),
            HttpStatus.CREATED
        )
    }

    fun updateSubscription(id: Int, subscription: SubscriptionUpdateDTO): ResponseEntity<SubscriptionItemDTO> {

        if (subscription.userId == 409){
            return ResponseEntity.status(HttpStatus.CONFLICT).build()
        }

        if (subscription.userId == 401){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }

        if (subscription.userId == 403){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build()
        }

        val updatedSubscription = subscriptionsRepository.updateSubscription(id, subscription)
            ?: return ResponseEntity.status(HttpStatus.NOT_FOUND).build()

        return ResponseEntity(
            updatedSubscription,
            HttpStatus.OK
        )
    }

    fun deleteSubscription(id: Int): ResponseEntity<Unit> {
        val deletedSubscription = subscriptionsRepository.deleteSubscription(id)
        if (deletedSubscription == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
        return ResponseEntity.noContent().build()
    }
}