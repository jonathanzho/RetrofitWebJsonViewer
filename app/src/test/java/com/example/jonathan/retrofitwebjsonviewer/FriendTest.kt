package com.example.jonathan.retrofitwebjsonviewer

//JZ import com.example.jonathan.retrofitwebjsonviewer.model.Friend.id
//JZ import com.example.jonathan.retrofitwebjsonviewer.model.Friend.name
import com.example.jonathan.retrofitwebjsonviewer.model.Friend
import org.junit.Assert
import org.junit.Test

class FriendTest {
    @Test
    fun testAccessId() {
        val id = 12345
        val aFriend = Friend()
        aFriend.id = id
        Assert.assertEquals(id.toLong(), aFriend.id.toLong())
    }

    @Test
    fun testAccessName() {
        val name = "John Smith"
        val aFriend = Friend()
        aFriend.name = name
        Assert.assertEquals(name, aFriend.name)
    }
}