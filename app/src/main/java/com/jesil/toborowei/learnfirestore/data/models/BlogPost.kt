package com.jesil.toborowei.learnfirestore.data.models

import com.google.firebase.firestore.ServerTimestamp
import java.util.*

data class BlogPost(
    val uid: String,
    val title: String,
    val content: String,
    val contentImage: String,
    val contentType: String,
    @ServerTimestamp val date: Date
)