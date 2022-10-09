package com.example.jonathan.webjsonviewer;

import static org.junit.Assert.assertEquals;

import com.example.jonathan.webjsonviewer.model.Friend;

import org.junit.Test;

public class FriendTest {
  @Test
  public void testAccessId() {
    int id = 12345;
    Friend aFriend = new Friend();
    aFriend.setId(id);
    assertEquals(id, aFriend.getId());
  }

  @Test
  public void testAccessName() {
    String name = "John Smith";
    Friend aFriend = new Friend();
    aFriend.setName(name);
    assertEquals(name, aFriend.getName());
  }
}