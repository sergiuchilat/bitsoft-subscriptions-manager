package com.subscriptions.bitsoftsubscriptionsmanager.api.modules.subscriptions.controllers

import com.subscriptions.bitsoftsubscriptionsmanager.api.modules.subscriptions.dto.response.SubscriptionItemDTO
import com.subscriptions.bitsoftsubscriptionsmanager.api.modules.subscriptions.dto.payload.SubscriptionCreateDTO
import com.subscriptions.bitsoftsubscriptionsmanager.api.modules.subscriptions.dto.payload.SubscriptionUpdateDTO
import com.subscriptions.bitsoftsubscriptionsmanager.api.modules.subscriptions.services.SubscriptionsService
import org.springframework.http.ResponseEntity
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping()

class SubscriptionsController {

    private val subscriptionsServices = SubscriptionsService()

    @GetMapping()
    fun getSubscriptions(): List<SubscriptionItemDTO> {
        return subscriptionsServices.getSubscriptions()
    }

    @GetMapping("{id}")
    fun getSubscription(@PathVariable id: Int): ResponseEntity<SubscriptionItemDTO> {
        return subscriptionsServices.getSubscription(id)
    }

    @PostMapping()
    fun createSubscription(@Valid @RequestBody subscription: SubscriptionCreateDTO): ResponseEntity<SubscriptionItemDTO> {
        return subscriptionsServices.createSubscription(subscription)
    }

    @PutMapping("{id}")
    fun updateSubscription(@PathVariable id: Int, @Valid @RequestBody subscription: SubscriptionUpdateDTO): ResponseEntity<SubscriptionItemDTO> {
        return subscriptionsServices.updateSubscription(id, subscription)
    }

    @DeleteMapping("{id}")
    fun deleteSubscription(@PathVariable id: Int): ResponseEntity<Unit> {
        return subscriptionsServices.deleteSubscription(id)
    }
}