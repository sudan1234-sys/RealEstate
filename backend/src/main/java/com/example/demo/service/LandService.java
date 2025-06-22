package com.example.demo.service;

import com.example.demo.model.Land;

import java.util.List;


public interface LandService {
    public void addLand(long userId, Land land);
    List<Land> getLands();

}
