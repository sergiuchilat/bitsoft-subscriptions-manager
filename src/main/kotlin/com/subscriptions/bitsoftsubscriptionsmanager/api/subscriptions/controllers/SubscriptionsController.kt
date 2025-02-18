package com.subscriptions.bitsoftsubscriptionsmanager.api.subscriptions.controllers

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class SubscriptionsController {

    @GetMapping("/subscriptions")
    fun getSubscriptions(): String {
        return "Subscriptions"
    }

    @GetMapping("/subscriptions/{id}")
    fun getSubscription(): String {
        return "Subscription"
    }

    @PostMapping("/subscriptions")
    fun createSubscription(): String {
        return "Subscription created"
    }

    @PutMapping("/subscriptions/{id}")
    fun updateSubscription(): String {
        return "Subscription updated"
    }

    @DeleteMapping("/subscriptions/{id}")
    fun deleteSubscription(): String {
        return "Subscription deleted"
    }
}