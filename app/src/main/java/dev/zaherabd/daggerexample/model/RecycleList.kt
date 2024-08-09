package dev.zaherabd.daggerexample.model

data class RecycleList(val item: List<RecycleData>)
data class RecycleData(val name: String?, val description: String?, val owner: Owner?)
data class Owner(val avatar_url: String?)