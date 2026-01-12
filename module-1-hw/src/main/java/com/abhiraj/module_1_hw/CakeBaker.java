package com.abhiraj.module_1_hw;

import com.abhiraj.module_1_hw.interfc.Frosting;
import com.abhiraj.module_1_hw.interfc.Syrup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CakeBaker {

    private final Frosting frosting;
    private final Syrup syrup;

    public CakeBaker(@Qualifier("strawberryFrosting") Frosting frosting, @Qualifier("chocolateSyrup") Syrup syrup) {
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public String bakeCake(){
        return "Baking a cake with " + frosting.getFrostingType() + " and " + syrup.getSyrupType();
    }
}
