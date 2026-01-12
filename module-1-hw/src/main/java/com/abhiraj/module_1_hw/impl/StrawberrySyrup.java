package com.abhiraj.module_1_hw.impl;

import com.abhiraj.module_1_hw.interfc.Syrup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("strawberrySyrup")
public class StrawberrySyrup implements Syrup {

    @Override
    public String getSyrupType() {
        return "Strawberry Syrup";
    }
}
