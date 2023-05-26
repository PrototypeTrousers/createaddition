package com.mrh0.createaddition.util.liquid_burning;

import com.mrh0.createaddition.CreateAddition;
import com.mrh0.createaddition.blocks.liquid_blaze_burner.LiquidBlazeBurnerTileEntity;
import com.simibubi.create.content.contraptions.processing.burner.BlazeBurnerTileEntity;
import net.minecraft.resources.ResourceLocation;


public class BurnableTagProperties {
    private final int time;
    private final ResourceLocation tagResource;
    private final boolean isSpecial;

    public BurnableTagProperties(int timePerBucket, boolean crashOnLow, boolean isSpecial) {
        this.tagResource = new ResourceLocation(CreateAddition.MODID ,"burnable_fuel_" + (isSpecial ? "superheated_": "") + timePerBucket);

        if (timePerBucket < 200 && crashOnLow) {
            throw new RuntimeException("Burning Time cannot be less then 200! Change this to stop this crash " +
                    "\n[Conflicting Tag ---> " + tagResource + "]\n");
        }

        int i = timePerBucket / 100;

        if (i * 100 != timePerBucket ) {
            throw new RuntimeException("Burning Time is indivisible by 100! Change this to stop this crash " +
                    "\n[Conflicting Tag ---> " + tagResource + "]\n");
        }

        this.time = timePerBucket;
        this.isSpecial = isSpecial;
    }

    @SuppressWarnings("unused")
    public BurnableTagProperties(int timePerBucket) {
        this(timePerBucket, true, false);
    }

    public int getTime() {
        return this.time;
    }

    public int getDropletAmount() {
        return 81000;
    }

    public boolean isSpecialFuel() {
        return isSpecial;
    }
    public ResourceLocation asResource() {
        return this.tagResource;
    }
}
