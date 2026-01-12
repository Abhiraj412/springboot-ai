package com.abhiraj.module_1_hw.impl;

import com.abhiraj.module_1_hw.interfc.Frosting;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("chocolateFrosting")
public class ChocolateFrosting implements Frosting {

    @Override
    public String getFrostingType() {
        return "Chocolate frosting";
    }

}
