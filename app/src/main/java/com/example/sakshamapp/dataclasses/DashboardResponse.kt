package com.example.sakshamapp.dataclasses

import java.io.Serializable

data class DashboardResponse(val entities: List<DashboardItem>, val entityTotal: Int)
data class DashboardItem(
    val property1: String,
    val property2: String,
    val description: String
) : Serializable
