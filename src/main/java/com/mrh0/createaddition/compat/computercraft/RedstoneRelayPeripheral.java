package com.mrh0.createaddition.compat.computercraft;

import com.mrh0.createaddition.blocks.connector.ConnectorTileEntity;
import com.mrh0.createaddition.blocks.redstone_relay.RedstoneRelayBlock;
import com.mrh0.createaddition.blocks.redstone_relay.RedstoneRelayTileEntity;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IPeripheral;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RedstoneRelayPeripheral implements IPeripheral {
    private final String type;
    private final RedstoneRelayTileEntity tileEntity;

    public RedstoneRelayPeripheral(String type, RedstoneRelayTileEntity tileEntity) {
        this.type = type;
        this.tileEntity = tileEntity;
    }

    @NotNull
    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public boolean equals(@Nullable IPeripheral iPeripheral) {
        return iPeripheral == this;
    }

    @Nullable
    @Override
    public Object getTarget() {
        return this.tileEntity;
    }

    @LuaFunction(mainThread = true)
    public int getMaxInsert() {
        return ConnectorTileEntity.MAX_IN;
    }

    @LuaFunction(mainThread = true)
    public int getMaxExtract() {
        return ConnectorTileEntity.MAX_OUT;
    }

    @LuaFunction(mainThread = true)
    public int getThroughput() {
        return this.tileEntity.getThroughput();
    }

    @LuaFunction(mainThread = true)
    public boolean isPowered() {
        return this.tileEntity.getBlockState().getValue(RedstoneRelayBlock.POWERED);
    }
}