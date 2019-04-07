package com.azp.roomdemo.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.azp.roomdemo.entity.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user where first_name LIKE :firstName AND last_name LIKE :lastName")
    User findByName(String firstName, String lastName);

    @Query("SELECT COUNT(*) FROM user")
    int countUsers();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
